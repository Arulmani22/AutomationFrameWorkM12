package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage
{
	//Rule 1 : Create a separate POM class every WebPage
	
	//Rule 2 : identify the web element by using @FindBy and make them private
	@FindBy(name = "user_name")
	private WebElement userNameEdt;
	
	@FindBy (name = "user_password")
	private WebElement passwordEdt;
	
	@FindBy (id = "submitButton")
	private WebElement submitBtn;
	
	//Rule 3 : Create a Constructor for initialization 
	
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//Rule 4 : Provide getters right click --->source--->getters
	public WebElement getUserNameEdt() {
		return userNameEdt;
	}

	public WebElement getPasswordEdt() {
		return passwordEdt;
	}

	public WebElement getSubmitBtn() {
		return submitBtn;
	}
	
	// Business Library - generic method
	
	public void loginToApp(String username , String password) 
	{
		userNameEdt.sendKeys(username);
		passwordEdt.sendKeys(password);
		submitBtn.click();
	}
	
	
	
	
}
