package ontomobile.phd.reasearch.owlapi;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;

import ontomobile.phd.research.Mint;
import ontomobile.phd.research.OntoMobileFactory;

public class MintMapping {
	
	static DataFormatter fmt = new DataFormatter();
	static String prefix = "http://www.semanticweb.org/daan/ontologies/2016/3/BDRTontology#";
	static Mint mnt ;
	
	
	public Mint AddInstancesFromCemetry(Sheet sheet1,OntoMobileFactory factory,int i){
	
	
		
		String MintInstance ="";
		
		Cell MintInstanceCell = sheet1.getRow(i).getCell(50);
		
		if(MintInstanceCell!= null){
			
			MintInstance = FormateInstances(fmt.formatCellValue(MintInstanceCell));
			
		}
		
		if(!MintInstance.isEmpty()){
			mnt = factory.createMint(prefix+MintInstance);
		}
		
		
		
		return mnt;
		
	}


	private String FormateInstances(String str) {
		String FormatedString ="";
		
		
		
		if(!str.isEmpty()){
			FormatedString  =str.replaceAll("\\s+", "_").trim();
		}
		if(!FormatedString.isEmpty() ){
		  if(Character.isDigit(FormatedString.charAt(0))){
			  FormatedString ="";
		  }
		}
		return FormatedString;
	}

}
