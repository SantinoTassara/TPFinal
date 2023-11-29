package TrabajoFinal.TrabajoFinal.Menus;

import java.util.InputMismatchException;
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
        this.continuar = false;
    }

    public void iniciar(){
        while (continuar) {
            String opcion = this.elegirOpcion();
            this.ejecutarOpcion(opcion);
        }
    }

    private String elegirOpcion(){
        while (true) {
            try{
                this.mostrarOpciones();
                String opcion = this.sc.next();
                return opcion;
            }catch(InputMismatchException e){
                this.sc.nextLine();
                System.out.println("ERROR: Ingrese una opcion valida");
            }
        }
    }
    private void mostrarOpciones(){
        System.out.println("---------- Menu de Articulos ----------");
        System.out.println("0.Volver al menu de empleados");
        System.out.println("1.Cargar Articulo");
        System.out.println("2.Editar Articulo");
        System.out.println("3.Mostrar Todos los Articulos");
        System.out.println("4.Eliminar Articulo");
        System.out.println("--------------------");
    }
    private void ejecutarOpcion(String opcion){
      
            switch (opcion) {
            case "1":
                this.cargarArticulo();
                break;
            case "2":
                this.editarArticulo();
                break;
            case "3":
                this.contenedorArticulos.mostrarAllArticulos();
                break;
            case "4":
                this.eliminarArticulo();
                break;
            case "0":
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
        
        try{
            System.out.println("Ingrese el nombre del producto: ");
            String nombre = this.sc.next();
            Producto producto = this.contenedorArticulos.articuloBuscado(nombre);
            if (producto == null) {
                System.out.println("Ingrese el precio:");
                double precio = this.sc.nextDouble();
                System.out.println("Ingrese la descripcion del producto: ");
                String descripcion = this.sc.next();

                int codigoArticulo = contenedorArticulos.codigoArticulos();
                
                System.out.println("Ingrese el Stock: ");
                int stock = this.sc.nextInt();
                
                char rubro = this.contenedorArticulos.seleccionRubro();

                String tipo = "Articulo Simple";

                Producto nuevoProducto = new ArtSimples(nombre, precio, descripcion, codigoArticulo, stock, rubro, codigoArticulo, tipo);
                this.contenedorArticulos.add(nuevoProducto);   
            }else{
                System.out.println("Ese producto ya existe");
            }    
        }catch(InputMismatchException e){
            this.sc.nextLine();
            System.out.println("ERROR: Ingrese una opcion valida:  ");
        }
    }

      private void cargarArticuloSub(){
        try{
            System.out.println("Ingrese el nombre del producto: ");
            String nombre = this.sc.next();
            nombre = nombre + "(S)";
            Producto producto = this.contenedorArticulos.articuloBuscado(nombre);
            if (producto == null) {
                System.out.println("Ingrese el precio:");
                double precio = this.sc.nextDouble();
                System.out.println("Ingrese la descripcion del producto: ");
                String descripcion = this.sc.next();

                int codigoArticulo = this.contenedorArticulos.codigoArticulos();
                
                System.out.println("Ingrese el Stock: ");
                int stock = this.sc.nextInt();
                
                char rubro = this.contenedorArticulos.seleccionRubro();

                String tipo = "Articulo Subsidiado";

                Producto nuevoProducto = new ArtSub(nombre, precio, descripcion, codigoArticulo, stock, rubro,tipo);
                this.contenedorArticulos.add(nuevoProducto);
            }else{
                System.out.println("Ese producto ya existe");
            }         
        }catch(InputMismatchException e){
            this.sc.nextLine();
            System.out.println("ERROR: Ingrese un opcion valida: ");
        }
    }

      private void cargarArtXDemanda(){
        try{
            System.out.println("Ingrese el nombre del producto: ");
            String nombre = this.sc.next();
            Producto producto = this.contenedorArticulos.articuloBuscado(nombre);
            if (producto == null) {
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

                String tipo = "Articulo por demanda";
                Producto nuevoProducto = new ArtXDemanda(nombre, precio, descripcion, codigoArticulo, stock, rubro, stockDeseado,tipo);
                this.contenedorArticulos.add(nuevoProducto);
            }else{
                System.out.println("Ese producto ya existe");
            }
        }catch(InputMismatchException e){
            this.sc.nextLine();
            System.out.println("ERROR: Ingrese una opcion valida: ");
        }
    }
    private void editarArticulo(){
        try{
            System.out.println("Ingrese el nombre del articulo: ");
            String nombre = this.sc.next();

            System.out.println("EL ARTICULO ES SUBSIDIADO: (S/N)");
            char respuesta = this.sc.next().charAt(0);
            if (respuesta == 'S'||respuesta == 's') {
                nombre = nombre + "(S)";
            }
            Producto articuloAEditar = this.contenedorArticulos.articuloBuscado(nombre);

            if (articuloAEditar == null) {
                System.out.println("El articulo buscado no existe");
            }else{
                System.out.println("Ingrese el nuevo nombre del articulo: ");
                String nuevoNombre = this.sc.next();
                if (respuesta == 'S'||respuesta == 's') {
                        nuevoNombre = nuevoNombre + "(S)";
                    }
                articuloAEditar.setNombreArticulo(nuevoNombre);
                System.out.println("Ingrese el nuevo precio del articulo:");
                double nuevoPrecio = this.sc.nextDouble();
                articuloAEditar.setPrecio(nuevoPrecio);
                System.out.println("Ingrese la nueva descripcion del articulo: ");
                String nuevaDescripcion = this.sc.next();
                articuloAEditar.setDescripcion(nuevaDescripcion);
                
                int nuevoIdAriculo = this.contenedorArticulos.codigoArticulos();
                articuloAEditar.setCodigoArticulo(nuevoIdAriculo);
                
                char nuevoRubro = this.contenedorArticulos.seleccionRubro();
                articuloAEditar.setRubro(nuevoRubro);

            }
        }catch(InputMismatchException e){
            this.sc.nextLine();
            System.out.println("ERROR: Ingrese una opcion valida:");
        }
    }
    private void eliminarArticulo(){
        System.out.println("-------------------------------");
        System.out.println("Ingrese el nombre del articulo a eliminar: ");
        String nombreBuscado = this.sc.next();
        Producto productoBuscado = this.contenedorArticulos.articuloBuscado(nombreBuscado);
        if (nombreBuscado == null) {
            System.out.println("Este articulo no existe");
        }else{
            this.contenedorArticulos.remove(productoBuscado);
        }
        System.out.println("-------------------------------");
    }
}
