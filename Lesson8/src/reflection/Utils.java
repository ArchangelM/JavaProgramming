package reflection;

import main.Box;

import java.awt.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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

        List<Object> list = new ArrayList<>();
        list.add(45);
        //list.add(new double[] {34d, 67d, 34,98});
        list.add(67.82d);
        list.add(new Color(23, 45, 169));


        Test test = initClass(Test.class, list);

        System.out.println(test.gettInt());
        System.out.println(test.getColor());
        System.out.println(test.getTestArray());
        System.out.println(test.getTestDouble());


        System.out.println();

        map = new HashMap<>();
        map.put("tInt", (Integer)12);
        map.put("testDouble", 45.98);
        map.put("color", new Color(23, 45, 169));


        PrivateTest prTest = setPrivates(PrivateTest.class, map);

        System.out.println(prTest.gettInt());
        System.out.println(prTest.getColor());
        System.out.println(prTest.getTestDouble());


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
        Method[] methods = curClass.getMethods();


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

    public static <T> T initClass(Class<T> curClass, List<Object> list) throws IllegalAccessException,
            InstantiationException, ExceptionInInitializerError, SecurityException, InvocationTargetException,
            NoSuchMethodException {

        Class[] paramTypes = new Class[list.size()];
        int i = 0;

        for (Object object: list
             ) {
            paramTypes[i] = list.get(i++).getClass();
        }

        Constructor constr = curClass.getConstructor(paramTypes);
        //constr.newInstance();
        Object[] params = list.toArray();
        T obj = curClass.getConstructor(paramTypes).newInstance(params);
/*        T obj = null;

        //Constructor[] constructors = obj.getClass().getConstructors();
        Constructor[] constructors = curClass.getConstructors();

        int parametrsNum = list.size();
        boolean equal = false;

        for(Constructor constructor: constructors
                ){
            if(parametrsNum == constructor.getParameterCount()) {
                Class[] paramTypes1 = constructor.getParameterTypes();
                equal = true;
                for (Class paramType : paramTypes1) {
                    for (Object object: list) {
                        equal = false;
                        if (!paramType.equals(object.getClass())) {
                            equal = true;
                            break;
                        }
                    }
                }
            }
            if (equal) {
                obj = curClass.getConstructor(paramTypes).newInstance();
                break;
            }

        }
*/
        return obj;
    }

    public static <T> T setPrivates(Class<T> curClass, Map<String, Object> map) throws IllegalAccessException,
            InstantiationException {
           T obj = curClass.newInstance();
           Field[] fields = curClass.getDeclaredFields();



        for (Field field:
                fields) {
            field.setAccessible(true);
            field.set (obj, map.get(field.getName()));

            };

        return obj;
    }



}
