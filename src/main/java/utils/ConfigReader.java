package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    public static Properties initalizeProperties()  {
        Properties properties=new Properties();
        File file=new File(System.getProperty("user.dir")+"/src/test/resources/config/config.properties");
        try {
            FileInputStream fis=new FileInputStream(file);
            properties.load(fis);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return properties;
    }
}
