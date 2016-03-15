package shapes;

/**
 * Created by Osipov on 16.03.2016.
 */
public class Launcher {
    public static void main(String[] args) throws Exception,InterruptedException {
        Shape shape = new Shape();
        Triangle triangle = new Triangle();
        Rectangle rectangle = new Rectangle();
        Circle circle = new Circle();

        System.out.print("Shape draw: ");
        shape.draw();

        System.out.print("Triangle draw: ");
        triangle.draw();

        shape = rectangle;

        System.out.print("Rectangle draw threw shape: ");
        shape.draw();

        Shape shape_circle = new Circle();
        System.out.print("Circle draw: ");
        circle.draw();
        System.out.print("Circle draw threw shape: ");
        shape_circle.draw();

    }
}
