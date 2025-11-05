package src;

import java.util.List;
import java.util.ArrayList;

public class Pizzeria {
    private List<Pedido> pedidos;
    private Ordenador ordenador;

    public Pizzeria(){
        pedidos = new ArrayList<>();
        ordenador = new Ordenador();
    }

    public void agregarPedido(Pedido p){
        pedidos.add(p);
        System.out.println("Pedido agregado: " + p);
    }

    public void eliminarPedido(int index){
        if (index < 1 || index > pedidos.size()){
            System.out.println("Índice inválido.");
            return;
        }
        pedidos.remove(index - 1);
        System.out.println("Pedido eliminado");
    }

    public void listarPedidos(){
        if (pedidos.isEmpty()){
            System.out.println("No hay pedidos cargados.");
            return;
        }
        System.out.println("\n--- LISTA DE PEDIDOS ---");
        for (int i = 0; i < pedidos.size(); i++){
            System.out.println((i + 1) + ". " + pedidos.get(i));
        }
    }


    public void ordenarPorTiempo(){
        ordenador.insercion(pedidos);
        System.out.println("Pedidos ordenados por tiempo de preparación (inserción).");
    }

    
    public void ordenarPorPrecio(){
        ordenador.shellsort(pedidos);
        System.out.println("Pedidos ordenados por precio total (shellsort).");
    }


    public void ordenarPorNombre(){
        ordenador.quicksort(pedidos, 0, pedidos.size() - 1);
        System.out.println("Pedidos ordenados por nombre del cliente (quicksort).");
    }


    public List<Pedido> getPedidos() { return pedidos; }
}
