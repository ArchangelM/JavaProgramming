package zip;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/**
 * Please read notification
 * It`s a Mock in metod init() at this Class
 *
 * При чтении можно взять размер и соответсвенно сделать буффер для чтения всего файла если он скажем меньше N кб
 * И по считывать не по 1 байту, а пачками, но так чтобы попасть в конец файла.
 */

public class ZipArchiver {
    private String option;

    private String zipFileName;
    private String path;

    public ZipArchiver() {
    }

    public String getOption() {
        return option;
    }

    public void setOption(String option) {
        this.option = option;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getZipFileName() {
        return zipFileName;
    }

    public void setZipFileName(String zipFileName) {
        this.zipFileName = zipFileName;
    }

   public boolean init(String[] args) {

       option = args[0];
       if (args.length >= 3) {
           zipFileName = args[1];
           zipFileName = "d:\\razrab\\test\\"+zipFileName; //Mock for test
           path = args[2].replace("\\", File.separator);
       } else if (args.length == 2) {
           zipFileName = args[1];
           zipFileName = "d:\\razrab\\test\\"+zipFileName; //Mock for test
       }


       if (option.equals("-zip")) {
           return zipFiles();
       } else if (option.equals("-unzip")) {
           return unZipFile();
       }else if (option.equals("-h")) {
           printHelp();
           return true;
       }

       System.out.println("Illegal option, see help: -h option");
       System.out.println("Example:");
       System.out.println("ziparchiver -h");

       return false;
   }

    public boolean zipFiles() {
        File zipFile = new File(zipFileName);


        File archFiles = new File(path);
        if(!archFiles.exists()) {
            System.out.println("Path not found");
        }


        try (
                ZipOutputStream zipFileIOutStream = new ZipOutputStream(new FileOutputStream(zipFile));
                )
        {
            for (String fileName: archFiles.list()
                 ) {
                //fileName = path + File.separator + fileName; //Сохраняет с путём
               // File file = new File(fileName);
                File file = new File(path + File.separator + fileName);

                if (file.exists()) {
                    FileInputStream fis = new FileInputStream(file);
                    BufferedInputStream bis = new BufferedInputStream(fis, 1024);

                    ZipEntry zipEntry = new ZipEntry(fileName);
                    zipFileIOutStream.putNextEntry(zipEntry);

                    int i = 0;

                    while(((i = bis.read()) != -1)) {
                        //osw.write((byte)i);

                        zipFileIOutStream.write((byte)i);
                    }
                /*while((zipFileStream.read(buffer) != -1)) {
                    osw.write(buffer);
                }
                */
                    bis.close();
                }

            }

        } catch (IOException e) {
            System.out.println(e);
        }


        return true;
    }


    public boolean unZipFile() {
        File f = new File(zipFileName);

        String tmp = f.getAbsolutePath();
        path = tmp.substring(0, tmp.lastIndexOf('.'));


        File folder = new File(path);
        if(!folder.exists()){
            folder.mkdir();
        }
        System.out.println();

        try (
                ZipInputStream zipFileStream = new ZipInputStream(new FileInputStream(zipFileName));


            ) {

            ZipEntry zipEntry = zipFileStream.getNextEntry();

            while(zipEntry != null) {
                String fileName = zipEntry.getName();

                File newFile = new File(path + File.separator + fileName);
                FileOutputStream osw = new FileOutputStream(newFile);
                BufferedOutputStream bos = new BufferedOutputStream(osw, 1024);
                int i = 0;

                while(((i = zipFileStream.read()) != -1)) {
                    //osw.write((byte)i);
                    bos.write((byte)i);
                }
                /*while((zipFileStream.read(buffer) != -1)) {
                    osw.write(buffer);
                }
                */
                bos.flush();
                bos.close();

                zipEntry = zipFileStream.getNextEntry();
            }
            //zipFile.


        } catch (IOException ioE) {
            System.out.println(ioE);
        }


        return true;
    }

    public void printHelp() {
        System.out.println("Please use arguments:");
        System.out.println("-<option> <zip file name> (<files path for archiving>)");
        System.out.println("Option: zip - to archive files;");
        System.out.println("        unzip - to extract file;");
        System.out.println("        h - this help.");
        System.out.println("If <zip file name> exists it would be overwrited.");
        System.out.println("Example for zip:");
        System.out.println("ziparchiver -zip example.zip \"d:\\path");
        System.out.println("Example for unzip:");
        System.out.println("ziparchiver -unzip example.zip \"d:\\path");
    }


}
