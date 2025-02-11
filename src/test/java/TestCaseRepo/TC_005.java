
package TestCaseRepo;

import org.testng.Assert;
import org.testng.annotations.Test;

import genericUtility.BaseClass;
import objectRepo.ContactsPage;
import objectRepo.CreateContactsPage;
import objectRepo.HomePage;

public class TC_005 extends BaseClass{

	@Test(groups= {"Sanity","Regression"})
	public void contacts_004() throws Exception
	{
		System.out.println("Test execution started");
		HomePage hp=new HomePage(driver);
		hp.clickOnContactMenuBtn();

		ContactsPage cp=new ContactsPage(driver);
		cp.clickOnCreateContactPlusIcon();

		String fname=eUtil.fetchingDataFromExcelFile("Contacts",8, 1);
		String lname=eUtil.fetchingDataFromExcelFile("Contacts",8, 2);
		String title=eUtil.fetchingDataFromExcelFile("Contacts",8, 3);
		String email=eUtil.fetchingDataFromExcelFile("Contacts",8, 4);
		String mailingCity=eUtil.fetchingDataFromExcelFile("Contacts",8, 4);
		String mailingState=eUtil.fetchingDataFromExcelFile("Contacts",8, 4);


		CreateContactsPage ccp=new CreateContactsPage(driver);
		ccp.createContactOperation(fname, lname, title, email, mailingCity, mailingState);
		System.out.println("Test execution ended");



	}
	@Test(retryAnalyzer=genericUtility.RetryAnalyzerImplementation.class)
	public void parallelTest()
	{
     // Assert.fail();
	}

}
