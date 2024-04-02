package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInfoPage
{
		//Rule 1 : Create a separate POM class every WebPage
	
		//Rule 2 : identify the web element by using @FindBy and make them private
	
		@FindBy (xpath = "//span[@class=\"dvHeaderText\"]")
		private WebElement ContactHeaderText;
		
		//Rule 3 : Create a Constructor for initialization
		public ContactInfoPage(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}

		//Rule 4 : Provide getters right click --->source--->getters
		public WebElement getContactHed() {
			return ContactHeaderText;
		}
		
		//Business Library
		/**
		 * This method will capture the header text and return it to caller
		 * @return
		 */
		public String captureHeaderText()
		{
			return ContactHeaderText.getText();
		}
	
	
	
}
