package src;

import java.util.List;
import java.util.ArrayList;
import java.util.Random;

public class TiempoOrdenamiento {
    private Ordenador ordenador = new Ordenador();


    public void probarTiempo(){
        int[] tamanos = {100, 1000, 5000};
        Random random = new Random();

        for (int n : tamanos){
            List<Pedido> lista = generarPedidos(n, random);
            System.out.println("\n--- Comparando con " + n + " pedidos ---");

            medir("Incersión (tiempo preparación)", () ->ordenador.insercion(new ArrayList<>(lista)));
            medir("Shellsort (precio)", () -> ordenador.shellsort(new ArrayList<>(lista)));
            medir("Quicksort (nombre cliente)", () -> ordenador.quicksort(new ArrayList<>(lista), 0, lista.size() - 1));
        }
    }


    private void medir(String nombre, Runnable metodo){
        long inicio = System.currentTimeMillis();
        metodo.run();
        long fin = System.currentTimeMillis();
        System.out.println(nombre + "-> " + (fin - inicio) + " ms");
    }


    private List<Pedido> generarPedidos(int n, Random random){
        List<Pedido> pedidos = new ArrayList<>();
        for(int i = 0; i < n; i++){
            String nombre = "Cliente" + i;
            double precio = 500 + random.nextDouble() * 1500;
            int tiempo = 5 + random.nextInt(55);
            pedidos.add(new Pedido(nombre, precio, tiempo));
        }
        return pedidos;
    }

}
