package Base;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


public class TestBase {

    public WebDriver driver;
    public Properties prop;



    @Parameters("myBrowser")

    @BeforeTest
    public WebDriver launchBrowser(  String myBrowser) throws IOException {

        prop= new Properties();

        //get properties file
        FileInputStream fis=new FileInputStream(".//src//test//java//Config//config.properties");
        prop.load(fis);



        //launch chrome browser
        if (myBrowser.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", ".//driver//chromedriver.exe");

            driver = new ChromeDriver();

        }
        //launch firefox browser
        else if (myBrowser.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver", ".//driver//geckodriver.exe");
            driver = new FirefoxDriver();
        }

       return driver;


    }



    //get screenshot if any test case fail
    public void getScreenshot(String result) throws IOException
    {
        File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(src, new File(System.getProperty("user.dir")+"/ScreenShots/"+result+"screenshot.png"));

    }
}