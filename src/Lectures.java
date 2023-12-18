public class Lectures {

    private Teacher teacher;
    private String name;

    public Lectures(Teacher teacher, String name){
        this.teacher = teacher;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void changeTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
}
