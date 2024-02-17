package main.java.gestor;

public class Moto extends Vehiculo {

    public Moto() {
        super();
        this.numRuedas = 2;
    }

    @Override
    public String toString() {
        return "Moto{" +
                "id=" + id
                + ", marca='" + marca + '\''
                + ", modelo='" + modelo + '\''
                + ", color='" + color + '\''
                + ", numRuedas=" + numRuedas
                + '}';
    }
}
