package lesson2part2instrum;

/**
 * Created by Rodichka on 01.03.2016.
 */
public class Musicant {
     public void play (Instrument i) {

         if (i instanceof Flute) {
             Flute flute = (Flute) i;
             flute.test();
         } else {
             i.sound();
         }

     }
}
