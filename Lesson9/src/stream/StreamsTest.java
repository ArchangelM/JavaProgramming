package stream;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class StreamsTest {
    public static void main(String[] args) {

        byte[] bytes = {34, -9, 123, 90, -5, -78, -1};
        ByteArrayInputStream input = new ByteArrayInputStream(bytes);

        printStreamData(input);
        System.out.println();

        //InputStream inputStream = new FileInputStream(" ");
        //Files files;
        Path path = Paths.get("d:\\razrab\\test\\test.txt");
        //InputStreamReader reader = new InputStreamReader(new FileInputStream(ваш_файл), "windows-1251");

        try (InputStream inputS = Files.newInputStream(path)) {
            printStreamData(inputS);
        }catch (IOException e){
            System.out.println(e);
        }


    }

    public static void printStreamData(ByteArrayInputStream input) {
        int cur = 0;

        while((cur = input.read()) != -1) {
            System.out.print((byte)cur);
            System.out.print(" ");
        }
    }

    public static void printStreamData(InputStream input) {
        int cur = 0;

        try {
            while ((cur = input.read()) != -1) {
                System.out.print((char) cur);

            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
