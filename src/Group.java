import java.util.ArrayList;

public class Group {

    String name;
    Course lessonPlan;
    ArrayList<Student> students;

    public Group(String name, Course lessonPlan) {
        this.name = name;
        this.lessonPlan = lessonPlan;
    }

    public void addStudents(Student students) {
        this.students.add(students);
    }
}
