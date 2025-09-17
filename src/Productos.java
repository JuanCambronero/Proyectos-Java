public class Productos {
    //Atributos
    private String codProducto;
    private String nombreProducto;
    private double precioProducto;
    private Categoria categoriaProducto;
    private int stockProducto;

    //Constructor
    public Productos(String codProducto, String nombreProducto, double precioProducto, Categoria categoriaProducto, int stockProducto) {
        this.codProducto = codProducto;
        this.nombreProducto = nombreProducto;
        this.precioProducto = precioProducto;
        this.categoriaProducto = categoriaProducto;
        this.stockProducto = stockProducto;
    }

    //Getters
    public String getCodProducto() {
        return codProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public double getPrecioProducto() {
        return precioProducto;
    }

    public Categoria getCategoriaProducto() {
        return categoriaProducto;
    }

    public int getStockProducto() {
        return stockProducto;
    }

    //Setters
    public void setPrecioProducto(double precioProducto) {
        this.precioProducto = precioProducto;
    }

    public void setStockProducto(int stockProducto) {
        this.stockProducto = stockProducto;
    }
}