package lists;

import java.io.Serializable;

/**
 * Created by Osipov on 27.03.2016.
 */
public class Student implements Serializable {
    private String name;
    private String soname;

    public Student() {
    }

    public Student(String name, String soname) {
        this.name = name;
        this.soname = soname;
    }

    @Override
    public String toString() {
        return name + " " + soname;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Student) {
            Student student = (Student) obj;

            if (name != null && name.equals(student.getName())) {
                if (soname != null && soname.equals(student.getSoname())) {
                    return true;
                }
            }
            return false;

        } else return super.equals(obj);

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
