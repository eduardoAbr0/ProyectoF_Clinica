package com.tecjerez.proyecto_clinica.bd.modelo;


public class Cita {
    private int id;
    private String fechaCita;
    private String horaCita;
    private String motivo ;
    private String estado;
    private double costo;

    public Cita(int id, String fechaCita, String horaCita, String motivo, String estado, double costo) {
        this.id = id;
        this.fechaCita = fechaCita;
        this.horaCita = horaCita;
        this.motivo = motivo;
        this.estado = estado;
        this.costo = costo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFechaCita() {
        return fechaCita;
    }

    public void setFechaCita(String fechaCita) {
        this.fechaCita = fechaCita;
    }

    public String getHoraCita() {
        return horaCita;
    }

    public void setHoraCita(String horaCita) {
        this.horaCita = horaCita;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }
    
    
}
