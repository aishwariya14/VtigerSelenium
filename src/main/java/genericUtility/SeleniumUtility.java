package genericUtility;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.google.common.io.Files;


/**
 * This is an Utility class which contains generic methods selinium library
 */


public class SeleniumUtility {
    
	public void accesToApplication(WebDriver driver,String URL) 
	{
	
        driver.get(URL);
    
    }
	/** 
	 * This is generic method to perform browser maximization
	 * @param driver
	 */

    public void maximizeWindow(WebDriver driver) 
    {
    	driver.manage().window().maximize();
    }
    /**
     * This is generic method to apply implicit wait to the script
     * @param driver
     * @param maxTime
     */
    
    public void implicitWait(WebDriver driver,int maxTime)
    {
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(maxTime));
    }
    
    //////////*********Handling Dropdown*******//////////
    
    /**
     * This is generic method to select an option in a drop down using index
     * @param dropdownElement
     * @param index
     */
    
    public void selectOptionUsingIndex(WebElement dropdownElement,int index) 
    {
    	Select sel=new Select(dropdownElement);
    	sel.selectByIndex(index);
    }
    
    
    /**
     * This is generic method to select an option in a drop down using value attribute
     * @param dropdownElement
     * @param value
     */
    
    public void selectOptionUsingValueAttribute(WebElement dropdownElement,String value) 
    {
    	Select sel=new Select(dropdownElement);
    	sel.selectByValue(value);
    }
    
    /**
     * This is generic method to select an option in a drop down using value visible text
     * @param dropdownElement
     * @param value
     */
    
    public void selectOptionUsingVisibleText(WebElement dropdownElement,String visibleText) 
    {
    	Select sel=new Select(dropdownElement);
    	sel.selectByValue(visibleText);
    }
    
    ///////////******Handling Alert*******////////////////
    
    /**
     * This is a generic method to accept the alert popup
     * @param driver
     */
    
    public void acceptAlert(WebDriver driver)
    {
    	driver.switchTo().alert().accept();
    }
    
    /**
     * This is a generic method to dismiss the alert popup
     * @param driver
     */
    
    public void dismissAlert(WebDriver driver)
    {
    	driver.switchTo().alert().dismiss();
    }
    
    /**
     * This is a generic method to fetch the alert message from the alert popup
     * @param driver
     */
    
    public String getAlertMessage(WebDriver driver)
    {
    	String alertMessage=driver.switchTo().alert().getText();
    	return alertMessage;
    }
    
    /**
     * This is a generic method to pass the value to the alert popup
     * @param driver
     */
    
    public void sendValueToAlert(WebDriver driver, String value)
    {
    	driver.switchTo().alert().sendKeys(value);
    }

    /////////*****Handling Mouse Actions*****//////////
    
    /**
     * This is a generic method to perform mouse hovering action on a webelement
     * @param driver
     * @param element
     */
    public void mouseHoveringAction(WebDriver driver,WebElement element)
    {
    	Actions act=new Actions(driver);
    	act.moveToElement(element).perform();
    }
    
    /**
     * This is a generic method to perform double click action on a webelement
     * @param driver
     * @param element
     */
    
    public void doubleClickAction(WebDriver driver,WebElement element) {
    	
    	Actions act=new Actions(driver);
    	act.doubleClick(element).perform();
    	
    }
    
    //////////////****Handling Frames ****///////////////
    
    /**
     * This is a generic method to switch the driver control to a frame using index
     * @param driver
     * @param index
     */
    
    public void switchToAFrameUsingIndex(WebDriver driver,int index)
    {
    	driver.switchTo().frame(index);
    }
    
    /**
     * This is a generic method to switch the driver control to a frame using name or id attribute
     * @param driver
     * @param index
     */
    
    public void switchToAFrameUsingNameOrId(WebDriver driver,String nameorIdAttribute)
    {
    	driver.switchTo().frame(nameorIdAttribute);
    }
    
    /**
     * This is a generic method to switch the driver control to a frame using frame element
     * @param driver
     * @param index
     */
    
    public void switchToAFrameUsingNameOrId(WebDriver driver,WebElement frameElement)
    {
    	driver.switchTo().frame(frameElement);
    }
    
    /**
     * This is a generic method to take the screenshot of a webpage
     * @param driver
     * @param index
     * @return 
     * @throws IOException 
     */
    
    public String getWebPageScreenshot(WebDriver driver,String dateTimeStamp) throws IOException
    {
    	TakesScreenshot ts=(TakesScreenshot)driver;
    	File src=ts.getScreenshotAs(OutputType.FILE);
    	File dest=new File(".\\Sreenshot\\image-"+dateTimeStamp+".png");
    	Files.copy(src, dest);
        return dest.getAbsolutePath();   //used in Listeners
    }
    
    
    
    
    
    
    
}


