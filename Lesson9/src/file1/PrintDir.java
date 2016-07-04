package file1;


import java.io.File;
import java.io.IOException;

public class PrintDir {
    public PrintDir() {

    }

    public void printDir(String path) {
        path = path.replace("\\", File.separator);
        File f = new File(path);

        System.out.println(f.getAbsolutePath());
        for (String cur:f.list()
             ) {
            System.out.println(cur);
        }


    }

    public String creatingDir(String path) {
        path = path.replace("\\", File.separator);
        path = path + "\\test";

        File f = new File(path);
        System.out.println(f.getAbsolutePath());
        if (f.mkdir()) {
            System.out.println(f.getAbsolutePath());
        } else {
            System.out.println("Mistake");
        }

        return path;

    }

    public void creatingFile(String path) throws IOException {
        path = path.replace("\\", File.separator);
        path = path + "\\test.txt";

        File f = new File(path);
        System.out.println(f.getAbsolutePath());



        if (f.createNewFile()) {
            System.out.println(f.getAbsolutePath());
        } else {
            System.out.println("Mistake");
        }

    }
}
