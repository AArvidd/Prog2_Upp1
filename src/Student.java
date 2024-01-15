public class Student extends People {

    private Group group;
    private Guardian parent;

    public Student(MainSystem main, String fName, String lName, long phoneNumber, Group group, Guardian parent){
        super(main, fName, lName, phoneNumber);
        this.group = group;
        this.parent = parent;
    }

    public void shangefName(String fName) {
        this.fName = fName;
        changeeMail("elev.ga");

    }

    public void changelName(String lName) {
        this.lName = lName;
        changeeMail("elev.ga");
    }

}
