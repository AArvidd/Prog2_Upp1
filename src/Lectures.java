//inehåller informationen till en lektion

public class Lectures {

    private Teacher teacher;
    private String name;
    int points;

    public Lectures(Teacher teacher, String name, int points){
        this.teacher = teacher;
        this.name = name;
        this.points = points;
    }

    public String getName() {
        return name;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public int getPoints() {
        return points;
    }

    public void changeTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
}
