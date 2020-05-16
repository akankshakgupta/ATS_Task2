package pageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;



public class TRFPage {

    private WebDriver driver;

    private By email= new  By.ByXPath("//input[@name='email']");
    private By password= new  By.ByXPath("//input[@name='password']");
    private By login= new  By.ByXPath("//button[@type='submit']");
    private By trf = new By.ByXPath("//p[contains(text(),'TRF Management')]");
    private  By add = new By.ByXPath("//p[contains(text(),'Add TRF')]");
    private By department = new By.ByXPath("//select[@id='department_id']");
    private  By bu = new By.ByXPath("//select[@id='buhead']");
    private  By  technology = new By.ByXPath("//input[@placeholder='Technology']");
    private  By designation = new By.ByXPath("//select[@id='designation']");
    private  By qualification = new By.ByXPath("//input[@class='select2-search__field']");
    private   By ctc = new By.ByXPath("//input[@placeholder='CTC Range']");
    private  By vacancy = new By.ByXPath("//input[@placeholder='Total number of Vacancies']");
    private  By skills = new By.ByXPath("//textarea[@placeholder='Mandatory Technical Skills.']");
    private  By technicalskill = new By.ByXPath("//textarea[@placeholder='Good to have Technical Skills.']");
    private  By responsibilities = new By.ByXPath("//textarea[@placeholder='Responsibilities.']");
    private  By manager = new By.ByXPath("//input[@placeholder='Reporting Manager']");
    private  By exp = new By.ByXPath("//input[@placeholder='Experience']");
    private  By attribute = new By.ByXPath("//textarea[@placeholder='Personality Attributes/ Traits.']");
    private  By authorize = new By.ByXPath("//input[@placeholder='Authorized Body']");



    public TRFPage (WebDriver driver) {

        this.driver=driver;
    }

    public WebElement Email()
    {
        return driver.findElement(email);
    }
    public WebElement Password()
    {
        return driver.findElement(password);
    }
    public WebElement Login()
    {
        return driver.findElement(login);
    }

    public WebElement getTrf()
    {
        return driver.findElement(trf);
    }
    public WebElement addTRF()
    {
        return driver.findElement(add);
    }

    public void Department()
    {
        Select dep = new Select(driver.findElement(department));
        dep.selectByValue("16");
    }
    public void BU()
    {

        Select bunit = new Select(driver.findElement(bu));
        bunit.selectByVisibleText("QA");
    }
    public WebElement Technology()
    {
        return driver.findElement(technology);

    }
    public void Designation()
    {
        Select bu = new Select(driver.findElement(designation));
        bu.selectByVisibleText("Quality Engineer");

    }
    public void Qualification()
    {
        WebElement textbox = driver.findElement(qualification);
        textbox.sendKeys(Keys.ENTER);



    }
    public WebElement ctc()
    {
        return driver.findElement(ctc);
    }

    public WebElement vacancy()
    {
        return driver.findElement(vacancy);
    }

    public WebElement skills()
    {
        return driver.findElement(skills);
    }
    public WebElement technicalskills()
    {
        return driver.findElement(technicalskill);
    }
    public WebElement responsibilities()
    {
        return driver.findElement(responsibilities);
    }
    public WebElement rm()
    {
        return driver.findElement(manager);
    }
    public WebElement exp()
    {
        return driver.findElement(exp);
    }
    public WebElement traits()
    {
        return driver.findElement(attribute);
    }
    public WebElement By()
    {
        return driver.findElement(authorize);
    }


}
