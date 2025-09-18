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
            if(inventarioProductos.containsKey(producto.getCodProducto())) {//Comprobar que no exista el producto
                System.out.println(producto.getCodProducto()+" ya existe este producto");
            }else{
                inventarioProductos.put(producto.getCodProducto(), producto);//Agregar producto si no existe ya
                System.out.println(producto.getCodProducto()+" se agregado correctamente");
            }
    }
    //Eliminar producto - 0(1)
    public void eliminarProducto(Productos producto) {
        if(inventarioProductos.containsKey(producto.getCodProducto())) {//Comprobar que el procucto exista
            System.out.println(producto.getCodProducto()+" no existe este producto");
        }else{
            inventarioProductos.remove(producto.getCodProducto(), producto);//Eliminarlo si existe
            System.out.println(producto.getCodProducto()+" eliminado");
        }
    }
    //Actualizar producto - 0(1)
    public void actualizarStock(Productos producto) {
        inventarioProductos.put(producto.getCodProducto(), producto);//Actualizar los datos de x producto
        System.out.println(producto.getCodProducto()+" se actualizado correctamente");
    }

    //Consultar Producto - 0(1)
    public void  buscarProducto(String codProducto) {
       if(inventarioProductos.containsKey(codProducto)) {
           Productos producto = inventarioProductos.get(codProducto);//Buscar un producto por el codigo de busqueda
           System.out.println(producto.toString());//Imprimir el producto buscado
       }else {
           System.out.println(codProducto+" no existe este producto");//Mostrar mensaje de que no existe el producto
       }
    }

    //Metodos avanzados

    //Mostrar inventario - 0(n)
    public String mostrarInventario() {
        if(inventarioProductos.size() > 0) {
            for (Productos i : inventarioProductos.values()) {//Recorer la lista
                System.out.println(i.toString());//Imprimir cada objeto de la lista
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

            for (Productos i : inventarioProductos.values()) {//Recorer la lista

                Categoria catObjetivo = i.getCategoriaProducto();//Usar la variable catObjetivo para almacenar el valor de la instancia producto para poder compararlo

                if (categoria.equals(catObjetivo.toString())) {//Comprobar que la categoria del producto equivale a la categoria buscada
                    System.out.println(i.toString());//Si corrersponden imprimirlos
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
            for (Productos i : inventarioProductos.values()) {//Recorrer la lista
                precio += i.valorStockProducto();//Sumar todos los precios de la lista a la variable
            }
            return precio;//Devolver el valor de la variable
        } else {
            System.out.println("No hay inventario");
        }
        return null;
    }
    //Vender producto - 0(1)
    public void venderProducto(String producto,int cantidad) {
        if(inventarioProductos == null || inventarioProductos.isEmpty()) {//Comprobar que existe la lista de productos y no está vacia
            System.out.println("No existe hay productos en stock");
        }

        if (inventarioProductos.containsKey(producto)) {//Seleccionar producto
            Productos productoCompra = inventarioProductos.get(producto);

            if (productoCompra.getStockProducto() >= cantidad) {//Comprobar que hay la cantidad que se quiere comprar
                double precioVenta = productoCompra.valorStockProducto()*cantidad;//Calcular el precio total
                System.out.println("Venta realizada: " + cantidad + " unidades de " +productoCompra.getNombreProducto()+ " por "+ (precioVenta-productoCompra.valorStockProducto()));//Mensaje de venta + calcular el precio de compra
                productoCompra.setStockProducto(productoCompra.getStockProducto() - cantidad);//Restar la cantidad vendida al stock
                System.out.println("Stock restante: "+productoCompra.getStockProducto() );//Mensaje con el nuevo stock
            }else {
                System.out.println("No suficientes productos en stock");
            }

        }else {
            System.out.println("No existe este producto en stock");
        }
    }
}