package TrabajoFinal.TrabajoFinal.Mains;


import java.util.Scanner;

import TrabajoFinal.TrabajoFinal.Contenedores.ContUsuarios;
import TrabajoFinal.TrabajoFinal.Menus.Login;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ContUsuarios contUsuarios = new ContUsuarios(sc);
        Login mLogin = new Login(sc, contUsuarios);

        mLogin.iniciar();
    }
}
