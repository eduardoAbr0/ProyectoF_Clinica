
package com.tecjerez.proyecto_clinica.bd;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conexionDB {
    private static conexionDB instancia;
    protected Connection conexion;

    private conexionDB() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String connectionUrl =
                "jdbc:sqlserver://BSRK\\SQLEXPRESS:1433;"
                        + "database=clinica;"
                        + "user=sqlEjemplo;"
                        + "password=root;"
                        + "encrypt=false;"
                        + "trustServerCertificate=false;"
                        + "loginTimeout=30;";
            //String URL = "jdbc:sqlserver://BSRK\\SQLEXPRESS:1433;databaseName=clinica";
            conexion = DriverManager.getConnection(connectionUrl);
            System.out.println("Conexion exitosa con BD");
        } catch (ClassNotFoundException e) {
            //throw new RuntimeException(e);
            System.out.println("Error en el DRIVER");
        } catch (SQLException e) {
            //System.out.print(e);
            System.out.println("Error en la URL");
        }
    }
    public static conexionDB getInstancia(){
        if(instancia == null){
            instancia = new conexionDB();
        }
        return instancia;
    }

    public Connection getConexion() {
        return conexion;
    }

    public void desconectar(){
        if (conexion != null) {
            try {
                conexion.close();
                System.out.println("Conexión cerrada correctamente");
            } catch (SQLException e) {
                System.err.println("Error al cerrar la conexión.");
            }
        }

    }
}
