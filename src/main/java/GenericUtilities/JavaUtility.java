package GenericUtilities;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * This class consist of Java specific generic methods
 * @author Arulmani P
 */
public class JavaUtility 
{
	/**
	 * This method will generate the system date in required format
	 * @return
	 */
	public String getDate()
	{
		Date d = new Date();
		SimpleDateFormat f = new SimpleDateFormat("dd-MM-yy hh-mm-ss");
		String date = f.format(d);
		return date;
		
		
		
	}
	
}
