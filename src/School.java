import java.util.ArrayList;
import java.util.Scanner;
//innehåller information om skolan samt funktioner för att göra ändringar i skolan

public class School {

    private MainSystem main;
    private String name;
    private ArrayList<Course> courses = new ArrayList<>();
    private ArrayList<Group> classes = new ArrayList<>();
    private Principal principal;
    private ArrayList<Staff> staff = new ArrayList<>();
    private ArrayList<Student> students = new ArrayList<>();

    public School(MainSystem main, String name, Principal principal) {
        this.main = main;
        this.name = name;
        this.principal = principal;
    }


    public void control(){
        Scanner scan = new Scanner(System.in);

        String[] questions = {
                "add course",
                "create class",
                "add student"
        };

        while(true){
            int choice;

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

        }

    }


    public String getName() {
        return name;
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public ArrayList<Group> getClasses() {
        return classes;
    }

    public ArrayList<Staff> getStaff() {
        return staff;
    }

    public Principal getPrincipal() {
        return principal;
    }


    public void changePrincipal(Principal principal) {
        this.principal = principal;
    }

    public void addCourse(Course course) {
        this.courses.add(course);
    }

    public void addClass(Group group){
        this.classes.add(group);
    }

    public void addStaff(Staff staff){
        this.staff.add(staff);
    }

    public void addStudent(Student student){
        this.students.add(student);
    }

}
