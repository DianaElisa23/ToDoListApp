import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<String> tareas = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n To Do List");
            System.out.println("1. Agregar tarea");
            System.out.println("2. Listar tareas");
            System.out.println("3. Salir");
            System.out.print("Seleccione una de las opciones: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Escribe la tarea: ");
                    String tarea = sc.nextLine();
                    tareas.add(tarea);
                    System.out.println("Tarea agregada");
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
                    System.out.println("Saliendo..");
                    break;

                default:
                    System.out.println("Opción inválida");
            }

        } while (opcion != 3);

        sc.close();
    }
}
