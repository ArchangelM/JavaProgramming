package reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Utils {
    public static void main(String[] args) {
        //reflaction
        System.out.println("printClass");

    }

    public static void printClassInfo(Class curClass) {
        //curClass.getClass().getClasses();

        System.out.println("Class name - " + curClass.getName());
        System.out.println("Class simple name - " + curClass.getSimpleName());
        System.out.println("Class parent - " + curClass.getSuperclass());
    }

    public static void printClassMethods(Class  curClass) {
        Method[] methods = curClass.getMethods();

        for (Method meth:
             methods) {
            System.out.println("Class method - " + meth.getName());
        }

    }

    public static void printClassFields(Class  curClass) {
        //System.out.println("Class fields " + curClass.getFields());

        Field[] fields = curClass.getFields();

        for (Field field:
                fields) {
            System.out.println("Class field - " + field.getName());
        }
    }
}
