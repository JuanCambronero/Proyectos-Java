import java.util.HashMap;
public class Inventario {
    //Atributos
    private String nombreTienda;
    HashMap<String,Productos> inventarioProductos;

    //Constructor
    public Inventario(String nombreTienda, HashMap<String, Productos> inventarioProductos) { this.nombreTienda = nombreTienda; this.inventarioProductos = inventarioProductos; }

    public Inventario() {
    }

    //Metodos Basicos

    //Agregar producto - 0(1)
    public void agregarProducto(Productos producto) {
            if(inventarioProductos.containsKey(producto.getCodProducto())) {
                System.out.println(producto.getCodProducto()+" ya existe este producto");
            }else{
                inventarioProductos.put(producto.getCodProducto(), producto);
                System.out.println(producto.getCodProducto()+" se agregado correctamente");
            }
    }
    //Eliminar producto - 0(1)
    public void eliminarProducto(Productos producto) {
        if(inventarioProductos.containsKey(producto.getCodProducto())) {
            System.out.println(producto.getCodProducto()+" no existe este producto");
        }else{
            inventarioProductos.remove(producto.getCodProducto(), producto);
            System.out.println(producto.getCodProducto()+" eliminado");
        }
    }
    //Actualizar producto - 0(1)
    public void actualizarStock(Productos producto) {
        inventarioProductos.put(producto.getCodProducto(), producto);
        System.out.println(producto.getCodProducto()+" se actualizado correctamente");
    }

    //Consultar Producto - 0(1)
    public void  buscarProducto(String codProducto) {
       if(inventarioProductos.containsKey(codProducto)) {
           Productos producto = inventarioProductos.get(codProducto);
           System.out.println(producto.toString());
       }
    }

    //Metodos avanzados

    //Mostrar inventario - 0(n)
    public String mostrarInventario() {
        if(inventarioProductos.size() > 0) {
            for (Productos i : inventarioProductos.values()) {
                System.out.println(i.toString());
            }

        }else {
            System.out.println("No hay inventario");
        }

        return null;
    }
    //Consultar productos por categoria - 0(n)
    public void mostrarPorCategoria(String categoria) {

        if(inventarioProductos.size() > 0) {

            categoria = Categoria.valueOf(categoria.toUpperCase()).toString();//Parsear la categoria escrita a Categoria enum

            for (Productos i : inventarioProductos.values()) {

                Categoria catObjetivo = i.getCategoriaProducto();//Usar la variable catObjetivo para almacenar el valor de la instancia producto para poder compararlo

                if (categoria.equals(catObjetivo.toString())) {
                    System.out.println(i.toString());
                }
            }
        }else {
            System.out.println("No existe hay productos de esta categoria en stock");
        }
    }
    //Precio de todo el inventario - 0(n)
    public Double precioInventario() {
        double precio = 0;

        if (inventarioProductos.size() > 0) {
            for (Productos i : inventarioProductos.values()) {
                precio += i.valorStockProducto();
            }
            return precio;
        } else {
            System.out.println("No hay inventario");
        }
        return null;
    }
    //Vender producto
    public void venderProducto(String producto,int cantidad) {
        if(inventarioProductos == null || inventarioProductos.isEmpty()) {
            System.out.println("No existe hay productos en stock");
        }

        if (inventarioProductos.containsKey(producto)) {
            Productos productoCompra = inventarioProductos.get(producto);
            if (productoCompra.getStockProducto() >= cantidad) {
                double precioVenta = productoCompra.valorStockProducto()*cantidad;
                System.out.println("Venta realizada: " + cantidad + " unidades de " +productoCompra.getNombreProducto()+ " por "+ (precioVenta-productoCompra.valorStockProducto()));
                productoCompra.setStockProducto(productoCompra.getStockProducto() - cantidad);
                System.out.println("Stock restante: "+productoCompra.getStockProducto() );
            }else {
                System.out.println("No suficientes productos en stock");
            }
        }else {
            System.out.println("No existe este producto en stock");
        }
    }
}