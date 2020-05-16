package Tests;

import Base.TestBase;
import Utility.LoginUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import org.testng.annotations.*;
import pageObjects.LoginPage;


import java.io.IOException;

public class Login extends TestBase {
    public static Logger log = LogManager.getLogger(TestBase.class.getName());

    @BeforeSuite
    public void initialize() throws IOException {
        driver= launchBrowser("myBrowser");
        log.info("Successfully Browser is launched");



    }
    @Test(dataProvider="test1data")
    public void login(String username, String password) {

        driver.get(prop.getProperty("url"));
        log.info("Url is open");


        LoginPage l=new LoginPage(driver);



        l.getEmail().sendKeys(username);
        log.info("Enter username");

        l.getPassword().sendKeys(password);
        log.info("Enter password");

        l.getLogin().click();
        log.info("Click on submit button");

    }
    @DataProvider(name = "test1data")
    public Object[][] getData() throws IOException {
        String excelPath =System.getProperty("user.dir")+"/Excel/Login.xlsx";
        Object data[][] = testData(excelPath, "LoginData");
        return data;

    }


    public Object[][] testData(String excelPath, String sheetName)  {

        LoginUtils excel = new LoginUtils(excelPath, sheetName);
        //count number of rows in excel
        int rowCount = excel.getRowCount();

        //count number of column in excel
        int colCount = excel.getColCount();

        Object data[][] = new Object[rowCount-1][colCount];

        //iterate each row and column in excel
        for(int i=1; i<rowCount; i++) {
            for(int j=0; j<colCount; j++) {

                String cellData = excel.getCellDataString(i, j);

                data[i-1][j] = cellData;

            }

        }
        return data;

    }
    @AfterTest
    public void teardown()
    {
        driver.close();
        driver=null;
    }


}
