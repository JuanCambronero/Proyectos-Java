import java.util.HashMap;
public class Inventario {
    //Atributos
    private String nombreTienda;
    HashMap<String,Productos> inventarioProductos;

    //Constructor
    public Inventario(String nombreTienda, HashMap<String, Productos> inventarioProductos) { this.nombreTienda = nombreTienda; this.inventarioProductos = inventarioProductos; }

    public Inventario() {
    }
//Metodos

    //Agregar producto
    public void agregarProducto(Productos producto) {
            if(inventarioProductos.containsKey(producto.getCodProducto())) {
                System.out.println(producto.getCodProducto()+" ya existe este producto");
            }else{
                inventarioProductos.put(producto.getCodProducto(), producto);
                System.out.println(producto.getCodProducto()+" se agregado correctamente");
            }
    }
    //Eliminar producto
    public void eliminarProducto(Productos producto) {
        if(inventarioProductos.containsKey(producto.getCodProducto())) {
            System.out.println(producto.getCodProducto()+" no existe este producto");
        }else{
            inventarioProductos.remove(producto.getCodProducto(), producto);
            System.out.println(producto.getCodProducto()+" eliminado");
        }
    }
    //Actualizar producto
    public void actualizarStock(Productos producto) {
        inventarioProductos.put(producto.getCodProducto(), producto);
        System.out.println(producto.getCodProducto()+" se actualizado correctamente");
    }

    //Consultar Producto
    public void  buscarProducto(String codProducto) {
       if(inventarioProductos.containsKey(codProducto)) {
           Productos producto = inventarioProductos.get(codProducto);
           System.out.println(producto.getCodProducto()+"|"+ producto.getNombreProducto()+"|"+producto.getCategoriaProducto()+"|"+producto.getPrecioProducto()+"|"+producto.getStockProducto());
       }
    }

    //Metodos avanzados

    //Mostrar inventario
    public String mostrarInventario() {
        if(inventarioProductos.size() > 0) {
                StringBuilder sb = new StringBuilder();//Nueva clase que sirve para almacenar texto para imprimir
                for (Productos i : inventarioProductos.values()) {
                    sb.append(i.getNombreProducto())
                            .append(" | ").append(i.getCategoriaProducto())
                            .append(" | ").append(i.getPrecioProducto())
                            .append(" | ").append(i.getStockProducto())
                            .append("\n");
            }
                return sb.toString();
        }else {
            System.out.println("No hay inventario");
        }
        return null;
    }

}