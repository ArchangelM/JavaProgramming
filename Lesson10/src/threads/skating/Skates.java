package threads.skating;

public class Skates {
    private int inventory_number;
    boolean free;

    public Skates(int inventory_number) {
        this.inventory_number = inventory_number;
        free = true;
    }

    public int getInventory_number() {
        return inventory_number;
    }

    public boolean isFree() {
        return free;
    }

    public void setFree(boolean free) {
        this.free = free;
    }
}
