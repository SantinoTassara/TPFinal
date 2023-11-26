package TrabajoFinal.TrabajoFinal.Menus;

import java.util.Scanner;

import TrabajoFinal.TrabajoFinal.Contenedores.ContArticulos;
import TrabajoFinal.TrabajoFinal.Contenedores.ContUsuarios;
import TrabajoFinal.TrabajoFinal.Modelos.Usuario;

public class Login {
    private Scanner sc;
    private boolean continuar = true;
    private ContUsuarios contUsuarios;
    private Register mRegister;
    private ContArticulos contArticulos;
    private MenuClientes mClientes;
    private MenuEmpleado mEmpleado;

    //constructor que recibe una Arraylist y un Scanner desde el main
    public Login(Scanner sc, ContUsuarios contUsuarios, ContArticulos contArticulos) {
        this.sc = sc;
        this.contUsuarios = contUsuarios;
        this.contArticulos = contArticulos;
        //los menus reciben el scanner y la lista
        mRegister = new Register(sc, contUsuarios);
        mClientes = new MenuClientes(sc, contArticulos, contUsuarios);
        mEmpleado = new MenuEmpleado(sc, contArticulos);
    }

    private void salir(){
        continuar = false;
        System.out.println("Gracias por elegirnos");
    }

    public void iniciar(){
        System.out.println("Bienvenido Pepeopiola's");
        while (continuar) {
            String opcion = this.elegirOpcion();
            this.ejecutarOpcion(opcion);
        }
    }

    private String elegirOpcion(){
        this.mostrarOpciones();
        String opcion = this.sc.next();
        return opcion;
    }
    
    private void mostrarOpciones(){
        System.out.println("1.Registrarse");
        System.out.println("2.Login");
    }

    private void ejecutarOpcion(String opcion){
        switch (opcion) {
            case "0":
                this.salir();
                break;
            case "1":
                this.mRegister.registrarUsuario();
                break;
            case "2":
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
        Usuario usuarioEncontrado = this.contUsuarios.buscarUsuario(username);

        if (usuarioEncontrado == null ) {
            System.out.println("El usuario no existe");
        }else{
            System.out.println("Ingrese la contraseña: ");
            String password = this.sc.next();
            if (usuarioEncontrado.getPassword().equals(password)) {
                //Aca verifica si el usuario es empleado o Cliente
                if (usuarioEncontrado.getRol().equals("Cliente")) {
                    mClientes.iniciar(usuarioEncontrado);
                }else if (usuarioEncontrado.getRol().equals("Empleado")) {
                    mEmpleado.iniciar(usuarioEncontrado);
                }

            }else{
                System.out.println("Contraseña incorrecta");
            }
        }

    }
    
}
