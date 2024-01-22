import java.util.ArrayList;
import java.util.Scanner;

public class MainSystem {

    private ArrayList<Student> students = new ArrayList<>();
    private ArrayList<Staff>  staff = new ArrayList<>();
    private ArrayList<School> schools = new ArrayList<>();
    private ArrayList<Course> courses = new ArrayList<>();

    String name;
    String domain;

    public MainSystem() {
        Scanner scan = new Scanner(System.in);
        boolean exit = false;
        while(true) {
            int choice = -1;

            while (true) {
                System.out.println("What do you want to do?");
                System.out.print("""
                        0: close program
                        1: add Student
                        2: add Staff
                        3: add schools
                        4: add Courses
                        Choice: """);

                try {
                    choice = scan.nextInt();
                }catch (Exception e){
                    choice = -1;
                    System.out.println("Illegal answer");
                    continue;
                }

                if(choice < 5 && choice >= 0){
                    break;
                }

                System.out.println("Illegal answer");
            }


            switch(choice){
                case 0 -> exit = true;
                case 1 -> createStudent();
                case 3 -> createSchool();
            }

            if (exit){
                break;
            }

        }
        System.out.println("\nShutting down...");
    }

    public void createSchool(){
        Scanner scan = new Scanner(System.in);

        System.out.print("Name of the school: ");
        String sName = scan.nextLine();

        System.out.print("Principal's first name: ");
        String fName = scan.nextLine();

        System.out.print("Principal's last name: ");
        String eName = scan.nextLine();


        long phoneNumber;
        while (true) {
            System.out.print("What is the students phone number: ");

            try {
                phoneNumber = scan.nextLong();
            }catch (Exception e){
                System.out.println("Invalid phone number");
                scan.nextLine();
                phoneNumber = -1;
                continue;
            }

            if(phoneNumber < 0){
                System.out.println("Invalid phone number");
                phoneNumber = -1;
                continue;
            }

            break;
        }


        int pSalary = -1;
        while (true) {
            System.out.print("principal's salary: ");

            try{
                pSalary = scan.nextInt();
            }catch (Exception e){
                System.out.println("invalid salary");
                pSalary = -1;
                scan.nextLine();
                continue;
            }

            if(pSalary < 0){
                System.out.println("invalid salary");
                continue;
            }

            break;
        }

        Principal temp = new Principal(this, fName, eName, phoneNumber, pSalary);

        addStaff(temp);
        addSchool(new School(sName, temp));

    }

    private void createStudent(){
        Scanner scan = new Scanner(System.in);

        //schools
        if(this.schools.isEmpty()){
            System.out.println("No Schools exist");
            return;
        }


        int choice;

        while (true) {
            System.out.println("Choose a School");
            for (int i = 0; i < this.schools.toArray().length; i++){
                System.out.println((i+1) + ": " + this.schools.get(i).getName());
            }
            System.out.print("Choice: ");

            try {
                choice = scan.nextInt();
            }catch (Exception e){
                System.out.println("Invalid option");
                scan.nextLine();
                choice = -1;
                continue;
            }

            choice--;

            if (choice < 0 || choice >= this.schools.toArray().length){
                System.out.println("Invalid option");
                break;
            }

            break;
        }

        School selectedSchool = this.schools.get(choice);


        //classes
        if (selectedSchool.getClasses().isEmpty()){
            System.out.println("No classes exist");
            return;
        }

        int classChois;

        while (true) {
            System.out.println("Choose a class");
            for (int i = 0; i < selectedSchool.getClasses().toArray().length; i++){
                System.out.println((i+1) + ": " + selectedSchool.getClasses().get(i).getName());
            }
            System.out.print("Choice: ");

            try {
                classChois = scan.nextInt();
            }catch (Exception e){
                System.out.println("Invalid option");
                scan.nextLine();
                classChois = -1;
                continue;
            }

            classChois--;

            if (classChois < 0 || classChois >= selectedSchool.getClasses().toArray().length){
                System.out.println("Invalid option");
                break;
            }

            break;
        }


        //name
        String[] questions = {
                "first name",
                "last name",
        };

        String[] studentName = new String[2];

        for(int i = 0; i < questions.length; i++){
            System.out.println("What is the student's " + questions[i]);
            studentName[i] = scan.nextLine();
        }


        //phone number
        long phoneNumber;

        while (true) {
            System.out.print("What is the students phone number: ");

            try {
                phoneNumber = scan.nextLong();
            }catch (Exception e){
                System.out.println("Invalid phone number");
                scan.nextLine();
                phoneNumber = -1;
                continue;
            }

            if(phoneNumber < 0){
                System.out.println("Invalid phone number");
                phoneNumber = -1;
                continue;
            }

            break;
        }

        //parent
        String[] guardianName = new String[2];

        for (int i = 0; i < 2; i++) {
            System.out.println("What is the guardian's " + questions[i]);
            guardianName[i] = scan.nextLine();
        }

        long guardianPhoneNumber = -1;

        while (true) {
            System.out.print("what is the guardian's phone number: ");
            try {
                guardianPhoneNumber = scan.nextLong();
            } catch (Exception e) {
                System.out.println("Invalid phone number");
                scan.nextLine();
                continue;
            }

            if (guardianPhoneNumber < 0){
                System.out.println("Invalid phone number");
                guardianPhoneNumber = -1;
                continue;
            }

            break;
        }

        Guardian temp = new Guardian(this, guardianName[0], guardianName[1], guardianPhoneNumber);
        this.students.add(new Student(this, studentName[0], studentName[1], phoneNumber, selectedSchool.getClasses().get(classChois), temp));
        selectedSchool.addStudent(this.students.get(this.students.size()-1));


    }

    public void addStudent(Student student) {
        this.students.add(student);
    }


    public void addStaff(Staff staff){
        this.staff.add(staff);
    }

    public void addSchool(School school){
        this.schools.add(school);
    }

    public void addCourse(Course course){
        this.courses.add(course);
    }

    public String getDomain() {
        return domain;
    }
}
