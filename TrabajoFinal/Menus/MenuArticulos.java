package TrabajoFinal.TrabajoFinal.Menus;

import java.util.Scanner;

import TrabajoFinal.TrabajoFinal.Contenedores.ContArticulos;
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
        System.out.println("--------------------");
        System.out.println("1.Cargar Articulo");
        System.out.println("2.Editar Articulo");
        System.out.println("3.Mostrar Todos los Articulos");
        System.out.println("--------------------");
    }
    private void ejecutarOpcion(int opcion){
       switch (opcion) {
        case 0:
            this.salir();
            break;
        case 1:
            this.cargarArticulo();
            break;
        case 2:
            this.contenedorArticulos.editarArticulo();
        case 3:
            this.contenedorArticulos.mostrarAllArticulos();
            break;
        default:
            System.out.println("Opcion incorrecta");
            break;
       }
    }
    

    private void cargarArticulo(){
        
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

        Producto nuevoProducto = new Producto(nombre, precio, descripcion, codigoArticulo, stock, rubro);
        this.contenedorArticulos.add(nuevoProducto);
      }
    
}
