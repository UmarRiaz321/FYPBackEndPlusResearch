package ontomobile.phd.reasearch.owlapi;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;

import ontomobile.phd.research.Inscription_OR_Stamp;
import ontomobile.phd.research.OntoMobileFactory;

public class InscriptionORStampMapping {

	static DataFormatter fmt = new DataFormatter();
	static String prefix = "http://www.semanticweb.org/daan/ontologies/2016/3/BDRTontology#";
	static Inscription_OR_Stamp ins;
	
	public Inscription_OR_Stamp addInstancesFromForts(Sheet sheet ,OntoMobileFactory factory, int RowNum){
		
		String Instances="";
		
		Cell InstancesCell = sheet.getRow(RowNum).getCell(33);
		
		if(InstancesCell!=null){
			
			Instances = FormateInstances(fmt.formatCellValue(InstancesCell));
		}
		if(!Instances.isEmpty()){
			ins = factory.createInscription_OR_Stamp(prefix+Instances);
		}
		
		return ins;

	}
	
	public Inscription_OR_Stamp addInstancesFromCementry(Sheet sheet ,OntoMobileFactory factory, int RowNum){
		
		String Instances="";
		
		Cell InstancesCell = sheet.getRow(RowNum).getCell(43);
		
		if(InstancesCell!=null){
			
			Instances = FormateInstances(fmt.formatCellValue(InstancesCell));
		}
		if(!Instances.isEmpty()){
			ins = factory.createInscription_OR_Stamp(prefix+Instances);
		}
		
		return ins;

	}

	public String FormateInstances(String str) {
		
		String FormatedString ="";
		
		if(!str.isEmpty()){
			FormatedString = str.replaceAll("\\s+", "_");
		}
		
		return FormatedString;
	}
}
