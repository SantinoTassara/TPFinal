/*Cosas a agregar:
    -Carrito
    -Editar articulos
    Menu Cliente:
    -Todas las opciones que tiene que ver con el carrito y transferencia de dinero a otros Usuarios
    Menu empleado: 
    -todo
    Articulos:
    -Edicion de articulos
    -Clases hijas de Productos (ArtSimple, ArtSub, ArtXDemanda)
    -Descuentos
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
