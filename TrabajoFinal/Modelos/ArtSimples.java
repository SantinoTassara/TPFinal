package TrabajoFinal.TrabajoFinal.Modelos;

public class ArtSimples extends Producto {

    public ArtSimples(String nombreArticulo, double precio, String descripcion, int codigoArticulo, int stock,
            char rubro, int lol) {
        super(nombreArticulo, precio, descripcion, codigoArticulo, stock, rubro);
    }


    public double getPrecioFinal(){
        return getPrecio();
    }
    public String toString(){
        return " IdArticulo: " + getCodigoArticulo() + "Nombre: "+ getNombreArticulo() + "Precio: "+ getPrecioFinal() + "Descripcion: " + getDescripcion() + "Stock: " + getStock() + "Rubro: " + getRubro();
    }
}
