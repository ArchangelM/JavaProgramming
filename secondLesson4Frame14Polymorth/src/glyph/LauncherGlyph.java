package glyph;

/**
 * Created by Rodichka on 19.03.2016.
 */
public class LauncherGlyph {
    public static void main(String[] args) throws NullPointerException {
        Glyph glyph = new RoundGlyph(5);
        glyph.draw();

        System.out.println();

        glyph = new ArrayGlyths();
        glyph.draw();
    }


}


