package date;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Datepp {
	
	//public static final int IMPLICITLY_TIME = 10;//CONSTANT
	//public static final int PAGE_LOAD_TIME = 10;//CONSTANT

	public String main() {
		
		Date date11 = new Date();
		
		String date1 = date11.toString().replace(" ", "_").replace(":","_");
		
		System.out.print(date1);
		
		return date1;

	}
	
	public Object[][] exceldata(String excelSheet) {
		
		String excelFile = System.getProperty("user.dir")+"\\src\\main\\java\\testdata\\excel.xlsx";
		
		File file = new File(excelFile);
		
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		XSSFWorkbook workbook = null;
		try {
			workbook = new XSSFWorkbook(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		XSSFSheet doc = workbook.getSheet(excelSheet);
		
		int rows = doc.getLastRowNum();//getLastRowNum() e za brojot na redovi vo fajlot
		
		int columns = doc.getRow(0).getLastCellNum();
		
		Object[][] data1 = new Object[rows][columns];
		
		for(int i=0;i<rows;i++) {
			
			XSSFRow row11 = doc.getRow(i+1);
			
			for(int c=0;c<columns;c++) {
				
				XSSFCell col1 = row11.getCell(c);
				
				 CellType celltype = col1.getCellType();
				
				switch(celltype) {
				
				case STRING:
					
					data1[i][c] = col1.getStringCellValue();
					
					break;
				
				case NUMERIC:
					
					data1[i][c] = Integer.toString((int)col1.getNumericCellValue());
					
					break;
				
				case BOOLEAN:
					
					data1[i][c] = col1.getBooleanCellValue();
					
					break;
				
				}
			 
			}
			
		}
		
		return data1;
		
		
	}

}
