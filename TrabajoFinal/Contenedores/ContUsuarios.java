package TrabajoFinal.TrabajoFinal.Contenedores;

import java.util.ArrayList;
import java.util.Scanner;

import TrabajoFinal.TrabajoFinal.Modelos.Usuario;

public class ContUsuarios {
    
    ArrayList<Usuario> listaUsuarios = new ArrayList<Usuario>();
    Scanner sc;

    public ContUsuarios(Scanner sc) {
        this.sc = sc;
    }

    //verifica si el usuario existe, tanto para el registro como para el login
    public Usuario buscarUsuario(String username){
        Usuario  usuarioBuscado = null;
        for (Usuario usuario : listaUsuarios) {
            if (usuario.getUsername().equals(username)) {
                usuarioBuscado = usuario;
                break;
            }
        }
        return usuarioBuscado;
    }

    //agrega un usuario a la lista
    public void add(Usuario usuario){
        this.listaUsuarios.add(usuario);
    }

    public void mostrarAllUsuarios(){
        for (Usuario usuario : listaUsuarios) {
            System.out.println(usuario.toString());
        }
    }
    

}
