package singlylinkedlist.studentrecordmanagement;

class Student {
    int rollNo;
    int age;
    int grade;
    String name;
    Student next;

    Student(int rollNo, int age, int grade, String name) {
        this.age = age;
        this.grade = grade;
        this.name = name;
        this.rollNo = rollNo;
        this.next = null;
    }
}
