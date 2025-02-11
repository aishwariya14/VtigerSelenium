package TestCaseRepo;

import org.testng.annotations.Test;

import genericUtility.BaseClass;
import objectRepo.ContactsPage;
import objectRepo.CreateContactsPage;
import objectRepo.HomePage;

public class TC_004 extends BaseClass{
	
	@Test(groups= {"Sanity"})
	public void contacts_004() throws Exception
	{
		System.out.println("Test execution started");
		HomePage hp=new HomePage(driver);
		hp.clickOnContactMenuBtn();

		ContactsPage cp=new ContactsPage(driver);
		cp.clickOnCreateContactPlusIcon();
		
		String fname=eUtil.fetchingDataFromExcelFile("Contacts",5, 1);
		String lname=eUtil.fetchingDataFromExcelFile("Contacts",5, 2);
		String title=eUtil.fetchingDataFromExcelFile("Contacts",5, 3);
		String email=eUtil.fetchingDataFromExcelFile("Contacts",5, 4);
		
		CreateContactsPage ccp=new CreateContactsPage(driver);
		ccp.createContactOperation(fname, lname, title, email);
		System.out.println("Test execution ended");
		
		
		
	}

}
