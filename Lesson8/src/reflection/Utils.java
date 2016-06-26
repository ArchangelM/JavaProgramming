package reflection;

import main.Box;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;

public class Utils {
    public static void main(String[] args) throws Exception{
        //reflaction

        System.out.println("printClass");
        System.out.println("PrintClass");
        printClassInfo(Box.class);
        System.out.println();
        printClassMethods(Box.class);
        System.out.println();
        printClassFields(Box.class);

        Map<String, Object> map = new HashMap<>();
        map.put("node", (Integer)12);

        Box box = initClass(Box.class, map);

        System.out.println("Node " + box.getNode());

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
            System.out.println("Class public field - " + field.getName());
        }

        fields = curClass.getDeclaredFields();

        for (Field field:
                fields) {
            System.out.println("Class all field - " + field.getName());
        }

    }


    public static <T> T initClass(Class<T> curClass, Map<String, Object> map) throws IllegalAccessException,
            InstantiationException, ExceptionInInitializerError, SecurityException, InvocationTargetException{

        T obj = curClass.newInstance();
        Method[] methods = obj.getClass().getMethods();

        for(Method method: methods
                ){
            for(String str: map.keySet()
                    ){
                if(method.getName().equalsIgnoreCase("set" +str)){
                    method.invoke(obj, map.get(str));
                }
            }
        }

        return obj;
    }


}