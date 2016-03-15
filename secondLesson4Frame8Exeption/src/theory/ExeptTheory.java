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
        System.out.println("4 ");
        doMethod4();
        System.out.println("5 my ");
        doMethodMyExpt();
        System.out.println("6 my ");
        doMethodMyExpt1();
        System.out.println("7 my ");
        doMethodMyExpt2();

    }

    public static void doMethod1() throws InterruptedException {
        System.out.println("I`m going to sleep");
        Thread.sleep(1000);
    }

    public static void doMethod2() {
        try {
            System.out.println("I`m going to sleep");
            Thread.sleep(-1000);
            throw new InterruptedException();
        } catch (InterruptedException  e) {
            System.out.println("I`m catch InterruptedExeption or ");
        } catch (IllegalArgumentException e) {
            System.out.println("I`m catch IllegalArgumentException ");
        } finally {
            System.out.println("It would be execute always, even all ok");
        }

        try {
            System.out.println("I`m going to sleep");
            Thread.sleep(1000);
        } catch (InterruptedException  e) {
            System.out.println("I`m catch InterruptedExeption or ");
        } finally {
            System.out.println("It would be execute always, even all ok");
        }
    }

    public static void doMethod3() {
        try {
            System.out.println("I`m going to sleep");
            Thread.currentThread().interrupt();
            Thread.sleep(1000);
        } catch (InterruptedException | IllegalStateException e) {
            System.out.println("I`m catch InterruptedExeption or IllegalStateException");
        } catch (Exception e) {
            System.out.println("I`m catch Exeption ");
            e.printStackTrace();
        } finally {
            System.out.println("It would be execute always, even all ok");
        }
    }

    public static void doMethod4() {
        try {
            System.out.println("I`m going to sleep");
            Thread.sleep(1000);
            throw new Exception("Are you afraid? It`s joke");

        } catch (InterruptedException | NumberFormatException e) {
            System.out.println("I`m catch InterruptedExeption or NumberFormatException");

        } catch (Exception e) {
            System.out.println("I`m catch Exeption ");
            e.printStackTrace();
        } finally {
            System.out.println("It would be execute always, even all ok");
        }
    }

    public static void doMethodMyExpt() {
        try {
            System.out.println("I`m going to sleep");
            Thread.sleep(1000);
            throw new MyPersonalExeption();

        } catch (InterruptedException | NumberFormatException e) {
            System.out.println("I`m catch InterruptedExeption or NumberFormatException");

        } catch (MyPersonalExeption e) {
            System.out.println("I`m catch MyPersonalExeption ");
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("I`m catch Exeption wo message!!!");
            System.out.println(e.getMessage());
            e.printStackTrace();
        } finally {
            System.out.println("It would be execute always, even all ok");
        }
    }

    public static void doMethodMyExpt1() {
        try {
            System.out.println("I`m going to sleep");
            Thread.sleep(1000);
            throw new MyPersonalExeption("Are you afraid? It`s joke");

        } catch (InterruptedException | NumberFormatException e) {
            System.out.println("I`m catch InterruptedExeption or NumberFormatException");

        } catch (MyPersonalExeption e) {
            System.out.println("I`m catch MyPersonalExeption ");
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("I`m catch Exeption do something!!!");
            System.out.println(e.getMessage());
        } finally {
            System.out.println("It would be execute always, even all ok");
        }
    }

    public static void doMethodMyExpt2() {
        try {
            System.out.println("I`m going to sleep");
            Thread.sleep(1000);
            throw new MyPersonalRTExeption("Ну и чего ж ты ожидал?");

        } catch (InterruptedException | NumberFormatException e) {
            System.out.println("I`m catch InterruptedExeption or NumberFormatException");

        } catch (MyPersonalRTExeption e) {
            System.out.println("I`m catch MyRuntimeExeption ");
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("I`m catch Exeption do something!!!");
            System.out.println(e.getMessage());
            e.printStackTrace();
        } finally {
            System.out.println("It would be execute always, even all ok");
        }
    }
}
