package driver;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import entities.Empleado;

@Dao
public interface empleadoDAO {
    //ALTAS
    @Insert
    public void agregarEmpleado(Empleado empleado);

    //BAJAS
    @Delete
    public void eliminarEmpleado(Empleado empleado);

    @Query("DELETE FROM Empleado WHERE id=:nc")
    public int deleteByID(String nc);

    //CAMBIOS
    @Update
    public void updateEmpleado(Empleado empleado);
    @Query("UPDATE Empleado SET Nombre=:n, PrimerApellido=:p, SegundoApellido=:sa, Calle=:ca, NumeroCasa=:nca, Colonia=:c, CodigoPostal=:cp, Telefono=:t, Puesto=:pu WHERE id=:nc")
    public void updateEmpleadoByID(String n, String p, String sa, String ca, int nca, String c, int cp, String t, String pu, String nc);

    //CONSULTAS
    @Query("SELECT * FROM Empleado")
    public List<Empleado> mostrarTodos();

}
