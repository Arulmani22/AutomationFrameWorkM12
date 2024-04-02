package practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RetryAnalyserPractice 
{
	@Test(retryAnalyzer = GenericUtilities.RetryAnalyserImplementation.class)
	
	public void sample()
	
	{
		Assert.fail(); // Purposely fail the script then only it will execute 3 time
		
		System.out.println("Hello World");
	}
	
	
	
}
