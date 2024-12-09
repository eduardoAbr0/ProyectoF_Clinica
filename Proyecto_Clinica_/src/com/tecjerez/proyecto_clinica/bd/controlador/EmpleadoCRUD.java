package com.tecjerez.proyecto_clinica.bd.controlador;

import com.tecjerez.proyecto_clinica.bd.conexionDB;
import com.tecjerez.proyecto_clinica.bd.modelo.Empleado;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.List;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import java.util.ArrayList;

public class EmpleadoCRUD implements DAOEmpleado {

    @Override
    public void insertar(Empleado empleado) throws SQLException {
        String sql = "INSERT INTO empleado(idEmpleado, Nombre, Primer_Apellido, Segundo_Apellido, Calle, Num_Casa,"
                + "Colonia,CP,Num_Telefono,Puesto) VALUES(?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = conexionDB.getInstancia().getConexion().prepareStatement(sql);
            preparedStatement.setInt(1, empleado.getId());
            preparedStatement.setString(2, empleado.getNombre());
            preparedStatement.setString(3, empleado.getPapellido());
            preparedStatement.setString(4, empleado.getSapellido());
            preparedStatement.setInt(5, empleado.getNumeroCasa());
            preparedStatement.setString(6, empleado.getCalle());
            preparedStatement.setString(7, empleado.getColonia());
            preparedStatement.setInt(8, empleado.getCp());
            preparedStatement.setInt(9, empleado.getTelefono());
            preparedStatement.setString(10, empleado.getTipoEmpleado());

            if (preparedStatement.executeUpdate() >= 1) {
                JOptionPane.showMessageDialog(null, "Empleado agregado correctamente", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al insertar empleado", "Mensaje", JOptionPane.ERROR_MESSAGE);
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
    public void actualizar(Empleado empleado) throws SQLException {
        String sql = "UPDATE Empleado SET Nombre = ?, Primer_Apellido = ?, Segundo_Apellido = ?, Num_Casa = ?, Calle = ?, Colonia = ?, CP = ?, Num_Telefono = ?, Puesto = ? WHERE ID = ?";
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = conexionDB.getInstancia().getConexion().prepareStatement(sql);
            preparedStatement.setString(1, empleado.getNombre());
            preparedStatement.setString(2, empleado.getPapellido());
            preparedStatement.setString(3, empleado.getSapellido());
            preparedStatement.setInt(4, empleado.getNumeroCasa());
            preparedStatement.setString(5, empleado.getCalle());
            preparedStatement.setString(6, empleado.getColonia());
            preparedStatement.setInt(7, empleado.getCp());
            preparedStatement.setInt(8, empleado.getTelefono());
            preparedStatement.setString(9, empleado.getTipoEmpleado());
            preparedStatement.setInt(10, empleado.getId());

            if (preparedStatement.executeUpdate() >= 1) {
                JOptionPane.showMessageDialog(null, "Se actualizó con éxito el empleado.", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al actualizar empleado.", "Error", JOptionPane.ERROR_MESSAGE);
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
        String sql = "DELETE FROM Empleado WHERE idEmpleado = ?";
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = conexionDB.getInstancia().getConexion().prepareStatement(sql);
            preparedStatement.setInt(1, id);

            if (preparedStatement.executeUpdate() >= 1) {
                JOptionPane.showMessageDialog(null, "Empleado eliminado", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al eliminar empleado", "Error", JOptionPane.ERROR_MESSAGE);
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

    public Empleado convertir(ResultSet rs, int id) throws SQLException {
        Empleado empleado = null;

        String nombre = rs.getString("Nombre");
        String pApellido = rs.getString("Papellido");
        String sApellido = rs.getString("Sapellido");
        int numeroCasa = rs.getInt("NumeroCasa");
        String calle = rs.getString("Calle");
        String colonia = rs.getString("Colonia");
        int cp = rs.getInt("CP");
        int telefono = rs.getInt("Telefono");
        String tipoEmpleado = rs.getString("Puesto");

        empleado = new Empleado(id, nombre, pApellido, sApellido, numeroCasa, calle, colonia, cp, telefono, tipoEmpleado);
        return empleado;
    }

    @Override
    public Empleado buscar(Integer id) throws SQLException {
        String sql = "SELECT * FROM empleados WHERE idEmpleado = ?";
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Empleado empleado = null;

        try {
            preparedStatement = conexionDB.getInstancia().getConexion().prepareStatement(sql);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                empleado = convertir(resultSet, id);
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

        return empleado;
    }

    @Override
    public List<Empleado> buscarTodos() throws SQLException {
        String sql = "SELECT * FROM Empleado";
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        ArrayList<Empleado> empleados = new ArrayList<>();
        try {
            preparedStatement = conexionDB.getInstancia().getConexion().prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                empleados.add(convertir(resultSet, id));
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

        return empleados;
    }

}
