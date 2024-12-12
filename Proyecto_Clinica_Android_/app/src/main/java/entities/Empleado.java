package entities;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Empleado {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    public int id;

    @NonNull
    @ColumnInfo(name = "Nombre")
    public String nombre;

    @NonNull
    @ColumnInfo(name = "PrimerApellido")
    public String primerAp;

    @NonNull
    @ColumnInfo(name = "SegundoApellido")
    public String segundoAp;

    @NonNull
    @ColumnInfo(name = "Calle")
    public String calle;

    @NonNull
    @ColumnInfo(name = "NumeroCasa")
    public int numCasa;

    @NonNull
    @ColumnInfo(name = "Colonia")
    public String colonia;

    @NonNull
    @ColumnInfo(name = "CodigoPostal")
    public int CP;

    @NonNull
    @ColumnInfo(name = "Telefono")
    public String numTelefono;

    @NonNull
    @ColumnInfo(name = "Puesto")
    public String puesto;

    public Empleado(@NonNull String nombre, @NonNull String primerAp,
                    @NonNull String segundoAp, @NonNull String calle, @NonNull int numCasa,
                    @NonNull String colonia, @NonNull int CP, @NonNull String numTelefono,
                    @NonNull String puesto) {
        this.nombre = nombre;
        this.primerAp = primerAp;
        this.segundoAp = segundoAp;
        this.calle = calle;
        this.numCasa = numCasa;
        this.colonia = colonia;
        this.CP = CP;
        this.numTelefono = numTelefono;
        this.puesto = puesto;
    }

    @NonNull
    public int getId() {
        return id;
    }

    public void setId(@NonNull int id) {
        this.id = id;
    }

    @NonNull
    public String getNombre() {
        return nombre;
    }

    public void setNombre(@NonNull String nombre) {
        this.nombre = nombre;
    }

    @NonNull
    public String getPrimerAp() {
        return primerAp;
    }

    public void setPrimerAp(@NonNull String primerAp) {
        this.primerAp = primerAp;
    }

    @NonNull
    public String getSegundoAp() {
        return segundoAp;
    }

    public void setSegundoAp(@NonNull String segundoAp) {
        this.segundoAp = segundoAp;
    }

    @NonNull
    public String getCalle() {
        return calle;
    }

    public void setCalle(@NonNull String calle) {
        this.calle = calle;
    }

    @NonNull
    public int getNumCasa() {
        return numCasa;
    }

    public void setNumCasa(@NonNull int numCasa) {
        this.numCasa = numCasa;
    }

    @NonNull
    public String getColonia() {
        return colonia;
    }

    public void setColonia(@NonNull String colonia) {
        this.colonia = colonia;
    }

    @NonNull
    public int getCP() {
        return CP;
    }

    public void setCP(@NonNull int CP) {
        this.CP = CP;
    }

    @NonNull
    public String getNumTelefono() {
        return numTelefono;
    }

    public void setNumTelefono(@NonNull String numTelefono) {
        this.numTelefono = numTelefono;
    }

    @NonNull
    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(@NonNull String puesto) {
        this.puesto = puesto;
    }

}