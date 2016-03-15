package theory;

/**
 * Created by Rodichka on 15.03.2016.
 */
public class ExeptTheory {

    public static void main(String[] args) throws Exception,InterruptedException {
        doMethod1();
        doMethod2();
    }

    public static void doMethod1() throws InterruptedException {
        System.out.println("I`m doing something");
        Thread.sleep(1000);
    }

    public static void doMethod2() {
        try {
            System.out.println("I`m doing something");
            Thread.sleep(-1000);
        }
        catch (InterruptedException | IllegalArgumentException e) {
            System.out.println("I`m catch InterruptedExeption");
        }
        catch (Exception e) {
            System.out.println("I`m catch Exeption ");
        }
        finally {
            System.out.println("It would be execute always");
        }
    }
}
