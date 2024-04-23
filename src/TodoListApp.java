import java.util.InputMismatchException;
import java.util.Scanner;

public class TodoListApp {
    private static final Scanner scanner = new Scanner(System.in);
    private static final TaskManager taskManager = new TaskManager();

    public static void main(String[] args) {
        boolean exit = false;

        while (!exit) {
            System.out.println("\n Bienvenido a la Aplicación de Lista de Tareas");
            System.out.println("1. Agregar tarea");
            System.out.println("2. Marcar tarea como completada");
            System.out.println("3. Ver todas las tareas pendientes");
            System.out.println("4. Eliminar tarea");
            System.out.println("5. Salir \n \n");
            System.out.print("Seleccione una opción: ");

            try {
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        taskManager.addTask();
                        break;
                    case 2:
                        taskManager.markTaskAsCompleted();
                        break;
                    case 3:
                        taskManager.viewPendingTasks();
                        break;
                    case 4:
                        taskManager.deleteTask();
                        break;
                    case 5:
                        exit = true;
                        System.out.println("Gracias por usar la aplicación.");
                        break;
                    default:
                        System.out.println("Opción no válida. Por favor, seleccione nuevamente.");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada no válida. Por favor, ingrese un número entero. \n");
                scanner.nextLine();
            }
        }
    }
}
