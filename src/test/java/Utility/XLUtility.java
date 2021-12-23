package Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLUtility {
	
	public FileInputStream fi;
	public FileOutputStream fo;
	public XSSFWorkbook workbook;
	public XSSFSheet sheet;
	public XSSFRow row;
	public XSSFCell cell;
	public CellStyle style;
	String path=null;
	
	public XLUtility(String path){
		this.path=path;
	}
	
	public void open(String sheetName) throws IOException {
		File file= new File(path);
		fi=new FileInputStream(file);
		workbook= new XSSFWorkbook(fi);
		sheet=workbook.getSheet(sheetName);
	}
	
	public void close() throws IOException {
		workbook.close();
		fi.close();
	}
	
	public int getRowCount(String sheetName) throws IOException  {
		open(sheetName);
		int rowcount=sheet.getLastRowNum();
		close();
		return rowcount;
	}
	
	public int getCellCount(String sheetName, int rownum) throws IOException {
		open(sheetName);
		row=sheet.getRow(rownum);
		int cellcount=row.getLastCellNum();
		close();
		return cellcount;
	}
	
	public String getCellData(String sheetName,int rownum,int colnum) throws IOException {
		open(sheetName);
		row=sheet.getRow(rownum);
		cell=row.getCell(colnum);
		
		DataFormatter formatter= new DataFormatter();
		String data;
		try {
			data= formatter.formatCellValue(cell);
		} catch (Exception e) {
			data="";
		}
		close();
		return data;	
	}
	
	public void setCellData(String sheetName, int rownum, int colnum, String data) throws IOException {
		open(sheetName);
		fo= new FileOutputStream(path);
		row=sheet.getRow(rownum);
		cell=row.createCell(colnum);
		cell.setCellValue(data);
		fo=new FileOutputStream(path);
		workbook.write(fo);
		close();
		fo.close();
	}
	
	public void fillGreenColor(String sheetName, int rownum, int colnum) throws IOException {
		open(sheetName);
		fo= new FileOutputStream(path);
		row=sheet.getRow(rownum);
		cell=row.getCell(colnum);
		style=workbook.createCellStyle();
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		style.setFillForegroundColor(IndexedColors.GREEN.getIndex());
		cell.setCellStyle(style);
		workbook.write(fo);
		close();
		fo.close();
	}
	
		
	public void fillRedColor(String sheetName, int rownum, int colnum) throws IOException {
		open(sheetName);
	    fo= new FileOutputStream(path);
		row=sheet.getRow(rownum);
		cell=row.getCell(colnum);
		style=workbook.createCellStyle();
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        style.setFillForegroundColor(IndexedColors.RED.getIndex());
		cell.setCellStyle(style);
		workbook.write(fo);
		close();
		fo.close();
	}
	
	public void fillRedColor(String sheetName, int f) throws IOException {
		open(sheetName);
		row=sheet.getRow(1);
		int a=row.getLastCellNum();
	    fo= new FileOutputStream(path);
		row=sheet.getRow(f+1);
		cell=row.getCell(a-1);
		style=workbook.createCellStyle();
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        style.setFillForegroundColor(IndexedColors.RED.getIndex());
		cell.setCellStyle(style);
		workbook.write(fo);
		close();
		fo.close();
	}
	
	public void fillGreenColor(String sheetName, int f) throws IOException {
		open(sheetName);
		row=sheet.getRow(1);
		int a=row.getLastCellNum();
	    fo= new FileOutputStream(path);
		row=sheet.getRow(f+1);
		cell=row.getCell(a-1);
		style=workbook.createCellStyle();
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        style.setFillForegroundColor(IndexedColors.GREEN.getIndex());
		cell.setCellStyle(style);
		workbook.write(fo);
		close();
		fo.close();
		
	}
	
	
}
