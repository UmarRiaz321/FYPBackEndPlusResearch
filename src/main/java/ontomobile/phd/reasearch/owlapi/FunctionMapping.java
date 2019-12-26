package ontomobile.phd.reasearch.owlapi;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import ontomobile.phd.research.Function;
import ontomobile.phd.research.OntoMobileFactory;

public class FunctionMapping {

	static Function func;
	static DataFormatter fmt = new DataFormatter();
	static String prefix = "http://www.semanticweb.org/daan/ontologies/2016/3/BDRTontology#";
	
	public Function AddInsFromForts(Sheet sheet, OntoMobileFactory factory, int RowNum, int CellNum){
		String Function = "";
		
		Cell FunctionCell = sheet.getRow(RowNum).getCell(CellNum);
		
		if(FunctionCell != null){
			
			Function  = fmt.formatCellValue(FunctionCell);
		}
		
		
		if(!Function .isEmpty()){
			Function  = Function.trim();
			Function  = Function.replaceAll("\\s+", "_").toLowerCase();
			
			func = factory.createFunction(prefix+Function);
		}
		
		return func;
	}
	
	public Function AddInsFromCementry(Sheet sheet, OntoMobileFactory factory, int RowNum, int CellNum){
		String Function = "";
		
		Cell FunctionCell = sheet.getRow(RowNum).getCell(CellNum);
		
		if(FunctionCell != null){
			
			Function  = fmt.formatCellValue(FunctionCell);
		}
		
		
		if(!Function .isEmpty()){
			Function  = Function.trim();
			Function  = Function.replaceAll("[\\s|\\u00A0]+", "_").toLowerCase();
			
			func = factory.createFunction(prefix+Function);
		}
		
		return func;
	}


}
