package TrabajoFinal.TrabajoFinal.Modelos;

public class Renglon {
    private Producto producto;
    private int cantidad;
    
    public Renglon(Producto producto, int cantidad) {
        this.producto = producto;
        this.cantidad = cantidad;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double calcularSubtotal(){
        return producto.getPrecioFinal() * cantidad;
    }
    public double precioSinDescueto(){
        return producto.getPrecio() * cantidad;
    }

    @Override
    public String toString() {
        return "Nombre del producto: " + producto.getNombreArticulo() + ", Cantidad: " + getCantidad();
    }
    
}
