/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package files;

import java.io.*;


// Prints the content of a text file
class PrintFile {
    public static void main(String[] args) {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(args[0]));
            String line;
            while ((line=reader.readLine())!=null) {
                System.out.println(line);
            }
        } catch (IOException ioe) {
            System.err.println("Reading failed.");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        } finally {
            try {
                reader.close();
            } catch (Exception e) {

            }
        }
    }
}
