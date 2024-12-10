/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tecjerez.proyecto_clinica.bd;

import com.tecjerez.proyecto_clinica.bd.controlador.CitaCRUD;
import com.tecjerez.proyecto_clinica.bd.controlador.DiagnosticoCRUD;
import com.tecjerez.proyecto_clinica.bd.controlador.EmpleadoCRUD;
import com.tecjerez.proyecto_clinica.bd.controlador.FacturaCRUD;
import com.tecjerez.proyecto_clinica.bd.controlador.OperacionCRUD;
import com.tecjerez.proyecto_clinica.bd.controlador.PacienteCRUD;
import com.tecjerez.proyecto_clinica.bd.controlador.PagoCRUD;
import com.tecjerez.proyecto_clinica.bd.controlador.PartoCRUD;
import com.tecjerez.proyecto_clinica.bd.modelo.Empleado;
import com.tecjerez.proyecto_clinica.bd.modelo.Paciente;
import com.tecjerez.proyecto_clinica.bd.modelo.Cita;
import com.tecjerez.proyecto_clinica.bd.modelo.Diagnostico;
import com.tecjerez.proyecto_clinica.bd.modelo.Factura;
import com.tecjerez.proyecto_clinica.bd.modelo.PacienteEdades;
import com.tecjerez.proyecto_clinica.bd.modelo.Operacion;
import com.tecjerez.proyecto_clinica.bd.controlador.PacientesGraficas;
import com.tecjerez.proyecto_clinica.bd.modelo.Pago;
import com.tecjerez.proyecto_clinica.bd.modelo.Parto;

public class hilos extends Thread {

    String operacio;
    Object objeto;
    int id;
    EmpleadoCRUD empleado = new EmpleadoCRUD();
    PacienteCRUD paciente = new PacienteCRUD();
    CitaCRUD cita = new CitaCRUD();
    PartoCRUD parto = new PartoCRUD();
    DiagnosticoCRUD diagnostico = new DiagnosticoCRUD();
    OperacionCRUD operacion = new OperacionCRUD();
    PagoCRUD pago = new PagoCRUD();
    FacturaCRUD factura = new FacturaCRUD();
    PacientesGraficas edades = new PacientesGraficas();

    public hilos(String operacion) {
        this.operacio = operacion;
        this.objeto = objeto;
    }

    @Override
    public void run() {
        switch (operacio) {
            case "insertarEmpleado":
                empleado.insertar((Empleado) objeto);
                break;
            case "eliminarEmpleado":
                empleado.eliminar(id);
                break;
            case "cambiarEmpleado":
                empleado.actualizar((Empleado) objeto);
                break;
            case "consultarEmpleado":
                objeto = empleado.buscar(id);
                break;
            case "consultarTEmpleado":
                objeto = empleado.buscarTodos();
                break;
            case "insertarPaciente":
                paciente.insertar((Paciente) objeto);
                break;
            case "eliminarPaciente":
                paciente.eliminar(id);
                break;
            case "cambiarPaciente":
                paciente.actualizar((Paciente) objeto);
                break;
            case "consultarPaciente":
                objeto = paciente.buscar(id);
                break;
            case "consultarTPaciente":
                objeto = paciente.buscarTodos();
                break;
            case "insertarCita":
                cita.insertar((Cita) objeto);
                break;
            case "eliminarCita":
                cita.eliminar(id);
                break;
            case "cambiarCita":
                cita.actualizar((Cita) objeto);
                break;
            case "consultarCita":
                objeto = cita.buscar(id);
                break;
            case "consultarTCita":
                objeto = cita.buscarTodos();
                break;
            case "insertarParto":
                parto.insertar((Parto) objeto);
                break;
            case "eliminarParto":
                parto.eliminar(id);
                break;
            case "cambiarParto":
                parto.actualizar((Parto) objeto);
                break;
            case "consultarParto":
                objeto = parto.buscar(id);
                break;
            case "consultarTPartos":
                objeto = parto.buscarTodos();
                break;
            case "insertarDiagnostico":
                diagnostico.insertar((Diagnostico) objeto);
                break;
            case "eliminarDiagnostico":
                diagnostico.eliminar(id);
                break;
            case "cambiarDiagnostico":
                diagnostico.actualizar((Diagnostico) objeto);
                break;
            case "consultarDiagnostico":
                objeto = diagnostico.buscar(id);
                break;
            case "consultarTDiagnosticos":
                objeto = diagnostico.buscarTodos();
                break;
            case "insertarOperacion":
                operacion.insertar((Operacion) objeto);
                break;
            case "eliminarOperacion":
                operacion.eliminar(id);
                break;
            case "cambiarOperacion":
                operacion.actualizar((Operacion) objeto);
                break;
            case "consultarOperacion":
                objeto = operacion.buscar(id);
                break;
            case "consultarTOperacion":
                objeto = operacion.buscarTodos();
                break;
            case "insertarPago":
                pago.insertar((Pago) objeto);
                break;
            case "eliminarPago":
                pago.eliminar(id);
                break;
            case "cambiarPago":
                pago.actualizar((Pago) objeto);
                break;
            case "consultarPago":
                objeto = pago.buscar(id);
                break;
            case "consultarTPago":
                objeto = pago.buscarTodos();
                break;
            case "insertarFactura":
                factura.insertar((Factura) objeto);
                break;
            case "eliminarFactura":
                factura.eliminar(id);
                break;
            case "cambiarFactura":
                factura.actualizar((Factura) objeto);
                break;
            case "consultarFactura":
                objeto = factura.buscar(id);
                break;
            case "consultarTFactura":
                objeto = factura.buscarTodos();
                break;
            case "obtenerEdades":
                objeto = edades.obtenerEdades();
                break;
            case "obtenerEdad":
                objeto = edades.obtenerEdad(id);
                break;
        }
    }

    public Object getObjeto() {
        return objeto;
    }

    public void setObjeto(Object objeto) {
        this.objeto = objeto;
    }

    public void setId(int id) {
        this.id = id;
    }
}
