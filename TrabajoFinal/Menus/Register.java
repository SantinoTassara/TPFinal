package TrabajoFinal.TrabajoFinal.Menus;

import java.util.ArrayList;
import java.util.Scanner;

import TrabajoFinal.TrabajoFinal.Modelos.Usuario;

public class Register {
    //atributos:
    private Scanner sc;
    private ArrayList<Usuario> listaUsuarios;
    private boolean verificado;

    
    //constructor:
    public Register(Scanner sc, ArrayList<Usuario> listaUsuarios) {
        this.sc = sc;
        this.listaUsuarios = listaUsuarios;
    }


    //metodos:

    public void registrarUsuario(){
        while (verificado == false) {
            System.out.println("Ingrese el nombre de usuario: ");
            String username = this.sc.next();
            this.verificarUsername(username);
        }
        String password = this.elegirContraseña();

        String rol = this.elegirRol();

        Usuario nuevoUsuario = new Usuario(password, password, rol);
        listaUsuarios.add(nuevoUsuario);
    }
    //verifica si el nombre de usuario ya esta en uso
    private boolean verificarUsername(String username){
        for (Usuario usuario : listaUsuarios) {
            if (usuario.getUsername().equals(username)) {
                System.out.println("Ese nombre ya esta registrado");
            }else{
                verificado = true;
            }
        }
        return verificado;
    }
    //define si el usuario es cliente o empleado
    private String elegirRol(){
        
        String rol = null;
        
        while (rol == null) {

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
    //pide la contraseña 2 veces para verificar en caso de que sean diferentes te pregunta de nuevo
    private String elegirContraseña(){        
        String contraseña = null;
        String verificarContraseña = null;
        boolean verificado = false;

        while (verificado == false) {
            System.out.println("Ingrese la contraseña");
            contraseña = this.sc.next();
            System.out.println("Ingrese nuevamente la contraseña");
            verificarContraseña = this.sc.next();
            if (contraseña.equals(verificarContraseña)) {
                verificado = true;
            }
        }

        return contraseña;
    }
}
