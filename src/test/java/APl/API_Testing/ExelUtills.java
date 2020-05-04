package APl.API_Testing;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExelUtills {
	
	public static FileInputStream fi ;
	public static FileOutputStream fo ;
	public static XSSFWorkbook wb;
	public static XSSFSheet sh;
	public static XSSFRow row ;
	public static XSSFCell cell;
	
	public static int getrowcount (String xlpath , String sheetname ) throws IOException  {
		fi = new FileInputStream(xlpath);
		wb = new XSSFWorkbook (fi);
		sh = wb.getSheet(sheetname);
		int rowcount=sh.getLastRowNum();
		
		wb.close();
		fi.close();
		return rowcount;
		
		
	}
	public static int getcelcount (String xlpath , String sheetname , int rownum ) throws IOException {
		fi = new FileInputStream(xlpath);
		wb = new XSSFWorkbook (fi);
		sh = wb.getSheet(sheetname);
		row=sh.getRow(rownum);
		int cellcount =row.getLastCellNum();
		wb.close();
		fi.close();
		return cellcount;
	}
	public static String getcelldata (String xlpath , String sheetname , int rownum , int cellnum) throws IOException {
		fi = new FileInputStream(xlpath);
		wb = new XSSFWorkbook (fi);
		sh = wb.getSheet(sheetname);
		row=sh.getRow(rownum);
		cell =row.getCell(cellnum);
		String data;
		try {
			
			DataFormatter format = new DataFormatter();
			String celldata = format.formatCellValue(cell);
			return celldata;
			
		}catch(Exception e) {
			data ="";
			
			
		}
		wb.close();
		fi.close();
		return sheetname;
		
		
		
	}
	public String setcelldata (String xlpath , String sheetname , int rownum , int cellnum,String data) throws IOException {
		fi = new FileInputStream(xlpath);
		wb = new XSSFWorkbook (fi);
		sh = wb.getSheet(sheetname);
		row=sh.getRow(rownum);
		cell =row.createCell(cellnum);
		cell.setCellValue(data);
		fo = new FileOutputStream(xlpath);
		wb.write(fo);
		fo.close();
		return data;
		
	}
	
	

}
