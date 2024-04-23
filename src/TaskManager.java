import java.util.ArrayList;
import java.util.Scanner;

public class TaskManager {
    private final ArrayList<String> todoList = new ArrayList<>();
    private final Scanner scanner = new Scanner(System.in);

    private static final String MESSAGE_ADD_TASK = "Ingrese la nueva tarea: ";
    private static final String MESSAGE_TASK_ADDED = "Tarea agregada correctamente.\n";
    private static final String MESSAGE_PENDING_TASKS = "Tareas pendientes: ";
    private static final String MESSAGE_COMPLETED_TASK = "Tarea marcada como completada correctamente. \n";
    private static final String MESSAGE_INVALID_TASK_NUMBER = "Número de tarea no válido.\n";
    private static final String MESSAGE_DELETE_TASK = "\n Ingrese el número de la tarea a eliminar: ";
    private static final String MESSAGE_TASK_DELETED = "Tarea eliminada correctamente.\n";


    public void addTask() {
        System.out.print(MESSAGE_ADD_TASK);
        String task = scanner.nextLine();
        todoList.add(task);
        System.out.println(MESSAGE_TASK_ADDED);
    }

    public void markTaskAsCompleted() {
        System.out.println(MESSAGE_PENDING_TASKS);
        for (int i = 0; i < todoList.size(); i++) {
            System.out.println((i + 1) + ". " + todoList.get(i));
        }
        System.out.print("\n Ingrese el número de la tarea completada: ");
        int index = getNextIntInput();
        if (index >= 1 && index <= todoList.size()) {
            todoList.remove(index - 1);
            System.out.println(MESSAGE_COMPLETED_TASK);
        } else {
            System.out.println(MESSAGE_INVALID_TASK_NUMBER);
        }
    }

    public void viewPendingTasks() {
        System.out.println(MESSAGE_PENDING_TASKS);
        for (int i = 0; i < todoList.size(); i++) {
            System.out.println((i + 1) + ". " + todoList.get(i));
        }
    }

    public void deleteTask() {
        System.out.println(MESSAGE_PENDING_TASKS);
        for (int i = 0; i < todoList.size(); i++) {
            System.out.println((i + 1) + ". " + todoList.get(i));
        }
        System.out.print(MESSAGE_DELETE_TASK);
        int index = getNextIntInput();
        if (index >= 1 && index <= todoList.size()) {
            todoList.remove(index - 1);
            System.out.println(MESSAGE_TASK_DELETED);
        } else {
            System.out.println(MESSAGE_INVALID_TASK_NUMBER);
        }
    }

    private int getNextIntInput() {
        while (!scanner.hasNextInt()) {
            System.out.println("Entrada no válida. Por favor, ingrese un número válido.");
            scanner.nextLine(); // Consume invalid input
        }
        return scanner.nextInt();
    }
}
