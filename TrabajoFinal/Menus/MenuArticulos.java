package TrabajoFinal.TrabajoFinal.Menus;

import java.util.ArrayList;
import java.util.Scanner;

import TrabajoFinal.TrabajoFinal.Modelos.Producto;

public class MenuArticulos {
    boolean continuar = true;
    ArrayList<Producto> listaArticulos;
    Scanner sc;
    int cantArticulos = 0;
    
    public MenuArticulos(ArrayList<Producto> listaArticulos, Scanner sc) {
        this.listaArticulos = listaArticulos;
        this.sc = sc;
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
        case 3:
            this.mostrarAllArticulos();
            break;
        default:
            System.out.println("Opcion incorrecta");
            break;
       }
    }
    private void mostrarArticulo(Producto producto){
        System.out.println("--------------------");
        System.out.println("Nombre: "+producto.getNombreArticulo());
        System.out.println("Precio: "+producto.getPrecio());
        System.out.println("Descripcion: "+producto.getDescripcion());
        System.out.println("Codigo del Articulo: "+producto.getCodigoArticulo());
        System.out.println("Stock disponible: "+producto.getStock());
        System.out.println("Rubro: "+producto.getRubro());
        System.out.println("--------------------");

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
        
        System.out.println("Ingrese el rubro: ");
        char rubro = 'A';

        Producto nuevoProducto = new Producto(nombre, precio, descripcion, codigoArticulo, stock, rubro);
        this.listaArticulos.add(nuevoProducto);
      }
    
      private void mostrarAllArticulos(){
        for (Producto producto : listaArticulos) {
            this.mostrarArticulo(producto);
        }
      }
}
