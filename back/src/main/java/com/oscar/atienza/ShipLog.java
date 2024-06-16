package com.oscar.atienza;

public class ShipLog {
    private String nombre;
    private int apariciones;

    public ShipLog(String nombre, int apariciones) {
        this.nombre = nombre;
        this.apariciones = apariciones;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getApariciones() {
        return apariciones;
    }

    public void setApariciones(int apariciones) {
        this.apariciones = apariciones;
    }

    @Override
    public String toString() {
        return "ShipLog{" +
                "nombre='" + nombre + '\'' +
                ", apariciones=" + apariciones +
                '}';
    }
}
