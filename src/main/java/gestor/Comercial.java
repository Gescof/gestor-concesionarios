package main.java.gestor;

import java.util.Objects;

public class Comercial {
    private static Integer latestId = 0;
    private final Integer id;
    private String dni;
    private String nombre;
    private String apellidos;
    private Short edad;
    private Integer numVentas;

    public Comercial() {
        latestId++;
        this.id = latestId;
    }

    public Integer getId() {
        return id;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Short getEdad() {
        return edad;
    }

    public void setEdad(Short edad) {
        this.edad = edad;
    }

    public Integer getNumVentas() {
        return numVentas;
    }

    public void setNumVentas(Integer numVentas) {
        this.numVentas = numVentas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Comercial comercial = (Comercial) o;
        return Objects.equals(id, comercial.getId())
                && Objects.equals(dni, comercial.getDni())
                && Objects.equals(nombre, comercial.getNombre())
                && Objects.equals(apellidos, comercial.getApellidos())
                && Objects.equals(edad, comercial.getEdad())
                && Objects.equals(numVentas, comercial.getNumVentas());
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dni, nombre, apellidos, edad, numVentas);
    }

    @Override
    public String toString() {
        return "Comercial{"
                + "id=" + id
                + ", dni='" + dni + '\''
                + ", nombre='" + nombre + '\''
                + ", apellidos='" + apellidos + '\''
                + ", edad=" + edad
                + ", numVentas=" + numVentas
                + '}';
    }
}
