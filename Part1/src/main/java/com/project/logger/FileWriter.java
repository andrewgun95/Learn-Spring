package com.project.logger;

import org.springframework.beans.factory.annotation.Qualifier;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

@Qualifier("file")
public class FileWriter implements LogWriter {

    @Override
    public void write(String str) {
        System.out.println("Writing into a file...");
        try {
            File file = new File("log.txt");
            if (!file.exists()) file.createNewFile();

            FileOutputStream output = new FileOutputStream(file);
            output.write(("File : " + str).getBytes());
            output.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
