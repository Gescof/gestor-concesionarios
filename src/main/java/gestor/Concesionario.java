package main.java.gestor;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Concesionario {
    private static final Scanner sc = new Scanner(System.in);

    static {
        sc.useDelimiter("\n");
    }

    private static Integer latestId = 0;
    private final Integer id;
    private String nombre;
    private String provincia;
    private Short codPostal;
    private List<Comercial> comerciales = new ArrayList<>();
    private List<Vehiculo> vehiculos = new ArrayList<>();

    public Concesionario() {
        latestId++;
        this.id = latestId;
    }

    public Integer getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public Short getCodPostal() {
        return codPostal;
    }

    public void setCodPostal(Short codPostal) {
        this.codPostal = codPostal;
    }

    public List<Comercial> getComerciales() {
        return comerciales;
    }

    public void setComerciales(List<Comercial> comerciales) {
        this.comerciales = comerciales;
    }

    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(List<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }

    public void agregarComercial() {
        Comercial nuevoComercial = new Comercial();

        System.out.println("DNI:");
        nuevoComercial.setDni(sc.next());

        System.out.println("Nombre:");
        nuevoComercial.setNombre(sc.next());

        System.out.println("Apellidos:");
        nuevoComercial.setApellidos(sc.next());

        System.out.println("Edad:");
        nuevoComercial.setEdad(sc.nextShort());

        System.out.println("Número de ventas:");
        nuevoComercial.setNumVentas(sc.nextInt());

        comerciales.add(nuevoComercial);
    }

    public void agregarVehiculo() {
        Vehiculo nuevoVehiculo = null;

        System.out.println("¿Qué tipo de vehículo es?");
        boolean fin = false;
        do {
            System.out.println("1. Coche");
            System.out.println("2. Motocicleta");
            int opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                    nuevoVehiculo = new Coche();
                    fin = true;
                    break;
                case 2:
                    nuevoVehiculo = new Moto();
                    fin = true;
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, elija una de las opciones permitidas");
                    System.out.println();
                    break;
            }
        } while (!fin);

        System.out.println("Marca:");
        nuevoVehiculo.setMarca(sc.next());

        System.out.println("Modelo:");
        nuevoVehiculo.setModelo(sc.next());

        System.out.println("Color:");
        nuevoVehiculo.setColor(sc.next());

        vehiculos.add(nuevoVehiculo);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Concesionario concesionario = (Concesionario) o;
        return Objects.equals(id, concesionario.getId())
                && Objects.equals(nombre, concesionario.getNombre())
                && Objects.equals(provincia, concesionario.getProvincia())
                && Objects.equals(codPostal, concesionario.getCodPostal())
                && Objects.equals(comerciales, concesionario.getComerciales())
                && Objects.equals(vehiculos, concesionario.getVehiculos());
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, provincia, codPostal, comerciales, vehiculos);
    }

    @Override
    public String toString() {
        return "Concesionario{"
                + "id=" + id
                + ", nombre='" + nombre + '\''
                + ", provincia='" + provincia + '\''
                + ", codPostal=" + codPostal
                + ", comerciales=" + comerciales
                + ", vehiculos=" + vehiculos
                + '}';
    }
}
