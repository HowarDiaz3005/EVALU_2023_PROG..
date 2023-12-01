package howard1sttry;

class Producto {
    private String nombre;
    private double precio;
    private int Cantidad;

    public Producto(String nombre, double precio, int cantidad) {
        this.nombre = nombre;
        this.precio = precio;
        this.Cantidad = cantidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return Cantidad;
    }

    public void setUnidades(int cantidad) {
        this.Cantidad = cantidad;
    }

}

