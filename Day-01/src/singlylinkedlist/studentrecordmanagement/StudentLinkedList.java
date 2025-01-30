package singlylinkedlist.studentrecordmanagement;

class StudentLinkedList {

    Student head;

    StudentLinkedList(int rollNo, int age, int grade, String name) {
        head = new Student(rollNo, age, grade, name);
    }

    void addAtBeginning(int rollNo, int age, int grade, String name) {
        Student newStudent = new Student(rollNo, age, grade, name);

        newStudent.next = head;
        head = newStudent;
    }

    void addAtEnding(int rollNo, int age, int grade, String name) {
        Student newStudent = new Student(rollNo, age, grade, name);

        Student temp = head;

        if (head == null) {
            head = temp;
            return;
        }

        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = newStudent;
    }

    void addAtPosition(int rollNo, int age, int grade, String name, int position) {
        Student newStudent = new Student(rollNo, age, grade, name);

        if (position == 1) {
            addAtBeginning(rollNo, age, grade, name);
            return;
        } else {
            Student temp = head;

            for (int i = 1; i < position - 1 && temp != null; i++) {
                temp = temp.next;
            }
            if (temp == null) {
                System.out.println("Position out of bounds.");
            } else {
                newStudent.next = temp.next;
                temp.next = newStudent;
            }
        }
    }

    void deleteByRollNo(int rollNo) {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        if (head.rollNo == rollNo) {
            head = head.next;
            return;
        }
        Student temp = head;
        while (temp.next != null && temp.next.rollNo != rollNo) {
            temp = temp.next;
        }
        if (temp.next == null) {
            System.out.println(" not found.");
        } else {
            temp.next = temp.next.next;
            System.out.println(rollNo + " deleted.");
        }
    }

    void searchByRollNumber(int rollNo) {
        Student temp = head;
        while (temp != null) {
            if (temp.rollNo == rollNo) {
                System.out.println("Student Found => Roll Number: " + temp.rollNo + ", Name: " + temp.name + ", Age: " + temp.age + ", Grade: " + temp.grade);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Student with Roll Number " + rollNo + " not found.");
    }

    void updateGrade(int rollNo, int newGrade) {
        Student temp = head;
        while (temp != null) {
            if (temp.rollNo == rollNo) {
                temp.grade = newGrade;
                System.out.println("Grade updated.");
                return;
            }
            temp = temp.next;
        }
        System.out.println(rollNo + " not found.");
    }

    void displayRecords() {
        if (head == null) {
            System.out.println("No student records found.");
            return;
        }
        Student current = head;
        while (current != null) {
            System.out.println("Roll Number " + current.rollNo + ", Name " + current.name + ", Age " + current.age + ", Grade " + current.grade);
            current = current.next;
        }
    }
}
