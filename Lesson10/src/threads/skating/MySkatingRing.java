package threads.skating;

import java.util.ArrayList;
import java.util.List;

public class MySkatingRing implements SkatingRing {
    private List<Skates> skates;
    private int free_skates;
    static final Object sync = new Object();

    private final int NUM_OF_SKATES = 5;

    public MySkatingRing() {
        skates = new ArrayList<>();
        for(int i = 0; i < NUM_OF_SKATES;i++) {
            skates.add(new Skates(i));
        }

        free_skates = NUM_OF_SKATES;
        System.out.println("Good morning! My Skating Ring begin to work!");
    }

    private Skates findFreeSkates() {
        for (Skates skates: this.skates
             ) {
            if(skates.isFree()) return skates;

        }
        return null;
    }

    public int getFree_skates() {
        return free_skates;
    }

    public boolean isFreeSkates() {
        if(free_skates > 0) return true;
        return false;
    }

    @Override
    public Skates getSkates(Skater skater) {

        if(free_skates > 0) {
            free_skates--;
            Skates skates = findFreeSkates();
            if (skates != null) {
               skates.setFree(false);
               System.out.println("Skater " + skater.getName() + " got skates #" + skates.getInventory_number() +
                            " We have " + free_skates + " " + Thread.currentThread());

                return skates;
            }

        }
        else {
            System.out.println("before wait synk " + Thread.currentThread());

                try {
                    synchronized (sync) {
                        sync.wait();
                    }

                    System.out.println("after wait synk");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            return null;
        }
        return null;
    }

    @Override
    public void returnSkates(Skates skates, Skater skater) {
        skates.setFree(true);
        free_skates++;
        System.out.println("Skater " + skater.getName() + " returned skates." + " We have " + free_skates);

        synchronized (sync) {
            System.out.println("release in synk " + Thread.currentThread());
            sync.notifyAll();
        }

    }
}
