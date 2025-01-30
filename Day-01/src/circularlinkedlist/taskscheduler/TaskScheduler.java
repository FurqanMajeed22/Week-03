package circularlinkedlist.taskscheduler;

public class TaskScheduler {
    public static void main(String[] args) {
        TaskLinkedList cll = new TaskLinkedList("A1","Take Input",2,"25");
        cll.displayTasks();

        cll.atTheBeginning("A2","Display",3,"26");
        cll.displayTasks();

        cll.atTheEnding("A3","Add",4,"27");
        cll.displayTasks();

        cll.atSpecificPosition("A4","Subtract",5,"28",2);
        cll.displayTasks();

        cll.removeByTaskId("A2");
        cll.displayTasks();

    }
}
