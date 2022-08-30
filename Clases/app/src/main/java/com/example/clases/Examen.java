package com.example.clases;

public class Examen {
    private Integer id;
    private String materia;
    private String fecha;

    public Examen(Integer id, String materia, String fecha) {
        this.id = id;
        this.materia = materia;
        this.fecha = fecha;
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
