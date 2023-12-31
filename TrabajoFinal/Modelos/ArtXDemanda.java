package TrabajoFinal.TrabajoFinal.Modelos;

public class ArtXDemanda extends Producto {
    private int stockDeseado;


    public ArtXDemanda(String nombreArticulo, double precio, String descripcion, int codigoArticulo, int stock,
            char rubro, int stockDeseado, String tipo) {
        super(nombreArticulo, precio, descripcion, codigoArticulo, stock, rubro, tipo);
        this.stockDeseado = stockDeseado;
    }

    public int getStockDeseado() {
        return stockDeseado;
    }

    public void setStockDeseado(int stockDeseado) {
        this.stockDeseado = stockDeseado;
    }

    public double getPrecioFinal(){
        double precioFinal = getPrecio();
        if (this.getStockDeseado() < this.getStock()) {
            double porcentajeExcedido = ((double) getStock() - getStockDeseado()) / getStockDeseado();
            double descuento = Math.min(porcentajeExcedido, 0.5) * 100;
            precioFinal -= precioFinal * (descuento / 100);
        }
        return precioFinal;
    }

    public String toString(){
        return " IdArticulo: " + getCodigoArticulo() + "Nombre: "+ getNombreArticulo() + "Precio: "+ getPrecioFinal() + "Descripcion: " + getDescripcion() + "Stock: " + getStock() + "Stock deseado: " + getStockDeseado() + "Rubro: " + getRubro();
    }
}
