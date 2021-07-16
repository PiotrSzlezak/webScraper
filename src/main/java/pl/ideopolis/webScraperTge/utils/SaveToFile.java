package pl.ideopolis.webScraperTge.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class SaveToFile {

    private final static Logger log = LoggerFactory.getLogger(SaveToFile.class);
    private static BufferedWriter bw;

    public static void saveToFile(String fileName, String path, String text) {
        log.trace("saveToFile method.");
        try {
            bw = new BufferedWriter(new FileWriter(path + fileName));
            bw.write(text);
            bw.flush();
            bw.close();
            log.trace("File " + fileName + " saved successfully at " + path);
        } catch (IOException e) {
            log.error("Something went wrong while saving the file.");
            e.printStackTrace();
        }
    }

}
