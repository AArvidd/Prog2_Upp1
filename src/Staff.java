public class Staff extends People {

    int salary;
    String position;

    public Staff(MainSystem main, String fName, String lName, long phoneNumber, int salary, String position){
        super(main, fName, lName, phoneNumber);

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
