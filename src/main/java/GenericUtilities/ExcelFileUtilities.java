package GenericUtilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * This class consists of generic methods related to property file
 * @author Arulmani P
 * 
 */
public class ExcelFileUtilities 
{
	/**
	 * This method will read data from excel file and return the value to caller
	 * @param sheetName
	 * @param rowno
	 * @param celno
	 * @return
	 * @throws IOException 
	 */
	public String  readDataFromExcelFile(String sheetName, int rowno, int celno) throws IOException
	{
			
		FileInputStream fise = new FileInputStream(".\\src\\test\\resources\\Test Case Data.xlsx");
		Workbook wb = WorkbookFactory.create(fise);
		String value =  wb.getSheet(sheetName).getRow(rowno).getCell(celno).getStringCellValue();
		return value;
		
		
		 
	}
	
	
}
