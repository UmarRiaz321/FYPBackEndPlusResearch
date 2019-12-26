package ontomobile.phd.reasearch.owlapi;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;

import ontomobile.phd.research.Form_Label;
import ontomobile.phd.research.OntoMobileFactory;

public class FormLabelMapping {
	static Form_Label flabel;
	static DataFormatter fmt = new DataFormatter();
	static String prefix = "http://www.semanticweb.org/daan/ontologies/2016/3/BDRTontology#";
	
	public Form_Label AddInsFromForts(Sheet sheet, OntoMobileFactory factory, int RowNum){
		String FormLabel ="";
		
		Cell FormLabelCell = sheet.getRow(RowNum).getCell(18);
		
		if(FormLabelCell != null){
			
			FormLabel = fmt.formatCellValue(FormLabelCell);
		}
		if(!FormLabel.isEmpty()){
			FormLabel = FormLabel.trim();
			FormLabel = FormLabel.replaceAll("\\s+", "_").toLowerCase();
			
			flabel = factory.createForm_Label(prefix+FormLabel);
		}
		return flabel;
	}
	
	public Form_Label AddInsFromCementry(Sheet sheet, OntoMobileFactory factory, int RowNum){
		
String FormLabel ="";
		
		Cell FormLabelCell = sheet.getRow(RowNum).getCell(12);
		
		if(FormLabelCell != null){
			
			FormLabel = fmt.formatCellValue(FormLabelCell);
		}
		if(!FormLabel.isEmpty()){
			FormLabel = FormLabel.trim();
			FormLabel = FormLabel.replaceAll("\\s+", "_").toLowerCase();
			
			flabel = factory.createForm_Label(prefix+FormLabel);
		}
		return flabel;
	}
}
