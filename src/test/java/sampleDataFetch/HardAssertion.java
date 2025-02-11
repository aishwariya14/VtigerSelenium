package sampleDataFetch;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HardAssertion {
	
	@Test
	public void strictLevelHardAssertion()
	{
		String expectedName="Aishu";
		String actualName="Jagan";
//		Assert.assertEquals(actualName, expectedName);
		Assert.assertEquals(actualName.equals(expectedName), true);
		System.out.println("Validation ended");
	}
	
	@Test
	public void containsLevelHardAssertion()
	{
		String expectedName="Aishu";
		String actualName="Aishwariya";
		Assert.assertTrue(actualName.contains(expectedName));
		System.out.println("Validation ended");
	}

}



