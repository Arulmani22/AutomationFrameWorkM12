package practice;

import java.io.FileInputStream;
import java.util.Properties;

public class ReadDataFromPopertyFile 
{

	public static void main(String[] args) throws Throwable 
	{
		
		// step 1: Open the document in java readable format
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\CommonData1.properties");
		
		// step 2: Create an object of properties class from java.util
		
		Properties p = new Properties();
		
		// step 3: Load the file input stream to properties
		p.load(fis);
		
		// Step 4: provide the key and read the value
		String URL = p.getProperty("url");
		String USERNAME = p.getProperty("username");
		String PASSWORD = p.getProperty("password");
		System.out.println(URL);
		System.out.println(USERNAME);
		System.out.println(PASSWORD);
		
		
		
	}

}
