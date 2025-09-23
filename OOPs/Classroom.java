package OOPs;

class Student {
    String name;
    int rollNo;

    Student(String name, int roll){
        this.name = name;
        this.rollNo = roll;
        System.out.println("New Student enrolled with roll no : "+this.rollNo);
    }

    // copy Contructor
    Student(Student s){
        this.name = s.name;
        this.rollNo = s.rollNo;
        System.out.println("Copy Constructor "+this.name+" "+this.rollNo);
    }

    // default Constructor
    Student(){
        System.out.println("Default Constructor");
    }

    public String toString(){
        return this.name+" "+this.rollNo;
    }

}

public class Classroom {
    public static void main(String[] args) {
        Student s1 = new Student("Suvajit",10);
        // Student s3 = new Student();
        // Student s2 = new Student(s1);

        s1.rollNo = 1;

        System.out.println(s1);

    }
}
