package filecopy;



import java.io.File;
import java.nio.charset.StandardCharsets;


public class LauncherFC {
    public static void main(String[] args) {
        File file = new File("test.txt");
        String path = "d:\\razrab\\test\\";
        path = path.replace("\\", File.separator);
        String fileName = "test.txt";

        StreamFileWork sfw = new StreamFileWork();

        sfw.CopyFile(path, fileName);

        path = "d:\\razrab\\test\\test1.txt";
        path = path.replace("\\", File.separator);

        file = new File(path);
        sfw.CopyFileBuf(file);

        ChangeEncoding changeEncoding = new ChangeEncoding();

        changeEncoding.changeEncoding(file, "CP1251", "UTF8");

    }
}


