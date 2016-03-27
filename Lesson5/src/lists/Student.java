package lists;

/**
 * Created by Osipov on 27.03.2016.
 */
public class Student {
    private String name;
    private String soname;

    public Student() {
    }

    public Student(String name, String soname) {
        this.name = name;
        this.soname = soname;
    }

    public boolean compare(Student student) {
       if (name.equals(student.getName())) {
           if (soname.equals(student.getSoname())) {
               return true;
           }
       }

        return false;
    }

    @Override
    public String toString() {
        return name + " " + soname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSoname() {
        return soname;
    }

    public void setSoname(String soname) {
        this.soname = soname;
    }

}
