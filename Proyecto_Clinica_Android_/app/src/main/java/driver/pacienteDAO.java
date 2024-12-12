package driver;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import entities.Paciente;

@Dao
public interface pacienteDAO {
    //ALTAS
    @Insert
    public void agregarPaciente(Paciente paciente);

    //BAJAS
    @Delete
    public void eliminarPaciente(Paciente paciente);

    @Query("DELETE FROM Paciente WHERE id=:nc")
    public int deleteByID(String nc);

    //CAMBIOS

    @Update
    public void updatePaciente(Paciente paciente);
    @Query("UPDATE Paciente SET Nombre=:n, PrimerApellido=:pa, SegundoApellido=:sa, FechaNac=:f, Sexo=:s, Sangre=:san, Alergias=:a, Telefono=:t WHERE id=:nc")
    public void updatePacienteByID(String n, String pa, String sa, String f, String s, String san, String a, String t, String nc);

    //CONSULTAS
    @Query("SELECT * FROM Paciente")
    public List<Paciente> mostrarTodos();

}

