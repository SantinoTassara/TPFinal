package TrabajoFinal.TrabajoFinal.Menus;

import java.util.Scanner;

import TrabajoFinal.TrabajoFinal.Contenedores.ContArticulos;
import TrabajoFinal.TrabajoFinal.Contenedores.ContUsuarios;
import TrabajoFinal.TrabajoFinal.Modelos.Producto;
import TrabajoFinal.TrabajoFinal.Modelos.Usuario;

public class MenuClientes {
    
    private boolean continuar = true;
    private Scanner sc;
    private ContUsuarios contUsuarios;
    private ContArticulos contArticulos;
    private Usuario usuarioLogeado;

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
        while (continuar) {
            int opcion = this.elegirOpcion();
            this.ejecutarOpcion(opcion);
        }
    }

    private int elegirOpcion(){
        this.mostrarOpciones();
        int opcion = this.sc.nextInt();
        return opcion;
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
        System.out.println("8. Ingresar al menu del carrito");
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

//falta agregar las opciones de trasferir y las que tiene que ver con el carrito
                case 0:
                    this.salir();
                    break;
                    
                default:
                    System.out.println("Opcion invalidad. Ingrese otra opcion. ");
                    break;
         }
}

    private void agregarDinero(){
        System.out.println("Ingrese la cantidad de dinero que quiere agregar");
        double dineroAAgregar = this.sc.nextDouble();

        if (dineroAAgregar <= 0) {
            System.out.println("ERROR: No se puede agregar una dinero negativo");
        }else{
            double dineroActual = this.usuarioLogeado.getBilletera();
            dineroAAgregar = dineroAAgregar + dineroActual;

            this.usuarioLogeado.setBilletera(dineroAAgregar);
        }
    }

    private void retirarDinero(){
        System.out.println("Ingrese la cantidad de dinero que quiere retirar");
        double dineroARetirar = this.sc.nextDouble();

        if (dineroARetirar < 0) {
            System.out.println("ERRO: Opcion invalida seleccione un numero positivo");
        }else{
            
            double dineroActual = this.usuarioLogeado.getBilletera();
            if (dineroARetirar > dineroActual) {
                System.out.println("Saldo insuficiente");
            }else{
                dineroARetirar = dineroARetirar - dineroActual;
                this.usuarioLogeado.setBilletera(dineroARetirar);
            }
        }
    }

    private void verSaldo(){
        double saldoDisponible = this.usuarioLogeado.getBilletera();
        System.out.println("Saldo disponible: "+ saldoDisponible);
    }

    private void buscarArticulo(){
        System.out.println("Ingrese el nombre del articulo buscado");
        String nombreBuscado = this.sc.next();

        Producto articuloBuscado = this.contArticulos.articuloBuscado(nombreBuscado);
        if (articuloBuscado == null) {
            System.out.println("No se encontro el articulo buscado");
        }else{
            this.contArticulos.mostrarArticulo(articuloBuscado); 
        }     
    }
    private void transferirDinero(){
        
    }
}