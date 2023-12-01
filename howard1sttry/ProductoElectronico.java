package howard1sttry;

class ProductoElectronico extends Producto {
    private String modelo;

    public ProductoElectronico(String nombre, double precio, int Cantidad, String modelo) {
        super(nombre, precio, Cantidad);
        this.modelo = modelo;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
}

