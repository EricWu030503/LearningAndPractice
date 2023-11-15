class CS61BStudent {
    public int idNumber; // Instance variable
    public int grade;
    public static String instructor = "Hug"; // Class (Static) variable

    public CS61BStudent(int id){
        idNumber = id;
        grade = 100;
    }

    public void watchLecture(){ // Instance method
    }

    public static String getInstructor(){ // Static Method
        return instructor;
    }
}

public class CS61B {
    public static String university = "UC Berkeley";
    public String semester;
    public CS61BStudent[] students;

    public CS61B(int capacity, CS61BStudent[] signups, String semester){
        this.semester = semester;
        students = new CS61BStudent[capacity];
        for (int i = 0; i < capacity; i++){
            students[i] = signups[i];
        }
    }
    public void makeStudentWatchLecture() {
        for (CS61BStudent student : students){
            student.watchLecture();
        }
    }

    public static void changeUniversity(String newUniveristy){
        university = newUniveristy;
    }
}
