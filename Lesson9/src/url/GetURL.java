package url;

import sun.net.www.protocol.http.HttpURLConnection;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.*;
import java.net.URLConnection;

public class GetURL {

    public void getDataFromURL(String urlPath) {

        URL myURL = null;

        try {
            myURL = new URL(urlPath);

            try(
                    BufferedReader  bufReader = new BufferedReader(new InputStreamReader(myURL.openStream()), 1024);
                    ) {
                String tmp;// = bufReader.readLine();
                while ((tmp = bufReader.readLine()) != null) {
                    System.out.println(tmp);
                }

                bufReader.close();
            }catch (IOException e) {
                System.out.println(e);
            }

        } catch (MalformedURLException e) {
           e.printStackTrace();
        }
    }

}
