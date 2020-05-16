package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

	public WebDriver driver;

	private By email= new  By.ByXPath("//input[@name='email']");
	private By password= new  By.ByXPath("//input[@name='password']");
	private By submit= new  By.ByXPath("//button[@type='submit']");




	public LoginPage(WebDriver driver) {

		this.driver=driver;
	}

	public WebElement getEmail()
	{
		return driver.findElement(email);
	}
	public WebElement getPassword()
	{
		return driver.findElement(password);
	}

	public WebElement getLogin()
	{
		return driver.findElement(submit);
	}

}

