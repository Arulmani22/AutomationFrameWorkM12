package GenericUtilities;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
import objectRepository.HomePage;
import objectRepository.LoginPage;
/**
 * This class consists of basic configuration annotation of TestNG
 * @author Arulmani P
 */
	public class BaseClass 
{
	public PropertyFileUtilities pUtil = new PropertyFileUtilities();
	public ExcelFileUtilities eUtil = new ExcelFileUtilities();
	public SeleniumUtilites sUtil = new SeleniumUtilites();
	public WebDriver driver;
	
	//For Listeners 
	public static WebDriver sDriver;
	
	@BeforeSuite(groups = {"SmokeSuite","RegressionSuite"})
	
	public void bsConfig()
	{
		System.out.println("====DB Connection Successful====");
	}
	
	//@Parameters("browser")
	//@BeforeTest
	@BeforeClass(alwaysRun = true)
	public void bcConfig(/*String BROWSER*/) throws IOException
	{
		String URL = pUtil.readDataFromPropertieFile("url");
		//driver = new EdgeDriver();
		//if (BROWSER.equals("edge"))
		//{
		//driver = new EdgeDriver();
		//}
		//else if (BROWSER.equals("chrome"))
		//{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		//}
		//else
		//{
		//	driver = new EdgeDriver();
		//}
		sUtil.maximuzeWindow(driver);
		sUtil.addImplicitWait(driver);
		driver.get(URL);
		
		//For Listeners
		sDriver=driver;
		
		
		System.out.println("===== Browser lauch successful ====");
	}

	@BeforeMethod(alwaysRun = true)
	public void bmConfig() throws IOException 
	{
		String USERNAME = pUtil.readDataFromPropertieFile("username");
		String PASSWORD = pUtil.readDataFromPropertieFile("password");
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);
		System.out.println("===== Login to App Successful ====");
	}

	@AfterMethod(alwaysRun = true)
	public void amConfig() throws InterruptedException 
	{
		HomePage hp = new HomePage(driver);
		hp.logoutOfApp(driver);
		System.out.println("==== Logout of App Successfull ====");
	}

	//@AfterTest
	@AfterClass(alwaysRun = true)
	public void acConfig()
	{
		driver.quit();
		System.out.println("===== Browser closure successful ====");
	}

	@AfterSuite(alwaysRun = true)
	public void asConfig()
	{
		System.out.println("===== DB closure successful =====");
	}






}
