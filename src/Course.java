import java.util.ArrayList;
import java.util.Scanner;

public class Course {

    private MainSystem main;
    private String name;
    private ArrayList<Lectures> lessons = new ArrayList<>();
    private int points;
    private ArrayList<Teacher> teachers = new ArrayList<>();

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
                case 2 -> createLesson(); // todo
                case 3: {
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
                default: {
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

    //TODO complete this
    private void chooseLesson(){
        ArrayList<Lectures> potential = main.getLessons();

        System.out.println("chce a ");

    }

}
