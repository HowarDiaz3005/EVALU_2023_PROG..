package howard1sttry;

import java.util.Date;

  public class ProductoAlimentation extends Producto {
    private Date fechaCaducidad;

    public ProductoAlimentation(String nombre, double precio, int Cantidad, Date fechaCaducidad) {
        super(nombre, precio, Cantidad);
        this.fechaCaducidad = fechaCaducidad;
    }

    public Date getFechaCaducidad() {
        return fechaCaducidad;
    }

    public void setFechaCaducidad(Date fechaCaducidad) {
        this.fechaCaducidad = fechaCaducidad;
    }
    
}
