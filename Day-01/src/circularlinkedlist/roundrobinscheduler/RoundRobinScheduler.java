package circularlinkedlist.roundrobinscheduler;

public class RoundRobinScheduler {
    public static void main(String[] args) {
        CircularLinkedList list = new CircularLinkedList();

        list.addProcess(1, 10, 1);
        list.addProcess(2, 5, 2);
        list.addProcess(3, 8, 3);

        list.displayList();

        list.roundRobinScheduling(4);
    }
}
