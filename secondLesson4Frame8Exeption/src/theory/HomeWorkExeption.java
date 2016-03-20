package theory;

/**
 * Created by Rodichka on 20.03.2016.
 */
public class HomeWorkExeption {
    public static void main(String[] args) throws Exception {
        catching();
        System.out.println("done");
    }

    public static void catching() {
        try {
            throw new Exception();
        } catch(Exception g) {
            throw new IllegalStateException();
        } finally {
            System.out.println("Works!!!");
        }
    }
}
