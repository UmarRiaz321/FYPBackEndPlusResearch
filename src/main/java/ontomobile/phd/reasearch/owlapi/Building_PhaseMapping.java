package ontomobile.phd.reasearch.owlapi;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;

import ontomobile.phd.research.Building_Phase;
import ontomobile.phd.research.OntoMobileFactory;


public class Building_PhaseMapping {
    static Building_Phase bp;
	static DataFormatter fmt = new DataFormatter();
	static String prefix = "http://www.semanticweb.org/daan/ontologies/2016/3/BDRTontology#";

	
public Building_Phase AddInsFromForts(Sheet sheet, OntoMobileFactory factory, int RowNum){
	
	String BuildingPhase = "";
	
	Cell BuildingPaseCell = sheet.getRow(RowNum).getCell(26);
	
	if(BuildingPaseCell!=null){
		BuildingPhase =fmt.formatCellValue(BuildingPaseCell);
		if(!BuildingPhase.isEmpty()){
			BuildingPhase = BuildingPhase.replaceAll("\\s+", "");
			bp = factory.createBuilding_Phase(prefix + "Rottweil_Forts_I_II_"+BuildingPhase);
			
		}
	}
	
	return bp;
} 
}
