package container;

//import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class ContainerTest {
    ServiceRepository serviceRepository;
    ServiceDescription cur;

    @Before
    public void init() {
        serviceRepository = new ServiceRepository();
        cur = new ServiceDescription();
    }

    @Test
    public void testNotNullList() {
        assertNotNull("Should be initiated", serviceRepository);
    }

    @Test
    public void testAddOnIndex() {
        cur.setType("Mio1");
        serviceRepository.addElement(cur, 0);
        assertEquals("Should add element", "Mio1", serviceRepository.getElement(0).test());
    }

    @Test
    public void testAddLast() {
        cur.setType("Mio last");
        serviceRepository.addElement(cur);
        assertEquals("Should add element", "Mio last", serviceRepository.getElement().test());
    }
}
