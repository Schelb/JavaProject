package org.example;

import java.io.FileWriter;
import java.io.IOException;

public class FileHandler {
    public void  write(String text){
        try(FileWriter writer = new FileWriter("docks.txt", false))
        {
            // запись всей строки
            writer.write(text);
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }
}
