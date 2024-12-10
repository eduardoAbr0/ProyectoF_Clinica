package com.tecjerez.proyecto_clinica.bd.modelo;

public class Empleado {
    private int id;
    private String nombre;
    private String Papellido;
    private String Sapellido ;
    private int numeroCasa;
    private String calle;
    private String colonia;
    private int cp;
    private int telefono;
    private String tipoEmpleado;

    public Empleado(int id, String nombre, String papellido, String sapellido,String calle, int numeroCasa, String colonia, int cp, int telefono, String tipoEmpleado) {
        this.id = id;
        this.nombre = nombre;
        this.Papellido = papellido;
        this.Sapellido = sapellido;
        this.numeroCasa = numeroCasa;
        this.calle = calle;
        this.colonia = colonia;
        this.cp = cp;
        this.telefono = telefono;
        this.tipoEmpleado = tipoEmpleado;
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

    public void setPapellido(String papellido) {
        Papellido = papellido;
    }

    public String getSapellido() {
        return Sapellido;
    }

    public void setSapellido(String sapellido) {
        Sapellido = sapellido;
    }

    public int getNumeroCasa() {
        return numeroCasa;
    }

    public void setNumeroCasa(int numeroCasa) {
        this.numeroCasa = numeroCasa;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public int getCp() {
        return cp;
    }

    public void setCp(int cp) {
        this.cp = cp;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getTipoEmpleado() {
        return tipoEmpleado;
    }

    public void setTipoEmpleado(String tipoEmpleado) {
        this.tipoEmpleado = tipoEmpleado;
    }

}
