package com.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReadNew {

	public static void main(String[] args) throws IOException {
		XSSFWorkbook ExcelWBook=null;
		XSSFSheet ExcelSheet;
		XSSFRow Row;
		XSSFCell Cell;
		
		File file = new File("C:\\Users\\Moreshwar\\Desktop\\MyStoreTestcases.xlsx");
		FileInputStream fis=null;
		try {
	//create FileInputStream to read data from file
	 fis = new FileInputStream(file);
} catch (FileNotFoundException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
// create object of XSSFWorkbook to handle xlsx file
ExcelWBook= new XSSFWorkbook(fis);
ExcelSheet= ExcelWBook.getSheetAt(0);
int ttlRow=ExcelSheet.getLastRowNum()+1;
int ttlCell=ExcelSheet.getRow(0).getLastCellNum();
for(int currntRow=0;currntRow<ttlRow;currntRow++) {
	for(int currentCell=0;currentCell<ttlCell;currentCell++) {
		System.out.println(ExcelSheet.getRow(currntRow).getCell(currentCell));
	System.out.print("\n");
	}
	System.out.println();
}
try {
	ExcelWBook.close();
} catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
	}
}
