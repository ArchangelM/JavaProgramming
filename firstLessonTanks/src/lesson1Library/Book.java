package lesson1Library;

/**
 * Created by Rodichka on 23.02.2016.
 */

import java.io.UnsupportedEncodingException;
import java.security.*;

import static java.security.MessageDigest.getInstance;

public class Book {
    private int index;
   // MessageDigest md5Name;
   // MessageDigest md5Auth;

    private String name;
    private String author;

    private Ganre ganre;


/*  http://stackoverflow.com/questions/415953/how-can-i-generate-an-md5-hash  http://devcolibri.com/4604
    byte[] bytesOfMessage = myString.getBytes("UTF-8");
    MessageDigest md = MessageDigest.getInstance("MD5");
    byte[] thedigest = md.digest(bytesOfMessage);
    If you have a lot of data take a look at the .update(byte[]) method which can be called repeatedly.
    Then call .digest() to obtain the resulting hash.
    */

    public void Book() {

    }

    public void Book(String name, String author, Ganre ganre) throws UnsupportedEncodingException {
        setName(name);
        setAuthor(author);
        setGanre(ganre);
        /*byte[] bytesOfMessage = name.getBytes("UTF-8");
        md5Name = getInstance("MD5");
        byte[] thedigest = md5Name.digest(bytesOfMessage);
        */
    }





    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Ganre getGanre() {
        return ganre;
    }

    public void setGanre(Ganre ganre) {
        this.ganre = ganre;
    }
}
