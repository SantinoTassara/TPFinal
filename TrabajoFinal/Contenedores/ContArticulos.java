package TrabajoFinal.TrabajoFinal.Contenedores;

import java.util.ArrayList;
import java.util.Scanner;

import TrabajoFinal.TrabajoFinal.Modelos.Producto;

public class ContArticulos {
    
    ArrayList<Producto> listaArticulos = new ArrayList<>();
    Scanner sc;
    
    public ContArticulos(Scanner sc) {
        this.sc = sc;
    }

    public Producto articuloBuscado(String nombre){
        Producto articuloBuscado = null;
        for (Producto producto : listaArticulos) {
            if (producto.getNombreArticulo().equalsIgnoreCase(nombre)) {
                articuloBuscado = producto;
                break;
            }
        }
        return articuloBuscado;
    }

    public void mostrarArticulo(Producto producto){
        System.out.println("--------------------");
        System.out.println("Nombre: "+producto.getNombreArticulo());
        System.out.println("Precio: "+producto.getPrecio());
        System.out.println("Descripcion: "+producto.getDescripcion());
        System.out.println("Codigo del Articulo: "+producto.getCodigoArticulo());
        System.out.println("Stock disponible: "+producto.getStock());
        System.out.println("Rubro: "+producto.getRubro());
        System.out.println("--------------------");
    }
    public void mostrarAllArticulos(){
        for (Producto producto : listaArticulos) {
            this.mostrarArticulo(producto);
        }
    }

    public void add(Producto producto){
        this.listaArticulos.add(producto);
    }

    public void editarArticulo(){
        System.out.println("Ingrese el nombre del articulo: ");
        String nombre = this.sc.next();
        Producto articuloAEditar = this.articuloBuscado(nombre);

        if (articuloAEditar == null) {
            System.out.println("El articulo buscado no existe");
        }else{
            System.out.println("Ingrese el nuevo nombre del articulo: ");
            String nuevoNombre = this.sc.next();
            articuloAEditar.setNombreArticulo(nuevoNombre);
            System.out.println("Ingrese el nuevo precio del articulo:");
            double nuevoPrecio = this.sc.nextDouble();
            articuloAEditar.setPrecio(nuevoPrecio);
            System.out.println("Ingrese la nueva descripcion del articulo: ");
            String nuevaDescripcion = this.sc.next();
            articuloAEditar.setDescripcion(nuevaDescripcion);
            
            int nuevoIdAriculo = this.codigoArticulos();
            articuloAEditar.setCodigoArticulo(nuevoIdAriculo);
            
            char nuevoRubro = seleccionRubro();
            articuloAEditar.setRubro(nuevoRubro);

        }
    }
    public int codigoArticulos(){
        int codigoArticulo = 0;
        boolean noRepetido = true;
        
        while (noRepetido == true) {
            System.out.println("Ingresa el id del articulo: ");
            codigoArticulo = this.sc.nextInt();

            for (Producto producto : listaArticulos) {
                if (codigoArticulo == producto.getCodigoArticulo()) {
                    noRepetido = false;
                    System.out.println("Ya existe ese ID de producto, ingrese otro.");
                    break;
                }
            }
        }

        return codigoArticulo;
    }
    public char seleccionRubro(){
        char rubro = 0;
        System.out.println("Seleccione a que rubro pertenece el producto: ");
        System.out.println("1.Rubro: Alimentos");
        System.out.println("2.Rubro: Electrodomesticos");
        System.out.println("3.Rubro: Indumentaria");
        

            String opcion = this.sc.next();
            switch (opcion) {
                case "1":
                    rubro = 'A';
                    break;
                case "2":
                    rubro = 'B';
                    break;
                case "3":
                    rubro = 'C';
                default:
                    System.out.println("Opcion incorrecta");
                    break;
            }
        
        return rubro;
    }

}
