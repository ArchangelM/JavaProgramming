package reflection;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.junit.Test;

import java.awt.*;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;


@RunWith(JUnit4.class)
public class ReflectionTest {
   //ApplicationManager appManager;
    List<Object> list;

    @Before
    public void init() {
        //appManager = new ApplicationManager();
        list = new ArrayList<>();
        list.add(45);
        //list.add(new double[] {34d, 67d, 34,98});
        list.add(67.82d);
        list.add(new Color(23, 45, 169));
    }

    @Test
    public void testInitClass() throws InvocationTargetException, NoSuchMethodException, InstantiationException,
            IllegalAccessException {
        PrivateTest privateTestest = ApplicationManager.initClass(PrivateTest.class, Service.class, list);
        Assert.assertNotNull("It`s null??? ", privateTestest);
    }

    @Test
    public void testInitClassWrongClass() throws InvocationTargetException, NoSuchMethodException, InstantiationException,
            IllegalAccessException {
        Test test = ApplicationManager.initClass(Test.class, Service.class, list);

        Assert.assertNull("WrongClass ", test);
    }

    @Test
    public void testInitClassWrongAnnotation() throws InvocationTargetException, NoSuchMethodException, InstantiationException,
            IllegalAccessException {
        PrivateTest privateTestest = ApplicationManager.initClass(PrivateTest.class, InitService.class, list);

        Assert.assertNull("WrongAnnotation ", privateTestest);
    }

    @Test
    public void testInitClassWrongParametrs() throws InvocationTargetException, NoSuchMethodException, InstantiationException,
            IllegalAccessException {

        list.add(89l);
        PrivateTest privateTestest = ApplicationManager.initClass(PrivateTest.class, Service.class, list);

        Assert.assertNull("WrongParametrs ", privateTestest);
    }
}
