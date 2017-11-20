/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package readwritestorenames;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author pwittenmyer
 */
public class ReadWriteStoreNames {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ReadFile();
    }
    
    public static String ReadFile()
    {
        ArrayList<String> array1 = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader("BoyNames.txt")))
        {
            String line = br.readLine();
            
            while(line != null)
                {
                    array1.add(line + "\n");
                    line = br.readLine();
                }
            Collections.sort(array1);
            System.out.println(array1);
            
            WriteFile(array1.toString());
        }
        catch(IOException e)
        {
            System.out.println(e);
        }
        return "Error!";
    }
    
    public static void WriteFile(String content) throws IOException
    {
        Path p = Paths.get("NewBoyNames.txt");
        Files.createFile(p);
        try (BufferedWriter bw = Files.newBufferedWriter(p)) {
            bw.write(content);
        }
        catch(IOException ioe)
        {
            System.out.println("Error!");
            System.exit(0);
        }
        
    }
}
