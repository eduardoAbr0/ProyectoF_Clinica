package com.tecjerez.proyecto_clinica.bd.modelo;

public class Factura {
    private int id;
    private String fecha;
    private String rfc;

    public Factura(int id, String fecha, String rfc) {
        this.id = id;
        this.fecha = fecha;
        this.rfc = rfc;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }
       
}
