package TrabajoFinal.TrabajoFinal.Modelos;

public class Usuario {
    private String username;
    private String password;
    private String rol;
    private Double billetera = 0.0;
    private Carrito carrito;
    
    public Usuario(String username, String password, String rol) {
        this.username = username;
        this.password = password;
        this.rol = rol;
        this.carrito = new Carrito();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Carrito getCarrito() {
        return carrito;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public void setCarrito(Carrito carrito) {
        this.carrito = carrito;
    }

    public Double getBilletera() {
        return billetera;
    }

    public void setBilletera(Double billetera) {
        this.billetera = billetera;
    }

    




}
