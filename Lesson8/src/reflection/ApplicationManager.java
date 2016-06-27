package reflection;

import java.awt.*;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ApplicationManager {

    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {


        List<Object> list = new ArrayList<>();
        list.add(45);
        //list.add(new double[] {34d, 67d, 34,98});
        list.add(67.82d);
        list.add(new Color(23, 45, 169));

        System.out.println("No Service annotation in class");
        Test test = initClass(Test.class, Service.class, list);

        System.out.println("Object = " + test);

        System.out.println();


        System.out.println("Class with Service annotation");
        PrivateTest prTest = initClass(PrivateTest.class, Service.class, list);;

        System.out.println("Object = " + prTest);

    }

    public static <T> T initClass(Class<T> curClass, Class annClass, List<Object> list) throws IllegalAccessException,
            InstantiationException, ExceptionInInitializerError, SecurityException, InvocationTargetException,
            NoSuchMethodException {

       // if(curClass.getAnnotationsByType(annClass));


        if (curClass.isAnnotationPresent(annClass)) {
            Class[] paramTypes = new Class[list.size()];
            int i = 0;

            for (Object object: list
                    ) {
                paramTypes[i] = list.get(i++).getClass();
            }

            Constructor constr = curClass.getConstructor(paramTypes);

            Object[] params = list.toArray();
            T obj = curClass.getConstructor(paramTypes).newInstance(params);

            Method[] methods = curClass.getDeclaredMethods();

            for (Method meth:methods
                 ) {
                if(meth.isAnnotationPresent(InitService.class)) {
                    //Аннотацию для проверки тоже можно передать и список параметров для вызоваметода
                    meth.invoke(obj, null);
                }
            }



            return obj;
        }

        return null;

    }

    public <T> T getService(Class<T> curClass) throws IllegalAccessException, InstantiationException {

        if (curClass.isAnnotationPresent(Service.class)) {
            T obj = curClass.newInstance();
            return obj;
        }

        return null;
    }

}
