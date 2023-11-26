package TrabajoFinal.TrabajoFinal.Menus;

import java.util.Scanner;

import TrabajoFinal.TrabajoFinal.Contenedores.ContArticulos;
import TrabajoFinal.TrabajoFinal.Modelos.Producto;
import TrabajoFinal.TrabajoFinal.Modelos.Usuario;

public class MenuEmpleado {
    private boolean continuar = true;
    private Scanner sc;
    private MenuArticulos mArticulos;
    private ContArticulos contArticulos;
    

    public MenuEmpleado(Scanner sc, ContArticulos contArticulos) {
        this.sc = sc;
        this.contArticulos = contArticulos;
        this.mArticulos = new MenuArticulos(sc, contArticulos);
    }


    //cuando crees la funcion agregar articulo, pregunta que se puedan crear los 3 tipos de articulos
    private void salir(){
        continuar = false;
    }

    public void iniciar(Usuario usuario){
        while (continuar) {
            String opcion = this.elegirOpcion();
            this.ejecutarOpcion(opcion);
        }
    }

    private String elegirOpcion(){
        this.mostrarOpciones();
        String opcion = this.sc.next();
        return opcion;
    }
    private void mostrarOpciones(){
        System.out.println("---------- Menu de Empleado ----------");
        System.out.println("0. Salir");
        System.out.println("1. Ingresar al menu de gestion de articulos");
        System.out.println("2. Editar Stock de un producto");
        System.out.println("3. ");
        System.out.println("--------------------------------------");
    }
    private void ejecutarOpcion(String opcion){
        
            switch (opcion) {
            case "0":
                this.salir();
                break;
            case "1":
                this.mArticulos.iniciar();
                break;
            case "2":
                this.editarStock();
                break;
            default:
                break;
            }
    }
    private void editarStock() {
        System.out.println("Ingrese el nombre del producto a editar el stock:");
        String nombreBuscado = this.sc.next();

        // Busca el producto en la lista
        Producto productoBuscado = this.contArticulos.articuloBuscado(nombreBuscado);

        if (productoBuscado == null) {
            System.out.println("El producto buscado no existe.");
        } else {
            // Mostrar el stock actual y solicitar la nueva cantidad
            System.out.println("El stock actual es: " + productoBuscado.getStock());
            System.out.println("Ingrese el nuevo stock del producto:");
            int nuevoStock = this.sc.nextInt();

            // agregar el producto nuevo al stock
            productoBuscado.setStock(nuevoStock);
            System.out.println("Stock actualizado correctamente.");
        }
    }
}
