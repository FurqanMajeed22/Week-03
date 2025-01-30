package circularlinkedlist.taskscheduler;

class TaskLinkedList {
    Task head;
    Task tail;

    TaskLinkedList(String taskID, String taskName, int priority, String dueDate) {
        head = new Task(taskID, taskName, priority, dueDate);
        head.next = head;
        tail = head;
    }

    void atTheBeginning(String taskID, String taskName, int priority, String dueDate) {
        Task newtask = new Task(taskID, taskName, priority, dueDate);

        tail.next = newtask;
        newtask.next = head;
        head = newtask;
    }

    void atTheEnding(String taskID, String taskName, int priority, String dueDate) {
        Task newTask = new Task(taskID, taskName, priority, dueDate);

        newTask.next = head;
        tail.next = newTask;
        tail = newTask;
    }

    void atSpecificPosition(String taskID, String taskName, int priority, String dueDate, int position) {
        Task newTask = new Task(taskID, taskName, priority, dueDate);

        Task temp = head;

        while (position - 2 > 1 && temp != null) {
            temp = temp.next;
        }
        if (temp == null) {
            System.out.println("Position Out of Bound");
        } else {
            newTask.next = temp.next;
            temp.next = newTask;

            if (temp == tail) {
                tail = newTask;
            }
        }
    }

    void removeByTaskId(String taskId) {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        if (head.taskID == taskId) {
            head = head.next;
            tail.next = head;
            return;
        }
        Task temp = head;
        while (temp.next != null && temp.next.taskID != taskId) {
            temp = temp.next;
        }

        if (temp.next == tail) {
            tail = temp;
        }
        temp.next = temp.next.next;
    }

    void displayTasks() {
        displayDetails(head);
        Task temp = head.next;
        while (temp != head) {
            displayDetails(temp);
            temp = temp.next;
        }
        System.out.println("");
    }

    void displayDetails(Task task) {
        System.out.println("Task Id " + task.taskID);
        System.out.println("Name " + task.taskName);
        System.out.println("Due Date " + task.dueDate);
        System.out.println("priority " + task.priority);
    }
}
