package glyph;

/**
 * Created by Osipov on 19.03.2016.
 */
public class Glyph {
    public Glyph() {
        System.out.println("Glyph@constructor ");
        draw();
        paint();
    }

    public void draw() {
        System.out.println("Glyph@draw ");
    }

    protected void paint() {
        System.out.println("Glyph@paint protected");
    }
}
