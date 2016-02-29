package lesson2part2instrum;

/**
 * Created by Rodichka on 01.03.2016.
 */
public class MusicLauncher {
    public static void main(String[] args) {
        Musicant mus1 = new Musicant();
        Instrument inst = new Instrument();
        Flute flute = new Flute();

        mus1.play(inst);

        mus1.play(flute);
    }
}
