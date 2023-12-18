public class Guardian extends People{

    Student child;

    public Guardian(String fName, String lName, String eMail, int phoneNumber, Student child){
        super(fName, lName, eMail, phoneNumber);
        this.child = child;
    }

    public Student getChild() {
        return child;
    }
}
