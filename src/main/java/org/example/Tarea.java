package org.example;

public class Tarea {
    private String descripcion;
    private boolean completado;
    private String prioridad;


    public Tarea(String descripcion, boolean completado,  String prioridad) {
        setDescripcion(descripcion);
        this.completado = completado;
        this.prioridad = prioridad;
    }

    public String getPrioridad() {
        return prioridad;
    }
    public void setPrioridad(String prioridad) {
        this.prioridad = prioridad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        if (!descripcion.isEmpty()) {
            this.descripcion = descripcion;
        }
    }

    public boolean isCompletado() {
        return completado;
    }

    public void setCompletado(boolean completado) {
        this.completado = completado;
    }

    @Override
    public String toString() {
        return descripcion + (completado ? " [COMPLETADA]" : "");
    }
}
