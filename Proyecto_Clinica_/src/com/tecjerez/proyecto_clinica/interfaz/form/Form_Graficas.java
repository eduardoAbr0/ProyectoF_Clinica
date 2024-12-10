/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.tecjerez.proyecto_clinica.interfaz.form;

import com.tecjerez.proyecto_clinica.bd.hilos;
import com.tecjerez.proyecto_clinica.bd.modelo.Cita;
import com.tecjerez.proyecto_clinica.bd.modelo.Empleado;
import com.tecjerez.proyecto_clinica.bd.modelo.Paciente;
import com.tecjerez.proyecto_clinica.bd.modelo.PacienteEdades;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.ArrayList;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

/**
 *
 * @author ed308
 */
public class Form_Graficas extends javax.swing.JPanel {

    private hilos h;
    private ArrayList<PacienteEdades> edades;
    private int medico;
    private int practicante;
    private int enfermera;

    public Form_Graficas() {
        initComponents();
    }

    public void consultarEmpleados() {
        ArrayList<Empleado> empleados = new ArrayList<>();

        h = new hilos("consultarTEmpleado");
        h.start();
        try {
            h.join();
            empleados = (ArrayList<Empleado>) h.getObjeto();
        } catch (InterruptedException b) {
            b.printStackTrace();
        }

        medico = 0;
        practicante = 0;
        enfermera = 0;
        for (Empleado a : empleados) {
            if (a.getTipoEmpleado().equalsIgnoreCase("Medico")) {
                medico++;
            } else if (a.getTipoEmpleado().equalsIgnoreCase("Enfermera")) {
                enfermera++;
            } else if (a.getTipoEmpleado().equalsIgnoreCase("Practicante")) {
                practicante++;
            }

        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        roundPanel1 = new com.tecjerez.proyecto_clinica.interfaz.swim.RoundPanel();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        roundPanel3 = new com.tecjerez.proyecto_clinica.interfaz.swim.RoundPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();

        setOpaque(false);

        roundPanel1.setBackground(new java.awt.Color(0, 204, 204));

        jButton2.setFont(new java.awt.Font("MS Gothic", 1, 18)); // NOI18N
        jButton2.setText("GRAFICAR EMPLEADOS");
        jButton2.setBorder(new javax.swing.border.MatteBorder(null));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("MS Gothic", 1, 18)); // NOI18N
        jButton4.setText("GRAFICAR PACIENTES");
        jButton4.setBorder(new javax.swing.border.MatteBorder(null));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout roundPanel1Layout = new javax.swing.GroupLayout(roundPanel1);
        roundPanel1.setLayout(roundPanel1Layout);
        roundPanel1Layout.setHorizontalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jButton2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(70, Short.MAX_VALUE))
        );
        roundPanel1Layout.setVerticalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addGap(150, 150, 150)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        roundPanel3.setBackground(new java.awt.Color(0, 204, 204));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 218, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 433, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 218, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout roundPanel3Layout = new javax.swing.GroupLayout(roundPanel3);
        roundPanel3.setLayout(roundPanel3Layout);
        roundPanel3Layout.setHorizontalGroup(
            roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel3Layout.createSequentialGroup()
                .addGap(149, 149, 149)
                .addGroup(roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(151, 151, 151))
        );
        roundPanel3Layout.setVerticalGroup(
            roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel3Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(76, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(roundPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(roundPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(roundPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(roundPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        DefaultPieDataset datos = new DefaultPieDataset();
        ArrayList<Paciente> pacientes = new ArrayList<>();

        h = new hilos("consultarTPaciente");
        h.start();
        try {
            h.join();
            pacientes = (ArrayList<Paciente>) h.getObjeto();
        } catch (InterruptedException b) {
            b.printStackTrace();
        }

        int masculino = 0;
        int femenino = 0;
        for (Paciente a : pacientes) {
            if (a.getSexo().equalsIgnoreCase("Masculino")) {
                masculino++;
            } else if (a.getSexo().equalsIgnoreCase("Femenino")) {
                femenino++;
            }
        }

        datos.setValue("Masculino", masculino);
        datos.setValue("Femenino", femenino);

        JFreeChart grafico_Pastel = ChartFactory.createPieChart("Pacientes por sexo", datos, true, true, false);

        ChartPanel panel = new ChartPanel(grafico_Pastel);
        panel.setMouseWheelEnabled(true);
        panel.setPreferredSize(new Dimension(400, 200));

        jPanel1.setLayout(new BorderLayout());
        jPanel1.add(panel, BorderLayout.CENTER);
        jPanel1.revalidate();

        //Grafica edades
        DefaultCategoryDataset datos2 = new DefaultCategoryDataset();
        h = new hilos("obtenerEdades");
        h.start();
        try {
            h.join();
            edades = (ArrayList<PacienteEdades>) h.getObjeto();
        } catch (InterruptedException b) {
            b.printStackTrace();
        }

        int rango25 = 0;
        int rango50 = 0;
        int rango75 = 0;
        int rango75mas = 0;

        for (PacienteEdades a : edades) {
            if (a.getEdad() <= 25) {
                rango25++;
            } else if (a.getEdad() <= 50) {
                rango50++;
            } else if (a.getEdad() <= 75) {
                rango75++;
            } else {
                rango75mas++;
            }
        }

        datos2.setValue(rango25, "pacientes", "Hasta 25 años");
        datos2.setValue(rango50, "pacientes", "25 a 50 años");
        datos2.setValue(rango75, "pacientes", "50 a 75 años");
        datos2.setValue(rango75mas, "pacientes", "mas de 75 años");

        JFreeChart grafico_Barras2 = ChartFactory.createBarChart3D("Rango de edades", "Rangos", "Cantidad", datos2, PlotOrientation.VERTICAL, true, true, false);

        ChartPanel panel2 = new ChartPanel(grafico_Barras2);
        panel2.setMouseWheelEnabled(true);
        panel2.setPreferredSize(new Dimension(400, 200));

        jPanel2.setLayout(new BorderLayout());
        jPanel2.add(panel2, BorderLayout.CENTER);
        jPanel2.revalidate();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        DefaultCategoryDataset datos = new DefaultCategoryDataset();

        consultarEmpleados();

        datos.setValue(medico, "Empleados", "Medico");
        datos.setValue(enfermera, "Empleados", "Enfermera");
        datos.setValue(practicante, "Empleados", "Practicante");

        JFreeChart grafico_Barras = ChartFactory.createBarChart3D("Categoria empleados", "Integrantes", "Cantidad", datos, PlotOrientation.VERTICAL, true, true, false);

        ChartPanel panel = new ChartPanel(grafico_Barras);
        panel.setMouseWheelEnabled(true);
        panel.setPreferredSize(new Dimension(400, 200));

        jPanel1.setLayout(new BorderLayout());
        jPanel1.add(panel, BorderLayout.CENTER);
        jPanel1.revalidate();

        /*DefaultCategoryDataset datos2 = new DefaultCategoryDataset();

        datos2.setValue(2, "", "Medico");
        datos2.setValue(4, "", "Enfermera");
        datos2.setValue(5, "", "Practicante");

        JFreeChart grafico_Barras2 = ChartFactory.createBarChart3D("Categoria empleados", "Integrantes", "Cantidad", datos, PlotOrientation.VERTICAL, true, true, false);

        ChartPanel panel2 = new ChartPanel(grafico_Barras);
        panel2.setMouseWheelEnabled(true);
        panel2.setPreferredSize(new Dimension(400, 200));

        jPanel2.setLayout(new BorderLayout());
        jPanel2.add(panel2, BorderLayout.CENTER);
        jPanel2.revalidate(); */
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private com.tecjerez.proyecto_clinica.interfaz.swim.RoundPanel roundPanel1;
    private com.tecjerez.proyecto_clinica.interfaz.swim.RoundPanel roundPanel3;
    // End of variables declaration//GEN-END:variables
}
