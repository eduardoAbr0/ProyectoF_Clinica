/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.tecjerez.proyecto_clinica.interfaz.Componentes_Graficos;

import com.tecjerez.proyecto_clinica.interfaz.swim.ButtonOutLine;
import com.tecjerez.proyecto_clinica.bd.conexionDB;
import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import javax.swing.JLabel;
import net.miginfocom.swing.MigLayout;


public class PanelCover extends javax.swing.JPanel {
    
    private final DecimalFormat df = new DecimalFormat("##0.###");
    private ActionListener event;
    private MigLayout layout;
    private JLabel titulo;
    private JLabel descripcion;
    private JLabel descripcion1;
    private ButtonOutLine button;
    private ButtonOutLine button1;
    private boolean isLogin;
   
    public PanelCover() {
        initComponents();
        setOpaque(false);
        layout = new MigLayout("wrap, fill","[center]","push[]25[]10[]25[]10[]push");
        setLayout(layout);
        init();
    }
    
    private void init(){
        titulo = new JLabel("Bienvenido");
        titulo.setFont(new Font("sansserif",1,30));
        titulo.setForeground(new Color(245,245,245));
        add(titulo);
        descripcion = new JLabel("Grupo Clínica de Bienestar");
        descripcion.setFont(new Font("sansserif",0,14));
        descripcion.setForeground(new Color(245,245,245));
        add(descripcion);
        descripcion1 = new JLabel("Ingresa los datos para registro");
        descripcion1.setFont(new Font("sansserif",0,14));
        descripcion1.setForeground(new Color(245,245,245));
        add(descripcion1);
        button = new ButtonOutLine();
        button.setBackground(new Color(245,245,245));
        button.setForeground(new Color(245,245,245));
        button.setText("Iniciar sesión");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               event.actionPerformed(e);
            }
        });
        add(button,"w 60%, h 40");
        button1 = new ButtonOutLine();
        button1.setBackground(new Color(255,0,0));
        button1.setForeground(new Color(255,0,0));
        button1.setText("Salir");
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        add(button1,"w 20%, h 40");
    }
    
    
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        GradientPaint gra = new GradientPaint(0,0, new Color(165,220,255), 0, getHeight(), new Color(122,186,229));
        g2.setPaint(gra);
        g2.fillRect(0, 0, getWidth(), getHeight());
        super.paintComponent(g); 
    }
    
    public void addEvent(ActionListener event){
        this.event = event;
    }
    
    public void registerIzq(double v){
        v = Double.valueOf(df.format(v));
        login(false);
        layout.setComponentConstraints(titulo, "pad 0 -"+v+"% 0 0");
        layout.setComponentConstraints(descripcion, "pad 0 -" + v + "% 0 0");
        layout.setComponentConstraints(descripcion1, "pad 0 -" + v + "% 0 0");
    }
    
    public void registerDer(double v){
        v = Double.valueOf(df.format(v));
        login(false);
        layout.setComponentConstraints(titulo, "pad 0 -"+v+"% 0 0");
        layout.setComponentConstraints(descripcion, "pad 0 -" + v + "% 0 0");
        layout.setComponentConstraints(descripcion1, "pad 0 -" + v + "% 0 0");
    }
    
    public void loginIzq(double v){
        v = Double.valueOf(df.format(v));
        login(true);
        layout.setComponentConstraints(titulo, "pad 0 "+v+"% 0 "+v+" %");
        layout.setComponentConstraints(descripcion, "pad 0 " + v + "% 0 " + v + "%");
        layout.setComponentConstraints(descripcion1, "pad 0 " + v + "% 0 " + v + "%");
    }
    
    public void loginDer(double v){
        v = Double.valueOf(df.format(v));
        login(false);
        layout.setComponentConstraints(titulo, "pad 0 " + v + "% 0 " + v + "%");
        layout.setComponentConstraints(descripcion, "pad 0 " + v + "% 0 " + v + "%");
        layout.setComponentConstraints(descripcion1, "pad 0 " + v + "% 0 " + v + "%");
    }
    
    public void login(boolean login){
        if (this.isLogin != login) {
            if (login) {
                titulo.setText("Bienvenido");
                descripcion1.setText("Ingresa datos para iniciar");
                button.setText("Crear una cuenta de usuario");
            } else {
                titulo.setText("Bienvenido");
                descripcion1.setText("Ingresa datos para registro");
                button.setText("Logear con cuenta");
            }
            this.isLogin = login;
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
