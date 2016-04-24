package date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class BirthDay {

    private final static String MY_BIRTH_DAY = "05.01.1980";
    private SimpleDateFormat myBirth;
    private Date myBirthDate;

    public BirthDay() {
        myBirth = new SimpleDateFormat();
        myBirth.applyPattern("dd.MM.yyyy");
        try {
            myBirthDate = myBirth.parse(MY_BIRTH_DAY );
        } catch (ParseException e) {
            System.out.println(e);
        }

    }

    public Date getMyBirthDate() {
        return myBirthDate;
    }

    @Override
    public String toString() {
        myBirth.applyPattern("dd MMM yyyy");
        return myBirth.format(myBirthDate);
    }

       public static void main(String[] args) {
           BirthDay myBD = new BirthDay();

           System.out.println(myBD);

           Calendar c = new GregorianCalendar();

           c.set(Calendar.MONTH, 0);
           c.set(Calendar.SECOND, 0);


           c.setTime(myBD.getMyBirthDate());

           System.out.println("Day of week: " + c.get(Calendar.DAY_OF_WEEK));

    }
}
