package TestCaseRepo;

import org.testng.annotations.Test;

import genericUtility.BaseClass;
import objectRepo.CreatingNewLeadPage;
import objectRepo.HomePage;
import objectRepo.LeadsPage;

public class TC_003 extends BaseClass {

	@Test(groups= {"Smoke","Regression"})
	public void leads_003() throws Exception
	{
		System.out.println("Test execution started");
		HomePage hp=new HomePage(driver);
		hp.clickOnLeadMenuBtn();

		LeadsPage lp=new LeadsPage(driver);
		lp.clickOnCreateLeadsPlusIcon();

		
		String fname=eUtil.fetchingDataFromExcelFile("Leads",8, 1);
		String lname=eUtil.fetchingDataFromExcelFile("Leads",8, 2);
		String company=eUtil.fetchingDataFromExcelFile("Leads",8, 3);
		String phone=eUtil.fetchingDataFromExcelFile("Leads",8, 4);
		String website=eUtil.fetchingDataFromExcelFile("Leads",8, 5);
		String noOfemployees=eUtil.fetchingDataFromExcelFile("Leads",8, 6);
		String country=eUtil.fetchingDataFromExcelFile("Leads",8, 7);
		String city=eUtil.fetchingDataFromExcelFile("Leads",8, 8);
		String state=eUtil.fetchingDataFromExcelFile("Leads",8, 9);
		
		
		CreatingNewLeadPage cnlp=new CreatingNewLeadPage(driver);
		cnlp.createNewLead(fname, lname, company, phone, website, noOfemployees, country, city, state);
		System.out.println("Test execution ended");

	}
}
