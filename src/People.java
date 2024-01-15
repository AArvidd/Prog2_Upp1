public class People {

    protected String fName;
    protected String lName;

    protected String eMail;
    protected long phoneNumber;

    protected MainSystem main;

    protected People (MainSystem main, String fName, String lName, long phoneNumber){
        this.main = main;
        this.fName = fName;
        this.lName = lName;
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

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void changeeMail(String additional) {
        String eMail = this.fName + "." + this.lName + "@";
        if(!additional.isEmpty())
            eMail = eMail + additional + ".";
        eMail = eMail + this.main.getDomain() + ".se";
    }

    public void changePhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void shangefName(String fName) {
        this.fName = fName;
        changeeMail("");

    }

    public void changelName(String lName) {
        this.lName = lName;
        changeeMail("");
    }
}
