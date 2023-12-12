public class Student extends People{

    private Group group;
    private Guardian parent;

    public Student(String fName, String lName, String eMail, int phoneNumber, Group group, Guardian parent){
        super(fName, lName, eMail, phoneNumber);
        this.group = group;
        this.parent = parent;
    }

}
