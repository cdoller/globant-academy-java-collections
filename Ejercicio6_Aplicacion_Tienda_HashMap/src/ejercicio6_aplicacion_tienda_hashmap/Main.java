package ejercicio6_aplicacion_tienda_hashmap;

import Servicio.ServicioProducto;
import Entidad.Producto;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ServicioProducto servProducto = new ServicioProducto();
        System.out.println("Bienvenido a App Tienda !\n");
        cargarProductos(servProducto);
        menuABMProducto(servProducto);
        System.out.println("Gracias por usar la App Tienda\n");
    }

    private static void menuABMProducto(ServicioProducto servProducto) {
        Scanner input = new Scanner(System.in).useDelimiter("\n");
        String nombre = "";
        Integer id = 0;
        Boolean seguir = true;
        do {
            System.out.println("---Menu Producto---");
            System.out.println("| Los productos se almacenan con un par de valores ID - Producto");
            System.out.println("| 1. Agregar Nuevo");
            System.out.println("| 2. Ver todos");
            System.out.println("| 3. Buscar producto");
            System.out.println("| 4. Obtener Id producto");
            System.out.println("| 5. Modificar");
            System.out.println("| 6. Eliminar");
            System.out.println("| 9. Salir");

            System.out.print(">>>> ");
            
            String opcion = input.next();
            if(!esUnDigito(opcion)){
                System.out.println("Opcion invalida, vuelva a ingresar");
                continue;
            }
            
            switch (opcion) {
                case "1":
                    System.out.print("Ingrese el nombre: ");
                    nombre = input.next();
                    System.out.print("Ingrese el precio: ");
                    Double precio = input.nextDouble();
                    Producto nuevoProducto = servProducto.agregarProducto(nombre, precio);
                    System.out.println("Se agrego el producto " + nuevoProducto.getNombre() + " con precio " + nuevoProducto.getPrecio());
                    break;
                case "2":
                    System.out.println("Listado de productos");
                    for (Map.Entry<Integer, Producto> aux : servProducto.obtenerProductos().entrySet()) {
                        System.out.println("ID: " + aux.getKey());
                        System.out.println("Nombre: " + aux.getValue().getNombre());
                        System.out.println("Precio: " + aux.getValue().getPrecio());
                        System.out.println("------------------");
                    }
                    break;
                case "3":
                    break;
                case "4":
                    System.out.print("Nombre del producto: ");
                    String posibleNombre = input.next();
                    id = servProducto.obtenerIdProducto(posibleNombre);
                    if (id < 0) {
                        System.out.println("No hay productos con ese nombre");
                        break;
                    }
                    System.out.println("El id es: " + id);
                    break;
                case "5":
                    System.out.print("Ingrese ID:");
                    id = input.nextInt();
                    if (!servProducto.verificarId(id)) {
                        break;
                    }
                    System.out.println("| A. Modificar completo");
                    System.out.println("| B. Modificar nombre");
                    System.out.println("| C. Modificar precio");
                    switch (input.next()) {
                        case "A":
                            System.out.print("Ingrese nuevo nombre: ");
                            nombre = input.next();

                            System.out.print("Ingrese nuevo precio: ");
                            precio = input.nextDouble();

                            servProducto.modificarProducto(id, nombre, precio);
                            break;
                        case "B":
                            System.out.print("Ingrese nuevo nombre: ");
                            nombre = input.next();
                            
                            servProducto.modificarProducto(id, nombre);
                            break;
                        case "C":
                            System.out.print("Ingrese nuevo precio: ");
                            precio = input.nextDouble();

                            servProducto.modificarProducto(id, precio);
                            break;
                        default:
                            System.out.println("No es una opcion valida");
                    }
                    break;
                case "6":
                    System.out.print("Ingrese ID:");
                    id = input.nextInt();
                    if (!servProducto.verificarId(id)) {
                        break;
                    }
                    System.out.println(servProducto.eliminarProducto(id).getNombre() + " ha sido eliminado.");
                    break;
                case "9":
                    seguir = false;
                    break;
                default:
                    System.out.println("No es una opcion valida");
            }   
        } while (seguir);
        
    }
    
    private static void cargarProductos(ServicioProducto servProducto){
        servProducto.agregarProducto("Monitor", 999.99);
        servProducto.agregarProducto("Notebook", 15000.0);
        servProducto.agregarProducto("Teclado", 500.0);
        servProducto.agregarProducto("Mouse", 350.0);
        servProducto.agregarProducto("Auriculares", 750.0);
    }
    
    /**
     * Valida que el string sea un solo numero
     * @param input string que ingresa el usuario
     * @return 
     */
    private static Boolean esUnDigito(String input){
        return input.matches("^[0-9]$");
    }
    
    private static Boolean esUnaLetraValida(String input){
        return input.matches("^[A-Za-z]$"); 
    }
}
