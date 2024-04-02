package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactPage
{
	//Rule 1 : Create a separate POM class every WebPage
	
	//Rule 2 : identify the web element by using @FindBy and make them private
	
	@FindBy(xpath = "//img[@src=\"themes/softed/images/btnL3Add.gif\"]")
	private WebElement CreateContactLookUpImg;
	
	
	//Rule 3 : Create a Constructor for initialization 
	
	public ContactPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		
	}
	
	//Rule 4 : Provide getters right click --->source--->getters

	public WebElement getContactEdt()
	{
		return CreateContactLookUpImg;
	}
	
	//business library
	/**
	 * This method will click on create contact
	 */
	public void clickoncreateContactLookUpImg()
	{
		CreateContactLookUpImg.click();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
