package lesson1Library;

import java.security.*;
import java.util.Arrays;

/**
 * Created by Rodichka on 23.02.2016.
 */
public class LauncerLibrary {

    public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub
        Book[] library = new Book[10];

        String name = "Эдгар По";
        MessageDigest md5Name;
        byte[] bytesOfMessage = name.getBytes("UTF-8");
        md5Name = MessageDigest.getInstance("MD5");
        byte[] thedigest = md5Name.digest(bytesOfMessage);

        System.out.println(Arrays.toString(thedigest));

    }
}
