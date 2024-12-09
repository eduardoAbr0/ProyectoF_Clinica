/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tecjerez.proyecto_clinica.bd.modelo;

public class Paciente {
    private int id;
    private String nombre;
    private String Papellido;
    private String Sapellido ;
    private String fechaNac;
    private String sexo;
    private String tipoSangre;
    private String alergias;
    private int telefono;
    private String fechaRegistro;

    public Paciente(int id, String nombre, String Papellido, String Sapellido, String fechaNac, String sexo, String tipoSangre, String alergias, int telefono, String fechaRegistro) {
        this.id = id;
        this.nombre = nombre;
        this.Papellido = Papellido;
        this.Sapellido = Sapellido;
        this.fechaNac = fechaNac;
        this.sexo = sexo;
        this.tipoSangre = tipoSangre;
        this.alergias = alergias;
        this.telefono = telefono;
        this.fechaRegistro = fechaRegistro;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPapellido() {
        return Papellido;
    }

    public void setPapellido(String Papellido) {
        this.Papellido = Papellido;
    }

    public String getSapellido() {
        return Sapellido;
    }

    public void setSapellido(String Sapellido) {
        this.Sapellido = Sapellido;
    }

    public String getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(String fechaNac) {
        this.fechaNac = fechaNac;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getTipoSangre() {
        return tipoSangre;
    }

    public void setTipoSangre(String tipoSangre) {
        this.tipoSangre = tipoSangre;
    }

    public String getAlergias() {
        return alergias;
    }

    public void setAlergias(String alergias) {
        this.alergias = alergias;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(String fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }


}
