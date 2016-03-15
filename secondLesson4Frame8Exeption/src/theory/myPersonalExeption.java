package theory;

/**
 * Created by osipov on 15.03.2016.
 */
public class MyPersonalExeption extends Exception {


    public MyPersonalExeption() {
        System.out.println("MyPersonalExeption() Всё плохо!!! Как ты мог, оно ж не готово!!!");
    }

    public MyPersonalExeption(String message) {
        super(message);
        System.out.println("MyPersonalExeption(string) Маємо те, що маємо, тобто фроунули");
    }
}
