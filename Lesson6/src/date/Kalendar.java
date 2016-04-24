package date;


import java.util.Calendar;
import java.util.GregorianCalendar;

public class Kalendar {

    public static void main(String[] args) {
        Calendar c = new GregorianCalendar();
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);

        System.out.println(c.getTime());
        System.out.println(String.valueOf(c.getActualMaximum(Calendar.DAY_OF_MONTH)));
    }



}
