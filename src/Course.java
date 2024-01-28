import java.util.ArrayList;
import java.util.Scanner;

public class Course {

    private MainSystem main;
    private String name;
    private ArrayList<Lectures> lessons = new ArrayList<>();
    private int points;

    public Course(MainSystem main, String name){
        this.main = main;
        this.name = name;
    }

    public void addLesson(Lectures lesson){
        this.lessons.add(lesson);
    }

    public ArrayList<Lectures> getLessonPlan() {
        return lessons;
    }

    public void populateCourse(){
        Scanner scan = new Scanner(System.in);

        int choice;

        boolean running = true;

        while(running){
            choice = 0;
            System.out.printf("""
                    
                    Course is currently worth %d points
                    Where should the new lesson come from?
                    1: Choose an existing lesson
                    2: Create a new lesson
                    3: Finnish course construction
                    Choice: """, this.points);

            try{
                choice = scan.nextInt();
            }catch (Exception e){
                System.out.println("Illegal answer");
                continue;
            }

            switch (choice){
                case 1 -> chooseLesson();
                case 2 -> createLesson();
                case 3 -> {
                    System.out.println("Are you sure? (y/n): ");
                    char exit = scan.next().charAt(0);

                    if (exit == 'y'){
                        running = false;
                    }else if (exit == 'n'){
                        continue;
                    } else {
                        System.out.println("assumed n");
                        continue;
                    }

                }
                default -> {
                    System.out.println("Illegal answer");
                    continue;
                }
            }

            if (this.points < 2300){
                continue;
            }

            System.out.println("Course has enough points");
            running = false;

        }
    }

    private void chooseLesson(){
        Scanner scan = new Scanner(System.in);
        ArrayList<Lectures> potential = main.getLessons();

        int choice;

        while(true) {
            if (potential.isEmpty()) {
                System.out.println("\nNo existing lesson exist");
                return;
            }

            System.out.println("Chose a lesson for the course");
            for (int i = 0; i < potential.size(); i++) {
                Lectures current = potential.get(i);
                System.out.println((i + 1) + ": " + current.getName() + " worth " + current.getPoints() + "points");
            }

            try{
                choice = scan.nextInt();
            }catch (Exception e){
                System.out.println("Illegal answer");
                scan.nextLine();
                continue;
            }

            choice--;

            if(choice >= 0 && choice < potential.size()){
                break;
            }

            System.out.println("Illegal answer");
        }

        Teacher teacher = main.createTeacher();
        this.lessons.add(main.copyLecture(choice, teacher));
        countPoints();
    }

    private void createLesson(){
        main.createLectures();
        Teacher teacher = main.createTeacher();
        this.lessons.add(main.copyLecture(main.getLessons().size() - 1, teacher));
        countPoints();
    }

    private void countPoints(){
        for (Lectures lesson: this.lessons)
            this.points += lesson.getPoints();
    }

}
