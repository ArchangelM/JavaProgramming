package reflection;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.junit.Test;

import java.awt.*;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static reflection.Utils.setPrivates;


@RunWith(JUnit4.class)
public class ReflectionTest {
   //ApplicationManager appManager;
    List<Object> list;
    Map<String, Object> map;

    @Before
    public void init() {
        //appManager = new ApplicationManager();
        list = new ArrayList<>();
        list.add(45);
        //list.add(new double[] {34d, 67d, 34,98});
        list.add(67.82d);
        list.add(new Color(23, 45, 169));

        map = new HashMap<>();


    }

    @Test
    public void testInitClass() throws InvocationTargetException, NoSuchMethodException, InstantiationException,
            IllegalAccessException {
        PrivateTest privateTest = ApplicationManager.initClass(PrivateTest.class, Service.class, list);
        Assert.assertNotNull("It`s null??? ", privateTest);
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
        PrivateTest privateTest = ApplicationManager.initClass(PrivateTest.class, InitService.class, list);

        Assert.assertNull("WrongAnnotation ", privateTest);
    }

    @Test
    public void testInitClassWrongParametrs() throws InvocationTargetException, NoSuchMethodException, InstantiationException,
            IllegalAccessException {

        list.add(89l);
        PrivateTest privateTest = ApplicationManager.initClass(PrivateTest.class, Service.class, list);

        Assert.assertNull("WrongParametrs ", privateTest);
    }

    @Test
    public void testSetPrivatesWrongParametrs() throws InvocationTargetException, NoSuchMethodException, InstantiationException,
            IllegalAccessException {

        map.put("tInt", (Integer)12);
        map.put("testDouble", 45.98);
        map.put("color", new Color(23, 45, 169));
        PrivateTest privateTest = setPrivates(PrivateTest.class, map);

        Assert.assertEquals(45.98, privateTest.getTestDouble(), 0d);
        Assert.assertEquals(12, privateTest.gettInt(), 0d);
        Assert.assertEquals(new Color(23, 45, 169), privateTest.getColor());
    }

}
