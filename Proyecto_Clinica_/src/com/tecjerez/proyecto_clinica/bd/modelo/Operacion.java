package com.tecjerez.proyecto_clinica.bd.modelo;


public class Operacion {
    private int id;
    private String tipo;
    private String fecha;
    private String duracion ;
    private String observaciones;
    private double costo;

    public Operacion(int id, String tipo, String fecha, String duracion, String observaciones, double costo) {
        this.id = id;
        this.tipo = tipo;
        this.fecha = fecha;
        this.duracion = duracion;
        this.observaciones = observaciones;
        this.costo = costo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }
    
    
}
