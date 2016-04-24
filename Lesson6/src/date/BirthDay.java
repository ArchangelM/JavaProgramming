package date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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

    @Override
    public String toString() {
        myBirth.applyPattern("dd MMM yyyy");
        return myBirth.format(myBirthDate);
    }

       public static void main(String[] args) {
        BirthDay myBD = new BirthDay();

        System.out.println(myBD);

    }
}
