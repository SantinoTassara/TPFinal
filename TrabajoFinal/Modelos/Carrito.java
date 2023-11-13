package TrabajoFinal.TrabajoFinal.Modelos;

import java.util.ArrayList;

public class Carrito {
    private ArrayList<Producto> listaProductos;
    private int cantProductos = 0;
    private double subtotal;

    
    
    public Carrito() {
        this.listaProductos  = new ArrayList<>(); ;
    }
    public ArrayList<Producto> getListaProductos() {
        return listaProductos;
    }
    public int getCantProductos() {
        return cantProductos;
    }
    public double getSubtotal() {
        return subtotal;
    }

    

}
