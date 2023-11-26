package TrabajoFinal.TrabajoFinal.Menus;

import java.util.Scanner;

import TrabajoFinal.TrabajoFinal.Contenedores.ContArticulos;
import TrabajoFinal.TrabajoFinal.Modelos.ArtSimples;
import TrabajoFinal.TrabajoFinal.Modelos.ArtSub;
import TrabajoFinal.TrabajoFinal.Modelos.ArtXDemanda;
import TrabajoFinal.TrabajoFinal.Modelos.Producto;

public class MenuArticulos {

    private ContArticulos contenedorArticulos;
    boolean continuar = true;
    Scanner sc;
    int cantArticulos = 0;
    
    public MenuArticulos(Scanner sc, ContArticulos contArticulo) {
        this.sc = sc;
        this.contenedorArticulos = contArticulo;
    }

    private void salir(){
        continuar = false;
    }

    public void iniciar(){
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
        System.out.println("---------- Menu de Articulos ----------");
        System.out.println("1.Cargar Articulo");
        System.out.println("2.Editar Articulo");
        System.out.println("3.Mostrar Todos los Articulos");
        System.out.println("4.Gestionar Stock");
        System.out.println("5.Volver al menu de empleados");
        System.out.println("--------------------");
    }
    private void ejecutarOpcion(String opcion){
      
            switch (opcion) {
            case "0":
                this.salir();
                break;
            case "1":
                this.cargarArticulo();
                break;
            case "2":
                this.contenedorArticulos.editarArticulo();
                break;
            case "3":
                this.contenedorArticulos.mostrarAllArticulos();
                break;
            case "4":
                //Gestionar Stock
                break;
            case "5":
                this.salir();
                break;
            default:
                System.out.println("Opcion incorrecta");
                break;
            }
    }
    

    private void cargarArticulo(){
        System.out.println("----------------------------------");
        System.out.println("Ingrese el tipo de articulo que quiere crear");
        System.out.println("1. Articulo Simple");
        System.out.println("2. Articulo Subsidiado");
        System.out.println("3. Articulo por demanda");
        System.out.println("----------------------------------");

        String opcion = this.sc.next();
        
        switch (opcion) {
            case "1":
                this.cargarArticuloSimple();
                break;
            case "2":
                this.cargarArticuloSub();
                break;
            case "3":
                this.cargarArtXDemanda();
                break;
            default:
                break;
        }
    }

    private void cargarArticuloSimple(){
        
        System.out.println("Ingrese el nombre del producto: ");
        String nombre = this.sc.next();
        System.out.println("Ingrese el precio:");
        double precio = this.sc.nextDouble();
        System.out.println("Ingrese la descripcion del producto: ");
        String descripcion = this.sc.next();

        int codigoArticulo = cantArticulos;
        cantArticulos++;
        
        System.out.println("Ingrese el Stock: ");
        int stock = this.sc.nextInt();
        
        char rubro = this.contenedorArticulos.seleccionRubro();

        Producto nuevoProducto = new ArtSimples(nombre, precio, descripcion, codigoArticulo, stock, rubro, codigoArticulo);
        this.contenedorArticulos.add(nuevoProducto);
    }

      private void cargarArticuloSub(){
        System.out.println("Ingrese el nombre del producto: ");
        String nombre = this.sc.next()  + "(S)";
        System.out.println("Ingrese el precio:");
        double precio = this.sc.nextDouble();
        System.out.println("Ingrese la descripcion del producto: ");
        String descripcion = this.sc.next();

        int codigoArticulo = cantArticulos;
        cantArticulos++;
        
        System.out.println("Ingrese el Stock: ");
        int stock = this.sc.nextInt();
        
        char rubro = this.contenedorArticulos.seleccionRubro();

        Producto nuevoProducto = new ArtSub(nombre, precio, descripcion, codigoArticulo, stock, rubro);
        this.contenedorArticulos.add(nuevoProducto);
    }

      private void cargarArtXDemanda(){
        System.out.println("Ingrese el nombre del producto: ");
        String nombre = this.sc.next();
        System.out.println("Ingrese el precio:");
        double precio = this.sc.nextDouble();
        System.out.println("Ingrese la descripcion del producto: ");
        String descripcion = this.sc.next();

        int codigoArticulo = this.contenedorArticulos.codigoArticulos();
        
        System.out.println("Ingrese el Stock: ");
        int stock = this.sc.nextInt();

        System.out.println("Ingrese el stock deseado: ");
        int stockDeseado = this.sc.nextInt();
        
        char rubro = this.contenedorArticulos.seleccionRubro();

        Producto nuevoProducto = new ArtXDemanda(nombre, precio, descripcion, codigoArticulo, stock, rubro, stockDeseado);
        this.contenedorArticulos.add(nuevoProducto);
    }
    
}
