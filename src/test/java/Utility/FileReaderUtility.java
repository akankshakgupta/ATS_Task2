package Utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class FileReaderUtility {

    static FileInputStream input;
    public static Properties loadFiles()
    {
        Properties prop = new Properties();
        try
        {
            input = new FileInputStream(".\\src\\test\\java\\Config\\config.properties");
            prop.load(input);

        }catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }catch (IOException e)
        {
            e.printStackTrace();
        }
        return prop;
    }


}
