package theory;

/**
 * Created by Osipov on 15.03.2016.
 */
public class MyPersonalRTExeption extends RuntimeException {
    public MyPersonalRTExeption() {
        System.out.println("MyPersonalRTExeption()Всё плохо!!! Как ты мог, у тебя же руки из деструктора растут!!!");
    }

    public MyPersonalRTExeption(String message) {
        super(message);
        System.out.println("MyPersonalRTExeption(String)Всё плохо!!! Как ты мог, у тебя же руки из деструктора растут!!!");
    }
}
