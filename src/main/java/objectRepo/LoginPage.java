package objectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * 
 * @author-Sumit Saurav
 * @version-08-01-25
 */
public class LoginPage {
	@FindBy(xpath="//input[@name='user_name']") private WebElement un;
	@FindBy(xpath="//input[@name='user_password']") private WebElement pwd;
	@FindBy(id="submitButton") private WebElement submitBtn;
	public WebElement getUn() {
		return un;
	}
	public WebElement getPwd() {
		return pwd;
	}
	public WebElement getSubmitBtn() {
		return submitBtn;
	}
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	/**
	 * This is a Bussiness Library/User Defined Methods for LoginPage Operations
	 * @param un
	 * @param pwd
	 */
	public void loginToApplication(String username,String password)
	{
		getUn().sendKeys(username);
		getPwd().sendKeys(password);
		getSubmitBtn().click();
	}
	
	
	
}
