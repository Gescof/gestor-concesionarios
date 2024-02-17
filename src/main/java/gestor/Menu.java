package main.java.gestor;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Menu {
    private static final Scanner sc = new Scanner(System.in);

    static {
        sc.useDelimiter("\n");
    }

    private final List<Concesionario> concesionarios = new ArrayList<>();

    public Menu() {
    }

    public List<Concesionario> getConcesionarios() {
        return concesionarios;
    }

    public void iniciar() {
        System.out.println("¡Bienvenid@ al menú del gestor de concesionarios!");
        System.out.println("Elija una de las siguientes opciones:");
        System.out.println();

        int opcion;
        do {
            escribirMenuPrincipal();
            opcion = elegirOpcionMenuPrincipal();
        } while (opcion != 4);
        sc.close();
    }

    private void escribirMenuPrincipal() {
        System.out.println("---------------------------------------------");
        System.out.println("1. Listar los concesionarios existentes");
        System.out.println("2. Agregar un nuevo concesionario");
        System.out.println("3. Eliminar un concesionario existente");
        System.out.println("4. Finalizar");
        System.out.println("---------------------------------------------");
    }

    private int elegirOpcionMenuPrincipal() {
        int opcion = sc.nextInt();
        switch (opcion) {
            case 1:
                listarConcesionarios();
                break;
            case 2:
                agregarConcesionario();
                break;
            case 3:
                eliminarConcesionario();
                break;
            case 4:
                System.out.println("Fin del programa");
                break;
            default:
                System.out.println("Opción no válida. Por favor, elija una de las opciones permitidas");
                System.out.println();
                break;
        }
        return opcion;
    }

    private void listarConcesionarios() {
        System.out.println("Lista de concesionarios existentes:");
        System.out.println(concesionarios.toString());
        System.out.println();
    }

    private void agregarConcesionario() {
        Concesionario nuevoConcesionario = new Concesionario();
        rellenarDatosConcesionario(nuevoConcesionario);
        concesionarios.add(nuevoConcesionario);
        System.out.println("Concesionario agregado con éxito");
        System.out.println(nuevoConcesionario);
    }

    private void rellenarDatosConcesionario(Concesionario concesionarioAModificar) {
        System.out.println("Rellene los datos necesarios");
        System.out.println();

        System.out.println("Nombre del concesionario:");
        concesionarioAModificar.setNombre(sc.next());

        System.out.println("Provincia:");
        concesionarioAModificar.setProvincia(sc.next());

        System.out.println("Código postal:");
        concesionarioAModificar.setCodPostal(sc.nextShort());

        boolean continuar;
        System.out.println("Comerciales:");
        do {
            concesionarioAModificar.agregarComercial();
            System.out.println("¿Desea agregar otro comercial? (Y/N)");
            continuar = sc.next().equalsIgnoreCase("Y");
        } while (continuar);

        System.out.println("Vehiculos:");
        do {
            concesionarioAModificar.agregarVehiculo();
            System.out.println("¿Desea agregar otro vehículo? (Y/N)");
            continuar = sc.next().equalsIgnoreCase("Y");
        } while (continuar);
    }

    private void eliminarConcesionario() {
        if (concesionarios.isEmpty()) {
            System.out.println("No existen concesionarios en el sistema");
        } else {
            boolean fin = false;
            do {
                listarConcesionarios();

                System.out.println("Indique el identificador del concesionario que quiere eliminar:");
                int idConcesionario = sc.nextInt();

                Concesionario concesionarioAEliminar = null;
                for (Concesionario concesionario : concesionarios) {
                    if (idConcesionario == concesionario.getId()) {
                        concesionarioAEliminar = concesionario;
                    } else {
                        System.out.println("Ese identificador no se encuentra en la lista");
                    }
                }

                if (concesionarioAEliminar != null) {
                    concesionarios.remove(concesionarioAEliminar);
                    System.out.println("Concesionario " + idConcesionario + " eliminado con éxito");
                    fin = true;
                }
            } while (!fin);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Menu menu = (Menu) o;
        return Objects.equals(concesionarios, menu.getConcesionarios());
    }

    @Override
    public int hashCode() {
        return Objects.hash(concesionarios);
    }

    @Override
    public String toString() {
        return "Menu{"
                + "concesionarios=" + concesionarios
                + '}';
    }
}
