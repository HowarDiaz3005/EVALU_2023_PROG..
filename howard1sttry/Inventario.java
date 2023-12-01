package howard1sttry;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Inventario 
{

    // maneja productos, ventas y la generación de facturas
    private List<Producto> productos;
    private List<Venta> ventas;
    private static String empresa;

    public Inventario() 
    {
        productos = new ArrayList<>();
        ventas = new ArrayList<>();
    }

    public static void setEmpresa(String empresa) 
    {
        Inventario.empresa = empresa;
    }

    public void agregarProducto(Producto producto) 
    {
        productos.add(producto);
    }

    public void agregarProductoElectronico(ProductoElectronico productoElectronico) 
    {
        productos.add(productoElectronico);
    }

    public void agregarProductoAlimentation(ProductoAlimentation ProductoAlimentation) 
    {
        productos.add(ProductoAlimentation);
    }

    public void agregarVenta(Venta venta) 
    {
        ventas.add(venta);
    }

    public void mostrarMenu() 
    {
        Scanner scanner = new Scanner(System.in);
        int opcion;
        boolean salir = false;

        do {
            System.out.println("Bienvenido al Sistema :)");
            System.out.println("==== MENÚ DEL INVENTARIO ====");
            System.out.println("1. Registrar producto");
            System.out.println("2. Mostrar inventario");
            System.out.println("3. Realizar Venta");
            System.out.println("4. Eliminar Producto del Inventario");
            System.out.println("5. SALIR");
            System.out.print("Seleccione una opción: ");

            try 
            {
                opcion = scanner.nextInt();
                scanner.nextLine();
                switch (opcion) 
                {
                    case 1:
                        registrarProducto();
                        break;
                    case 2:
                        mostrarInventario();
                        break;
                    case 3:
                        realizarVenta();
                        break;
                    case 4:
                        eliminarProducto();
                        break;
                    case 5:
                        System.out.println("Saliendo del programa...");
                        salir = true;
                        break;
                    default:
                        System.out.println("Opción inválida. Por favor, seleccione nuevamente.");
                        break;
                }
            } 
            
            catch (InputMismatchException e) 
            {
                System.out.println("Debe ingresar un número válido. Inténtelo nuevamente.");
                scanner.nextLine(); // Limpiar el buffer de entrada
                opcion = 0; // Restablecer la opción a un valor predeterminado
            }
        } while (!salir);

        Login.mostrarLogin(null);// Se manda a llamar el metodo estatico para mostrar la pantalla de inicio de
                                 // sesión.
        // Limpiar Consola
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public void registrarProducto() 
    {
        // *Recopila la información necesaria para crear un nuevo producto y luego lo
        // agrega a la lista de productos en el inventario */

        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el nombre del producto: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese el precio del producto: ");
        double precio = scanner.nextDouble();
        System.out.print("Ingrese las unidades del producto: ");
        int unidades = scanner.nextInt();
        scanner.nextLine();

        System.out.println("1. Producto electrónico");
        System.out.println("2. Producto alimenticio");
        System.out.print("Seleccione el tipo de producto: ");
        int tipoProducto = scanner.nextInt();
        scanner.nextLine();

        Producto producto;// Creacion del producto

        switch (tipoProducto) 
        {
            case 1:
                System.out.print("Ingrese el modelo del producto electrónico: ");
                String modelo = scanner.nextLine();
                producto = new ProductoElectronico(nombre, precio, unidades, modelo);
                break;
            case 2:
                System.out.print("Ingrese la fecha de caducidad del producto alimenticio (dd/MM/yyyy): ");
                String fechaCaducidadStr = scanner.nextLine();
                try {
                    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                    Date fechaCaducidad = dateFormat.parse(fechaCaducidadStr);
                    producto = new ProductoAlimentation(nombre, precio, unidades, fechaCaducidad);
                }
                
                catch (ParseException e) 
                {
                    System.out.println("Formato de fecha inválido. No se pudo registrar el producto alimenticio.");
                    return;
                }
                break;
            default:
                System.out.println("Opción inválida. No se pudo registrar el producto.");
                return;
        }
        // Finalmente se agrega
        agregarProducto(producto);
        System.out.println("Producto registrado exitosamente.");
    }

    public void mostrarInventario() 
    {
        if (productos.isEmpty()) 
        {
            System.out.println("El inventario está vacío.");
        } 
        
        else
        {
            System.out.println("                                                              ");
            System.out.println("==== INVENTARIO ====");
            System.out.println("Nombre\t\tPrecio\t\tUnidades\t\tTipo\t\tModelo/Fecha Caducidad");
            System.out.println(
                    "------------------------------------------------------------------------------------------------");
            System.out.println("                                                                                ");
            for (Producto producto : productos) 
            {
                String tipoProducto = producto instanceof ProductoElectronico ? "Electrónico" : "Alimenticio";// Se
                                                                                                              // determina
                                                                                                              // el tipo
                                                                                                              // de
                                                                                                              // producto
                                                                                                              // (Electrónico
                                                                                                              // o
                                                                                                              // Alimenticio)
                                                                                                              // utilizando
                                                                                                              // la
                                                                                                              // operación
                                                                                                              // ternaria.
                String modeloFechaCaducidad;

                if (producto instanceof ProductoElectronico) 
                {
                    modeloFechaCaducidad = ((ProductoElectronico) producto).getModelo();
                } 
                
                else 
                {
                    Date fechaCaducidad = ((ProductoAlimentation) producto).getFechaCaducidad();
                    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");
                    modeloFechaCaducidad = sdf.format(fechaCaducidad);
                }

                System.out.printf("%-17s%-17s%-18s%-24s%-24s\n",
                        producto.getNombre(), producto.getPrecio(), producto.getCantidad(), tipoProducto,
                        modeloFechaCaducidad);
            }
            System.out.println(
                    "------------------------------------------------------------------------------------------------");
        }
    }

    public void realizarVenta() 
    {// Gestiona el proceso de venta de productos.
        Scanner scanner = new Scanner(System.in);
        System.out.println("==== REALIZAR VENTA ====");

        if (productos.isEmpty()) 
        {
            System.out.println("No hay productos en el inventario para realizar la venta.");
            return;
        }

        mostrarInventario();// Se muestra el inventario actual

        System.out.print("Ingrese la cantidad de diferentes productos a vender: ");
        int numeroProductos = scanner.nextInt();
        scanner.nextLine();

        if (numeroProductos <= 0) 
        {// Mayor que 0
            System.out.println("Cantidad inválida. La venta no se puede realizar.");
            return;
        }

        for (int i = 0; i < numeroProductos; i++) 
        {
            System.out.println("Producto #" + (i + 1));
            System.out.print("Ingrese el nombre del producto: ");
            String nombre = scanner.nextLine();

            // Se verifica si existe el producto
            Producto productoEncontrado = null;
            for (Producto producto : productos) 
            {
                if (producto.getNombre().equalsIgnoreCase(nombre)) 
                {
                    productoEncontrado = producto;
                    break;
                }
            }

            if (productoEncontrado == null) 
            {
                System.out.println("Producto no encontrado en el inventario.");
                continue;
            }

            System.out.print("Ingrese la cantidad a vender: ");
            int cantidad = scanner.nextInt();
            scanner.nextLine();

            if (cantidad > 0 && cantidad <= productoEncontrado.getCantidad()) 
            {
                productoEncontrado.setUnidades(productoEncontrado.getCantidad() - cantidad);
                System.out.println("Venta realizada exitosamente.");

                LocalDate fechaVenta = LocalDate.now();

                double gananciasVenta = cantidad * productoEncontrado.getPrecio();
                Venta venta = new Venta(nombre, fechaVenta, cantidad, gananciasVenta, nombre);// Aqui se agrega a las
                                                                                              // ventas

                agregarVenta(venta);
            } 
            
            else 
            {
                System.out.println("Cantidad inválida. La venta no se puede realizar.");
            }
        }

        if (!ventas.isEmpty()) 
        {
            generarFactura(ventas);
        }
    }

    double vta;

    public void generarFactura(List<Venta> ventas) 
    {
        Scanner pantalla = new Scanner(System.in);

        System.out.println("Ingrese el nombre del cliente: ");
        String cliente = pantalla.nextLine();

        System.out.println("/////// Factura ///////");
        System.out.println("**********************");
        System.out.println("Empresa: " + empresa);
        System.out.println("Cliente: " + cliente);

         double totalVenta = 0.0;

        for (int i = 0; i < ventas.size(); i++) 
        {
            Venta venta = ventas.get(i);
            int numVenta = i + 1;
            totalVenta += venta.getGananciasVenta();

            Producto productoEncontrado = null;
            for (Producto producto : productos) 
            {
                if (producto.getNombre().equalsIgnoreCase(venta.getNombre())) 
                {
                    productoEncontrado = producto;
                    break;
                }
            }

            System.out.println("Venta #" + numVenta);
            System.out.println("Nombre del producto: " + venta.getNombre());
            System.out.println("Unidades: " + venta.getCantidad());
           
            System.out.println("Precio unitario: " + productoEncontrado.getPrecio());
            System.out.println("Precio total de producto: " + venta.getGananciasVenta());
            System.out.println("----------------------------------------");
        }

        System.out.println("Pago total: " + totalVenta);
        System.out.println("                                ");

        vta =totalVenta;
    }


    public void eliminarProducto() 
    {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el nombre del producto a eliminar: ");
        String nombre = scanner.nextLine();

        Producto productoEncontrado = null;

        for (Producto producto : productos) 
        {
            if (producto.getNombre().equalsIgnoreCase(nombre)) 
            {
                productoEncontrado = producto;
                break;
            }
        }

        if (productoEncontrado != null) 
        {
            productos.remove(productoEncontrado);
            System.out.println("Producto eliminado exitosamente.");
        }
        
        else 
        {
            System.out.println("No se encontró un producto con ese nombre en el inventario.");
        }
    }

}

