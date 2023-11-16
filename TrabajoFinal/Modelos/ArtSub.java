package TrabajoFinal.TrabajoFinal.Modelos;

public class ArtSub extends Producto {

    double precioConDescuento;

    public ArtSub(String nombreArticulo, double precio, String descripcion, int codigoArticulo, int stock, char rubro,
            double precioConDescuento) {
        super(nombreArticulo, precio, descripcion, codigoArticulo, stock, rubro);
        this.precioConDescuento = precioConDescuento;
    }

    public double getPrecioConDescuento() {
        return precioConDescuento;
    }

    public void setPrecioConDescuento(double precioConDescuento) {
        this.precioConDescuento = precioConDescuento;
    }

    
    
    
}
