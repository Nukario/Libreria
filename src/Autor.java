public class Autor extends Entidad {
    private static int contadorId = 1; // Contador estático para IDs autoincrementales

    private String nombre;
    private int añoPublicacion;

    public Autor(String nombre, int añoPublicacion) {
        super("0" + contadorId++); // Generar ID automáticamente
        this.nombre = nombre;
        this.añoPublicacion = añoPublicacion;
    }

    // Getters y Setters (sin incluir ID, ya que es autogenerado)
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getañoPublicacion() {
        return añoPublicacion;
    }

    public void setañoPublicacion(int añoPublicacion) {
        this.añoPublicacion = añoPublicacion;
    }

    @Override
    public String toString() {
        return "Autor ID=" + getId() + ", Nombre=" + nombre + ", Año de Publicación=" + añoPublicacion;
    }
}
