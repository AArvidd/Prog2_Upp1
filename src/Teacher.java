import java.util.ArrayList;

public class Teacher extends Staff {

    ArrayList<Lectures> lectures;

    public Teacher(MainSystem main, String fName, String lName, long phoneNumber, int salary, ArrayList<Lectures> lectures){
        super(main, fName, lName, phoneNumber, salary, "Teacher");
        this.lectures = lectures;
    }

}
