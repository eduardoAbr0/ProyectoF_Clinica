package com.tecjerez.proyecto_clinica.bd.controlador;

import com.tecjerez.proyecto_clinica.bd.conexionDB;
import com.tecjerez.proyecto_clinica.bd.modelo.Paciente;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.List;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import java.util.ArrayList;

public class PacienteCRUD implements DAOPaciente {

    @Override
    public void insertar(Paciente paciente) throws SQLException {
        String sql = "INSERT INTO paciente(idPaciente, Nombre, Primer_Apellido, Segundo_Apellido, Fecha_Nacimiento, Sexo, Tipo_Sangre, Alergias, Num_Telefono, Fecha_Registro) VALUES(?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = conexionDB.getInstancia().getConexion().prepareStatement(sql);
            preparedStatement.setInt(1, paciente.getId());
            preparedStatement.setString(2, paciente.getNombre());
            preparedStatement.setString(3, paciente.getPapellido());
            preparedStatement.setString(4, paciente.getSapellido());
            preparedStatement.setString(5, paciente.getFechaNac());
            preparedStatement.setString(6, paciente.getSexo());
            preparedStatement.setString(7, paciente.getTipoSangre());
            preparedStatement.setString(8, paciente.getAlergias());
            preparedStatement.setInt(9, paciente.getTelefono());
            preparedStatement.setString(10, paciente.getFechaRegistro());

            if (preparedStatement.executeUpdate() >= 1) {
                JOptionPane.showMessageDialog(null, "Paciente agregado correctamente", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al insertar paciente", "Mensaje", JOptionPane.ERROR_MESSAGE);
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
    public void actualizar(Paciente paciente) throws SQLException {
        String sql = "UPDATE paciente SET Nombre = ?, Primer_Apellido = ?, Segundo_Apellido = ?, Fecha_Nacimiento = ?, Sexo = ?, Tipo_Sangre = ?, Alergias = ?, Num_Telefono = ?, Fecha_Registro = ? WHERE idPaciente = ?";
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = conexionDB.getInstancia().getConexion().prepareStatement(sql);
            preparedStatement.setString(1, paciente.getNombre());
            preparedStatement.setString(2, paciente.getPapellido());
            preparedStatement.setString(3, paciente.getSapellido());
            preparedStatement.setString(4, paciente.getFechaNac());
            preparedStatement.setString(5, paciente.getSexo());
            preparedStatement.setString(6, paciente.getTipoSangre());
            preparedStatement.setString(7, paciente.getAlergias());
            preparedStatement.setInt(8, paciente.getTelefono());
            preparedStatement.setString(9, paciente.getFechaRegistro());
            preparedStatement.setInt(10, paciente.getId());

            if (preparedStatement.executeUpdate() >= 1) {
                JOptionPane.showMessageDialog(null, "Paciente actualizado con éxito.", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al actualizar paciente.", "Error", JOptionPane.ERROR_MESSAGE);
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
        String sql = "DELETE FROM paciente WHERE idPaciente = ?";
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = conexionDB.getInstancia().getConexion().prepareStatement(sql);
            preparedStatement.setInt(1, id);

            if (preparedStatement.executeUpdate() >= 1) {
                JOptionPane.showMessageDialog(null, "Paciente eliminado con éxito", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al eliminar paciente", "Error", JOptionPane.ERROR_MESSAGE);
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

    public Paciente convertir(ResultSet rs, int id) throws SQLException {
        Paciente paciente = null;

        String nombre = rs.getString("Nombre");
        String primerApellido = rs.getString("Primer_Apellido");
        String segundoApellido = rs.getString("Segundo_Apellido");
        String fechaNac = rs.getString("Fecha_Nacimiento");
        String sexo = rs.getString("Sexo");
        String tipoSangre = rs.getString("Tipo_Sangre");
        String alergias = rs.getString("Alergias");
        int telefono = rs.getInt("Telefono");
        String fechaRegistro = rs.getString("Fecha_Registro");

        paciente = new Paciente(id, nombre, primerApellido, segundoApellido, fechaNac, sexo, tipoSangre, alergias, telefono, fechaRegistro);

        return paciente;
    }

    @Override
    public Paciente buscar(Integer id) throws SQLException {
        String sql = "SELECT * FROM paciente WHERE idPaciente = ?";
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Paciente paciente = null;

        try {
            preparedStatement = conexionDB.getInstancia().getConexion().prepareStatement(sql);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                paciente = convertir(resultSet, id);
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró el registro", "Error", JOptionPane.WARNING_MESSAGE);
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

        return paciente;
    }

    @Override
    public List<Paciente> buscarTodos() throws SQLException {
        String sql = "SELECT * FROM pacientes";
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        ArrayList<Paciente> pacientes = new ArrayList<>();
        try {
            preparedStatement = conexionDB.getInstancia().getConexion().prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                pacientes.add(convertir(resultSet, id));
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

        return pacientes;
    }

}
