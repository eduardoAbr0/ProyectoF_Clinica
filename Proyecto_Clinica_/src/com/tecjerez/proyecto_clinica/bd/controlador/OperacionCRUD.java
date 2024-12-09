package com.tecjerez.proyecto_clinica.bd.controlador;

import com.tecjerez.proyecto_clinica.bd.conexionDB;
import com.tecjerez.proyecto_clinica.bd.modelo.Operacion;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.List;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import java.util.ArrayList;

public class OperacionCRUD implements DAOOperacion {

    @Override
    public void insertar(Operacion operacion) throws SQLException {
        String sql = "INSERT INTO operacion(idOPeracion, Tipo_Operacion, Fecha_Operacion, Duracion, Observaciones, Costo_Operacion) VALUES(?,?,?,?,?,?)";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = conexionDB.getInstancia().getConexion().prepareStatement(sql);
            preparedStatement.setInt(1, operacion.getId());
            preparedStatement.setString(2, operacion.getTipo());
            preparedStatement.setString(3, operacion.getFecha());
            preparedStatement.setString(4, operacion.getDuracion());
            preparedStatement.setString(5, operacion.getObservaciones());
            preparedStatement.setDouble(6, operacion.getCosto());

            if (preparedStatement.executeUpdate() >= 1) {
                JOptionPane.showMessageDialog(null, "Operación agregada correctamente", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al insertar operación", "Mensaje", JOptionPane.ERROR_MESSAGE);
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
    public void actualizar(Operacion operacion) throws SQLException {
        String sql = "UPDATE operacion SET Tipo_Operacion = ?, Fecha_Operacion = ?, Duracion = ?, Observaciones = ?, Costo_Operacion = ? WHERE ID_Operacion = ?";
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = conexionDB.getInstancia().getConexion().prepareStatement(sql);
            preparedStatement.setString(1, operacion.getTipo());
            preparedStatement.setString(2, operacion.getFecha());
            preparedStatement.setString(3, operacion.getDuracion());
            preparedStatement.setString(4, operacion.getObservaciones());
            preparedStatement.setDouble(5, operacion.getCosto());
            preparedStatement.setInt(6, operacion.getId());

            if (preparedStatement.executeUpdate() >= 1) {
                JOptionPane.showMessageDialog(null, "Operación actualizada con éxito.", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al actualizar operación.", "Error", JOptionPane.ERROR_MESSAGE);
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
        String sql = "DELETE FROM operacion WHERE idOperacion = ?";
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = conexionDB.getInstancia().getConexion().prepareStatement(sql);
            preparedStatement.setInt(1, id);

            if (preparedStatement.executeUpdate() >= 1) {
                JOptionPane.showMessageDialog(null, "Operación eliminada", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
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

    public Operacion convertir(ResultSet rs, int id) throws SQLException {
        Operacion operacion = null;
        String tipo = rs.getString("Tipo");
        String fecha = rs.getString("Fecha");
        String duracion = rs.getString("Duracion");
        String observaciones = rs.getString("Observaciones");
        double costo = rs.getDouble("Costo");

        operacion = new Operacion(id, tipo, fecha, duracion, observaciones, costo);
        return operacion;
    }

    @Override
    public Operacion buscar(Integer id) throws SQLException {
        String sql = "SELECT * FROM operacion WHERE idOperacion = ?";
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Operacion operacion = null;
        try {
            preparedStatement = conexionDB.getInstancia().getConexion().prepareStatement(sql);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                operacion = convertir(resultSet, id);
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
        return operacion;
    }

    @Override
    public List<Operacion> buscarTodos() throws SQLException {
        String sql = "SELECT * FROM operacion";
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        ArrayList<Operacion> operaciones = new ArrayList<>();
        try {
            preparedStatement = conexionDB.getInstancia().getConexion().prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                operaciones.add(convertir(resultSet, id));
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

        return operaciones;
    }

}
