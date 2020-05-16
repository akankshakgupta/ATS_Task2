package Utility;

import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class ReuseableMethods {
    public static void timelapsImplicitWait(WebDriver driver)
    {
        int time = Integer.parseInt(FileReaderUtility.loadFiles().getProperty("time"));
        driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
    }





}
