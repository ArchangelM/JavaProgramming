package threads.skating;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LauncherSkatingRing {
    private static final int NUM_SKATERS = 10;

    public static void main(String[] args) throws Exception{
        MySkatingRing mySkatingRing = new MySkatingRing();

        //List<Skater> skaters = new ArrayList<>();

        for (int i = 0; i < NUM_SKATERS; i++) {
            //skaters.add(new Skater("Mr. " + String.valueOf(i)));

            new Thread(new Runnable() {
                @Override
                public void run() {

                    Random random = new Random();
                    Skater skater = new Skater("Mr. " + String.valueOf(random.nextInt(2 * NUM_SKATERS)));
                    Skates skates;
                    try {
                        do {
                            skates = mySkatingRing.getSkates(skater);
                        } while(skates == null);

                        Thread.sleep(random.nextInt(2000));
                        mySkatingRing.returnSkates(skates, skater);
                    } catch (InterruptedException e) {
                          e.printStackTrace();
                    }

                }
            }).start();

            Thread.sleep(100);
        }
    }
}
