public class People {

    protected String fName;
    protected String lName;

    protected String eMail;
    protected int phoneNumber;

    protected People (String fName, String lName, String eMail, int phoneNumber){
        this.fName = fName;
        this.lName = lName;
        this.eMail = eMail;
        this.phoneNumber = phoneNumber;
    }

    public String getfName() {
        return fName;
    }

    public String getlName() {
        return lName;
    }

    public String geteMail() {
        return eMail;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void changeeMail(String eMail) {
        this.eMail = eMail;
    }

    public void changePhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void shangefName(String fName) {
        this.fName = fName;
    }

    public void changelName(String lName) {
        this.lName = lName;
    }
}
