package TrabajoFinal.TrabajoFinal.Menus;

import java.util.InputMismatchException;
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
        String username = this.sc.nextLine();
        usuarioARegistrar = this.contUsuarios.buscarUsuario(username);
        
        if (usuarioARegistrar != null) {
            while (usuarioARegistrar != null) {
            System.out.println("El nombre de usuario ya esta registrado ingrese otro: ");
            username = this.sc.nextLine();
            usuarioARegistrar = this.contUsuarios.buscarUsuario(username);
        }
        }

        String password = this.elegirClave();

        String rol = this.elegirRol();

        Usuario nuevoUsuario = new Usuario(username, password, rol);
        this.contUsuarios.add(nuevoUsuario);
    }
    //define si el usuario es cliente o empleado
    private String elegirRol(){
        
        while (true) {
            try{
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
            }catch(InputMismatchException e){
                this.sc.nextLine();
                System.out.println("ERROR: Ingrese una opcion valida");
            }
        }
    }
    //verificacion de contraseña
    private String elegirClave(){        
        String clave = null;
        String verificarClave = null;
        boolean verificado = false;

        while (verificado == false) {
            System.out.println("Ingrese la contraseña");
            clave = this.sc.nextLine();
            System.out.println("Ingrese nuevamente la contraseña");
            verificarClave = this.sc.nextLine();
            if (clave.equals(verificarClave)) {
                verificado = true;
            }
        }
        return clave;
    }
}
