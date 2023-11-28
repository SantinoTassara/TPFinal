package TrabajoFinal.TrabajoFinal.Modelos;

import java.util.ArrayList;



public class Carrito {
    private ArrayList<Renglon> listaRenglones;
    private Usuario usuarioLogueado;
    public Carrito(Usuario usuarioLogueado) {
        this.listaRenglones = new ArrayList<>();
        this.usuarioLogueado = usuarioLogueado;
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
        boolean valido = this.validarStock();
        double precioFinal = 0;
        if (valido == true) {
            for (Renglon renglon : listaRenglones) {
            Producto producto = renglon.getProducto();
            double precioFinalProducto = renglon.calcularSubtotal();
            System.out.println("Cantidad: " + renglon.getCantidad() + "Nombre del producto: " + producto.getNombreArticulo() + "Precio por unidad: " + producto.getPrecio() + "Precio Total" + precioFinalProducto);
            System.out.println("------------------------------------------");
            precioFinal = precioFinal + precioFinalProducto;
        }
            System.out.println("El total a pagar es: " + precioFinal);
            if (precioFinal > usuarioLogueado.getBilletera()) {
                System.out.println("Saldo insuficiente");
            }else{
                this.reducirStock();
                double dineroADescontar = usuarioLogueado.getBilletera() - precioFinal;
                usuarioLogueado.setBilletera(dineroADescontar);
                System.out.println("Compra finalizada. Muchas Gracias");
            }
        }

        
        
    }
    private void reducirStock(){
        for (Renglon renglon : listaRenglones) {
            Producto producto = renglon.getProducto();
            int nuevoStock = producto.getStock() - renglon.getCantidad();
            producto.setStock(nuevoStock);
        }
    }

    private boolean validarStock(){
        boolean valido = true;
        for (Renglon renglon : listaRenglones) {
            if (renglon.getProducto().getStock() < renglon.getCantidad()) {
                System.out.println("Stock insuficiente del producto: " + renglon.toString());
                valido = false;
                break;
            }
        }
        return valido;
        
    }
}
