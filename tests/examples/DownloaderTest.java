package examples;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import download.Downloader;

import java.io.IOException;

/** this is an example of writing tests with JUnit5
 * More information at: <a href="https://howtodoinjava.com/junit-5-tutorial">JUnit tutorial</a> to run the tests,
 * right click on the tests folder and select "Run all tests"
 * @author solangekarsenty
 * */
public class DownloaderTest {
    Downloader d1, d2;

    @BeforeEach
    void setUp() {
        // URL exists
        d1 = new Downloader("https://cs.hac.ac.il/wp-content/uploads/2020/07/cropped-cshac.png");
        // URL does not exist
        d2 = new Downloader("https://cs.hac.ac.il/wp-content/uploads/2020/07/bad.png");
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testCtor() {
        Assertions.assertDoesNotThrow( () -> new Downloader("not a URL"));
    }

    @Test
    void testDownloadAnything() {

        Assertions.assertDoesNotThrow(() -> d1.downloadAnything("good.png"));

        Assertions.assertThrows(IOException.class,
                () -> d2.downloadAnything("bad.png"));
    }

}
