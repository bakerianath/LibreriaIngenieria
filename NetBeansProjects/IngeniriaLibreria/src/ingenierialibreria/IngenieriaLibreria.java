
package ingenierialibreria;

import java.util.Scanner;

/**
 *
 * @author bakeriana
 */
public class IngenieriaLibreria {

    static Scanner scanner = new Scanner(System.in); //Sirve para recoger texto por consola
    static int select = -1; //opción elegida del usuario
    static Scanner scanner1 = new Scanner(System.in); //Sirve para recoger texto por consola
    
    public static void main (String[] args) {

        //Mientras la opción elegida sea 0, preguntamos al usuario
        while (select != 0) {
            try{
                System.out.println(
                        "TAREA INGENIERIA:\n\n" +
                        "1.- Regigstrar usuario\n" +
                        "0.- Salir");
                //Recoger una variable por consola
                select = Integer.parseInt(scanner.nextLine());

                //Ejemplo de switch case en Java
                switch (select) {
                    case 1:
                        String nombre; String apellido; long cedula; String fecha; Cliente cl = null;
                        
                        System.out.print("Introducir nombre de usuario: ");
                        nombre= scanner.nextLine();
                        System.out.print("\n");
                        
                        System.out.print("Introducir apellido de usuario: ");
                        apellido= scanner.nextLine();
                        System.out.print("\n");
                        
                        System.out.print("Introducir cedula de usuario: ");
                        cedula= scanner.nextLong();
                        System.out.print("\n");
                        
                        System.out.print("Introducir fecha de la ultima compra (YYYY-MM-DD): ");
                        fecha= scanner1.nextLine();
                        System.out.print("\n");
                        
                        cl = new Cliente(nombre,apellido,cedula,fecha);
                        FachadaCliente fc = new FachadaCliente();
                        boolean x = fc.validarUsuario(cl);
                        
                        break;
                    default:
                        System.out.println("\nHecho por Nathaly Bakerian Scovino");
                        System.out.println("Para Ingenieria del Software");
                        System.out.println("Profesor. Carlos Barroeta");
                        break;
                }

                System.out.println("\n");
            }
            catch (Exception e){
            }
        }
    }
}
