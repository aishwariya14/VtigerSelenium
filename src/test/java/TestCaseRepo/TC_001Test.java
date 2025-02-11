
package TestCaseRepo;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import genericUtility.BaseClass;
import objectRepo.CreatingNewLeadPage;
import objectRepo.HomePage;
import objectRepo.LeadsPage;
//@Listeners(genericUtility.ListenersImplementation.class)
public class TC_001Test extends BaseClass{
	
	@Test(groups= {"Smoke"})
   public void leads_001() throws Exception
   {
	   System.out.println("Test execution started");
	   HomePage hp=new HomePage(driver);
	   hp.clickOnLeadMenuBtn();
	   
	   //Assert.fail();
	   
	   LeadsPage lp=new LeadsPage(driver);
	   lp.clickOnCreateLeadsPlusIcon();
	   
	   String lname=eUtil.fetchingDataFromExcelFile("Leads",2, 1);
	   String company=eUtil.fetchingDataFromExcelFile("Leads",2, 2);
	   CreatingNewLeadPage cnlp=new CreatingNewLeadPage(driver);
	   cnlp.createNewLead(lname,company);
	   System.out.println("Test execution ended");
	   
   }
}
