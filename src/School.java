import java.util.ArrayList;

public class School {

    String name;
    private ArrayList<Course> courses;
    private ArrayList<Group> classes;
    private Principal principal;
    private ArrayList<Staff> staff;

    public School(String name, Principal principal) {
        this.name = name;
        this.principal = principal;
    }

    public School(String name){
        this.name = name;
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

}
