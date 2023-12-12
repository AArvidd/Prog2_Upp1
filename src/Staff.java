public class Staff extends People{

    int salary;
    String position;

    public Staff(String fName, String lName, String eMail, int phoneNumber, int salary, String position){
        super(fName, lName, eMail, phoneNumber);

        setSalary(salary);

        this.position = position;
    }

    public void setSalary(int salary){
        if (salary < 20800) {
            salary = 20800;
            System.out.println("Pay to low, increased to 20800kr/month");
        }
        this.salary = salary;
    }

}