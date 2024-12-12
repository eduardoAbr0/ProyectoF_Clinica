package entities;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Login {
    @PrimaryKey()
    @NonNull
    public String usuario;

    @NonNull
    @ColumnInfo(name = "pass")
    public String contra;

    public Login(@NonNull String usuario, @NonNull String contra) {
        this.usuario = usuario;
        this.contra = contra;
    }

    @NonNull
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(@NonNull String usuario) {
        this.usuario = usuario;
    }

    @NonNull
    public String getContra() {
        return contra;
    }

    public void setContra(@NonNull String contra) {
        this.contra = contra;
    }
}
