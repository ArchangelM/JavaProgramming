package hashmap;

import hashcode.Address;
import hashcode.Person;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by Osipov on 04.04.2016.
 */
public class LauncherHashMap {
    public static void main(String[] args) {
        hashcode.Person pers1 = new hashcode.Person("Misha", 30, 2000);
        hashcode.Person pers2 = new hashcode.Person("Misha", 36, 2000);
        hashcode.Person pers3 = new hashcode.Person("Misha", 30, 2000);

        System.out.println("1. " + pers1.getName() + " hash: " + pers1.hashCode());
        System.out.println("2. " + pers2.getName() + " hash: " + pers2.hashCode());
        System.out.println("3. " + pers3.getName() + " hash: " + pers3.hashCode());
        System.out.println("1&3 Obj 1 is equal Obj 3 " + (pers1.equals(pers3)));
        System.err.println("1&3 hash 1: " + pers1.hashCode() + " 2: " + pers3.hashCode() + " and hash equal is " +
                (pers1.hashCode() == pers3.hashCode()));

        pers1 = new hashcode.Person("Misha", 30, 2000, new Address("Kiev", "Dmitr", 13));
        pers2 = new hashcode.Person("Misha", 36, 2000, new Address("Kiev", "Dmitr", 13));
        pers3 = new Person("Misha", 30, 2000, new Address("Kiev", "Dmitr", 13));

        System.err.println("1&3 Obj 1 is equal Obj 3 " + (pers1.equals(pers3)));
        System.err.println("1&3 hash 1: " + pers1.hashCode() + " 2: " + pers3.hashCode() + " and hash equal is " +
                (pers1.hashCode() == pers3.hashCode()));


        //HashMap
        Map<String, Person> personMap = new HashMap<>();

        pers3.setName("York");

        personMap.put(pers1.getName(), pers1);
        personMap.put(pers2.getName(), pers2);
        personMap.put("mmm", pers1);
        personMap.putIfAbsent(pers1.getName(), pers1);
        personMap.put(pers3.getName(), pers3);

        System.out.println("Keys " + personMap.keySet());
        System.out.println("Hash map " + personMap.values());

        Set<String> keys = personMap.keySet();

        System.out.println("Hash map: ");

        for (String key :
                keys) {
            System.out.println(personMap.get(key));
        }
    }


}
