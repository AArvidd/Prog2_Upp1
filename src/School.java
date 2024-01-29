import java.util.ArrayList;
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


    public void controll(){

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
