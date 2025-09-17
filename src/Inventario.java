import java.util.HashMap;
public class Inventario {
    //Atributos
    private String nombreTienda;
    HashMap<String,Productos> inventarioProductos;

    //Constructor
    public Inventario(String nombreTienda, HashMap<String, Productos> inventarioProductos) { this.nombreTienda = nombreTienda; this.inventarioProductos = inventarioProductos; }
    //Metodos
    //Agregar producto
    public void agregarProducto(Productos producto) { inventarioProductos.put(producto.getCodProducto(), producto); }
    //Eliminar producto
    public void eliminarProducto(Productos producto) { inventarioProductos.remove(producto.getCodProducto()); }
    //Actualizar stock
    public void actualizarStock(Productos producto) { inventarioProductos.put(producto.getCodProducto(), producto); } }