package theory;

/**
 * Created by Osipov on 15.03.2016.
 */
public class ExeptTheory {

    public static void main(String[] args) throws Exception,InterruptedException {
        System.out.println("1 ");
        doMethod1();
        System.out.println("2 ");
        doMethod2();
        System.out.println("3 ");
        doMethod3();
    }

    public static void doMethod1() throws InterruptedException {
        System.out.println("I`m going to sleep");
        Thread.sleep(1000);
    }

    public static void doMethod2() {
        try {
            System.out.println("I`m going to sleep");
            Thread.sleep(-1000);
        }
        catch (InterruptedException  e) {
            System.out.println("I`m catch InterruptedExeption or ");
        }
        catch (IllegalArgumentException e) {
            System.out.println("I`m catch IllegalArgumentException ");
        }
        finally {
            System.out.println("It would be execute always");
        }
    }

    public static void doMethod3() {
        try {
            System.out.println("I`m going to sleep");
            Thread.currentThread().interrupt();
            Thread.sleep(1000);
        }
        catch (InterruptedException | IllegalArgumentException e) {
            System.out.println("I`m catch InterruptedExeption or IllegalArgumentException");
        }
        catch (Exception e) {
            System.out.println("I`m catch Exeption ");
        }
        finally {
            System.out.println("It would be execute always");
        }
    }
}
