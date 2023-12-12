import java.util.ArrayList;

public class Teacher extends Staff{

    ArrayList<Lectures> lectures;

    public Teacher(String fName, String lName, String eMail, int phoneNumber, int salary, ArrayList<Lectures> lectures){
        super(fName, lName, eMail, phoneNumber, salary, "Teacher");
        this.lectures = lectures;
    }

}
