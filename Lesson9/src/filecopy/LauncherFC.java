package filecopy;



import java.io.File;


public class LauncherFC {
    public static void main(String[] args) {
        File file = new File("test.txt");
        String path = "d:\\razrab\\test\\";
        path = path.replace("\\", File.separator);
        String fileName = "test.txt";

        StreamFileWork sfw = new StreamFileWork();

        sfw.CopyFile(path, fileName);

    }
}


