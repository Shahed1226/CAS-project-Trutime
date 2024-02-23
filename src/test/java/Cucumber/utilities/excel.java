package Cucumber.utilities;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class excel {
	public  static void exceldata(List<String>dates,List<String>legend) throws IOException {
		FileOutputStream fp=new FileOutputStream(System.getProperty("user.dir")+"\\output\\excel.xlsx");
		XSSFWorkbook wb=new XSSFWorkbook();
		XSSFSheet sheet=wb.createSheet("sheet1");
		int count=0;
		for(int i=0;i<dates.size();i++) {
			XSSFRow row=sheet.createRow(i);
			row.createCell(0).setCellValue(dates.get(i));
			count++;
		}
		for(int i=1;i<legend.size();i+=2) {
			XSSFRow row=sheet.createRow(count);
			row.createCell(0).setCellValue(legend.get(i));
			count++;
		}
		wb.write(fp);
		wb.close();
		fp.close();
	}
}

