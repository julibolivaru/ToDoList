import java.util.ArrayList;
import java.util.Scanner;

public class ToDoList {
    private static final ArrayList<String> todoList = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean exit = false;

        while (!exit) {
            System.out.println("Bienvenido a la Aplicación de Lista de Tareas");
            System.out.println("1. Agregar tarea");
            System.out.println("2. Marcar tarea como completada");
            System.out.println("3. Ver todas las tareas pendientes");
            System.out.println("4. Eliminar tarea");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addTask();
                    break;
                case 2:
                    markTaskAsCompleted();
                    break;
                case 3:
                    viewPendingTasks();
                    break;
                case 4:
                    deleteTask();
                    break;
                case 5:
                    exit = true;
                    System.out.println("Gracias por usar la aplicación.");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, seleccione nuevamente.");
                    break;
            }
        }
    }

    private static void addTask() {
        System.out.print("Ingrese la nueva tarea: ");
        String task = scanner.nextLine();
        todoList.add(task);
        System.out.println("Tarea agregada correctamente.");
    }

    private static void markTaskAsCompleted() {
        System.out.println("Tareas pendientes:");
        for (int i = 0; i < todoList.size(); i++) {
            System.out.println((i + 1) + ". " + todoList.get(i));
        }
        System.out.print("Ingrese el número de la tarea completada: ");
        int index = scanner.nextInt();
        if (index >= 1 && index <= todoList.size()) {
            todoList.remove(index - 1);
            System.out.println("Tarea marcada como completada correctamente.");
        } else {
            System.out.println("Número de tarea no válido.");
        }
    }

    private static void viewPendingTasks() {
        System.out.println("Tareas pendientes:");
        for (int i = 0; i < todoList.size(); i++) {
            System.out.println((i + 1) + ". " + todoList.get(i));
        }
    }

    private static void deleteTask() {
        System.out.println("Tareas pendientes:");
        for (int i = 0; i < todoList.size(); i++) {
            System.out.println((i + 1) + ". " + todoList.get(i));
        }
        System.out.print("Ingrese el número de la tarea a eliminar: ");
        int index = scanner.nextInt();
        if (index >= 1 && index <= todoList.size()) {
            todoList.remove(index - 1);
            System.out.println("Tarea eliminada correctamente.");
        } else {
            System.out.println("Número de tarea no válido.");
        }
    }
}
