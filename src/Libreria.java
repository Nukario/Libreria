import java.util.Scanner;

public class Libreria {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        GestorEntidades<Libro> gestorLibros = new GestorEntidades<>();
        GestorEntidades<Editorial> gestorEditoriales = new GestorEntidades<>();
        GestorEntidades<Autor> gestorAutores = new GestorEntidades<>();

        int opcionPrincipal;
        do {
            System.out.println("\n--- Menú Principal ---");
            System.out.println("1. Libros");
            System.out.println("2. Editoriales");
            System.out.println("3. Autores");
            System.out.println("4. Salir");
            System.out.print("Selecciona una opción: ");
            opcionPrincipal = scanner.nextInt();
            scanner.nextLine();

            switch (opcionPrincipal) {
                case 1:
                    menuEntidades(gestorLibros, scanner, "Libro");
                    break;
                case 2:
                    menuEntidades(gestorEditoriales, scanner, "Editorial");
                    break;
                case 3:
                    menuEntidades(gestorAutores, scanner, "Autor");
                    break;
                case 4:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción inválida. Intenta nuevamente.");
            }
        } while (opcionPrincipal != 4);

        scanner.close();
    }

    private static <T extends Entidad> void menuEntidades(
            GestorEntidades<T> gestor, Scanner scanner, String tipoEntidad) {

        int opcion;
        do {
            System.out.println("\n--- Menú de " + tipoEntidad + "s ---");
            System.out.println("1. Agregar");
            System.out.println("2. Modificar");
            System.out.println("3. Eliminar");
            System.out.println("4. Listar");
            System.out.println("5. Regresar");
            System.out.print("Selecciona una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    agregarEntidad(gestor, scanner, tipoEntidad);
                    break;
                case 2:
                    modificarEntidad(gestor, scanner, tipoEntidad);
                    break;
                case 3:
                    System.out.print("Ingrese el ID del " + tipoEntidad + " a eliminar: ");
                    String idEliminar = scanner.nextLine();
                    gestor.eliminar(idEliminar);
                    break;
                case 4:
                    gestor.listar();
                    break;
                case 5:
                    System.out.println("Regresando al menú principal...");
                    break;
                default:
                    System.out.println("Opción inválida. Intenta nuevamente.");
            }
        } while (opcion != 5);
    }

    private static <T extends Entidad> void agregarEntidad(
            GestorEntidades<T> gestor, Scanner scanner, String tipoEntidad) {

        switch (tipoEntidad) {
            case "Libro":
                System.out.print("Ingrese el título del libro: ");
                String titulo = scanner.nextLine();
                System.out.print("Ingrese el autor del libro: ");
                String autor = scanner.nextLine();
                System.out.print("Ingrese el precio del libro: ");
                double precio = scanner.nextDouble();
                scanner.nextLine();
                System.out.print("Ingrese la fecha de publicación (YYYY-MM-DD): ");
                String fechaPublicacion = scanner.nextLine();
                gestor.agregar((T) new Libro(titulo, autor, precio, fechaPublicacion));
                break;

            case "Editorial":
                System.out.print("Ingrese el nombre de la editorial: ");
                String nombreEditorial = scanner.nextLine();
                System.out.print("Ingrese la dirección de la editorial: ");
                String direccion = scanner.nextLine();
                System.out.print("Ingrese el año de publicación: ");
                int añoPublicacion = scanner.nextInt();
                scanner.nextLine();
                gestor.agregar((T) new Editorial(nombreEditorial, direccion, añoPublicacion));
                break;

            case "Autor":
                System.out.print("Ingrese el nombre del autor: ");
                String nombreAutor = scanner.nextLine();
                System.out.print("Ingrese el año de publicación: ");
                int añoAutor = scanner.nextInt();
                scanner.nextLine();
                gestor.agregar((T) new Autor(nombreAutor, añoAutor));
                break;

            default:
                System.out.println("Tipo de entidad no soportado.");
        }
        System.out.println(tipoEntidad + " agregado exitosamente.");
    }

    private static <T extends Entidad> void modificarEntidad(
            GestorEntidades<T> gestor, Scanner scanner, String tipoEntidad) {

        System.out.print("Ingrese el ID del " + tipoEntidad + " a modificar: ");
        String idModificar = scanner.nextLine();

        switch (tipoEntidad) {
            case "Libro":
                gestor.modificar(idModificar, scanner, new String[]{"Título", "Autor", "Precio", "Fecha de Publicación"},
                        (entidad, sc, campos) -> {
                            Libro libro = (Libro) entidad;
                            System.out.print("Ingrese el nuevo título: ");
                            libro.setTitulo(sc.nextLine());
                            System.out.print("Ingrese el nuevo autor: ");
                            libro.setAutor(sc.nextLine());
                            System.out.print("Ingrese el nuevo precio: ");
                            libro.setPrecio(sc.nextDouble());
                            sc.nextLine();
                            System.out.print("Ingrese la nueva fecha de publicación (YYYY-MM-DD): ");
                            libro.setFechaPublicacion(sc.nextLine());
                        });
                break;

            case "Editorial":
                gestor.modificar(idModificar, scanner, new String[]{"Nombre", "Dirección", "Año de Publicación"},
                        (entidad, sc, campos) -> {
                            Editorial editorial = (Editorial) entidad;
                            System.out.print("Ingrese el nuevo nombre: ");
                            editorial.setNombre(sc.nextLine());
                            System.out.print("Ingrese la nueva dirección: ");
                            editorial.setDireccion(sc.nextLine());
                            System.out.print("Ingrese el nuevo año de publicación: ");
                            editorial.setañoPublicacion(sc.nextInt());
                            sc.nextLine();
                        });
                break;

            case "Autor":
                gestor.modificar(idModificar, scanner, new String[]{"Nombre", "Año de Publicación"},
                        (entidad, sc, campos) -> {
                            Autor autor = (Autor) entidad;
                            System.out.print("Ingrese el nuevo nombre: ");
                            autor.setNombre(sc.nextLine());
                            System.out.print("Ingrese el nuevo año de publicación: ");
                            autor.setañoPublicacion(sc.nextInt());
                            sc.nextLine();
                        });
                break;

            default:
                System.out.println("Tipo de entidad no soportado.");
        }
        System.out.println(tipoEntidad + " modificado exitosamente.");
    }
}
