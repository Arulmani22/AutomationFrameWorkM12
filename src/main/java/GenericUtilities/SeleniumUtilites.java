package GenericUtilities;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

/**
 * This class consists of generic methods related to Selenium web driver
 * @author Arulmani P
 */
public class SeleniumUtilites
{
	/**
	 * This method will maximize the window
	 * @param driver
	 */

	public void maximuzeWindow(WebDriver driver)
	{
		driver.manage().window().maximize();
	
	}
	
	/**
	 * This method will minimize the window
	 * @param driver
	 */
	public void manimizeWindow(WebDriver driver)
	{
		driver.manage().window().minimize();
	
	}
	
	/**
	 * This method will add 10 seconds of implictWait 
	 * @param driver
	 */
	public void addImplicitWait(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	/**
	 * This method will wait for 10 seconds for a web element to be visible
	 * @param driver
	 * @param element
	 */
	public void waitForElementToBeVissible(WebDriver driver, WebElement element, String url)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		wait.until(ExpectedConditions.visibilityOf(element));
		wait.until(ExpectedConditions.elementToBeClickable(element));
		wait.until(ExpectedConditions.elementToBeSelected(element));
		wait.until(ExpectedConditions.urlToBe(url));
	}
	
	/**
	 * This method will handle drop down by index
	 * @param element
	 * @param index
	 */
	
	public void handleDropDown(WebElement element, int index)
	{
		Select sel = new Select(element);
		sel.selectByIndex(index);
	}
	/**
	 * This method will handle drop down by string value
	 * @param element
	 * @param value
	 */
	
	public void handleDropDown(WebElement element, String value)
	{
		Select sel = new Select(element);
		sel.selectByValue(value);
	}
	
	/**
	 * This method will handle drop down by visible text
	 * @param element
	 * @param text
	 */
	public void handleDropDown(String text, WebElement element)
	{
		Select sel = new Select(element);
		sel.selectByVisibleText(text);
		
	}
		
	/**
	 * This method will perform mouse over action on a WebElment
	 * @param driver
	 * @param element
	 */
	public void handleMouseAction(WebDriver driver, WebElement element)
	{
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
	}
	/**
	 * This method will perform right click action on web page
	 * @param driver
	 */
	
	public void rightClickAction(WebDriver driver)
	{
		Actions act = new Actions(driver);
		act.contextClick().perform();
	}
	
	/**
	 * This method will perform double Click action on web page
	 * @param driver
	 */
	public void doubleClickAction(WebDriver driver)
	{
		Actions act = new Actions(driver);
		act.doubleClick().perform();
	}
	
	/**
	 * This method will perform drag and drop Action on Web page
	 * @param driver
	 * @param src
	 * @param dst
	 */
	public void dragAndDropAction(WebDriver driver, WebElement src, WebElement dst)
	{
		Actions act = new Actions(driver);
		act.dragAndDrop(src, dst).perform();
	}
	/**
	 * This method will perform scroll action on web page
	 * @param driver
	 * @param element
	 */
	public void scrollToElementAction(WebDriver driver, WebElement element)
	{
		Actions act = new Actions(driver);
		act.scrollToElement(element).perform();
	}
	
	/**
	 * This will handle the scroll down action by 500 units
	 * @param driver
	 */
	public void scrollDownAction(WebDriver driver)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("Windows.scrollBy(0,500)", " , ");
	}
	
	/**
	 * This will handle the scroll UP action by 500 units
	 * @param driver
	 */
	public void scrollUPAction(WebDriver driver)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("Windows.scrollBy(0,-500)", " , ");
	}
	/**
	 * This will handle the frame by using index
	 * @param driver
	 * @param frameIndex
	 */
	public void handleFrame(WebDriver driver, int frameIndex) 
	{
		driver.switchTo().frame(frameIndex);
	}
	
	/**
	 * This will handle the frame by using nameorID
	 * @param driver
	 * @param nameorId
	 */
	public void handleFrame(WebDriver driver, String nameorId) 
	{
		driver.switchTo().frame(nameorId);
	}
	/**
	 * This will handle the frame by using element
	 * @param driver
	 * @param element
	 */
	public void handleFrame(WebDriver driver , WebElement element) 
	{
		driver.switchTo().frame(element);
	}
	/**
	 * This will handle the parent frame
	 * @param driver
	 */
	public void handleFrameByParents(WebDriver driver)
	{
		driver.switchTo().parentFrame();
	}
	/**
	 * This will handle the from by using default content
	 * @param driver
	 */
	public void bcakToTheFrame(WebDriver driver) 
	{
		driver.switchTo().defaultContent();
	}
	/**
	 * This will handle the PopUpAlert
	 * @param driver
	 */
	public void alertPopUp(WebDriver driver) 
	{
		driver.switchTo().alert();
	}
	/**
	 * This will handle the cancel the PopUp
	 * @param driver
	 */
	public void cancelAlert(WebDriver driver) 
	{
		driver.switchTo().alert().dismiss();
	}
	/**
	 * This will handle the accept PopUp
	 * @param driver
	 */
	public void acceptPopUp(WebDriver driver) 
	{
		driver.switchTo().alert().accept();
	}
	/**
	 * This will handle the enter text alert PopUp
	 * @param driver
	 * @param Text
	 */
	public void enterTextAlert(WebDriver driver, String Text)
	{
		driver.switchTo().alert().sendKeys(Text);
	}
	/**
	 * This will handle the alert text and return it to caller
	 * @param driver
	 * @return
	 */
	public String getAlertText(WebDriver driver) 
	{
		return driver.switchTo().alert().getText();
	}
	
	/**
	 * This method will capture the screenshots and return the path to the caller
	 * @param driver
	 * @param ScreenShotName
	 * @return
	 * @throws IOException
	 */
	public String captureTheScreenShot(WebDriver driver, String ScreenShotName) throws IOException 
	{
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dst = new File(".\\ScreenShots\\"+ScreenShotName+".png");

		Files.copy(src, dst);
		
		//Used for extend the reports
		return dst.getAbsolutePath();	
	}
	/**
	 * This will handle by using with keyBoardSelectClass
	 * @param driver
	 * @param element
	 */

	public void handlingKeyBoardAerrowUp(WebDriver driver, WebElement element) 
	{
		Actions act = new Actions(driver); 
		act.sendKeys(Keys.ARROW_UP);
		
	}
	
	/**
	 * This will handle by using with keyBoardSelectClass
	 * @param driver
	 * @param element
	 */
	public void handlingKeyBoardAerrowDown(WebDriver driver, WebElement element) 
	{
		Actions act = new Actions(driver); 
		act.sendKeys(Keys.ARROW_DOWN);
		
	}
	/**
	 * This will handle by using with keyBoardRobotClass
	 * @param driver
	 * @throws Throwable
	 */
	public void handlingKeyUsingWithRobotClass(WebDriver driver) throws Throwable
	{
		Robot rbt = new Robot();
		rbt.keyPress(KeyEvent.VK_DOWN);
		rbt.keyRelease(KeyEvent.VK_DOWN);
	}
	
	
}


