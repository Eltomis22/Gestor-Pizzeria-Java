package src;

public class Pedido {
    private String nombreCliente;
    private double precioTotal;
    private int tiempoPreparacion;

    public Pedido(String nombreCliente, double precioTotal, int tiempoPreparacion) {
        this.nombreCliente = nombreCliente;
        this.precioTotal = precioTotal;
        this.tiempoPreparacion = tiempoPreparacion;//minutos
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public double getPrecioTotal() {
        return precioTotal;
    }

    public int getTiempoPreparacion() {
        return tiempoPreparacion;
    }

    public void setPrecioTotal(double precioTotal) {
        this.precioTotal = precioTotal;
    }

    public void setTiempoPreparacion(int tiempoPreparacion) {
        this.tiempoPreparacion = tiempoPreparacion;
    }

    @Override
    public String toString() {
        return String.format("Cliente: %-15s | Precio: $%-8.2f | Tiempo: %d min",
                nombreCliente, precioTotal, tiempoPreparacion);
    }
}


