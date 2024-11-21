public class Editorial extends Entidad {
    private static int contadorId = 1; // Contador estático para IDs autoincrementales

    private String nombre;
    private String direccion;
    private int añoPublicacion;

    public Editorial(String nombre, String direccion, int añoPublicacion) {
        super("0" + contadorId++); // Generar ID automáticamente
        this.nombre = nombre;
        this.direccion = direccion;
        this.añoPublicacion = añoPublicacion;
    }

    // Getters y Setters (sin incluir ID, ya que es autogenerado)
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getañoPublicacion() {
        return añoPublicacion;
    }

    public void setañoPublicacion(int añoPublicacion) {
        this.añoPublicacion = añoPublicacion;
    }

    @Override
    public String toString() {
        return "Editorial ID=" + getId() + ", Nombre=" + nombre + ", Dirección=" + direccion +
                ", Año de Publicación=" + añoPublicacion;
    }
}
