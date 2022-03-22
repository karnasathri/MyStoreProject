package com.mystore.dataprovider;

import org.testng.annotations.DataProvider;

import com.mystore.utility.NewExcelLibrary;

public class DataProviders {
	
	
	NewExcelLibrary obj = new NewExcelLibrary();
	
	@DataProvider(name = "Credentials1")
	public Object[][] getcredentials(){
		//Total rows count
		int rows =obj.getRowCount("Credentials1");
		//Total colums
		int column = obj.getColumnCount("Credentials1");
		int actRows = rows-1;
		Object[][] data = new Object[actRows][column];
		
		for(int i=0;i<actRows;i++) {
			for(int j=0; j<column;j++){
				data[i][j]=obj.getCellData("Credentials1",j, i+2);
			
			
		}
	}
		return data;
	

	}
}
