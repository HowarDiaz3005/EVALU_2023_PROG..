package howard1sttry;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Login {

    public static void mostrarLogin(String[] args) {

        Map<String, String> cuentas = new HashMap<>();

        Scanner scanner = new Scanner(System.in);

        boolean inicioSesionExitoso = false;
        //Inicias un bucle que continuará hasta que el inicio de sesión sea exitoso.

        while (!inicioSesionExitoso) {

            System.out.println("CREACIÓN DE CUENTA");
            System.out.print("Ingrese su nombre de usuario: ");
            String usuario = scanner.nextLine();

            System.out.print("Ingrese el nombre de la empresa: ");
            String empresa = scanner.nextLine();

            System.out.print("Ingrese su contraseña: ");
            String contraseña = scanner.nextLine();

            //Limpiar la consola con caracteres irregulares
            System.out.print("\033[H\033[2J");  
            System.out.flush();  

            cuentas.put(usuario, contraseña);
            
            //*Aquí, el usuario proporciona un nombre de usuario, el nombre de la empresa y una contraseña. 
            //Luego, estos detalles se almacenan en el mapa cuentas. */

            System.out.println("\nINICIO DE SESIÓN");
            System.out.print("Nombre de usuario: ");
            String usuarioLogin = scanner.nextLine();

            System.out.print("Contraseña: ");
            String contraseñaLogin = scanner.nextLine();

            if (cuentas.containsKey(usuarioLogin) && cuentas.get(usuarioLogin).equals(contraseñaLogin)) {
                System.out.println("Inicio de sesión exitoso.");
                inicioSesionExitoso = true;
                Inventario.setEmpresa(empresa);
               
                //Limpiar Consola
                System.out.print("\033[H\033[2J");
                System.out.flush();

            } else {
                System.out.println("Nombre de usuario o contraseña incorrectos.");
                System.out.println("                                           ");
                //*El programa solicita al usuario que ingrese su nombre de usuario y contraseña para iniciar sesión.
                //Luego, verifica si el nombre de usuario existe en el mapa cuentas y si la contraseña proporcionada coincide.
                //Si es así, se muestra un mensaje de inicio de sesión exitoso; de lo contrario, se informa al usuario que la información es incorrecta. */
            }
        }
    }
}

