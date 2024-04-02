package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

public class Scenario4 
{

	public static void main(String[] args) throws Throwable 
	{
		
		WebDriver driver = new EdgeDriver();
		
		driver.get("http://localhost:8888/index.php?action=Login&module=Users");
		
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@name=\"user_name\"]")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@name=\"user_password\"]")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@id=\"submitButton\"]")).click();
		driver.findElement(By.xpath("//a[contains(text(),\"Contacts\")]")).click();
		driver.findElement(By.xpath("//img[@alt=\"Create Contact...\"]")).click();
		Thread.sleep(1000);
		WebElement gen = driver.findElement(By.xpath("//select[@name=\"salutationtype\"]"));
		gen.click();
		gen.sendKeys(Keys.ARROW_DOWN);
		WebElement name = driver.findElement(By.xpath("//input[@name=\"firstname\"]"));
		name.sendKeys("Dinesh");
		driver.findElement(By.name("lastname")).sendKeys("Rammoorthy");
		driver.findElement(By.xpath("//input[@name=\"account_name\"]")).sendKeys("BPO");
		WebElement sor = driver.findElement(By.xpath("//select[@name=\"leadsource\"]"));
		sor.click();
		sor.sendKeys(Keys.ARROW_DOWN);
		driver.findElement(By.id("title")).sendKeys("Customer Details");
		driver.findElement(By.xpath("//input[@name=\"department\"]")).sendKeys("Fire");
		driver.findElement(By.id("email")).sendKeys("dinesh@gmail.com");
		driver.findElement(By.id("mobile")).sendKeys("9517538526");
		driver.findElement(By.xpath("//input[@name=\"birthday\"]")).sendKeys("1993-09-20");
		driver.findElement(By.xpath("//input[@class=\"crmButton small save\"]")).click();
		String ContactHeader = driver.findElement(By.xpath("//span[@class=\"dvHeaderText\"]")).getText();
		System.out.println(ContactHeader);
	
		if (ContactHeader.contains("Rammoorthy")) 
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
