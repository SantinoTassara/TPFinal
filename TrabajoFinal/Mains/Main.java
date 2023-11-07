package TrabajoFinal.TrabajoFinal.Mains;

import java.util.ArrayList;
import java.util.Scanner;

import TrabajoFinal.TrabajoFinal.Menus.Login;
import TrabajoFinal.TrabajoFinal.Modelos.Usuario;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Usuario> listaUsuarios = new ArrayList<>();
        Login mLogin = new Login(sc, listaUsuarios);

        mLogin.iniciar();
    }
}
