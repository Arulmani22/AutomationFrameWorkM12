package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import GenericUtilities.SeleniumUtilites;

public class HomePage extends SeleniumUtilites
{
		//Rule 1 : Create a separate POM class every WebPage
	
		//Rule 2 : identify the web element by using @FindBy and make them private
	
	@FindBy(linkText = "Contacts")
	private WebElement contactLink;
	
	@FindBy(linkText = "Products")
	private WebElement productLink;
	
	@FindBy(xpath = "//img[@src=\"themes/softed/images/user.PNG\"]")
	private WebElement administratorImg;
		
	@FindBy(linkText = "Leads")
	private WebElement leadLink;
	
	@FindBy (linkText = "Sign Out")
	private WebElement signoutBtn;
	
	//Rule 3 : Create a Constructor for initialization 
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//Rule 4 : Provide getters right click --->source--->getters
	public WebElement getContactLink() {
		return contactLink;
	}
	public WebElement getProductLink() {
		return productLink;
	}
	public WebElement getAdministratorImg() {
		return administratorImg;
	}
	public WebElement getLeadLink() {
		return leadLink;
	}
	public WebElement getSignoutBtn() {
		return signoutBtn;
	}

	

	//Business Library
	/**
	 * This method will click on contacts link in home page
	 */
	public void clickOnContactLink()
	{
		contactLink.click();
	}
	
	
	public void logoutOfApp(WebDriver driver) throws InterruptedException 
	{
		handleMouseAction(driver, administratorImg);
		Thread.sleep(1000);
		signoutBtn.click();
	}
	
	
	
}
