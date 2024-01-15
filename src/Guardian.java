public class Guardian extends People {

    Student child;

    public Guardian(MainSystem main, String fName, String lName, long phoneNumber, Student child){
        super(main, fName, lName, phoneNumber);
        this.child = child;
    }

    public Student getChild() {
        return child;
    }

    public void shangeeMain(String eMail){
        this.eMail = eMail;
    }

    public void shangefName(String fName) {
        this.fName = fName;

    }

    public void changelName(String lName) {
        this.lName = lName;
    }
}
