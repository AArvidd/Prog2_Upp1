import java.util.ArrayList;
//innehåller en klass av elever

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

    public String getName() {
        return name;
    }
}
