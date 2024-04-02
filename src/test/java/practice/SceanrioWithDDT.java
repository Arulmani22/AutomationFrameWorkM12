package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

public class SceanrioWithDDT
{

	public static void main(String[] args) throws Throwable 
	{
		//Read the data form property file
		FileInputStream fisp = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		Properties p = new Properties();
		p.load(fisp);
		String Url = p.getProperty("url");
		String Username = p.getProperty("username");
		String Password = p.getProperty("password");
		
		//Read the data from excel file
		FileInputStream fise = new FileInputStream(".\\src\\test\\resources\\Test Case Data.xlsx");
		Workbook wb = WorkbookFactory.create(fise);
		String LASTNAME = wb.getSheet("ContactCreation").getRow(5).getCell(2).getStringCellValue();
		//browser lunching
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//Login into the application
		driver.get("Url");
		driver.findElement(By.xpath("//input[@name=\"user_name\"]")).sendKeys("Username");
		driver.findElement(By.xpath("//input[@name=\"user_password\"]")).sendKeys("Password");
		driver.findElement(By.xpath("//input[@id=\"submitButton\"]")).click();
		//Navigate to the contact 
		driver.findElement(By.xpath("//a[contains(text(),\"Contacts\")]")).click();
		//Create Contact
		driver.findElement(By.xpath("//img[@alt=\"Create Contact...\"]")).click();
		//Create with mandatory text field LastName
		driver.findElement(By.name("lastname")).sendKeys("LASTNAME");
		driver.findElement(By.xpath("//input[@class=\"crmButton small save\"]")).click();
		
		//Validate the contact
		String ContactHeader = driver.findElement(By.xpath("//span[@class=\"dvHeaderText\"]")).getText();
		System.out.println(ContactHeader);

		if (ContactHeader.contains("LASTNAME")) 
		{
			System.out.println("Pass");
		}
		else
		{
			System.out.println("Fail");
		}
		
		WebElement ele = driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]"));
		
		Actions act = new Actions(driver);
		act.moveToElement(ele).perform();
		Thread.sleep(1000);
		driver.findElement(By.linkText("Sign Out")).click();
		driver.quit();
		
				
		
	}

}
