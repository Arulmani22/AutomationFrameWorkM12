package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import GenericUtilities.SeleniumUtilites;

public class CreateNewContactPage extends SeleniumUtilites
{
		//Rule 1 : Create a separate POM class every WebPage
	
		//Rule 2 : identify the web element by using @FindBy and make them private
	
	@FindBy(name ="lastname")
	private WebElement LastNameEdt;
	
	@FindBy(name ="leadsource")
	private WebElement leadDropdown;
	
	@FindBy (name = "button")
	private WebElement SaveBtn;
	
		//Rule 3 : Create a Constructor for initialization 
	public CreateNewContactPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
		//Rule 4 : Provide getters right click --->source--->getters
	public WebElement getLastnameEdt() {
		return LastNameEdt;
	}

	public WebElement getLeadDdn() {
		return leadDropdown;
	}

	public WebElement getSaveBtn() {
		return SaveBtn;
	}
	
	/**
	 * This method will create new contact
	 * @param lastname
	 */
	
	public void createNewContact(String lastname)
	
	{
		LastNameEdt.sendKeys(lastname);
		SaveBtn.click();
	}
	
	
	public void createNewContact(String lastname , String leadSourceValue)
	{
		LastNameEdt.sendKeys(lastname);
		handleDropDown(leadDropdown, leadSourceValue);
		SaveBtn.click();
	}
	
	
	
}
