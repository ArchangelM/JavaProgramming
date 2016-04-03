package hashcode;

/**
 * Created by Osipov on 04.04.2016.
 */
public class Person {
    private String name;
    private int age;
    private long salary;

    @Override
    public int hashCode() {
        final int basis = 37;
        int result = 71;

        if(name == null) {
            result = basis*result;
        } else {
            result = basis*result+name.hashCode();
        }

        Integer iAge = new Integer(age);
        Long iSalary = new Long(salary);

        result = basis*result+iAge.hashCode();
        result = basis*result+iSalary.hashCode();

        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj != null ) {
            Person pers = (Person) obj;
            if(name.equals(pers.getName()) && age == pers.getAge() && salary == getSalary()) {
                return true;
            }
        }


        return false;
    }

    public Person() {
    }

    public Person(String name, int age, long salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public long getSalary() {
        return salary;
    }
}
