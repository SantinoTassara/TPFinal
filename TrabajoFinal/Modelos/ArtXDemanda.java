package TrabajoFinal.TrabajoFinal.Modelos;

public class ArtXDemanda extends Producto {
    
    int stockDeseado;

    public ArtXDemanda(String nombreArticulo, double precio, String descripcion, int codigoArticulo, int stock,
            char rubro, int stockDeseado) {
        super(nombreArticulo, precio, descripcion, codigoArticulo, stock, rubro);
        this.stockDeseado = stockDeseado;
    }

    public int getStockDeseado() {
        return stockDeseado;
    }

    public void setStockDeseado(int stockDeseado) {
        this.stockDeseado = stockDeseado;
    }

    
}
