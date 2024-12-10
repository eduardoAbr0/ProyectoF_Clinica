package com.tecjerez.proyecto_clinica.bd.controlador;

import com.tecjerez.proyecto_clinica.bd.conexionDB;
import com.tecjerez.proyecto_clinica.bd.modelo.PacienteEdades;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class PacientesGraficas {

    public List<PacienteEdades> obtenerEdades() {
        String sql = "{CALL ObtenerPacientesEdad}";
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        ArrayList<PacienteEdades> pacientes = new ArrayList<>();
        try {
            preparedStatement = conexionDB.getInstancia().getConexion().prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {

                int id = resultSet.getInt(1);
                PacienteEdades paciente = null;
                int edad = Integer.parseInt(resultSet.getString("Edad"));

                paciente = new PacienteEdades(id, edad);
                pacientes.add(paciente);
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

    public PacienteEdades obtenerEdad(Integer id) {
        String sql = "SELECT idPaciente, dbo.CalcularEdad(Fecha_Nacimiento) AS Edad FROM clinica.paciente WHERE idPaciente = ?;;";
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        PacienteEdades paciente = null;

        try {
            preparedStatement = conexionDB.getInstancia().getConexion().prepareStatement(sql);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                int nombre = resultSet.getInt("idPaciente");
                int edad = resultSet.getInt("Edad");

                paciente = new PacienteEdades(id, edad);
            } else {
                SwingUtilities.invokeLater(() -> {
                    JOptionPane.showMessageDialog(null, "No se encontró registro", "Error", JOptionPane.WARNING_MESSAGE);
                });
            }
        } catch (SQLException e) {
            e.printStackTrace();
            SwingUtilities.invokeLater(() -> {
            JOptionPane.showMessageDialog(null, "Error SQL", "Error", JOptionPane.ERROR_MESSAGE);
            });
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
}
