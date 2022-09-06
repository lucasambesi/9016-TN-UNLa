package com.example.clases;

import android.widget.EditText;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "examenes")
public class Examen {

    @DatabaseField(id = true)
    private Integer id;

    @DatabaseField
    private String materia;

    @DatabaseField
    private String fecha;

    public Examen(){
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
}
