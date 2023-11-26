/*Cosas a agregar:
    -Carrito
    Menu Cliente:
    -Todas las opciones que tiene que ver con el carrito
    Menu empleado: 
    -edicion de stock(Solo verificar si funciona)
    -otras cosas (Revisar)
    Articulos:
    -Edicion de articulos
    -hay que verificar si los descuentos se aplican correctamente
*/

package TrabajoFinal.TrabajoFinal.Mains;


import java.util.Scanner;

import TrabajoFinal.TrabajoFinal.Contenedores.ContArticulos;
import TrabajoFinal.TrabajoFinal.Contenedores.ContUsuarios;
import TrabajoFinal.TrabajoFinal.Menus.Login;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ContUsuarios contUsuarios = new ContUsuarios(sc);
        ContArticulos contArticulos = new ContArticulos(sc);
        Login mLogin = new Login(sc, contUsuarios, contArticulos);

        mLogin.iniciar();

        
    }
}
