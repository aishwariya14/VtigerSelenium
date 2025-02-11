package genericUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import objectRepo.HomePage;
import objectRepo.LoginPage;

public class BaseClass {

	public WebDriver driver;
	public static WebDriver sDriver; //used only in listeners
	public PropertiesUtility pUtil=new PropertiesUtility();
	public SeleniumUtility sUtil= new SeleniumUtility();
	public ExcelUtility eUtil=new ExcelUtility();
	
	@BeforeSuite(alwaysRun = true)
	public void dbconnection()
	{
		System.out.println("DB connection Successful");
	}
	
	@Parameters("browser")
	@BeforeClass(alwaysRun = true)
	public void launchBrowser(@Optional("chrome") String BROWSER) throws Exception
	{
		if(BROWSER.equals("chrome"))
		{
			driver=new ChromeDriver();
		}
		
		else if(BROWSER.equals("edge"))
		{
			driver=new EdgeDriver();
		}
		
		else if(BROWSER.equals("firefox"))
		{
			driver=new FirefoxDriver();
		}
		
		else
		{
			driver=new ChromeDriver();
		}
		
		sDriver=driver;  //initalizing static driver with actual driver to be used in listeners
		sUtil.maximizeWindow(driver);
		sUtil.implicitWait(driver, 15);
		String URL=pUtil.getDataFromPropertiesFile("url");
		sUtil.accesToApplication(driver, URL);
	}
	
	@BeforeMethod(alwaysRun = true)
	public void loginoperation() throws Exception
	{
		String UN=pUtil.getDataFromPropertiesFile("username");
		String PWD=pUtil.getDataFromPropertiesFile("password");
		LoginPage lp=new LoginPage(driver);
		lp.loginToApplication(UN, PWD);
	}
	
	@AfterMethod(alwaysRun = true)
	public void logoutOperation()
	{
		HomePage hp=new HomePage(driver);
		hp.signOutOperation(driver);
	}
	
	@AfterClass(alwaysRun = true)
	public void closeBrowser()
	{
		driver.quit();
	}
	
	@AfterSuite(alwaysRun = true)
	public void dbConnectionClosed()
	{
		System.out.println("DB disconnected");
	}
}
