//inehåller inforrmationen om en lärare

import java.util.ArrayList;

public class Teacher extends Staff {

    ArrayList<Lectures> lectures;

    public Teacher(MainSystem main, String fName, String lName, long phoneNumber, int salary){
        super(main, fName, lName, phoneNumber, salary, "Teacher");
    }

    public void addLecture(Lectures lectures){
        this.lectures.add(lectures);
    }

}
