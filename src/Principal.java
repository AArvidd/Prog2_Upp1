public class Principal extends Admin {

    School school;

    public Principal (MainSystem main, String fName, String lName, long phoneNumber, int salary, School school){
        super(main, fName, lName, phoneNumber, salary, "Principal");

        this.school = school;

    }

    public Principal (MainSystem main, String fName, String lName, long phoneNumber, int salary){
        super(main, fName, lName, phoneNumber, salary, "Principal");
    }

    public void setSalary(int salary){
        if(salary < 55000){
            salary = 55000;
            System.out.println("Pay to low four a Principal, increased to 55000kr/month");
        }

        this.salary = salary;
    }

    public void setSchool(School school) {
        this.school = school;
    }
}
