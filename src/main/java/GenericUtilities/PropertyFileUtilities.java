package GenericUtilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * This class consists of generic methods related to property file
 * @author Arulmani P
 * 
 */
public class PropertyFileUtilities
{
	/**
	 * This will read the data from property file and return the value
	 * @param key
	 * @return
	 * @throws IOException
	 */
	public  String readDataFromPropertieFile(String key) throws IOException 
	
	{
		FileInputStream fisp = new FileInputStream(".\\src\\test\\resources\\CommonData1.properties");
		Properties p = new Properties();
		p.load(fisp);
		String value = p.getProperty(key);
		return value;
		
	}
	
		
	
}

