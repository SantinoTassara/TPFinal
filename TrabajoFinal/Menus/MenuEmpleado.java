package TrabajoFinal.TrabajoFinal.Menus;

import java.util.Scanner;

import TrabajoFinal.TrabajoFinal.Contenedores.ContArticulos;
import TrabajoFinal.TrabajoFinal.Modelos.Usuario;

public class MenuEmpleado {
    //private boolean continuar = true;
    Scanner sc;
    MenuArticulos mArticulos;
    ContArticulos contArticulos;
    

    public MenuEmpleado(Scanner sc, ContArticulos contArticulos) {
        this.sc = sc;
        this.contArticulos = contArticulos;
    }


    //cuando crees la funcion agregar articulo, pregunta que se puedan crear los 3 tipos de articulos
    public void iniciar(Usuario usuario){
        System.out.println("----------MENU EMPLEADO----------");
        System.out.println("Ingresar al menu de articulos");
        mArticulos.iniciar();
    }
}
