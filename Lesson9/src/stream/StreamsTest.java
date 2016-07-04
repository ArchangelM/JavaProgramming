package stream;

import java.io.ByteArrayInputStream;

public class StreamsTest {
    public static void main(String[] args) {

        byte[] bytes = {34, -9, 123, 90, -5, -78, -1};
        ByteArrayInputStream input = new ByteArrayInputStream(bytes);

        printStreamData(input);

    }

    public static void printStreamData(ByteArrayInputStream input) {
        int cur = 0;

        while((cur = input.read()) != -1) {
            System.out.print((byte)cur);
            System.out.print(" ");
        }
    }
}
