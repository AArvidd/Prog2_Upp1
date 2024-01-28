import java.util.ArrayList;
import java.util.Scanner;

public class MainSystem {

    private ArrayList<Student> students = new ArrayList<>();
    private ArrayList<Staff>  staff = new ArrayList<>();
    private ArrayList<School> schools = new ArrayList<>();
    private ArrayList<Course> courses = new ArrayList<>();
    private ArrayList<Lectures> lessons = new ArrayList<>();

    String name;
    String domain;

    public MainSystem() {
        Scanner scan = new Scanner(System.in);
        boolean exit = false;
        
        String[] questions = {
                "close program",
                "add Student",
                "add Schools",
                "add Courses",
                "goto Schools"
        };
        
        while(true) {
            int choice;

            while (true) {
                System.out.println("\nWhat do you want to do?");
                for (int i = 0; i < questions.length; i++) {
                    System.out.println((i+1) + ": " + questions[i]);
                }
                System.out.print("Choice: ");

                try {
                    choice = scan.nextInt();
                }catch (Exception e){
                    choice = -1;
                    System.out.println("Illegal answer");
                    continue;
                }

                choice--;

                if(choice < questions.length && choice >= 0){
                    break;
                }

                System.out.println("Illegal answer");
            }
            System.out.println();


            switch(choice){
                case 0 -> exit = true;
                case 1 -> createStudent();
                case 2 -> createSchool();
                case 3 -> createCourse();
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
        String sName = scan.next();
        scan.nextLine();

        System.out.print("Principal's first name: ");
        String fName = scan.next();
        scan.nextLine();

        System.out.print("Principal's last name: ");
        String eName = scan.next();
        scan.nextLine();


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
        temp.setSchool(this.schools.get(this.schools.size()-1));

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
            for (int i = 0; i < this.schools.size(); i++){
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

            if (choice <= 0 || choice > this.schools.size()){
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

        int classChoice;

        while (true) {
            System.out.println("Choose a class");
            for (int i = 0; i < selectedSchool.getClasses().size(); i++){
                System.out.println((i+1) + ": " + selectedSchool.getClasses().get(i).getName());
            }
            System.out.print("Choice: ");

            try {
                classChoice = scan.nextInt();
            }catch (Exception e){
                System.out.println("Invalid option");
                scan.nextLine();
                classChoice = -1;
                continue;
            }

            classChoice--;

            if (classChoice <= 0 || classChoice > selectedSchool.getClasses().size()){
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
            studentName[i] = scan.next();
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
            guardianName[i] = scan.next();
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
        this.students.add(new Student(this, studentName[0], studentName[1], phoneNumber, selectedSchool.getClasses().get(classChoice), temp));
        selectedSchool.addStudent(this.students.get(this.students.size()-1));


    }

    private void createCourse(){
        Scanner scan = new Scanner(System.in);

        System.out.println("Course's name");
        String name = scan.next();

        this.courses.add(new Course(this, name));
        this.courses.get(this.courses.size()-1).populateCourse();
    }

    public Teacher createTeacher(){
        Scanner scan = new Scanner(System.in);

        System.out.print("What is the teacher's first name: ");
        String fName = scan.next();

        System.out.print("what is the teacher's last name: ");
        String eName = scan.next();


        long phoneNumber;

        while (true) {
            System.out.print("What is the teacher's phone number: ");

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

        int salary;

        while(true){
            System.out.print("What is the teacher's salary: ");

            try {
                salary = scan.nextInt();
            }catch (Exception e){
                System.out.println("Invalid salary");
                scan.nextLine();
                salary = -1;
                continue;
            }

            if(salary < 0){
                System.out.println("Invalid salary");
                salary = -1;
                continue;
            }

            break;
        }

        Teacher teacher = new Teacher(this, fName, eName, phoneNumber, salary);

        this.staff.add(teacher);
        return teacher;
    }

    public void createLectures(){
        Scanner scan = new Scanner(System.in);

        System.out.print("What is the lesson's name: ");
        String name = scan.next();


        int points;

        while(true){
            System.out.print("How many points is the lecture worth: ");

            try {
                points = scan.nextInt();
            }catch (Exception e){
                System.out.println("Invalid points");
                scan.nextLine();
                points = -1;
                continue;
            }

            if(points < 0){
                System.out.println("Invalid points");
                points = -1;
                continue;
            }

            break;
        }

        this.lessons.add(new Lectures(null, name, points));

    }

    public Lectures copyLecture(int index, Teacher teacher){
        Lectures template = this.lessons.get(index);

        return new Lectures(teacher, template.getName(), template.getPoints());
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

    public ArrayList<Lectures> getLessons() {
        return lessons;
    }
}
