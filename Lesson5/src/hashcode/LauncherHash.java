package hashcode;

/**
 * Created by Osipov on 04.04.2016.
 */
public class LauncherHash {
    public static void main(String[] args) {
        Person pers1 = new Person("Misha", 30, 2000);
        Person pers2 = new Person("Misha", 36, 2000);
        Person pers3 = new Person("Misha", 30, 2000);

        System.out.println("1. " + pers1.getName() + " hash: " + pers1.hashCode());
        System.out.println("2. " + pers2.getName() + " hash: " + pers2.hashCode());
        System.out.println("3. " + pers3.getName() + " hash: " + pers3.hashCode());
        System.out.println("1&3 Obj 1 is equal Obj 3 " + (pers1.equals(pers3)));
        System.err.println("1&3 hash 1: " + pers1.hashCode() + " 2: " + pers3.hashCode() + " and hash equal is " +
                (pers1.hashCode() == pers3.hashCode()));

        pers1 = new Person("Misha", 30, 2000, new Address("Kiev", "Dmitr", 13));
        pers2 = new Person("Misha", 36, 2000, new Address("Kiev", "Dmitr", 13));
        pers3 = new Person("Misha", 30, 2000, new Address("Kiev", "Dmitr", 13));

        System.err.println("1&3 Obj 1 is equal Obj 3 " + (pers1.equals(pers3)));
        System.err.println("1&3 hash 1: " + pers1.hashCode() + " 2: " + pers3.hashCode() + " and hash equal is " +
                (pers1.hashCode() == pers3.hashCode()));
    }

}
