/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.tecjerez.proyecto_clinica.interfaz;

import com.tecjerez.proyecto_clinica.interfaz.event.EventMenu;
import com.tecjerez.proyecto_clinica.interfaz.login;
import com.tecjerez.proyecto_clinica.interfaz.form.Form;
import com.tecjerez.proyecto_clinica.interfaz.form.Form_Citas;
import com.tecjerez.proyecto_clinica.interfaz.form.Form_Diagnosticos;
import com.tecjerez.proyecto_clinica.interfaz.form.Form_Empleados;
import com.tecjerez.proyecto_clinica.interfaz.form.Form_Facturas;
import com.tecjerez.proyecto_clinica.interfaz.form.Form_Operaciones;
import com.tecjerez.proyecto_clinica.interfaz.form.Form_Pacientes;
import com.tecjerez.proyecto_clinica.interfaz.form.Form_Pagos;
import com.tecjerez.proyecto_clinica.interfaz.form.Form_Partos;
import com.tecjerez.proyecto_clinica.interfaz.form.Form_Graficas;
import java.awt.*;
import java.awt.Component;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
 
public class main extends javax.swing.JFrame {

    private int x,y;
    private login lg;
    
    public main() {
        initComponents();
        setBackground(new Color(0, 0, 0, 0));
        EventMenu event = new EventMenu() {
            @Override
            public void selected(int index) {
                if (index == 0) {
                    showForm(new Form_Empleados());
                } else if (index == 1) {
                    showForm(new Form_Pacientes());
                }else if (index == 2) {
                    showForm(new Form_Citas());
                }else if (index == 3) {
                    showForm(new Form_Partos());
                }else if (index == 4) {
                    showForm(new Form_Operaciones());
                }else if (index == 5) {
                    showForm(new Form_Diagnosticos());
                }else if (index == 6) {
                    showForm(new Form_Facturas());
                }else if (index == 7) {
                    showForm(new Form_Pagos());
                }else if (index == 8) {
                    showForm(new Form_Graficas());
                }else if (index == 9) {
                    lg = new login();
                    lg.setVisible(true);
                    
                    dispose();
                } else {
                    showForm(new Form(index));
                }
            }
        };
        menu1.initMenu(event);
        showForm(new Form_Empleados());
    }

    private void showForm(Component com) {
        body.removeAll();
        body.add(com);
        body.revalidate();
        body.repaint();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        roundPanel1 = new com.tecjerez.proyecto_clinica.interfaz.swim.RoundPanel();
        header1 = new com.tecjerez.proyecto_clinica.interfaz.Componentes_Graficos.Header();
        menu1 = new com.tecjerez.proyecto_clinica.interfaz.Componentes_Graficos.Menu();
        body = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                formMouseDragged(evt);
            }
        });
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
        });

        roundPanel1.setBackground(new java.awt.Color(21, 21, 21));

        body.setBackground(new java.awt.Color(51, 51, 51));
        body.setOpaque(false);
        body.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout roundPanel1Layout = new javax.swing.GroupLayout(roundPanel1);
        roundPanel1.setLayout(roundPanel1Layout);
        roundPanel1Layout.setHorizontalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(header1, javax.swing.GroupLayout.DEFAULT_SIZE, 1600, Short.MAX_VALUE)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(menu1, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(body, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        roundPanel1Layout.setVerticalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addComponent(header1, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(menu1, javax.swing.GroupLayout.DEFAULT_SIZE, 722, Short.MAX_VALUE)
                    .addComponent(body, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(roundPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(roundPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        x = evt.getX();
        y = evt.getY();
    }//GEN-LAST:event_formMousePressed

    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        setLocation(evt.getXOnScreen()-x, evt.getYOnScreen()-y);
    }//GEN-LAST:event_formMouseDragged

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
            JFrame.setDefaultLookAndFeelDecorated(true);
            JDialog.setDefaultLookAndFeelDecorated(true);

        } catch (UnsupportedLookAndFeelException | ClassNotFoundException | InstantiationException | IllegalAccessException e){
            e.printStackTrace();
        }
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel body;
    private com.tecjerez.proyecto_clinica.interfaz.Componentes_Graficos.Header header1;
    private com.tecjerez.proyecto_clinica.interfaz.Componentes_Graficos.Menu menu1;
    private com.tecjerez.proyecto_clinica.interfaz.swim.RoundPanel roundPanel1;
    // End of variables declaration//GEN-END:variables
}
