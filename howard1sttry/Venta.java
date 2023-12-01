package howard1sttry;

import java.time.LocalDate;

    class Venta extends Producto {
    private LocalDate fechaVenta;
    private int cantidad;
    private double gananciasVenta;

    public Venta(String nombre, LocalDate fechaVenta, int cantidad, double gananciasVenta, String modelo) {
        super(nombre, 0, cantidad);
        this.fechaVenta = fechaVenta;
        this.cantidad = cantidad;
        this.gananciasVenta = gananciasVenta;
    }

    public LocalDate getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(LocalDate fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getGananciasVenta() {
        return gananciasVenta;
    }

    public void setGananciasVenta(double gananciasVenta) {
        this.gananciasVenta = gananciasVenta;
    }
}
