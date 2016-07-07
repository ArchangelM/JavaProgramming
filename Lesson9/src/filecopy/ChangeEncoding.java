package filecopy;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class ChangeEncoding {
    public void changeEncoding(File file, String currentEncoding, String neededEncoding) {
        List<String> text = new ArrayList<>();
        char[] chars;

        try {
            FileInputStream fis = new FileInputStream(file);
            InputStreamReader isr = new InputStreamReader(fis, currentEncoding);
            BufferedReader reader = new BufferedReader(isr, 256);

            int i = 0;
            //reader.read(chars, 0, )

            do {
                text.add(reader.readLine());
            } while(text.get(i++) != null);


        } catch (IOException e) {
            System.out.println(e);
        }




        try {
            FileOutputStream fos = new FileOutputStream(file);
            OutputStreamWriter osw = new OutputStreamWriter(fos, neededEncoding);
            BufferedWriter writer = new BufferedWriter(osw, 256);

            if(text.size() >= 1) {
                writer.write(text.get(0));
            }

            for(int i = 1;i < text.size();i++) {
                writer.append(text.get(i));
            }



        } catch (IOException e) {
            System.out.println(e);
        }
    }




}
