//ninehåller informationen till en räcktor

public class Principal extends Admin {

    School school;

    public Principal (MainSystem main, String fName, String lName, long phoneNumber, int salary, School school){
        super(main, fName, lName, phoneNumber, salary, "Principal");

        this.school = school;

    }

    public void setSalary(int salary){
        //sätter lönen och ser till så att räktorn inte blir underbetald
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
