package download;

import java.net.HttpURLConnection;
import java.net.http.*;

import java.io.*;
import java.net.URL;
import java.net.URI;

/**
    how to execute this program from a terminal:
    % cd out/production/Example2-IO
    % java download.Downloader http://cs.hac.ac.il
 */
public class Downloader {
    private String source;  // the URL to read from

    /**
     * ctor
     * @param fname the URL to read from
     */
    public Downloader(String fname) {
        this.source = fname;
    }

    /**
     * Downloads a remote file to the local disk.
     *
     * @param filename the output file to save the source to
     * @exception IOException upon opening streams or reading. Closing of stream IOException is caught.
     */
    public void downloadAnything(String filename) throws IOException {
        URL url = new URL(source);
        // try with resource
        try (
                InputStream input = new BufferedInputStream(url.openStream());
                OutputStream output = new BufferedOutputStream(new FileOutputStream(filename));
        ) {
            int b;
            while ((b = input.read()) != -1) {
                output.write(b);
            }
        }

        // alternate way to do it - not using try/with resources
//        InputStream input = new BufferedInputStream(url.openStream());
//        OutputStream output = new BufferedOutputStream(new FileOutputStream(filename));
//        int b;
//        while ((b = input.read()) != -1) {
//            output.write(b);
//        }
//
//        // we finished writing, fail on closing input is not fatal
//        try { input.close(); } catch (Exception e) {}
//
//        output.close();
    }

    /**
     * Downloads a remote file to the local disk using HttpUrlConnection class
     * checks that content-type is TEXT otherwise does nothing and prints an error message
     *
     * @param filename the output file to save the source to
     * @exception IOException upon opening streams or reading. Closing of stream IOException is caught.
     */
    public void downloadIfText(String filename) throws IOException {
        String inputLine;

        URL url = new URL(source);
        // this does not connect to the URL but only build the connection object
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        // now we connect
        con.connect();
        // get the HTTP response code
        int responseCode = con.getResponseCode();

        if (responseCode != HttpURLConnection.HTTP_OK) {
            System.out.println("failed to download " + filename);
            return;
        }
        // we want to download only if the content-type is text
        String contentType = con.getHeaderField("Content-Type");
        if (!contentType.startsWith("text")) {
            throw new IOException("Content-Type is not text");
        }
        // we check if the response is 200 and if the content-type is TEXT
         BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));

        PrintWriter output = new PrintWriter(new FileOutputStream(filename));

        // read each line
        while ((inputLine = in.readLine()) != null) {
            output.print(inputLine);
        }

        // we finished writing, fail on closing input is not fatal
        try { in.close(); } catch (Exception e) {}
        output.close();

    }

    /**
     * since Java 10 - using HttpClient
     * print the contents of the given URL, only if text
     * @throws IOException if the URL does not exist or cannot be read
     * @throws InterruptedException if the thread is interrupted
     * @return the content of the URL as a String
     */
    public String getUrlTextContent() throws IOException, InterruptedException {
        var request = HttpRequest.newBuilder()
                .uri(URI.create(source))
                .GET()
                .build();

        var client = HttpClient.newHttpClient();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        // print to stdout only if it is HTML
        if (response.headers().firstValue("Content-Type").orElse("").startsWith("text/html"))
            return(response.body());
        else
            throw new IOException("Content-Type is not text");
    }
    /**
     * Returns the content of a file as an array of bytes
     *
     * @param filename the name of the file
     * @return the content of the file as an array of bytes
     * @throws IOException if the file does not exist or cannot be read
     */
    public byte[] getFileAsByteArray(String filename)  throws IOException {

        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        InputStream input = new FileInputStream(filename);
        int b;
        while ((b = input.read()) != -1) {
            buffer.write(b);
        }
        input.close();  // all streams must be closed

        return buffer.toByteArray();
    }

}

