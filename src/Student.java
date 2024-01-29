//inehåller infotmation om en elev

public class Student extends People {

    private Group group;
    private Guardian parent;

    public Student(MainSystem main, String fName, String lName, long phoneNumber, Group group, Guardian parent){
        super(main, fName, lName, phoneNumber);
        this.group = group;
        this.parent = parent;
    }

    public void shangefName(String fName) {
        //ändrar elevens förnamn samt elevens email
        this.fName = fName;
        changeeMail("elev.ga");

    }

    public void changelName(String lName) {
        //ändrar elevens efternamn samt elevens email
        this.lName = lName;
        changeeMail("elev.ga");
    }

}
