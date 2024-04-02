package practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

import GenericUtilities.ExcelFileUtilities;
import GenericUtilities.PropertyFileUtilities;
import GenericUtilities.SeleniumUtilites;
import objectRepository.LoginPage;

public class Scenario1WithDDTAndGU
{

	public static void main(String[] args) throws IOException, Throwable
	{
		//Create Object of all Utility Class
		
		  PropertyFileUtilities pUtil = new PropertyFileUtilities();
		  ExcelFileUtilities eUtil = new ExcelFileUtilities();
		  SeleniumUtilites sUtil = new SeleniumUtilites();
		
		  	String URL = pUtil.readDataFromPropertieFile("url");
			String USERNAME = pUtil.readDataFromPropertieFile("username");
			String PASSWORD = pUtil.readDataFromPropertieFile("password");
			
			//Read the data from excel file
			
			String LASTNAME = eUtil.readDataFromExcelFile("ContactCreation", 5, 2);
		
			//browser lunching
			WebDriver driver = new EdgeDriver();
			sUtil.maximuzeWindow(driver);
			sUtil.addImplicitWait(driver);
			
			//Login into the application
			driver.get(URL);
			
			//driver.findElement(By.xpath("//input[@name=\"user_name\"]")).sendKeys("USERNAME");
			//driver.findElement(By.xpath("//input[@name=\"user_password\"]")).sendKeys("PASSWORD");
			//driver.findElement(By.xpath("//input[@id=\"submitButton\"]")).click();
			
			//POM Implementation
			LoginPage lp = new LoginPage(driver);
			lp.loginToApp(USERNAME, PASSWORD);
			
			
		/*	lp.getUserNameEdt().sendKeys(USERNAME);
			lp.getPasswordEdt().sendKeys(PASSWORD);
			lp.getSubmitBtn().click();*/
			
			
			
			
			//Navigate to the contact 
			driver.findElement(By.xpath("//a[contains(text(),\"Contacts\")]")).click();
			//Create Contact
			driver.findElement(By.xpath("//img[@alt=\"Create Contact...\"]")).click();
			//Create with mandatory text field LastName
			driver.findElement(By.name("lastname")).sendKeys(LASTNAME);
			driver.findElement(By.xpath("//input[@class=\"crmButton small save\"]")).click();
			
			//Validate the contact
			String ContactHeader = driver.findElement(By.xpath("//span[@class=\"dvHeaderText\"]")).getText();
			System.out.println(ContactHeader);

			if (ContactHeader.contains(LASTNAME)) 
			{
				System.out.println("Pass");
			}
			else
			{
				System.out.println("Fail");
			}
			
			WebElement ele = driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]"));
			
			sUtil.handleMouseAction(driver, ele);
			Thread.sleep(1000);
			driver.findElement(By.linkText("Sign Out")).click();
			driver.quit();
			
		
		
	}

}
