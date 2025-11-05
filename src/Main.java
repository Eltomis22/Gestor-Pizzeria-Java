package src;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Pizzeria pizzeria = new Pizzeria();
        TiempoOrdenamiento tester = new TiempoOrdenamiento();
        Scanner scanner = new Scanner(System.in);
        int opcion = -1;

        do{
            System.out.println("\n--- SISTEMA DE GESTIÓN DE PIZZERÍA ---");
            System.out.println("1. Agregar pedido");
            System.out.println("2. Listar pedidos");
            System.out.println("3. Eliminar pedido");
            System.out.println("4. Ordenar pedidos por tiempo de preparación (inserción)");
            System.out.println("5. Ordenar pedidos por precio total (shellsort)");
            System.out.println("6. Ordenar pedidos por nombre del cliente (quicksort)");
            System.out.println("7. Medir tiempos de ordenamiento");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            switch (opcion) {
                case 1:
                    System.out.print("Nombre del cliente: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Precio total: ");
                    double precio = scanner.nextDouble();
                    System.out.print("Tiempo de preparación (minutos): ");
                    int tiempo = scanner.nextInt();
                    pizzeria.agregarPedido(new Pedido(nombre, precio, tiempo));
                    break;
                case 2:
                    pizzeria.listarPedidos();
                    break;
                case 3:
                    pizzeria.listarPedidos();
                    System.out.print("Ingrese el número del pedido a eliminar: ");
                    int idx = scanner.nextInt();
                    pizzeria.eliminarPedido(idx);
                    break;
                case 4:
                    pizzeria.ordenarPorTiempo();
                    break;
                case 5:
                    pizzeria.ordenarPorPrecio();
                    break;
                case 6:
                    pizzeria.ordenarPorNombre();
                    break;
                case 7:
                    tester.probarTiempos();
                    break;
                case 0:
                    System.out.println("Saliendo del sistema...");
            
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
                    break;
            }

        } while (opcion != 0);
        scanner.close();

    }
}
