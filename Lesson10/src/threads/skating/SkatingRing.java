package threads.skating;

public interface SkatingRing {
    public Skates getSkates(Skater skater);
    public void returnSkates(Skates skates, Skater skater);
}
