package ontomobile.phd.reasearch.owlapi;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;

import ontomobile.phd.research.Date_Range;
import ontomobile.phd.research.OntoMobileFactory;

public class DateRangeMapping {
	static String prefix = "http://www.semanticweb.org/daan/ontologies/2016/3/BDRTontology#";
	static DataFormatter fmt = new DataFormatter();
	static Date_Range dr;
	
	
	public Date_Range AddingInstanceFromForts(Sheet sheet, OntoMobileFactory factory, int RowNum, int CellNum){
		
		String DateRange = "";
		
		Cell DateRangeCell = sheet.getRow(RowNum).getCell(CellNum);
		
		if(DateRangeCell!=null){
			
			DateRange = FormateDateRange(fmt.formatCellValue(DateRangeCell));
		}
		
		if(!DateRange.isEmpty()){dr = factory.createDate_Range(prefix+DateRange);}
		
		return dr;
	}
	
	public Date_Range AddingInstanceFromCementry(Sheet sheet, OntoMobileFactory factory, int RowNum, int CellNum){
		
		String DateRange = "";
		
		Cell DateRangeCell = sheet.getRow(RowNum).getCell(CellNum);
		
		if(DateRangeCell!=null){
			
			DateRange = FormateDateRange(fmt.formatCellValue(DateRangeCell));
		}
		
		if(!DateRange.isEmpty()){dr = factory.createDate_Range(prefix+DateRange);}
		
		return dr;
	}


	private String FormateDateRange(String str) {
		
		String FormatedString ="";
		
		if(str.isEmpty()){
		 str = str.trim();
		 FormatedString.replaceAll("\\s+","");
		}
		return FormatedString;
	}
	
	
}
