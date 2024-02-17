package main.java.gestor;

public class Coche extends Vehiculo {

    public Coche() {
        super();
        this.numRuedas = 4;
    }

    @Override
    public String toString() {
        return "Coche{" +
                "id=" + id
                + ", marca='" + marca + '\''
                + ", modelo='" + modelo + '\''
                + ", color='" + color + '\''
                + ", numRuedas=" + numRuedas
                + '}';
    }
}
