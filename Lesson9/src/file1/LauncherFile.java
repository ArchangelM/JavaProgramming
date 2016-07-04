package file1;

import java.io.File;
import java.io.IOException;

public class LauncherFile {
    public static void main(String[] args) throws IOException {
        File file = new File("test.txt");


        String path = "d:\\razrab";

        PrintDir prnDir = new PrintDir();

        path = prnDir.creatingDir(path);
        prnDir.creatingFile(path);
        prnDir.printDir(path);



    }

}
