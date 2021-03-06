package duke.task;

public class Deadline extends Task {
    private String byTime;

    /**
     * Constructs a deadline object.
     *
     * @param deadlineTask Name of deadline.
     * @param byTime Time by which deadline should be completed.
     */
    public Deadline(String deadlineTask, String byTime) {
        super(deadlineTask);
        this.byTime = byTime;
    }

    /**
     * Returns the deadline in array form.
     *
     * @return String array.
     */
    @Override
    public String[] taskToArray() {
        String done;
        if (this.isCompleted()) {
            done = "0";
        } else {
            done = "1";
        }
        String[] str;
        if (!this.isTagged()) {
            str = new String[]{"D", done, this.getTaskName(), byTime};
        } else {
            str = new String[]{"D", done, this.getTaskName(), byTime, this.getTagName()};
        }
        return str;
    }

    @Override
    public String toString() {
        if (!this.isTagged()) {
            return "[D]" + super.toString() + " (by: " + byTime + ")";
        } else {
            return "[D]" + super.toString() + " (by: " + byTime + ") " + this.getTagName();
        }
    }
}
