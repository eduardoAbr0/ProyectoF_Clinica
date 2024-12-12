package entities;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

    @Entity
    public class Paciente {
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
        @ColumnInfo(name = "FechaNac")
        public String fechaNac;

        @NonNull
        @ColumnInfo(name = "Sexo")
        public String sexo;

        @NonNull
        @ColumnInfo(name = "Sangre")
        public String sangre;

        @NonNull
        @ColumnInfo(name = "Alergias")
        public String alergia;

        @NonNull
        @ColumnInfo(name = "Telefono")
        public String numTelefono;

        public Paciente(@NonNull String numTelefono, @NonNull String fechaNac, @NonNull String nombre, @NonNull String primerAp, @NonNull String segundoAp, @NonNull String sexo, @NonNull String sangre, @NonNull String alergia) {
            this.numTelefono = numTelefono;
            this.fechaNac = fechaNac;
            this.nombre = nombre;
            this.primerAp = primerAp;
            this.segundoAp = segundoAp;
            this.sexo = sexo;
            this.sangre = sangre;
            this.alergia = alergia;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
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
        public String getFechaNac() {
            return fechaNac;
        }

        public void setFechaNac(@NonNull String fechaNac) {
            this.fechaNac = fechaNac;
        }

        @NonNull
        public String getSexo() {
            return sexo;
        }

        public void setSexo(@NonNull String sexo) {
            this.sexo = sexo;
        }

        @NonNull
        public String getSangre() {
            return sangre;
        }

        public void setSangre(@NonNull String sangre) {
            this.sangre = sangre;
        }

        @NonNull
        public String getAlergia() {
            return alergia;
        }

        public void setAlergia(@NonNull String alergia) {
            this.alergia = alergia;
        }

        @NonNull
        public String getNumTelefono() {
            return numTelefono;
        }

        public void setNumTelefono(@NonNull String numTelefono) {
            this.numTelefono = numTelefono;
        }
    }
