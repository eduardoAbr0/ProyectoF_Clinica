/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tecjerez.proyecto_clinica.bd.controlador;

import com.tecjerez.proyecto_clinica.bd.conexionDB;
import com.tecjerez.proyecto_clinica.bd.modelo.Parto;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.List;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import java.util.ArrayList;

public class PartoCRUD implements DAOParto {

    @Override
    public void insertar(Parto parto) {
        String sql = "INSERT INTO clinica.parto(Fecha_Parto, Hora_Parto, Tipo_Parto, Observaciones, Paciente_idPaciente) VALUES(?,?,?,?,?); SELECT SCOPE_IDENTITY();";
        String sqlEmpleadoParto = "INSERT INTO Empleado_has_parto (Empleado_idEmpleado, Parto_idParto, Parto_Paciente_idPaciente) VALUES (?, ?, ?)";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = conexionDB.getInstancia().getConexion().prepareStatement(sql);
            preparedStatement.setString(1, parto.getFechaParto());
            preparedStatement.setString(2, parto.getHora());
            preparedStatement.setString(3, parto.getTipo());
            preparedStatement.setString(4, parto.getObservaciones());
            preparedStatement.setInt(5, parto.getIdPaciente());

            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                int idParto = rs.getInt(1);
                JOptionPane.showMessageDialog(null, "Parto agregado correctamente", "Mensaje", JOptionPane.INFORMATION_MESSAGE);

                try {
                    preparedStatement = conexionDB.getInstancia().getConexion().prepareStatement(sql);
                    preparedStatement.setInt(1, parto.getIdEmpleado());
                    preparedStatement.setInt(2, idParto);
                    preparedStatement.setInt(3, parto.getIdPaciente());
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, "Error SQL", "Mensaje", JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al insertar parto", "Mensaje", JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error SQL", "Mensaje", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    @Override
    public void actualizar(Parto parto) {
        String sql = "UPDATE parto SET Fecha_Parto = ?, Hora_Parto = ?, Tipo_Parto = ?, Observaciones = ? WHERE idParto = ?";
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = conexionDB.getInstancia().getConexion().prepareStatement(sql);
            preparedStatement.setString(1, parto.getFechaParto());
            preparedStatement.setString(2, parto.getHora());
            preparedStatement.setString(3, parto.getTipo());
            preparedStatement.setString(4, parto.getObservaciones());
            preparedStatement.setInt(5, parto.getId());

            if (preparedStatement.executeUpdate() >= 1) {
                JOptionPane.showMessageDialog(null, "Se actualizó con éxito el parto.", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al actualizar parto.", "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error SQL", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    @Override
    public void eliminar(Integer id) {
        String sql = "DELETE FROM parto WHERE idParto = ?";
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = conexionDB.getInstancia().getConexion().prepareStatement(sql);
            preparedStatement.setInt(1, id);

            if (preparedStatement.executeUpdate() >= 1) {
                JOptionPane.showMessageDialog(null, "Parto eliminado", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error SQL", "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error SQL", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public Parto convertir(ResultSet rs, int id) throws SQLException {
        Parto parto = null;
        String fechaParto = rs.getString("Fecha_Parto");
        String hora = rs.getString("Hora");
        String tipo = rs.getString("Tipo");
        String observaciones = rs.getString("Observaciones");

        parto = new Parto(id, fechaParto, hora, tipo, observaciones);
        return parto;
    }

    @Override
    public Parto buscar(Integer id) {
        String sql = "SELECT * FROM parto WHERE idParto = ?";
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Parto parto = null;
        try {
            preparedStatement = conexionDB.getInstancia().getConexion().prepareStatement(sql);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                parto = convertir(resultSet, id);
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró registro", "Error", JOptionPane.WARNING_MESSAGE);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error SQL", "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error SQL", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        return parto;
    }

    @Override
    public List<Parto> buscarTodos() {
        String sql = "SELECT * FROM parto";
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        ArrayList<Parto> partos = new ArrayList<>();
        try {
            preparedStatement = conexionDB.getInstancia().getConexion().prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                partos.add(convertir(resultSet, id));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error SQL", "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error SQL", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        return partos;
    }

}
