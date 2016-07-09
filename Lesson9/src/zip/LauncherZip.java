package zip;

/**
 * Please read notification
 * It`s a Mock in metod init() at ZipArchiver Class
 */

public class LauncherZip {

    public static void main(String[] args) {

        ZipArchiver zipArchive = new ZipArchiver();

        if(args.length < 1) {
            zipArchive.printHelp();
        } else {
            zipArchive.init(args);
        }

    }

}
