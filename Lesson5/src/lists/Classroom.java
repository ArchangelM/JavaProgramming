package lists;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Osipov on 27.03.2016.
 */
public class Classroom {
    private List<Student> students;

    public Classroom() {
        students = new ArrayList<>();
    }

    public Classroom(List<Student> students) {
        this.students = students;
    }

    public void enter(Student student) {
        if(!students.contains(student)) {
            students.add(student);
        }
    }

    public void leave(Student student) {
        students.remove(student);
    }

    public int getStudentCount() {
        return students.size();
    }
/*
    public boolean isPresent(String name, String soname) {
        Student student = new Student(name, soname);

        int i = 0;

        while(i < students.size()) {
            if (students.get(i).compare(student)) return true;
            i++;
        }

        return false;
    }
   */
    public boolean isPresent(String name, String soname) {
        Student student = new Student(name, soname);
        return students.contains(student);
    }

    public void printStudentInfo() {
        System.out.println("Students list:");

        for(int i = 0; i < students.size();i++) {
            System.out.println(students.get(i));
        }

    }

    public List<Student> getStudents() {
        //return students;
        return new ArrayList<>(students);
    }
}
