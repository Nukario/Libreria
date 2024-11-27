import java.util.ArrayList;
import java.util.Scanner;

public class GestorEntidades<T extends Entidad> {
    private ArrayList<T> entidades;

    public GestorEntidades() {
        this.entidades = new ArrayList<>();
    }

    public void agregar(T entidad) {
        entidades.add(entidad);
        System.out.println("Agregado exitosamente.");
    }

    public void modificar(String id, Scanner scanner, String[] campos, CampoModificador<T> modificador) {
        for (T entidad : entidades) {
            if (entidad.getId().equalsIgnoreCase(id)) {
                modificador.modificar(entidad, scanner, campos);
                System.out.println("Modificado exitosamente.");
                return;
            }
        }
        System.out.println("No encontrado.");
    }

    public void eliminar(String id) {
        entidades.removeIf(entidad -> entidad.getId().equalsIgnoreCase(id));
        System.out.println("Eliminado exitosamente.");
    }

    public void listar() {
        if (entidades.isEmpty()) {
            System.out.println("No hay datos registradas.");
        } else {
            System.out.println("\n--- Lista de Entidades ---");
            for (T entidad : entidades) {
                System.out.println(entidad);
            }
        }
    }
}
