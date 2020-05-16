package Tests;

import Base.TestBase;
import Utility.ReuseableMethods;
import Utility.TestUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.*;
import pageObjects.TRFPage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class Trf extends TestBase {

    public static Logger log = LogManager.getLogger(TestBase.class.getName());



    @BeforeSuite
    public void initialize() throws IOException {
        driver = launchBrowser("myBrowser");
        log.info("Successfully browser is launched");


    }
   @BeforeTest
   public void getPage()
   {

       TRFPage tf = new TRFPage(driver);
       driver.get(prop.getProperty("url"));
       log.info("Url is open");
       driver.manage().window().maximize();

       ReuseableMethods.timelapsImplicitWait(driver);

       tf.Email().sendKeys(prop.getProperty("username"));



       tf.Password().sendKeys(prop.getProperty("password"));

       tf.Login().click();
       tf.getTrf().click();
       log.info("Successfully click on TRF Tab");

       tf.addTRF().click();
       log.info("Successfully click on Add Tab");

       tf.Department();
       log.info("The Department is added");

       tf.BU();
       log.info("Business Unit is added");

       tf.Technology().sendKeys("Automation Testing");
       log.info("Technology is added");

       tf.Designation();
       log.info("Designation is added");

       tf.Qualification();
       tf.Qualification();
       log.info("Qualification is added");


   }


    @DataProvider
    public Iterator<Object[]> getData()

    {
       ArrayList<Object[]> testdata = (ArrayList<Object[]>) TestUtil.getDataFromExcel();
       return testdata.iterator();
    }

       @Test(dataProvider = "getData")
        public void getDetail( String CTC, String Vacancy ,  String Mandatory_Skills, String Skills,
                               String Responsiblities, String Reporting_Manager, String Experience, String Traits, String Authorized_By) {

        TRFPage tf = new TRFPage(driver);
        tf.ctc().clear();
        tf.ctc().sendKeys(CTC);
        log.info("CTC is added");

        tf.vacancy().clear();
        tf.vacancy().sendKeys(Vacancy);
        log.info("Vacancy is added");

        tf.skills().clear();
        tf.skills().sendKeys(Mandatory_Skills);
        log.info("Desired skill added");

        tf.technicalskills().clear();
        tf.technicalskills().sendKeys(Skills);



        tf.responsibilities().clear();
        tf.responsibilities().sendKeys(Responsiblities);
        log.info("Technical skill added");

        tf.rm().clear();
        tf.rm().sendKeys(Reporting_Manager);
        log.info("Responsibilities is added ");

        tf.exp().clear();
        tf.exp().sendKeys(Experience);
           log.info("Experience is added");


           tf.traits().clear();
        tf.traits().sendKeys(Traits);
           log.info("Personality Attribute is added");

        tf.By().clear();
        tf.By().sendKeys(Authorized_By);
           log.info("Authorized body is added");





       }

    @AfterTest
    public void teardown()
    {
        driver.close();
        driver=null;

    }


}
