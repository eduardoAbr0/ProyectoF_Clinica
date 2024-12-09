package com.tecjerez.proyecto_clinica.bd.controlador;

import com.tecjerez.proyecto_clinica.bd.conexionDB;
import com.tecjerez.proyecto_clinica.bd.modelo.Cita;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.List;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import java.util.ArrayList;

public class CitaCRUD implements DAOCita {

    @Override
    public void insertar(Cita cita) throws SQLException {
        String sql = "INSERT INTO citas(idCita, Fecha_Cita, Hora_Cita, Motivo_Cita, Estado, Costo_Cita) VALUES(?,?,?,?,?,?)";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = conexionDB.getInstancia().getConexion().prepareStatement(sql);
            preparedStatement.setInt(1, cita.getId());
            preparedStatement.setString(2, cita.getFechaCita());
            preparedStatement.setString(3, cita.getHoraCita());
            preparedStatement.setString(4, cita.getMotivo());
            preparedStatement.setString(5, cita.getEstado());
            preparedStatement.setDouble(6, cita.getCosto());
            if (preparedStatement.executeUpdate() >= 1) {
                JOptionPane.showMessageDialog(null, "Cita agregada correctamente", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al insertar cita", "Mensaje", JOptionPane.ERROR_MESSAGE);
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
    public void actualizar(Cita cita) throws SQLException {
        String sql = "UPDATE citas SET Fecha_Cita = ?, Hora_Cita = ?, Motivo_Cita = ?, Estado = ?, Costo_Cita = ? WHERE idCita = ?";
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = conexionDB.getInstancia().getConexion().prepareStatement(sql);
            preparedStatement.setString(1, cita.getFechaCita());
            preparedStatement.setString(2, cita.getHoraCita());
            preparedStatement.setString(3, cita.getMotivo());
            preparedStatement.setString(4, cita.getEstado());
            preparedStatement.setDouble(5, cita.getCosto());
            preparedStatement.setInt(6, cita.getId());

            if (preparedStatement.executeUpdate() >= 1) {
                JOptionPane.showMessageDialog(null, "Cita actualizada con éxito.", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al actualizar cita.", "Error", JOptionPane.ERROR_MESSAGE);
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
    public void eliminar(Integer id) throws SQLException {
        String sql = "DELETE FROM citas WHERE idCita = ?";
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = conexionDB.getInstancia().getConexion().prepareStatement(sql);
            preparedStatement.setInt(1, id);

            if (preparedStatement.executeUpdate() >= 1) {
                JOptionPane.showMessageDialog(null, "Cita eliminada", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al eliminar cita", "Error", JOptionPane.ERROR_MESSAGE);
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

    public Cita convertir(ResultSet rs, int id) throws SQLException {
        Cita cita = null;
        String fechaCita = rs.getString("Fecha_Cita");
        String horaCita = rs.getString("Hora_Cita");
        String motivo = rs.getString("Motivo");
        String estado = rs.getString("Estado");
        double costo = rs.getDouble("Costo");

        cita = new Cita(id, fechaCita, horaCita, motivo, estado, costo);
        return cita;
    }

    @Override
    public Cita buscar(Integer id) throws SQLException {
        String sql = "SELECT * FROM cita WHERE idCita = ?";
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Cita cita = null;
        try {
            preparedStatement = conexionDB.getInstancia().getConexion().prepareStatement(sql);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                cita = convertir(resultSet, id);
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
        return cita;
    }

    @Override
    public List<Cita> buscarTodos() throws SQLException {
        String sql = "SELECT * FROM cita";
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        ArrayList<Cita> citas = new ArrayList<>();
        try {
            preparedStatement = conexionDB.getInstancia().getConexion().prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                citas.add(convertir(resultSet, id));
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

        return citas;
    }

}
