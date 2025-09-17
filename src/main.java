import java.util.HashMap;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Inicializamos el inventario
        Inventario inventario = new Inventario("MiTienda", new HashMap<>());

        boolean repetir = true;

        while (repetir) {
            System.out.println("\n--- Menú de Inventario ---");
            System.out.println("1. Nuevo Producto");
            System.out.println("2. Modificar Producto");
            System.out.println("3. Eliminar Producto");
            System.out.println("4. Buscar Producto");
            System.out.println("5. Salir");
            System.out.print("Ingrese opción: ");

            int opcion = sc.nextInt();
            sc.nextLine(); // limpiar buffer

            switch (opcion) {
                case 1:
                    System.out.println("--- Crear Producto ---");
                    System.out.print("Código del producto: ");
                    String codigo = sc.nextLine();

                    System.out.print("Nombre del producto: ");
                    String nombre = sc.nextLine();

                    System.out.print("Precio del producto: ");
                    double precio = sc.nextDouble();
                    sc.nextLine();

                    System.out.print("Categoría del producto (usa enum Categoria): ");
                    String categoriaStr = sc.nextLine();
                    Categoria categoria = Categoria.valueOf(categoriaStr.toUpperCase());

                    System.out.print("Stock del producto: ");
                    int stock = sc.nextInt();
                    sc.nextLine();

                    Productos nuevoProducto = new Productos(codigo, nombre, precio, categoria, stock);
                    inventario.agregarProducto(nuevoProducto);
                    break;

                case 2:
                    System.out.println("--- Modificar Producto ---");
                    System.out.print("Código del producto a actualizar: ");
                    String codUpdate = sc.nextLine();

                    System.out.print("Nuevo stock: ");
                    int nuevoStock = sc.nextInt();
                    sc.nextLine();

                    if (inventario.inventarioProductos.containsKey(codUpdate)) {
                        Productos proAct = inventario.inventarioProductos.get(codUpdate);
                        proAct.setStockProducto(nuevoStock);
                        inventario.actualizarStock(proAct);
                    } else {
                        System.out.println("El producto con código " + codUpdate + " no existe.");
                    }
                    break;

                case 3:
                    System.out.println("--- Eliminar Producto ---");
                    System.out.print("Código del producto: ");
                    String codEliminar = sc.nextLine();

                    if (inventario.inventarioProductos.containsKey(codEliminar)) {
                        Productos prodEliminar = inventario.inventarioProductos.get(codEliminar);
                        inventario.eliminarProducto(prodEliminar);
                    } else {
                        System.out.println("El producto con código " + codEliminar + " no existe.");
                    }
                    break;

                case 4:
                    System.out.println("--- Buscar Producto ---");
                    System.out.print("Código del producto: ");
                    String codBuscar = sc.nextLine();
                    inventario.buscarProducto(codBuscar);
                    break;

                case 5:
                    repetir = false;
                    System.out.println("Saliendo del programa...");
                    break;

                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
        sc.close();
    }
}
