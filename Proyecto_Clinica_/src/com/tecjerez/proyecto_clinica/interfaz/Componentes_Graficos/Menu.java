/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.tecjerez.proyecto_clinica.interfaz.Componentes_Graficos;

import java.awt.Color;
import net.miginfocom.swing.MigLayout;
import com.tecjerez.proyecto_clinica.interfaz.swim.scrollbar.ScrollBarCustom;
import com.tecjerez.proyecto_clinica.interfaz.event.EventMenu;
import com.tecjerez.proyecto_clinica.interfaz.swim.ButtonMenu;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author ed308
 */
public class Menu extends javax.swing.JPanel {

    private EventMenu event; 
    
    public Menu() {
        initComponents();
        setOpaque(false);
        ScrollBarCustom sb = new ScrollBarCustom();
        sb.setForeground(new Color(130, 130, 130, 100));
        jScrollPane1.setVerticalScrollBar(sb);
        panelMenu.setLayout(new MigLayout("wrap, fillx, inset 3", "[fill]", "[]0[]"));
    }
    
    public void initMenu(EventMenu event) {
        this.event = event;
        addMenu(new ImageIcon(getClass().getResource("/com/tecjerez/proyecto_clinica/interfaz/iconos/icon-registromedico.png")), "Empleados", 0);
        addMenu(new ImageIcon(getClass().getResource("/com/tecjerez/proyecto_clinica/interfaz/iconos/icon-registrousuario.png")), "Pacientes", 1);
        addMenu(new ImageIcon(getClass().getResource("/com/tecjerez/proyecto_clinica/interfaz/iconos/icon-cita.png")), "Citas", 2);
        addMenu(new ImageIcon(getClass().getResource("/com/tecjerez/proyecto_clinica/interfaz/iconos/icon-partos.png")), "Partos", 3);
        addMenu(new ImageIcon(getClass().getResource("/com/tecjerez/proyecto_clinica/interfaz/iconos/icon-operaciones.png")), "Operaciones", 4);
        addMenu(new ImageIcon(getClass().getResource("/com/tecjerez/proyecto_clinica/interfaz/iconos/icon-diagnosticos.png")), "Diagnosticos", 5);
        addMenu(new ImageIcon(getClass().getResource("/com/tecjerez/proyecto_clinica/interfaz/iconos/icon-facturas.png")), "Facturas", 6);
        addMenu(new ImageIcon(getClass().getResource("/com/tecjerez/proyecto_clinica/interfaz/iconos/icon-pago.png")), "Pagos", 7);
        //addMenu(new ImageIcon(getClass().getResource("/com/tecjerez/proyecto_clinica/interfaz/iconos/icon-registrousuario.png")), "Reportes cobertura semanal", 6);
        //addMenu(new ImageIcon(getClass().getResource("/com/tecjerez/proyecto_clinica/interfaz/iconos/icon-registrousuario.png")), "Reportes maestro diario", 1);
        addMenu(new ImageIcon(getClass().getResource("/com/tecjerez/proyecto_clinica/interfaz/iconos/icon-reportes.png")), "Reportes medicos", 8);
        addEmpty();
        addMenu(new ImageIcon(getClass().getResource("/com/tecjerez/proyecto_clinica/interfaz/iconos/icon-cerrarsesion.png")), "Cerrar sesión", 9);
    }
    
    private void addEmpty() {
        panelMenu.add(new JLabel(), "push");
    }

    private void addMenu(Icon icon, String text, int index) {
        ButtonMenu menu = new ButtonMenu();
        menu.setIcon(icon);
        menu.setText("  " + text);
        panelMenu.add(menu);
        menu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                event.selected(index);
                setSelected(menu);
            }
        });
    }

    private void setSelected(ButtonMenu menu) {
        for (Component com : panelMenu.getComponents()) {
            if (com instanceof ButtonMenu) {
                ButtonMenu b = (ButtonMenu) com;
                b.setSelected(false);
            }
        }
        menu.setSelected(true);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        roundPanel1 = new com.tecjerez.proyecto_clinica.interfaz.swim.RoundPanel();
        imageAvatar1 = new com.tecjerez.proyecto_clinica.interfaz.swim.ImageAvatar();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        roundPanel2 = new com.tecjerez.proyecto_clinica.interfaz.swim.RoundPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        panelMenu = new javax.swing.JPanel();

        roundPanel1.setBackground(new java.awt.Color(51, 51, 51));

        imageAvatar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/tecjerez/proyecto_clinica/interfaz/iconos/icon-usuario.png"))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Usuario");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("BIENVENIDO");

        jLabel3.setForeground(new java.awt.Color(204, 204, 204));
        jLabel3.setText("Admin");

        javax.swing.GroupLayout roundPanel1Layout = new javax.swing.GroupLayout(roundPanel1);
        roundPanel1.setLayout(roundPanel1Layout);
        roundPanel1Layout.setHorizontalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(roundPanel1Layout.createSequentialGroup()
                        .addComponent(imageAvatar1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        roundPanel1Layout.setVerticalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addGap(0, 10, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(1, 1, 1)
                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(1, 1, 1)
                        .addComponent(jLabel3)
                        .addContainerGap())
                    .addComponent(imageAvatar1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        roundPanel2.setBackground(new java.awt.Color(51, 51, 51));

        jScrollPane1.setBorder(null);
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        panelMenu.setBackground(new java.awt.Color(51, 51, 51));

        javax.swing.GroupLayout panelMenuLayout = new javax.swing.GroupLayout(panelMenu);
        panelMenu.setLayout(panelMenuLayout);
        panelMenuLayout.setHorizontalGroup(
            panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 208, Short.MAX_VALUE)
        );
        panelMenuLayout.setVerticalGroup(
            panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 531, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(panelMenu);

        javax.swing.GroupLayout roundPanel2Layout = new javax.swing.GroupLayout(roundPanel2);
        roundPanel2.setLayout(roundPanel2Layout);
        roundPanel2Layout.setHorizontalGroup(
            roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        roundPanel2Layout.setVerticalGroup(
            roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(roundPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(roundPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(roundPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(roundPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.tecjerez.proyecto_clinica.interfaz.swim.ImageAvatar imageAvatar1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panelMenu;
    private com.tecjerez.proyecto_clinica.interfaz.swim.RoundPanel roundPanel1;
    private com.tecjerez.proyecto_clinica.interfaz.swim.RoundPanel roundPanel2;
    // End of variables declaration//GEN-END:variables
}
