import java.util.ArrayList;

public class Course {

    String name;
    ArrayList<Lectures> lessons;

    public Course(String name){
        this.name = name;
    }

    public void addLesson(Lectures lesson){
        this.lessons.add(lesson);
    }

    public ArrayList<Lectures> getLessonPlan() {
        return lessons;
    }
}
