import java.util.HashMap;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Inicializamos el inventario
        Inventario inventario = new Inventario("PC-Component's", new HashMap<>());

        // Productos iniciales
        inventario.agregarProducto(new Productos("P001", "Portátil Lenovo", 750.00, Categoria.PC, 10));
        inventario.agregarProducto(new Productos("P002", "Ratón Logitech", 25.99, Categoria.PC, 30));
        inventario.agregarProducto(new Productos("P003", "Teclado Mecánico", 55.00, Categoria.PC, 15));
        inventario.agregarProducto(new Productos("P004", "Smartphone Samsung", 899.00, Categoria.MOVIL, 8));
        inventario.agregarProducto(new Productos("P005", "Auriculares Sony", 120.50, Categoria.MOVIL, 20));
        inventario.agregarProducto(new Productos("P006", "Tablet iPad", 450.00, Categoria.TABLET, 12));
        inventario.agregarProducto(new Productos("P007", "Tablet Samsung", 399.00, Categoria.TABLET, 7));


        boolean repetir = true;

        while (repetir) {
            System.out.println("\n--- Menú de Inventario ---");
            System.out.println("1. Nuevo Producto");
            System.out.println("2. Modificar Producto");
            System.out.println("3. Eliminar Producto");
            System.out.println("4. Buscar Producto");
            System.out.println("5. Mostar Inventario");
            System.out.println("6. Búsqueda por categoria");
            System.out.println("7. Precio total del inventario");
            System.out.println("8. Vender producto");
            System.out.println("0. Salir");
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
                    System.out.println("--- Mostar Inventario ---");
                    System.out.println(inventario.mostrarInventario());
                    break;

                case 6:
                    System.out.println("--- Mostrar por Categoría ---");
                    System.out.print("Ingrese categoría: ");
                    String categBuscar = sc.nextLine();
                    inventario.mostrarPorCategoria(categBuscar);
                    break;

                case 7:
                    System.out.println("--- Precio total del Inventario ---");
                    Double precioTotal = inventario.precioInventario();
                    if (precioTotal != null) {
                        System.out.println("Valor total del inventario: " + precioTotal + " €");
                    }
                    break;

                case 8:
                    System.out.println("--- Vender producto ---");
                    System.out.print("Introduce el código del producto: ");
                    String codVender = sc.nextLine();
                    System.out.print("Introduce la cantidad a vender: ");
                    int cantidad = sc.nextInt();
                    sc.nextLine();
                    inventario.venderProducto(codVender, cantidad);
                    break;

                case 0:
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
