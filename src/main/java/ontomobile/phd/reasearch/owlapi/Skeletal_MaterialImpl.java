package ontomobile.phd.reasearch.owlapi;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;

import ontomobile.phd.research.OntoMobileFactory;
import ontomobile.phd.research.Skeletal_Material;

public class Skeletal_MaterialImpl {

	static DataFormatter fmt = new DataFormatter();
	String prefix = "http://www.semanticweb.org/daan/ontologies/2016/3/BDRTontology#";
	static Skeletal_Material sm;
	
	
	public void AddDataProperties(Sheet sheet1, OntoMobileFactory factory){
		
		
		
		for(int i = 1 ;i<7745; i++){
		
		String Weight = "";
		String Description ="";
		
		Cell weight = sheet1.getRow(i).getCell(9);
		Cell DescriptionCell = sheet1.getRow(i).getCell(10);
		if(weight!= null){Weight = FormateWeight(fmt.formatCellValue(weight));}
		
		if(!Weight.isEmpty()){
	       sm = factory.createSkeletal_Material(prefix+i);
			sm.addHas_weight(Float.parseFloat(Weight));
		}
		 if(DescriptionCell!=null){
			 Description = fmt.formatCellValue(DescriptionCell);
		 }
		 if(!Description.isEmpty()){
			 
			 sm.addHas_Description(Description);
		 }
		}
		
	}
	
	public String FormateWeight(String str){
		String	FormatedString ="";
		if(!str.isEmpty()){
			if(!Character.isDigit(str.charAt(0))){
				int i =0;
				while(i < str.length() && !Character.isDigit(str.charAt(i))) i++;
				if(!str.isEmpty()){
				FormatedString = str.substring(i,str.length()).trim();}
			}
			else
			{
				FormatedString = str.trim();
			}
			if(!FormatedString.isEmpty()){
				
				if(FormatedString.contains("g")){
					FormatedString = FormatedString.replace("g","").trim();
				}
				if(FormatedString.contains("(")){
					FormatedString = FormatedString.substring(0,FormatedString.indexOf("(")).trim();
				}
				if(FormatedString.contains(";")){
					
					String[] newS = FormatedString.split(";");
					FormatedString = newS[0].trim();
				}
	           if(FormatedString.contains(",")){
					FormatedString = FormatedString.replace(",", ".").trim();
				}
	           if(FormatedString.endsWith(". unbestimmt") || FormatedString.endsWith(". eher weiblich. spätjuvenil-matur") ){
	        	   
	        	   FormatedString = FormatedString.substring(0,FormatedString.indexOf(" ")).trim();
	           }
	           if(FormatedString.contains(" ")){
	        	   FormatedString = FormatedString.substring(0,FormatedString.indexOf(" ")).trim();
	           }
			}
			
			
		}
		
		return FormatedString;
		
	} 

}
