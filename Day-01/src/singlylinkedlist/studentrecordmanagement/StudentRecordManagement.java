package singlylinkedlist.studentrecordmanagement;

public class StudentRecordManagement {
    public static void main(String[] args) {
        StudentLinkedList student = new StudentLinkedList(1,10,1,"Deepansh");
        student.addAtBeginning(2,12,1,"Anubhav");;
        student.addAtEnding(3,13,2,"Om");
        student.addAtPosition(4,14,2,"Furqan",3);
        student.addAtPosition(5,15,3,"ABC",1);
        student.displayRecords();

        student.updateGrade(1,5);
        student.displayRecords();

        student.deleteByRollNo(4);
        student.displayRecords();

        student.deleteByRollNo(3);
        student.displayRecords();

        student.deleteByRollNo(2);
        student.displayRecords();

        student.searchByRollNumber(1);
    }
}