package src;

import java.util.List;
public class Ordenador {
    public void insercion(List<Pedido> pedidos) {
        for(int i = 1; i < pedidos.size(); i++) {
            Pedido actual = pedidos.get(i);
            int j = i - 1;
            while (j >= 0 && pedidos.get(j).getTiempoPreparacion() > actual.getTiempoPreparacion()) {
                pedidos.set(j + 1, pedidos.get(j));
                j--;
            }
            pedidos.set(j + 1, actual);
        }
    }


    public void shellSort(List<Pedido> pedidos){
        int n = pedidos.size();
        for(int gap = n / 2; gap > 0; gap /= 2){
            for(int i = gap; i < n; i++){
                Pedido temp = pedidos.get(i);
                int j = i;
                while (j >= gap && pedidos.get(j - gap).getPrecioTotal() > temp.getPrecioTotal()) {
                    pedidos.set(j, pedidos.get(j - gap));
                    j -= gap;
                }
                pedidos.set(j, temp);
            } 
        }
    }


    public void quickSort(List<Pedido> pedidos, int low, int high){
        if (low < high) {
            int pi = particion(pedidos, low, high);
            quickSort(pedidos, low, high);
            quickSort(pedidos, pi + 1, high);
        }
    }


    private int particion(List<Pedido> pedidos, int low, int high){
        String pivot = pedidos.get(high).getNombreCliente().toLowerCase();
        int i = (low - 1);
        for (int j = low; j < high; j++){
            if (pedidos.get(j).getNombreCliente().toLowerCase().compareTo(pivot) < 0){
                i++;
                Pedido temp = pedidos.get(i);
                pedidos.set(i, pedidos.get(j));
                pedidos.set(j, temp);
            }
        }
        Pedido temp = pedidos.get(i + 1);
        pedidos.set(i + 1, pedidos.get(high));
        pedidos.set(high, temp);
        return i + 1;
    }
}
