package TrabajoFinal.TrabajoFinal.Modelos;

import java.util.ArrayList;
import java.util.Scanner;

import TrabajoFinal.TrabajoFinal.Contenedores.ContArticulos;

public class Carrito {
    private ArrayList<Renglon> listaRenglones;
    public Carrito(Scanner sc, ContArticulos contArticulos, Usuario usuarioLogueado) {
        this.listaRenglones = new ArrayList<>();
    }

    public void agregarProducto(Producto producto, int cantidad) {
        // Buscar si el producto ya está en el carrito
        Renglon existente = buscarRenglon(producto);

        if (existente != null) {
            // Si el producto ya está en el carrito, actualizar la cantidad
            existente.setCantidad(existente.getCantidad() + cantidad);
        } else {
            // Si el producto no está en el carrito, agregarlo como un nuevo renglón
            Renglon nuevoRenglon = new Renglon(producto, cantidad);
            listaRenglones.add(nuevoRenglon);
        }
    }
    private Renglon buscarRenglon(Producto producto) {
        // Buscar un renglón en el carrito que contenga el producto
        Renglon existente = null;
        for (Renglon renglon : listaRenglones) {
            if (renglon.getProducto().equals(producto)) {
                existente = renglon;
            }
        }
        return existente;
    }
    public void eliminarProducto(Producto producto) {
        // Buscar y eliminar el producto del carrito
        Renglon existente = buscarRenglon(producto);

        if (existente != null) {
            listaRenglones.remove(existente);
        }else{
            System.out.println("El producto no se encuentra en el carrito");
        }
    }

    public double calcularTotal() {
        // Calcula el total sumando los subtotales de cada producto en el carrito
        double total = 0.0;

        for (Renglon renglon : listaRenglones) {
            total = renglon.calcularSubtotal();
        }

        return total;
    }

    public void verCarrito(){
        for (Renglon renglon : listaRenglones) {
            System.out.println(renglon);
        }
        double total = this.calcularTotal();
        System.out.println("El subtotal de la compra es: " + total);
    }

    public void finalizarCompra(){
        
    }
}
