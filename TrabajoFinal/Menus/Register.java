package TrabajoFinal.TrabajoFinal.Menus;

import java.util.Scanner;

import TrabajoFinal.TrabajoFinal.Contenedores.ContUsuarios;
import TrabajoFinal.TrabajoFinal.Modelos.Usuario;

public class Register {
    
    //atributos:
    private Scanner sc;
    private ContUsuarios contUsuarios;


    
    //constructor:
    public Register(Scanner sc, ContUsuarios contUsuarios) {
        this.sc = sc;
        this.contUsuarios = contUsuarios;
    }    


    //metodos:
    public void registrarUsuario(){
        Usuario usuarioARegistrar = null;

        System.out.println("Ingrese el nombre de usuario: ");
        String username = this.sc.next();
        usuarioARegistrar = this.contUsuarios.buscarUsuario(username);
        
        if (usuarioARegistrar != null) {
            while (usuarioARegistrar != null) {
            System.out.println("El nombre de usuario ya esta registrado ingrese otro: ");
            username = this.sc.next();
            usuarioARegistrar = this.contUsuarios.buscarUsuario(username);
        }
        }

        String password = this.contUsuarios.elegirClave();

        String rol = this.contUsuarios.elegirRol();

        Usuario nuevoUsuario = new Usuario(username, password, rol);
        this.contUsuarios.add(nuevoUsuario);
    }
   
}
