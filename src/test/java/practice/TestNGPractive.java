package practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGPractive
{
	/*@Test (invocationCount = 3)// it will execute tries in a time
	
	public void createCustomer()
	{
		System.out.println("create");
	}
	
	@Test//(priority = 1)//it will execute like -and+ after put the (priority)
	
	public void modifyCustomer()
	{
		System.out.println("modify");
	}
	
	@Test (invocationCount = 0) // it will not accept the 0 and negative value
	public void deleteCustomer()
	{
		System.out.println("delete");
	}*/
	
	
	//***************************************************************************
	
	/*@Test (enabled = false) // it will skipped the script execution
	
	public void createCustomer()
	{
		System.out.println("create");
	}
	
	@Test 
	
	public void modifyCustomer()
	{
		System.out.println("modify");
	}
	
	@Test (invocationCount = 0)// it will skipped the script execution
	public void deleteCustomer()
	{
		System.out.println("delete");
	}*/
	//***************************************************************************
	
	@Test 
	
	public void createCustomer()
	{
		Assert.fail(); // Purposely failing this entire method
		System.out.println("create");
	}
	
	@Test (dependsOnMethods = "createCustomer") //the string should be method name it will depend on first method
	
	public void modifyCustomer()
	{
		System.out.println("modify");
	}
	
	@Test
	public void deleteCustomer()
	{
		System.out.println("delete");
	}
	
	
}
