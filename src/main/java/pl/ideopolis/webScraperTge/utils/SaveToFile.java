package pl.ideopolis.webScraperTge.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class SaveToFile {

    private final static Logger log = LoggerFactory.getLogger(SaveToFile.class);
    private static File f;
    private static boolean issue = false;

    public static void saveToFile(String fileName, String path, String text) {
        log.trace("saveToFile method.");
        init(path+fileName);
        checkPath();
        if(!issue) {
            try {
                BufferedWriter bw = new BufferedWriter(new FileWriter(path + fileName));
                bw.write(text);
                bw.flush();
                bw.close();
                log.info("File {} saved successfully at {}", fileName, path);
            } catch (IOException e) {
                log.error("Saving file was not successful. \n{}",e.getMessage());
            }
        } else {
            log.error("File could not be saved.");
        }
    }

    private static void init(String path){
        f = new File(path);
        issue = false;
    }

    private static void checkPath(){
        if(!checkIfFolderExists()){
            createFolder();
        }
        checkIfLocationIsAccessible();
    }

    private static boolean checkIfFolderExists(){
        return f.exists();
    }

    private static void checkIfLocationIsAccessible(){
        if (f.canWrite()){
            log.trace("File path can be accessed.");
        } else {
            issue = true;
            log.error("File path is inaccessible.");
        }
    }

    private static void createFolder(){
        if (f.mkdir()){
            log.trace("Folder created successfully.");
        } else {
            issue = true;
            log.error("Folder could not be created. ");
        }
    }

}
