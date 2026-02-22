import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class Main {
    static ArrayList<String> tareas = new ArrayList<>();
    static final String ARCHIVO_TAREAS = "tareas.txt";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;

        // Cargar tareas al iniciar
        cargarTareas();

        do {
            System.out.println("\n To Do List");
            System.out.println("1. Agregar tarea");
            System.out.println("2. Listar tareas");
            System.out.println("3. Marcar tarea como completada");
            System.out.println("4. Eliminar tarea");
            System.out.println("5. Salir");
            System.out.print("Seleccione una de las opciones: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Escribe la tarea: ");
                    String tarea = sc.nextLine();
                    tareas.add(tarea);
                    System.out.println("Tarea agregada");
                    guardarTareas();
                    break;

                case 2:
                    System.out.println("Tareas pendientes:");
                    if (tareas.isEmpty()) {
                        System.out.println("No hay tareas pendientes");
                    } else {
                        for (int i = 0; i < tareas.size(); i++) {
                            System.out.println((i + 1) + ". " + tareas.get(i));
                        }
                    }
                    break;

                case 3:
                    System.out.println("Funcionalidad de marcar como completada (próxima versión)");
                    break;

                case 4:
                    if (tareas.isEmpty()) {
                        System.out.println("No hay tareas para eliminar");
                    } else {
                        System.out.println("Tareas:");
                        for (int i = 0; i < tareas.size(); i++) {
                            System.out.println((i + 1) + ". " + tareas.get(i));
                        }
                        System.out.print("Ingresa el número de la tarea a eliminar: ");
                        int indice = sc.nextInt();
                        sc.nextLine();
                        if (indice > 0 && indice <= tareas.size()) {
                            tareas.remove(indice - 1);
                            System.out.println("Tarea eliminada");
                            guardarTareas();
                        } else {
                            System.out.println("Número de tarea inválido");
                        }
                    }
                    break;

                case 5:
                    System.out.println("Saliendo..");
                    break;

                default:
                    System.out.println("Opción inválida");
            }

        } while (opcion != 5);

        sc.close();
    }

    static void guardarTareas() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ARCHIVO_TAREAS))) {
            oos.writeObject(tareas);
        } catch (IOException e) {
            System.out.println("Error al guardar las tareas: " + e.getMessage());
        }
    }

    static void cargarTareas() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ARCHIVO_TAREAS))) {
            tareas = (ArrayList<String>) ois.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("Archivo de tareas no encontrado. Se creará uno nuevo.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al cargar las tareas: " + e.getMessage());
        }
    }
}