package TrabajoFinal.TrabajoFinal.Menus;

import java.util.InputMismatchException;
import java.util.Scanner;

import TrabajoFinal.TrabajoFinal.Contenedores.ContArticulos;
import TrabajoFinal.TrabajoFinal.Contenedores.ContUsuarios;
import TrabajoFinal.TrabajoFinal.Modelos.Carrito;
import TrabajoFinal.TrabajoFinal.Modelos.Producto;
import TrabajoFinal.TrabajoFinal.Modelos.Usuario;

public class MenuClientes {
    
    private boolean continuar = true;
    private Scanner sc;
    private ContUsuarios contUsuarios;
    private ContArticulos contArticulos;
    private Usuario usuarioLogeado;
    private Carrito carrito;

    public MenuClientes(Scanner sc, ContArticulos contArticulos, ContUsuarios contUsuarios){
        this.sc = sc;
        this.contArticulos = contArticulos;
        this.contUsuarios = contUsuarios;
    }

    private void salir(){
        this.continuar = false;
    }

    public void iniciar(Usuario usuario){
        this.usuarioLogeado = usuario;
        this.carrito = new Carrito(usuarioLogeado);
        while (continuar) {
            int opcion = this.elegirOpcion();
            this.ejecutarOpcion(opcion);
        }
    }

    private int elegirOpcion(){
        while (true) {
            try{
                this.mostrarOpciones();
                int opcion = this.sc.nextInt();
                return opcion;
            }catch(InputMismatchException e){
                this.sc.nextLine();
                System.out.println("ERROR: Ingrese una opcion valida");
            }
        }
    }

    private void mostrarOpciones(){
        System.out.println("-------- Menu Usuario --------");
        System.out.println("1. Agregar dinero a la cuenta");
        System.out.println("2. Retirar dinero de la cuenta");
        System.out.println("3. Transferir dinero a otro usuario");
        System.out.println("4. Ver el saldo disponible");
        System.out.println("5. Ver listado de todos los productos");
        System.out.println("6. Buscar producto");
        System.out.println("7. Agregar Producto al carrito");
        System.out.println("8. Eliminar Producto del carrito");
        System.out.println("9. Ver productos en el carrito");
        System.out.println("10. Finalizar compra");
        System.out.println("0. Salir");
        System.out.println("-----------------------------");
    }

    private void ejecutarOpcion(int opcion){
            switch (opcion) {
                case 1:
                    this.agregarDinero();
                    break;
                case 2:
                    this.retirarDinero();
                    break;
                case 3:
                    this.transferirDinero();
                    break;
                case 4:
                    this.verSaldo();
                    break;
                case 5:
                    this.contArticulos.mostrarAllArticulos();
                    break;
                case 6:
                    this.buscarArticulo();
                    break;
                case 7: 
                    this.agregarProducto();
                    break;
                case 8:
                    this.eliminarProducto();
                    break;
                case 9:
                    this.carrito.verCarrito();
                    break;
                case 10:
                    this.carrito.finalizarCompra();
                    break;
                case 0:
                    this.salir();
                    break;
                    
                default:
                    System.out.println("Opcion invalidad. Ingrese otra opcion. ");
                    break;
         }
}

    private void agregarDinero(){
            try{
                System.out.println("Ingrese la cantidad de dinero que quiere agregar");
                double dineroAAgregar = this.sc.nextDouble();

                if (dineroAAgregar <= 0) {
                    System.out.println("ERROR: No se puede agregar una dinero negativo");
                }else{
                    double dineroActual = this.usuarioLogeado.getBilletera();
                    dineroAAgregar = dineroAAgregar + dineroActual;

                    this.usuarioLogeado.setBilletera(dineroAAgregar);
                }   
            }catch(InputMismatchException e){
                this.sc.nextLine();
                System.out.println("ERROR: Ingrese una opcion valida:");
            }
    }

    private void retirarDinero(){
            try{
                System.out.println("Ingrese la cantidad de dinero que quiere retirar");
                double dineroARetirar = this.sc.nextDouble();

                if (dineroARetirar < 0) {
                System.out.println("ERRO: Opcion invalida seleccione un numero positivo");
                }else{
                
                double dineroActual = this.usuarioLogeado.getBilletera();
                if (dineroARetirar > dineroActual) {
                    System.out.println("Saldo insuficiente");
                }else{
                    dineroARetirar = dineroActual - dineroARetirar;
                    this.usuarioLogeado.setBilletera(dineroARetirar);
                    }
                }
            }catch(InputMismatchException e){
                this.sc.nextLine();
                System.out.println("ERROR: Ingrese una opcion valida:");
            }
    }


    private void verSaldo(){
        double saldoDisponible = this.usuarioLogeado.getBilletera();
        System.out.println("Saldo disponible: "+ saldoDisponible);
    }

    private void buscarArticulo(){
        System.out.println("Ingrese el nombre del articulo buscado");
        String nombreBuscado = this.sc.next();
        
        System.out.println("EL ARTICULO ES SUBSIDIADO: (S/N)");
        char respuesta = this.sc.next().charAt(0);
        if (respuesta == 'S'||respuesta == 's') {
            nombreBuscado = nombreBuscado + "(S)";
        }

        Producto articuloBuscado = this.contArticulos.articuloBuscado(nombreBuscado);
        if (articuloBuscado == null) {
            System.out.println("No se encontro el articulo buscado");
        }else{
            this.contArticulos.mostrarArticulo(articuloBuscado); 
        }     
    }
    private void transferirDinero(){
            try{
                System.out.println("Ingrese el usuario al que quiere transferir");
                String nombreBuscado = this.sc.next();

                Usuario usuarioBuscado = this.contUsuarios.buscarUsuario(nombreBuscado);

                if (usuarioBuscado == null) {
                    System.out.println("El usuario buscado no existe");
                }else{
                    System.out.println("Ingrese la cantidad de dinero que quiere transferir");
                    double dineroATransferir = this.sc.nextDouble();

                    if (dineroATransferir <= 0) {
                        System.out.println("No se puede transferir dinero negativo: ");
                    }else{
                    if (dineroATransferir > this.usuarioLogeado.getBilletera()) {
                    System.out.println("Saldo insuficiente");
                    }else{
                    usuarioBuscado.setBilletera(dineroATransferir);
                    double dineroFinal = this.usuarioLogeado.getBilletera();

                    dineroFinal = dineroFinal - dineroATransferir;
                    this.usuarioLogeado.setBilletera(dineroFinal);
                    }
                }
                }
            }catch(InputMismatchException e){
                this.sc.nextLine();
                System.out.println("ERROR: Ingrese una opcion valida:");
            }
    }
    private void agregarProducto(){
        System.out.println("Ingrese el nombre del producto que quiere agregar");
        String nombreBuscado = this.sc.next();

        System.out.println("EL ARTICULO ES SUBSIDIADO: (S/N)");
        char respuesta = this.sc.next().charAt(0);

        if (respuesta == 'S'||respuesta == 's') {
            nombreBuscado = nombreBuscado + "(S)";
        }

        Producto productoAAgregar = this.contArticulos.articuloBuscado(nombreBuscado);

        if (productoAAgregar == null) {
            System.out.println("Ese producto no existe");
        }else{
            System.out.println("Ingrese la cantidad que quiera agregar");
            int cantidad = this.sc.nextInt();

            if (cantidad < productoAAgregar.getStock()) {
                this.carrito.agregarProducto(productoAAgregar, cantidad);
            }else{
                System.out.println("No hay stock suficiente para agregar ese Producto");
            }
    }
    }

    private void eliminarProducto(){
        System.out.println("Ingrese el nombre del producto que quiera eliminar del carrito");
        String nombreBuscado = this.sc.next();
        System.out.println("EL ARTICULO ES SUBSIDIADO: (S/N)");
        char respuesta = this.sc.next().charAt(0);

        if (respuesta == 'S'||respuesta == 's') {
            nombreBuscado = nombreBuscado + "(S)";
        }

        Producto productoAEliminar = this.contArticulos.articuloBuscado(nombreBuscado);
        if (productoAEliminar == null) {
            System.out.println("El producto buscado no existe");
        }else{
            this.carrito.eliminarProducto(productoAEliminar);
        }
    }
    
}