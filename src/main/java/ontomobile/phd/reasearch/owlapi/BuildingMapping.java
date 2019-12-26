package ontomobile.phd.reasearch.owlapi;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;

import ontomobile.phd.research.Building;
import ontomobile.phd.research.OntoMobileFactory;


public class BuildingMapping {
	static DataFormatter fmt = new DataFormatter();
	static String prefix = "http://www.semanticweb.org/daan/ontologies/2016/3/BDRTontology#";
	static Building b;
	
	public Building InstancesFromForts(Sheet sheet, int rowNumber ,  OntoMobileFactory factory){
	
		String buillding ="";
		
		Cell buildingCell = sheet.getRow(rowNumber).getCell(21);
		
		if(buildingCell!=null){
			
			buillding = FormateBuilding(fmt.formatCellValue(buildingCell));
			
		}
		
		if(!buillding.isEmpty()){
			b = factory.createBuilding(prefix+"Rottweil_(AF_V)_Forts_"+buillding);
		}
		return b;
		
	}

	private String FormateBuilding(String str) {
		String FormatedString ="";
		if(!str.isEmpty()){
			str = str.trim();
			FormatedString =str.replaceAll("\\s+", "_").toLowerCase();	
		}
		
		return FormatedString;
	}
}
