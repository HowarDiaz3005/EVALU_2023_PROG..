package howard1sttry;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

            Inventario inventario = new Inventario();

                Login login = new Login();

                    Login.mostrarLogin(args);

                    inventario.mostrarMenu();

                    scanner.close();
    }
}

