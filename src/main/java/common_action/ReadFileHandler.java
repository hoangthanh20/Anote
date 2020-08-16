package common_action;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
/*
* This class is used to read file for any configurations.
* it's used for loading the testcase data at the beforeTest phrase.
* @author: Thanh Nguyen
* */

public class ReadFileHandler {
    /*
    * This function is used to read the file having .properties extension.
    * param: the file directory
    * */
    public Properties readPropertiesFileFromDirectory(String fileDir) {
        Properties prop = new Properties();
        InputStream inputFile = null;
        try {
            inputFile = new FileInputStream(fileDir);
            // load a properties file
            prop.load(inputFile);
            // get the property value and print it out
            //prop.entrySet().forEach(e -> System.out.println(e.getKey() + " : " + e.getValue()));
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (inputFile != null) {
                try {
                    inputFile.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return prop;
    }
}
