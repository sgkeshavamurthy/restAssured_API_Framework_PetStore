package api.utilities;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class DataLoader {
	@DataProvider (name = "dataForPOST")
	public String[][] DataMatrix() {

	    String filename = "C:\\Users\\hp\\eclipse-workspace\\RestAssuredFramework-17Feb\\ArtifactID_RestAssuredProject\\src\\test\\java\\api\\testdata\\TestData.xlsx";
	    String sheetname = "Sheet1";

	    try {
	        FileInputStream excelStream = new FileInputStream(filename);
	        XSSFWorkbook excelWorkbook = new XSSFWorkbook(excelStream);
	        XSSFSheet excelSheet = excelWorkbook.getSheet(sheetname);

	        int lastRowIndex = excelSheet.getLastRowNum();  // no +1
	        int colCount = excelSheet.getRow(0).getLastCellNum();

	        String[][] dataMatrix = new String[lastRowIndex][colCount];

	        DataFormatter formatter = new DataFormatter();

	        for (int i = 1; i <= lastRowIndex; i++) {
	            for (int j = 0; j < colCount; j++) {
	                dataMatrix[i - 1][j] =
	                        formatter.formatCellValue(
	                                excelSheet.getRow(i).getCell(j));
	            }
	        }

	        excelWorkbook.close();
	        excelStream.close();

	        return dataMatrix;

	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return null;
	}
	

}
