public class Libro extends Entidad {
    private static int contadorId = 1; // Contador estático para IDs autoincrementales

    private String titulo;
    private String autor;
    private double precio;
    private String fechaPublicacion;

    public Libro(String titulo, String autor, double precio, String fechaPublicacion) {
        super("0" + contadorId++); // Generar ID automáticamente
        this.titulo = titulo;
        this.autor = autor;
        this.precio = precio;
        this.fechaPublicacion = fechaPublicacion;
    }

    // Getters y Setters (sin incluir ID, ya que es autogenerado)
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(String fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    @Override
    public String toString() {
        return "Libro ID=" + getId() + ", Título=" + titulo + ", Autor=" + autor +
                ", Precio=$" + precio + ", Fecha de Publicación=" + fechaPublicacion ;
    }
}
