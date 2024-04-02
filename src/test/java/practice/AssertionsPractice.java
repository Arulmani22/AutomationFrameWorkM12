package practice;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertionsPractice
{

	
	@Test
	
	
	public void sample()
	{
		
		/*String a = "hello";
	
		System.out.println("Step 1");
		System.out.println("Step 2");
		System.out.println("Step 3");
	
		Assert.assertEquals(1, 1);// condition should be satisfy then it will get pass
		
		Assert.assertTrue(a.contains("o"));// in case condition satisfied then rest program will execute. if not program will terminatied
	
		System.out.println("Step 4");
		System.out.println("Step 5");*/
	
		String a1 = "hi";
		
		System.out.println("Step 1");
		System.out.println("Step 2");
		System.out.println("Step 3");
	
		Assert.assertEquals(1 , 2);// condition should be satisfy then it will get pass
		
		Assert.assertTrue(a1.contains("o"));// in case condition satisfied then rest program will execute. if not program will terminatied
	
		System.out.println("Step 4");
		System.out.println("Step 5");
	
}
	

	@Test
	public void sample1()
	{
		
	SoftAssert sa = new SoftAssert();
		String a = "hi";
					
		System.out.println("Step 1");
		System.out.println("Step 2");
		System.out.println("Step 3");
	
		sa.assertEquals(0, 1);// after gave the wrong input still it is getting pass the script
		sa.assertTrue(a.contains("i"));
		sa.assertAll();// after giving the asserAll() then only the error will capture
		System.out.println("Step 4");
		System.out.println("Step 5");
	
	
	
	
	}
	
}
