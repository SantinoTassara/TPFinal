package TrabajoFinal.TrabajoFinal.Menus;

import java.util.ArrayList;
import java.util.Scanner;

import TrabajoFinal.TrabajoFinal.Modelos.Usuario;

public class Login {
    private Scanner sc;
    private boolean continuar = true;
    private ArrayList<Usuario> listaUsuarios;
    private MenuClientes mClientes = new MenuClientes();
    private MenuEmpleado mEmpleado = new MenuEmpleado();

    //constructor que recibe una Arraylist y un Scanner desde el main
    public Login(Scanner sc, ArrayList<Usuario> listaUsuarios) {
        this.sc = sc;
        this.listaUsuarios = listaUsuarios;
    }

    //es el menu de registros recibe el scanner y la lista
    private Register mRegister = new Register(sc, listaUsuarios);

    public void iniciar(){
        System.out.println("Bienvenido Mercado Libre");
        while (continuar) {
            int opcion = this.elegirOpcion();
            this.ejecutarOpcion(opcion);
        }
    }

    private int elegirOpcion(){
        this.mostrarOpciones();
        int opcion = this.sc.nextInt();
        return opcion;
    }
    
    private void mostrarOpciones(){
        System.out.println("1.Registrarse");
        System.out.println("2.Login");
    }

    private void ejecutarOpcion(int opcion){
        switch (opcion) {
            case 1:
                    this.mRegister.registrarUsuario();
                break;
            case 2:
                    this.login();
                break;
            default:
                break;
        }
    }
    //funcion login
    private void login(){
        System.out.println("Ingrese el nombre de usuario");
        String username = this.sc.next();
        Usuario usuarioEncontrado = this.buscarUsuario(username);

        if (usuarioEncontrado == null ) {
            System.out.println("El usuario no existe");
        }else{
            System.out.println("Ingrese la contraseña: ");
            String password = this.sc.next();
            if (usuarioEncontrado.getPassword().equals(password)) {
                //Aca verifica si el usuario es empleado o Cliente
                if (usuarioEncontrado.getRol().equals("Cliente")) {
                    mClientes.iniciar();
                }else if (usuarioEncontrado.getRol().equals("Empleado")) {
                    mEmpleado.iniciar();
                }

            }else{
                System.out.println("Contraseña incorrecta");
            }
        }

    }
    //verifica que  el nombre de usuario sea correcto, si es correcto te devuelve usuario y sino te devuelve un null
    private Usuario buscarUsuario(String username){
        Usuario  usuarioBuscado = null;
        for (Usuario usuario : listaUsuarios) {
            if (usuario.getUsername().equals(username)) {
                usuarioBuscado = usuario;
            }
        }
        
        return usuarioBuscado;
    }
}
