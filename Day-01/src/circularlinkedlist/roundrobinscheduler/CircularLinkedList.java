package circularlinkedlist.roundrobinscheduler;

class CircularLinkedList {
    Process head = null;

    // Add a process at the end of the circular linked list
    void addProcess(int id, int burstTime, int priority) {
        Process newProcess = new Process(id, burstTime, priority);
        if (head == null) {
            head = newProcess;
            newProcess.next = head;
        } else {
            Process temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = newProcess;
            newProcess.next = head;
        }
    }

    // Remove a process by Process ID
    void removeProcess(int id) {
        if (head == null) return;

        Process temp = head;
        Process prev = null;
        while (temp != head || prev == null) {
            if (temp.id == id) {
                if (prev != null) {
                    prev.next = temp.next;
                } else {
                    if (temp.next == head) {
                        head = null;
                    } else {
                        prev = head;
                        while (prev.next != head) prev = prev.next;
                        head = temp.next;
                        prev.next = head;
                    }
                }
                return;
            }
            prev = temp;
            temp = temp.next;
        }
    }

    // Simulate the round-robin scheduling with a fixed time quantum
    void roundRobinScheduling(int timeQuantum) {
        if (head == null) return;

        Process temp = head;
        int totalWaitingTime = 0;
        int totalTurnaroundTime = 0;
        int count = 0;

        // Store the original burst times to calculate turnaround time later
        Process check = head;
        while (check != null) {
            count++;
            check = check.next;
            if (check == head) break;
        }

        temp = head;
        while (count > 0) {
            if (temp.burstTime > timeQuantum) {
                temp.burstTime -= timeQuantum;
                totalWaitingTime += (timeQuantum * count);
            } else {
                totalTurnaroundTime += (timeQuantum * count);
                removeProcess(temp.id);
                count--;
                continue;
            }
            System.out.println("Process ID: " + temp.id + " Burst Time Left: " + temp.burstTime);
            temp = temp.next;
        }

        System.out.println("Average Waiting Time: " + (totalWaitingTime / count));
        System.out.println("Average Turnaround Time: " + (totalTurnaroundTime / count));
    }

    // Display the process list
    void displayList() {
        if (head == null) return;

        Process temp = head;
        while (temp != head) {
            System.out.println("Process ID: " + temp.id + " Burst Time: " + temp.burstTime);
            temp = temp.next;
        }
    }
}
