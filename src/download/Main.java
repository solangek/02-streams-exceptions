package download;
import java.io.IOException;
public class Main {
    /**
     * This program downloads a file from a given url * and saves it to the local
     * file Usage: java Download <url> <filename>
     * run this demo with right-click on the file name (project tab) and "run"
     */
    public static void main(String[] args) {

        try {
            //if (args.length() != 2) will throw an exception
            Downloader d = new Downloader(args[0]);
            d.downloadAnything(args[1]);
            // uncomment to print the file
            // d.printUrlContent();
        } catch (ArrayIndexOutOfBoundsException aioobe) {
            System.err.println("Usage: java Download <url> <filename>");
        } catch (IOException ioe) {
            System.err.println("Download failed");
            ioe.printStackTrace(); // only for debugging!
        }
    }

}
