package contactsTests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import GenericUtilities.BaseClass;
import objectRepository.ContactInfoPage;
import objectRepository.ContactPage;
import objectRepository.CreateNewContactPage;
import objectRepository.HomePage;

@Listeners(GenericUtilities.ListenersImpleamentation.class)
public class CreateNewContactTest02 extends BaseClass
{
	@Test(groups = "RegressionSuite")
	public void createContactWithMandatoryField() throws IOException
	{
		
			//Read the data from excel file
			String LASTNAME = eUtil.readDataFromExcelFile("ContactCreation", 5, 2);
							
			
			//Step :3 navigate to contact link
			HomePage hp = new HomePage(driver);
			hp.clickOnContactLink();
			
			//Step :4 Click on create contact link
			ContactPage cp = new ContactPage(driver);
			cp.clickoncreateContactLookUpImg();
			
			//Step :5 Create contact with mandatory field
			CreateNewContactPage ccp = new CreateNewContactPage(driver);
			ccp.createNewContact(LASTNAME);
			 
			Assert.fail();
			
			//Step : 6 validate for contact
			ContactInfoPage cip = new ContactInfoPage(driver);
			String ContactHeader = cip.captureHeaderText();
			Assert.assertTrue(ContactHeader.contains(LASTNAME));
			System.out.println(ContactHeader);
			
			
		
	}

	
	
}
