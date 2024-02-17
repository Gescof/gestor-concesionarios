package main.java.gestor;

import java.util.Objects;

public class Vehiculo {
    protected static Integer latestId = 0;
    protected final Integer id;
    protected String marca;
    protected String modelo;
    protected String color;
    protected Short numRuedas;

    public Vehiculo() {
        latestId++;
        this.id = latestId;
    }

    public Integer getId() {
        return id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Short getNumRuedas() {
        return numRuedas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vehiculo vehiculo = (Vehiculo) o;
        return Objects.equals(id, vehiculo.getId())
                && Objects.equals(marca, vehiculo.getMarca())
                && Objects.equals(modelo, vehiculo.getModelo())
                && Objects.equals(color, vehiculo.getColor())
                && Objects.equals(numRuedas, vehiculo.getNumRuedas());
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, marca, modelo, color, numRuedas);
    }

    @Override
    public String toString() {
        return "Vehiculo{"
                + "id=" + id
                + ", marca='" + marca + '\''
                + ", modelo='" + modelo + '\''
                + ", color='" + color + '\''
                + ", numRuedas=" + numRuedas
                + '}';
    }
}
