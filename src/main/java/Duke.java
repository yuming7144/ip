
import java.util.Scanner;

public class Duke {
    private static final String horizontalLine = "    ____________________________________________________________";
    private static final String indentation = "     ";

    public static void greet() {
        System.out.println(horizontalLine);
        System.out.println(indentation + "Hello! I'm Duke");
        System.out.println(indentation + "What can I do for you?");
        System.out.println(horizontalLine);
    }

    public static void exit() {
        String bye = "Bye. Hope to see you again soon!";
        System.out.println(horizontalLine);
        System.out.println(indentation + bye);
        System.out.println(horizontalLine);
    }


    public static void main(String[] args) {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
        Scanner scanner = new Scanner(System.in);
        TaskManager taskManager = new TaskManager();
        greet();
        String command = scanner.nextLine();
        while(command != null) {
            if (command.equals("bye")) {
                exit();
                scanner.close();
                break;
            } else {
                if (command.equals("list")) {
                    System.out.println(horizontalLine);
                    taskManager.printList();
                    System.out.println(horizontalLine);
                } else {
                    System.out.println(horizontalLine);
                    String[] strArr = command.split(" ", 2);
                    String taskType = strArr[0];
                    if (taskType.equals("done")){
                        int index = command.length() - 1;
                        int taskNumber = Integer.parseInt(command.substring(index));
                        taskManager.markTaskAsDone(taskNumber);
                    } else if (taskType.equals("todo")) {
                        Todo todo = new Todo(strArr[1]);
                        taskManager.addTask(todo);
                    } else if (taskType.equals("deadline")) {
                        String[] deadlineArr = strArr[1].split(" /by ", 2);
                        Deadline deadline = new Deadline(deadlineArr[0], deadlineArr[1]);
                        taskManager.addTask(deadline);
                    } else if (taskType.equals("event")) {
                        String[] eventArr = strArr[1].split(" /at ", 2);
                        Event event = new Event(eventArr[0], eventArr[1]);
                        taskManager.addTask(event);
                    }
                    System.out.println(horizontalLine);
                }
            }
            command = scanner.nextLine();
        }

    }
}
