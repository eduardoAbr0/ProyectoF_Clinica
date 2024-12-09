package com.tecjerez.proyecto_clinica.bd.controlador;

import java.sql.SQLException;
import java.util.List;

public interface DAO<T, K> {
    public void insertar(T t) throws SQLException;
    public void actualizar(T t) throws SQLException;
    public void eliminar(K id) throws SQLException;
    public T buscar(K id) throws SQLException;
    public List<T> buscarTodos() throws SQLException;
}
