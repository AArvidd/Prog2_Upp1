import java.util.ArrayList;
import java.util.Scanner;
import java.util.SortedMap;

public class MainSystem {

    private ArrayList<People> people;
    private ArrayList<Staff>  staff;
    private ArrayList<School> schools;
    private ArrayList<Course> courses;

    String name;
    String domain;

    public MainSystem() {
        Scanner scan = new Scanner(System.in);
        while(true) {
            int choice = -1;

            while (true) {
                System.out.println("What do you want to do?");
                System.out.print("""
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

                if(choice < 5 && choice > 0){
                    break;
                }

                System.out.println("Illegal answer");
            }


            switch(choice){
                case 1 -> createStudent();
                case 3 -> createSchool();
            }


        }
    }

    public void createSchool(){
        Scanner scan = new Scanner(System.in);

        System.out.println("Name of the school: ");
        String sName = scan.nextLine();

        System.out.println("Principals first name: ");
        String fName = scan.nextLine();

        System.out.println("Principals last name: ");
        String eName = scan.nextLine();

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
                phoneNumber = scan.nextInt();
            }catch (Exception e){
                System.out.println("Invalid phone number");
                scan.nextLine();
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



    }

    public void addPeople(People people) {
        this.people.add(people);
    }


    public void addStaff(Staff staff){
        this.staff.add(staff);
        addPeople(staff);
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
