import java.time.DateTimeException;
import java.time.LocalDate;

public class Task {
    String title;
    String description;
    int priority;
    LocalDate dueDate;

    public Task(String title, String description, int priority, int day, int month, int year) {
        this.title = title;
        this.description = description;
        this.priority = priority;
        this.dueDate = LocalDate.of(year, month, day);
    }
}
