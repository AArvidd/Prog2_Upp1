import java.util.ArrayList;
import java.util.Scanner;

public class MainSystem {

    private ArrayList<People> people;
    private ArrayList<Staff>  staff;
    private ArrayList<School> schools;
    private ArrayList<Course> courses;

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
                case 1 -> createPeople();
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

    private void createPeople(){
        Scanner scan = new Scanner(System.in);



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

}
