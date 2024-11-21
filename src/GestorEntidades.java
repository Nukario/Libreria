import java.util.ArrayList;
import java.util.Scanner;

public class GestorEntidades<T extends Entidad> {
    private ArrayList<T> entidades;

    public GestorEntidades() {
        this.entidades = new ArrayList<>();
    }

    public void agregar(T entidad) {
        entidades.add(entidad);
        System.out.println("Entidad agregada exitosamente.");
    }

    public void modificar(String id, Scanner scanner, String[] campos, CampoModificador<T> modificador) {
        for (T entidad : entidades) {
            if (entidad.getId().equalsIgnoreCase(id)) {
                modificador.modificar(entidad, scanner, campos);
                System.out.println("Entidad modificada exitosamente.");
                return;
            }
        }
        System.out.println("Entidad no encontrada.");
    }

    public void eliminar(String id) {
        entidades.removeIf(entidad -> entidad.getId().equalsIgnoreCase(id));
        System.out.println("Entidad eliminada exitosamente.");
    }

    public void listar() {
        if (entidades.isEmpty()) {
            System.out.println("No hay entidades registradas.");
        } else {
            System.out.println("\n--- Lista de Entidades ---");
            for (T entidad : entidades) {
                System.out.println(entidad);
            }
        }
    }
}
