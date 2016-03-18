package shapes;

/**
 * Created by Rodichka on 18.03.2016.
 */
public class ShapeInit {

     public ShapeInit(Shape[] shapes) {
        if (shapes != null) {
            shapes[0] = new Circle();
            shapes[1] = new Triangle();
            shapes[2] = new Rectangle();

        }
    }
}
