package Tasks;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Objects;

public class ArgumentsHandler {

    public static void argumentsHandler(String[] args) throws IOException {

        try {
            switch (args[0]) {
            /*//Empty argument
            case "":
                System.out.println("Command Line Todo application\n" +
                        "=============================\n" +
                        "\n" +
                        "Command line arguments:\n" +
                        "    -l   Lists all the tasks\n" +
                        "    -a   Adds a new task\n" +
                        "    -r   Removes an task\n" +
                        "    -c   Completes an task");
                System.out.println();
                break;*/
                //List argument
                case "-l":
                    int counter = 1;
                    if (Objects.requireNonNull(ReadFile.readFile()).isEmpty()) {
                        System.out.println("No todos for today! :)");
                        System.out.println();
                    } else {
                        for (String line : Objects.requireNonNull(ReadFile.readFile())) {
                            System.out.println(counter + ". " + line);
                            counter++;
                        }
                        System.out.println();
                    }
                    break;
                //Add argument
                case "-a": {
                    if (!args[1].isEmpty()) {
                        WriteFile.writeFile(args[1]);
                    } else {
                        System.out.println("Unable to add: no task provided");
                    }
                    break;
                }
                //Remove argument
                case "-r": {
                    try {
                        if (Integer.parseInt(args[1]) < Objects.requireNonNull(ReadFile.readFile()).size())
                            RemoveTask.removeLine(Integer.parseInt(args[1]));
                    } catch (InputMismatchException e) {
                        System.out.println("Unable to remove: index is not a number");
                    }
                    break;
                }
                //Completed argument
                case "-c": {
                    CompleteTask.completeTask(args[1]);
                    break;
                }
                //Unsopported arguments
                default:
                    System.out.println("Unsupported argument");
                    System.out.println();
                    String[] help = new String[1];
                    help[0] = "-help";
                    ArgumentsHandler.argumentsHandler(help);
                    break;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Command Line Todo application\n" +
                    "=============================\n" +
                    "\n" +
                    "Command line arguments:\n" +
                    "    -l   Lists all the tasks\n" +
                    "    -a   Adds a new task\n" +
                    "    -r   Removes an task\n" +
                    "    -c   Completes an task");
            System.out.println();
        }
    }
}
