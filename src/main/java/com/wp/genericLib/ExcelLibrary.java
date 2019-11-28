package com.wp.genericLib;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelLibrary {
	public static FileInputStream fis=null;
	public static FileOutputStream fos=null;
	public static Workbook wb=null;
	public static Sheet s=null;
	public static Row r=null;
	public static Cell c=null;

	public static String getExcelData(String sheetName,int rowNum,int cellNum){
		String retVal=null;
		ConfigFileReader configFileReader = new ConfigFileReader();
		String environment=configFileReader.getEnvironment();
		try {
			if(environment.equalsIgnoreCase("production")){
				fis = new FileInputStream("datafiles/data_production.xlsx");
			}
			else{
				fis = new FileInputStream("datafiles/data_staging.xlsx");
			}
			
			wb = WorkbookFactory.create(fis);
			s = wb.getSheet(sheetName);
			r = s.getRow(rowNum);	
			c = r.getCell(cellNum);
			retVal = c.getStringCellValue();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return retVal;
	}



	public int getRowCount(String sheetName){
		int rowCount=0;
		try {
			fis = new FileInputStream("datafiles/data.xlsx");
			wb = WorkbookFactory.create(fis);
			s = wb.getSheet(sheetName);		
			rowCount = s.getLastRowNum();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return rowCount;
	}



	public void writeToExcel(String sheetName, int rowNum, int cellNum, String data){
		try {
			fis = new FileInputStream("datafiles/data.xlsx");
			wb = WorkbookFactory.create(fis);
			s = wb.getSheet(sheetName);
			r = s.getRow(rowNum);
			c = r.createCell(cellNum);
			c.setCellValue(data);
			fos = new FileOutputStream("datafiles/data.xlsx");
			wb.write(fos);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


}

