package howard1sttry;

class Factura extends Producto
    {
    
    private double gananciaTotal;
    private String cliente;

    public Factura(String nombre, double precio, int unidades, String modelo, double gananciaTotal, String cliente) 
    {
        super(nombre, precio, unidades);
        this.gananciaTotal = gananciaTotal;
        this.cliente = cliente;
    }

    public double getGananciaTotal() 
    {
        return gananciaTotal;
    }

    public void setGananciaTotal(double gananciaTotal) 
    {
        this.gananciaTotal = gananciaTotal;
    }

    public String getCliente() 
    {
        return cliente;
    }

    public void setCliente(String cliente) 
    {
        this.cliente = cliente;
    }
}

