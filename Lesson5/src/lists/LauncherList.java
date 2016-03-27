package lists;

/**
 * Created by Osipov on 27.03.2016.
 */
public class LauncherList {
    public static void main(String[] args) throws Exception {
        Classroom classroom = new Classroom();

        classroom.enter(new Student("Misha", "Osipov"));
        classroom.enter(new Student("Mis", "Alexeev"));
        classroom.enter(new Student("Sergey", "Nebuko"));
        classroom.enter(new Student("Alex", "Kirk"));
        classroom.enter(new Student("Tom", "Kruz"));
        classroom.enter(new Student("Bruce", "Willis"));

        classroom.leave(new Student("Alex", "Kirk"));

        classroom.printStudentInfo();

        System.out.println("Is Tom Kruz present? " + classroom.isPresent("Tom", "Kruz"));
        System.out.println(classroom.getStudentCount() + " studens in classroom.");
    }
}
