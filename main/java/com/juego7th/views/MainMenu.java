package com.juego7th.views;
import com.juego7th.modelo.Users;
import com.juego7th.service.UsersService;
import java.util.Scanner;
public class MainMenu {
    public static void menu(){

         Scanner scanner = new Scanner(System.in);
         UsersService usersService = new UsersService();
         Users user = null;
         int opcion;
         do {
            vista();
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer
                switch (opcion) {
                    case 1:
                        System.out.print("Ingrese nombre de usuario: ");
                        String nuevoUsuario = scanner.nextLine();
                        System.out.print("Ingrese correo electrónico: ");
                        String nuevoEmail = scanner.nextLine();
                        System.out.print("Ingrese contraseña: ");
                        String nuevaContrasena = scanner.nextLine();
                        String registroResultado = usersService.registrerUser(nuevoUsuario, nuevaContrasena, nuevoEmail);
                        System.out.println(registroResultado);
                        break;

                    case 2:
                        System.out.print("Ingrese nombre de usuario: ");
                        String usuario = scanner.nextLine();
                        System.out.print("Ingrese contraseña: ");
                        String contrasena = scanner.nextLine();
                        user = usersService.loginUser(usuario, contrasena);
                        if (user != null) {
                            System.out.println("Inicio de sesión exitoso. ¡Bienvenido, " + user.getName() + "!");
                        } else {
                            System.out.println("Error: Credenciales incorrectas.");
                        }
                        break;

                    case 3:
                        if (user != null) {
                            System.out.println("Iniciando el juego 'Seven To Hell'...");
                            // Lógica del juego aquí
                        } else {
                            System.out.println("Debe iniciar sesión para jugar.");
                        }
                        break;

                    case 4:
                        if (user != null) {
                            System.out.println("=== Perfil de Usuario ===");
                            System.out.println("ID: " + user.getId());
                            System.out.println("Nombre: " + usersService);
                            System.out.println("Correo electrónico: " + user.getEmail());
                        } else {
                            System.out.println("Debe iniciar sesión para ver el perfil.");
                        }
                        break;

                    case 5:
                        System.out.println("Saliendo del juego. ¡Hasta pronto!");
                        break;
                    default:
                        System.out.println("Opción no válida. Intente nuevamente.");
                }
         } while (opcion != 5);

                scanner.close();
    }

    public static void vista(){

        System.out.println("\n=== Menú Principal ===");
        System.out.println("1. Registrarse");
        System.out.println("2. Iniciar sesión");
        System.out.println("3. Jugar");
        System.out.println("4. Ver perfil");
        System.out.println("5. Salir");
        System.out.print("Seleccione una opción: ");

    }
}




