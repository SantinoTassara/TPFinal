package TrabajoFinal.TrabajoFinal.Modelos;

public abstract class Producto {
    private String nombreArticulo;
    private double precio;
    private String descripcion;
    private int codigoArticulo;
    private int stock;
    private char rubro;
    
    public Producto(String nombreArticulo, double precio, String descripcion, int codigoArticulo, int stock,
            char rubro) {
        this.nombreArticulo = nombreArticulo;
        this.precio = precio;
        this.descripcion = descripcion;
        this.codigoArticulo = codigoArticulo;
        this.stock = stock;
        this.rubro = rubro;
    }

    public String getNombreArticulo() {
        return nombreArticulo;
    }

    public void setNombreArticulo(String nombreArticulo) {
        this.nombreArticulo = nombreArticulo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCodigoArticulo() {
        return codigoArticulo;
    }

    public void setCodigoArticulo(int codigoArticulo) {
        this.codigoArticulo = codigoArticulo;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public char getRubro() {
        return rubro;
    }

    public void setRubro(char rubro) {
        this.rubro = rubro;
    }
    
    public abstract double getPrecioFinal();    

    public abstract String toString();
}
