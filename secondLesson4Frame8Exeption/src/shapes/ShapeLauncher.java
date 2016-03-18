package shapes;

/**
 * Created by Osipov on 16.03.2016.
 */
public class ShapeLauncher {
    final static int NUM_SHAPES = 4;

    public static void main(String[] args) throws Exception,InterruptedException {
        Shape[] shapes = new Shape[NUM_SHAPES];

        ShapeInit init = new ShapeInit(shapes);

        ShapesTemplate field = new ShapesTemplate(shapes);

        /*
        Shape shape = new Shape();
        Triangle triangle = new Triangle();
        Rectangle rectangle = new Rectangle();
        Circle circle = new Circle();

        System.out.print("Shape draw: ");
        shape.draw();
        shape.colorDraw("green");
        System.out.println("");

        System.out.print("Triangle draw: ");
        triangle.draw();
        triangle.colorDraw("purple");
        System.out.println("");

        shape = rectangle;

        System.out.print("Rectangle draw threw shape: ");
        shape.draw();
        shape.colorDraw("red");
        System.out.println("");

        Shape shape_circle = new Circle();
        System.out.print("Circle draw: ");
        circle.draw();
        circle.colorDraw("yellow");
        System.out.println("");

        System.out.print("Circle draw threw shape: ");
        shape_circle.draw();
        shape_circle.colorDraw("black");
        System.out.println("");
*/
    }
}
