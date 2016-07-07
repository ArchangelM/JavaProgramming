package filecopy;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class StreamFileWork {

    public void write(String fileName, byte[] cur) {
       try(FileOutputStream f = new FileOutputStream(fileName)) {
           f.write(cur);

       } catch (IOException e) {
           System.out.println(e);
        }

    }

    public byte[] read(String fileName) {
        List<Byte> list = new ArrayList<>();

        try(FileInputStream f = new FileInputStream(fileName)) {
            int i = 0;
            while((i = f.read()) != -1) {
                list.add(Byte.valueOf((byte)i));
            }
        } catch (IOException e) {
            System.out.println(e);
        }

        byte [] cur = new byte[list.size()];
        for (int i = 0;i < cur.length;i++) {
            cur[i] = (byte)list.get(i);
        }

        return cur;
    }

    public void bufWrite(String fileName, byte[] cur) {
        try(BufferedOutputStream bufOutStr = new BufferedOutputStream(new FileOutputStream(fileName))) {
            bufOutStr.write(cur);

        } catch (IOException e) {
            System.out.println(e);
        }

    }

    public byte[] bufRead(String fileName) {
        List<Byte> list = new ArrayList<>();

        try(BufferedInputStream bufInStr = new BufferedInputStream(new FileInputStream(fileName))) {
            int i = 0;
            while((i = bufInStr.read()) != -1) {
                list.add(Byte.valueOf((byte)i));
            }
        } catch (IOException e) {
            System.out.println(e);
        }

        byte [] cur = new byte[list.size()];
        for (int i = 0;i < cur.length;i++) {
            cur[i] = (byte)list.get(i);
        }

        return cur;
    }

    public void CopyFile(String path, String fileName) {
        path = path+fileName;
        byte[] inside = read(path);

        path = path.replace(".", "_Copy.");

        write(path, inside);
    }

    public void CopyFile(File f) {
        String path = f.getAbsolutePath();

        byte[] inside = read(path);

        path = path.replace(".", "_Copy.");

        write(path, inside);
    }

    public void CopyFileBuf(File f) {
        String path = f.getAbsolutePath();

        byte[] inside = bufRead(path);

        path = path.replace(".", "_Copy.");

        bufWrite(path, inside);
    }
}
