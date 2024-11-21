import java.util.Scanner;

@FunctionalInterface
public interface CampoModificador<T> {
    void modificar(T entidad, Scanner scanner, String[] campos);
}
