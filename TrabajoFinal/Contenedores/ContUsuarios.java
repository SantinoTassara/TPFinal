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

    //verificacion de contraseña
    public String elegirClave(){        
        String clave = null;
        String verificarClave = null;
        boolean verificado = false;

        while (verificado == false) {
            System.out.println("Ingrese la contraseña");
            clave = this.sc.next();
            System.out.println("Ingrese nuevamente la contraseña");
            verificarClave = this.sc.next();
            if (clave.equals(verificarClave)) {
                verificado = true;
            }
        }
        return clave;
    }
    public void mostrarAllUsuarios(){
        for (Usuario usuario : listaUsuarios) {
            System.out.println(usuario.toString());
        }
    }
    //define si el usuario es cliente o empleado
       public String elegirRol(){
        
        String rol = "falso";
        
        while (rol == "falso") {

            System.out.println("Elija el rol del usuario: ");
            System.out.println("1.Cliente");
            System.out.println("2.Empleado");
            int opcion = this.sc.nextInt();

            if (opcion == 1) {
                rol = "Cliente";
            }else if (opcion == 2) {
                //pide la clave de empleado y verifica que sea correcta, profe no podia ser una contraseña mas facil para testear???
                System.out.println("Ingrese la clave de empleado: ");
                String claveEmpleado = this.sc.next();

                if (claveEmpleado.equals("pepepiola123")) {
                    rol = "Empleado";
                }else{
                    System.out.println("Contraseña de la empleado incorrecta");
                }
            }else{
                System.out.println("Opcion incorrecta");
            }

        }
        return rol;
    }

}
