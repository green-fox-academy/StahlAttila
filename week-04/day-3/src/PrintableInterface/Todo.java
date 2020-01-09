package PrintableInterface;

public class Todo implements Printable {
    protected String task;
    protected String priority;
    protected Boolean completed;

    @Override
    public void PrintAllField() {
        System.out.println("Task: " + this.task + " | Priority: " + this.priority + " | Done: " + this.completed);
    }
}
