package sampleDataFetch;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import genericUtility.ExcelUtility;
import genericUtility.PropertiesUtility;
import genericUtility.SeleniumUtility;
import objectRepo.CreatingNewLeadPage;
import objectRepo.HomePage;
import objectRepo.LeadsPage;
import objectRepo.LoginPage;

public class TC_001Practice {
	
	@Test
	public void tc_001() throws Exception{
	
	WebDriver driver=new ChromeDriver();
	SeleniumUtility sUtil = new SeleniumUtility();
	sUtil.maximizeWindow(driver);
	sUtil.implicitWait(driver, 15);
	PropertiesUtility pUtil=new PropertiesUtility();
	String URL = pUtil.getDataFromPropertiesFile("url");
	String username = pUtil.getDataFromPropertiesFile("username");
	String password = pUtil.getDataFromPropertiesFile("password");
	sUtil.accesToApplication(driver, URL);
	
	
	LoginPage lop = new LoginPage(driver);
	lop.loginToApplication(username, password);
	
	HomePage hp=new HomePage(driver);
	hp.clickOnContactMenuBtn();
	
	LeadsPage lp=new LeadsPage(driver);
	lp.clickOnCreateLeadsPlusIcon();
	
	ExcelUtility eUtil=new ExcelUtility();
	String lname=eUtil.fetchingDataFromExcelFile("Leads", 2, 1);
	String company=eUtil.fetchingDataFromExcelFile("Leads", 2, 2);
	CreatingNewLeadPage cnlp=new CreatingNewLeadPage(driver);
	cnlp.createNewLead(lname,company);
	hp.signOutOperation(driver);  
	driver.quit();
	
	}
	

}
