package driver;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import entities.Login;

@Dao
public interface loginDAO {
    //ALTAS
    @Insert
    public void agregarUsuario(Login login);


    //CONSULTAS
    @Query("SELECT * FROM Login WHERE usuario=:u")
    public int busquedaByID(String u);

}