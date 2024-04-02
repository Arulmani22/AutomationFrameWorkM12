package contactsTests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import GenericUtilities.ExcelFileUtilities;
import GenericUtilities.PropertyFileUtilities;
import GenericUtilities.SeleniumUtilites;
import objectRepository.ContactInfoPage;
import objectRepository.ContactPage;
import objectRepository.CreateNewContactPage;
import objectRepository.HomePage;
import objectRepository.LoginPage;

public class CreateNewContactTest01
{
	@Test
	public void createContactWithMandatoryField1() throws IOException, InterruptedException
	{
		 PropertyFileUtilities pUtil = new PropertyFileUtilities();
		  ExcelFileUtilities eUtil = new ExcelFileUtilities();
		  SeleniumUtilites sUtil = new SeleniumUtilites();
		
		  	String URL = pUtil.readDataFromPropertieFile("url");
			String USERNAME = pUtil.readDataFromPropertieFile("username");
			String PASSWORD = pUtil.readDataFromPropertieFile("password");
			
			//Read the data from excel file
			
			String LASTNAME = eUtil.readDataFromExcelFile("ContactCreation (2)", 5, 2);
			
			//Step :1 Launching the Browser
			//browser lunching
			WebDriver driver = new EdgeDriver();
			sUtil.maximuzeWindow(driver);
			sUtil.addImplicitWait(driver);	
			
			driver.get(URL);
			
			//Login into the application
			
			LoginPage lp = new LoginPage(driver);
			lp.loginToApp(USERNAME, PASSWORD);
			
			//Step :3 navigate to contact link
			HomePage hp = new HomePage(driver);
			hp.clickOnContactLink();
			
			//Step :4 Click on create contact link
			ContactPage cp = new ContactPage(driver);
			cp.clickoncreateContactLookUpImg();
			
			//Step :5 Create contact with mandatory field
			CreateNewContactPage ccp = new CreateNewContactPage(driver);
			ccp.createNewContact(LASTNAME);
			 
			//Step : 6 validate for contact
			ContactInfoPage cip = new ContactInfoPage(driver);
			String ContactHeader = cip.captureHeaderText();
			
			System.out.println(ContactHeader);
			
			if (ContactHeader.contains(LASTNAME)) 
			{
				System.out.println("Pass");
			}
			else
			{
				System.out.println("Fail");
			}
			
			//Step :7 logout of APP
			hp.logoutOfApp(driver);
		
			//Step :8 close the browser
			driver.quit();
	}

	
	
}
