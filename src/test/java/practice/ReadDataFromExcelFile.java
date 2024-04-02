package practice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromExcelFile
{

	public static void main(String[] args) throws IOException
	{
		// Step:1 Open the document in java readable format
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\Test Case Data.xlsx");
		//Step:2 Create workbook
		Workbook wb = WorkbookFactory.create(fis);	
		//Step:3 navigate to required sheet
        Sheet sh = wb.getSheet("ContactCreation");
		//Step:4 Navigate to required row
		Row rw = sh.getRow(5);
		//Step:5 Navigate to required cell
		Cell cl = rw.getCell(2);
		//Step:6 Capture the data
		String value = cl.getStringCellValue();	
		System.out.println(value);
		//step:7 close the workbook
		wb.close();
		

	}

}
