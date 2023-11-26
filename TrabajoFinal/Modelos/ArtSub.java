package TrabajoFinal.TrabajoFinal.Modelos;

public class ArtSub extends Producto {


    public ArtSub(String nombreArticulo, double precio, String descripcion, int codigoArticulo, int stock, char rubro) {
        super(nombreArticulo, precio, descripcion, codigoArticulo, stock, rubro);
    }


    public double getPrecioFinal(){
     Double precioConDescuento = getPrecio();
     if (this.getRubro() == 'A') {
        Double cantidadADescontar = (getPrecio() * 30) /100;
        precioConDescuento = precioConDescuento - cantidadADescontar;
     }else if (this.getRubro() == 'B') {
        Double cantidadADescontar = (getPrecio() * 24) /100;
        precioConDescuento = precioConDescuento - cantidadADescontar;
     }else if (this.getRubro() == 'C') {
        Double cantidadADescontar = (getPrecio() * 15) /100;
        precioConDescuento = precioConDescuento - cantidadADescontar;
     }
        return precioConDescuento;
    }

    public String toString(){
        return " IdArticulo: " + getCodigoArticulo() + "Nombre: "+ getNombreArticulo() + "Precio: "+ getPrecio() + "Descripcion: " + getDescripcion() + "Stock: " + getStock() + "Rubro: " + getRubro();
    }
    
}
