package app.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;


public class ReadFile {
    private File fileObj;
    ReadFile(String path){
        fileObj = new File(System.getProperty("user.dir") + path);
    }
    public void readFile(File file){}

    public File getFileObj() {
        return fileObj;
    }
}
