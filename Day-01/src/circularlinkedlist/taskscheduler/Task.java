package circularlinkedlist.taskscheduler;

class Task {
    String taskID;
    String taskName;
    int priority;
    String dueDate;
    Task next = null;

    Task(String taskID, String taskName, int priority, String dueDate) {
        this.dueDate = dueDate;
        this.taskID = taskID;
        this.taskName = taskName;
        this.priority = priority;
        this.next = null;
    }
}
