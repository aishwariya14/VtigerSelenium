package TestCaseRepo;

import org.testng.annotations.Test;

import genericUtility.BaseClass;
import objectRepo.CreatingNewLeadPage;
import objectRepo.HomePage;
import objectRepo.LeadsPage;

public class TC_002 extends BaseClass {

	@Test(groups= {"Smoke","Sanity"})
	public void leads_001() throws Exception
	{
		System.out.println("Test execution started");
		HomePage hp=new HomePage(driver);
		hp.clickOnLeadMenuBtn();

		LeadsPage lp=new LeadsPage(driver);
		lp.clickOnCreateLeadsPlusIcon();

		
		String fname=eUtil.fetchingDataFromExcelFile("Leads",5, 1);
		String lname=eUtil.fetchingDataFromExcelFile("Leads",5, 2);
		String company=eUtil.fetchingDataFromExcelFile("Leads",5, 3);
		String phone=eUtil.fetchingDataFromExcelFile("Leads",5, 4);
		String website=eUtil.fetchingDataFromExcelFile("Leads",5, 5);
		
		CreatingNewLeadPage cnlp=new CreatingNewLeadPage(driver);
		cnlp.createNewLead(fname, lname, company, phone, website);
		System.out.println("Test execution ended");

	}











}
