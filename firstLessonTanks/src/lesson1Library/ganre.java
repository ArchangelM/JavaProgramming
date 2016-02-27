package lesson1Library;

/**
 * Created by Rodichka on 23.02.2016.
 */
public enum Ganre {
    FANTASY, COMPUTERS, FICTION, FOOD, HISTORY;

    private final static int num = 5;

    public static  Ganre getSpecGanre(int i) {
        if(i >= 0) {
            i = i%5;
            switch (i) {
                case 0: return FANTASY;
                case 1: return COMPUTERS;
                case 2: return FICTION;
                case 3: return FOOD;
                case 4: return HISTORY;
            }
        }
        return HISTORY;
    }

    public static Ganre getNextGanre(Ganre cur) {
             switch (cur) {
                case FANTASY:   return COMPUTERS;
                case COMPUTERS: return FICTION;
                case FICTION:   return FOOD;
                case FOOD:      return HISTORY;
                case HISTORY:   return FANTASY;
            }
            return FANTASY;
    }

    public static Ganre getFirstGanre() {
        return FANTASY;
    }

    public static int getNum() {
        return num;
    }
}
