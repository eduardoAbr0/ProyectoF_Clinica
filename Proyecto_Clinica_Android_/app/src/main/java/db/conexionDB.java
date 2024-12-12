package db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import driver.empleadoDAO;
import driver.loginDAO;
import driver.pacienteDAO;
import entities.Empleado;
import entities.Login;
import entities.Paciente;


@Database(entities = {Empleado.class, Paciente.class, Login.class}, version =  1)
public abstract class conexionDB extends RoomDatabase {
    private static conexionDB INSTANCE;

    public abstract empleadoDAO empleadoDAO();
    public abstract pacienteDAO pacienteDAO();
    public abstract loginDAO loginDAO();

    public static conexionDB getAppDatabase(Context context){
        if (INSTANCE == null){
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                    conexionDB.class, "conexionBD").build();
        }

        return INSTANCE;
    }

    public static void destroyInstance(){
        INSTANCE = null;
    }
}
