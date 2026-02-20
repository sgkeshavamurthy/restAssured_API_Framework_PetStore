package api.utilities;
import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.ss.usermodel.DataFormatter;


public class utility_readExcel {
	
	FileInputStream excelStream;
	XSSFWorkbook excelWorkbook;
	XSSFSheet excelSheet;
	XSSFCell excelCell;
	
	
	public int get_rowCount(String filename, String sheetname)
	{
		int rcount = 0;
		try 
		{
			excelStream = new FileInputStream(filename);
			excelWorkbook = new XSSFWorkbook(excelStream);
			excelSheet = excelWorkbook.getSheet(sheetname);
			rcount = excelSheet.getLastRowNum();
		}
		catch (Exception e)
		{
			return 0;
		}
		return rcount;
	}
	public int get_columnCount(String filename, String sheetname)
	{
		int ccount = 0;
		try
		{
			excelStream = new FileInputStream(filename);
			excelWorkbook = new XSSFWorkbook(excelStream);
			excelSheet = excelWorkbook.getSheet(sheetname);
			ccount = excelSheet.getRow(0).getLastCellNum();
			
		}
		catch (Exception e)
		{
			return 0;
			
		}
		return ccount;
		
	}
	public String get_Rowvalue(String filename, String sheet, int rowno, int columnno)
	{
		String rValue = "";
		try
		{
			DataFormatter formatter = new DataFormatter();
	//		String cellValue = formatter.formatCellValue(excelCell);
	//		System.out.print("inside try : " + rowno + columnno);
			excelStream = new FileInputStream(filename);
			excelWorkbook = new XSSFWorkbook(excelStream);
			excelSheet = excelWorkbook.getSheet(sheet);
			excelCell = excelSheet.getRow(rowno).getCell(columnno);
		//	rValue = excelCell.getStringCellValue();
			
			rValue = formatter.formatCellValue(excelCell);
			
		}
		catch (Exception e)
		{
			System.out.println("Exception found: " + e.getMessage());
		}
		
		return rValue;
	}
	

}
