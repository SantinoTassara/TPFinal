package TrabajoFinal.TrabajoFinal.Menus;

import java.util.InputMismatchException;
import java.util.Scanner;

import TrabajoFinal.TrabajoFinal.Contenedores.ContArticulos;
import TrabajoFinal.TrabajoFinal.Modelos.Usuario;

public class MenuEmpleado {
    private boolean continuar = true;
    private Scanner sc;
    private MenuArticulos mArticulos;
    private ContArticulos contArticulos;
    private Usuario empleadoLogueado;
    

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
        empleadoLogueado = usuario;
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
        System.out.println("---------- Menu de Empleado ----------");
        System.out.println("0. Salir");
        System.out.println("1. Ingresar al menu de gestion de articulos");
        System.out.println("2. ");
        System.out.println("3. ");
        System.out.println("--------------------------------------");
    }
    private void ejecutarOpcion(int opcion){
        try{
            switch (opcion) {
            case 0:
                this.salir();
                break;
            case 1:
                this.mArticulos.iniciar();
                break;
            default:
                break;
        }
        }catch(InputMismatchException e){
            System.out.println("ERROR: La opcion seleccionada es invalida!!!");
        }
    }
}
