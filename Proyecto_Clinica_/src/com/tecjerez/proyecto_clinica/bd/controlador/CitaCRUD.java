package com.tecjerez.proyecto_clinica.bd.controlador;

import com.tecjerez.proyecto_clinica.bd.conexionDB;
import com.tecjerez.proyecto_clinica.bd.modelo.Cita;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.List;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import javax.swing.SwingUtilities;

public class CitaCRUD implements DAOCita {

    @Override
    public void insertar(Cita cita) {
        String sql = "INSERT INTO clinica.cita(Fecha_Cita, Hora_Cita, Motivo_Cita, Estado, Costo_Cita, Paciente_idPaciente, Empleado_idEmpleado) VALUES(?,?,?,?,?,?,?)";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = conexionDB.getInstancia().getConexion().prepareStatement(sql);
            preparedStatement.setString(1, cita.getFechaCita());
            preparedStatement.setString(2, cita.getHoraCita());
            preparedStatement.setString(3, cita.getMotivo());
            preparedStatement.setString(4, cita.getEstado());
            preparedStatement.setDouble(5, cita.getCosto());
            preparedStatement.setInt(6, cita.getPacienteId());
            preparedStatement.setInt(7, cita.getMedicoId());
            if (preparedStatement.executeUpdate() >= 1) {
                JOptionPane.showMessageDialog(null, "Cita agregada correctamente", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            String mensajeError = e.getMessage();

            if (mensajeError.contains("FOREIGN KEY constraint") && mensajeError.contains("cita$fk_Cita_Empleado1")) {
                JOptionPane.showMessageDialog(null, "Error: El medico no existe.", "Error", JOptionPane.WARNING_MESSAGE);
            } else if (mensajeError.contains("FOREIGN KEY constraint") && mensajeError.contains("cita$fk_Cita_Paciente1")) {
                JOptionPane.showMessageDialog(null, "Error: El paciente no existe.", "Error", JOptionPane.WARNING_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Error SQL: " + mensajeError, "Error", JOptionPane.ERROR_MESSAGE);
                e.printStackTrace();
            }

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
    public void actualizar(Cita cita) {
        String sql = "UPDATE clinica.cita SET Fecha_Cita = ?, Hora_Cita = ?, Motivo_Cita = ?, Estado = ?, Costo_Cita = ? WHERE idCita = ?";
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
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró la cita.", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
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
    public void eliminar(Integer id) {
        String sql = "DELETE FROM clinica.cita WHERE idCita = ?";
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
        String motivo = rs.getString("Motivo_Cita");
        String estado = rs.getString("Estado");
        double costo = rs.getDouble("Costo_Cita");
        int idPaciente = rs.getInt("Paciente_idPaciente");
        int idMedico = rs.getInt("Empleado_idEmpleado");

        cita = new Cita(id, fechaCita, horaCita, motivo, estado, costo);
        cita.setPacienteId(idPaciente);
        cita.setMedicoId(idMedico);
        return cita;
    }

    @Override
    public Cita buscar(Integer id) {
        String sql = "SELECT * FROM clinica.cita WHERE idCita = ?";
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
                SwingUtilities.invokeLater(() -> {
                    JOptionPane.showMessageDialog(null, "No se encontró registro", "Error", JOptionPane.WARNING_MESSAGE);
                });
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
    public List<Cita> buscarTodos() {
        String sql = "SELECT * FROM dbo.viewCitasPacientes";
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        ArrayList<Cita> citas = new ArrayList<>();
        try {
            preparedStatement = conexionDB.getInstancia().getConexion().prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                System.out.println("Procesando fila...");
                Cita cita = null;
                int id = resultSet.getInt(1);
                String fechaCita = resultSet.getString("Fecha_Cita");
                String estado = resultSet.getString("Estado");
                int idPaciente = resultSet.getInt("idPaciente");
                String nombre = resultSet.getString("nombre");
                String primerap = resultSet.getString("primer_Apellido");
                int telefono = resultSet.getInt("Num_Telefono");

                cita = new Cita(id, fechaCita, null, null, estado, idPaciente);
                cita.setPacienteId(idPaciente);
                cita.setNombre(nombre);
                cita.setPrimerAp(primerap);
                cita.setTelefono(telefono);
                citas.add(cita);
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
