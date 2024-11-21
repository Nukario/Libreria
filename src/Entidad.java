public abstract class Entidad {
    private String id; // Identificador único para cada entidad

    public Entidad(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public abstract String toString();
}
