/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package files;

import java.io.*;

/** This class reads a text file and writes it into 
 * another text file after converting all letters to
 * uppercase.
 * Usage: java ToUpper <source> <target>
 * */
public class ToUpper {

    public static void main(String[] args) {
        Reader reader = null;
        Writer writer = null;
        if (args.length != 2) {
            System.err.println("Invalid usage.");
            return;
        }
        String sourceName = args[0];
        String targetName = args[1];
        try {
            reader = new FileReader(sourceName);
            writer = new FileWriter(targetName);
            int c;

            while ((c = reader.read()) != -1) {
                c = Character.toUpperCase((char) c);
                writer.write(c);
            }
        } catch (IOException ioe) {
            System.err.println("Copying failed.");
        } finally {
            // make sure we close the files even if an exception occurs
            try {
                reader.close();
            } catch (Exception e) {}
            try {
                writer.close();
            } catch (Exception e) {}
        }
    }
}
