/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.tecjerez.proyecto_clinica.interfaz.Componentes_Graficos;

import com.tecjerez.proyecto_clinica.interfaz.swim.ButtonC;
import com.tecjerez.proyecto_clinica.interfaz.swim.MyTextField;
import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import net.miginfocom.swing.MigLayout;

public class PanelLoginRegister extends javax.swing.JLayeredPane {
      
    public PanelLoginRegister() {
        initComponents();
        initRegister();
        initLogin();
        login.setVisible(false);
        register.setVisible(true);
    }
    
    private void initRegister(){
        register.setLayout(new MigLayout("wrap","push[center]push","push[]25[]10[]push"));
        JLabel label = new JLabel("Crear cuenta");
        label.setFont(new Font("sansserif",1,30));
        label.setForeground(new Color(153, 204, 255));
        register.add(label);
        MyTextField txtUser = new MyTextField();
        txtUser.setPrefixIcon(new ImageIcon(getClass().getResource("/com/tecjerez/proyecto_clinica/interfaz/iconos/user.png")));
        txtUser.setHint("Nombre de usuario");
        register.add(txtUser, "w 60%");
        MyTextField txtPassw = new MyTextField();
        txtPassw.setPrefixIcon(new ImageIcon(getClass().getResource("/com/tecjerez/proyecto_clinica/interfaz/iconos/pass.png")));
        txtPassw.setHint("Contraseña");
        register.add(txtPassw, "w 60%");
        ButtonC cmd = new ButtonC();
        cmd.setBackground(new Color(153, 204, 255));
        cmd.setForeground(new Color(250,250,250));
        cmd.setLabel("Crear usuario");
        register.add(cmd,"w 40%, h 40");
    }
    
    private void initLogin(){
        login.setLayout(new MigLayout("wrap","push[center]push","push[]25[]10[]push"));
        JLabel label = new JLabel("Iniciar sesión");
        label.setFont(new Font("sansserif",1,30));
        label.setForeground(new Color(153, 204, 255));
        login.add(label);
        MyTextField txtUser = new MyTextField();
        txtUser.setPrefixIcon(new ImageIcon(getClass().getResource("/com/tecjerez/proyecto_clinica/interfaz/iconos/user.png")));
        txtUser.setHint("Nombre de usuario");
        login.add(txtUser, "w 60%");
        MyTextField txtPassw = new MyTextField();
        txtPassw.setPrefixIcon(new ImageIcon(getClass().getResource("/com/tecjerez/proyecto_clinica/interfaz/iconos/pass.png")));
        txtPassw.setHint("Contraseña");
        login.add(txtPassw, "w 60%");
        ButtonC cmd = new ButtonC();
        cmd.setBackground(new Color(153, 204, 255));
        cmd.setForeground(new Color(250,250,250));
        cmd.setLabel("Entrar");
        login.add(cmd,"w 40%, h 40");
    }
    
    public void showRegister(boolean show){
        if(show){
            register.setVisible(true);
            login.setVisible(false);
        }else{
            register.setVisible(false);
            login.setVisible(true);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        login = new javax.swing.JPanel();
        register = new javax.swing.JPanel();

        setLayout(new java.awt.CardLayout());

        login.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout loginLayout = new javax.swing.GroupLayout(login);
        login.setLayout(loginLayout);
        loginLayout.setHorizontalGroup(
            loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        loginLayout.setVerticalGroup(
            loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        add(login, "card3");

        register.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout registerLayout = new javax.swing.GroupLayout(register);
        register.setLayout(registerLayout);
        registerLayout.setHorizontalGroup(
            registerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        registerLayout.setVerticalGroup(
            registerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        add(register, "card2");
    }// </editor-fold>//GEN-END:initComponents

  
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel login;
    private javax.swing.JPanel register;
    // End of variables declaration//GEN-END:variables
}
