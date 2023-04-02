import java.util.Scanner;
import java.time.LocalDate;

public class Input {

    private static Scanner scanner;

    public static void set() {
        scanner = new Scanner(System.in);
    }

    public static String getString() {
        return scanner.next();
    }

    public static int getInt() {
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input! Enter an integer!");
        }

        return scanner.nextInt();
    }

    public static String getTitle() {
        System.out.println("Enter the title of the task");
        return getString();
    }

    public static String getDescription() {
        System.out.println("Enter the description of the task");
        return getString();
    }

    public static int getPriority() {
        System.out.println("Enter the priority of the task, the larger the priority is, the less important the task");
        return getInt();
    }

    public static LocalDate getDate() {
        LocalDate date = LocalDate.now();
        System.out.print("Enter the due date for the task, first enter the day: ");
        date = date.withDayOfMonth(getInt());
        System.out.print("Enter now the month: ");
        date = date.withMonth(getInt());
        System.out.print("Enter lastly the year: ");
        return date.withYear(getInt());
    }
}
