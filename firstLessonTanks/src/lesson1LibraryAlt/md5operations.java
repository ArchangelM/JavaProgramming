package lesson1LibraryAlt;

/**
 * Created by Rodichka on 27.02.2016.
 */

import java.security.MessageDigest;
import java.util.Arrays;

public class md5operations {
    public static void md5try() throws Exception {
       // Book[] library = new Book[10];

        String name = "Эдгар По";
        MessageDigest md5Name;
        byte[] bytesOfMessage = name.getBytes("UTF-8");
        md5Name = MessageDigest.getInstance("MD5");
        byte[] thedigest = md5Name.digest(bytesOfMessage);

        System.out.println(Arrays.toString(thedigest));

    }

       /*  http://stackoverflow.com/questions/415953/how-can-i-generate-an-md5-hash  http://devcolibri.com/4604
    byte[] bytesOfMessage = myString.getBytes("UTF-8");
    MessageDigest md = MessageDigest.getInstance("MD5");
    byte[] thedigest = md.digest(bytesOfMessage);
    If you have a lot of data take a look at the .update(byte[]) method which can be called repeatedly.
    Then call .digest() to obtain the resulting hash.

    import java.io.UnsupportedEncodingException;
    import java.security.*;

    import static java.security.MessageDigest.getInstance;
    throws UnsupportedEncodingException
    */

    // MessageDigest md5Name;
    // MessageDigest md5Auth;
            /*byte[] bytesOfMessage = name.getBytes("UTF-8");
        md5Name = getInstance("MD5");
        byte[] thedigest = md5Name.digest(bytesOfMessage);
        */
}
