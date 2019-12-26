package ontomobile.phd.reasearch.owlapi;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;

import ontomobile.phd.research.Fragment;
import ontomobile.phd.research.Fragment_Type;
import ontomobile.phd.research.OntoMobileFactory;

public class Fragment_TypeMapping {

	static DataFormatter fmt = new DataFormatter();
	static String prefix = "http://www.semanticweb.org/daan/ontologies/2016/3/BDRTontology#";
	static Fragment_Type  Frt ;
	static Fragment fragment ;
	public void addInstances(Sheet sheet1,OntoMobileFactory factory){
	
		for(int i = 1; i<7746; i++){
			String FragmentBSCellValue="";
			String FragmentRsCellValue="";
			String FragmentFragCellValue="";
			String FragmentCellValue = "";
			String ArtefactContext = "";
			String ArtefactName="";
			Cell FragmentWSCell = sheet1.getRow(i).getCell(19);
			Cell FragmentBSCell  = sheet1.getRow(i).getCell(20);
			Cell FragmentRSCell = sheet1.getRow(i).getCell(21);
			Cell FragmentFragCell = sheet1.getRow(i).getCell(22);
			Cell AretfactInstance = sheet1.getRow(i).getCell(11);
			if(FragmentWSCell!=null){
				FragmentCellValue = FormateCellValue(fmt.formatCellValue(FragmentWSCell));
			}
			if(FragmentRSCell!=null){
				FragmentRsCellValue = FormateBSCellValue(fmt.formatCellValue(FragmentRSCell));
			}
			if(FragmentFragCell!=null){
				FragmentFragCellValue = FormateBSCellValue(fmt.formatCellValue(FragmentFragCell));
			}
		
			if(FragmentBSCell != null){
				FragmentBSCellValue = FormateBSCellValue(fmt.formatCellValue(FragmentBSCell));
			}
			if(AretfactInstance!= null)
	        {
				ArtefactContext = FormateArtefactString(fmt.formatCellValue(AretfactInstance));
		    }
			if(!ArtefactContext.isEmpty()){
				ArtefactName = prefix+Values.Rottweil_cemeteries_+ArtefactContext;
			}
			if(!FragmentCellValue.isEmpty()){
				fragment = factory.createFragment(ArtefactName+"_Fragment_"+FragmentCellValue);
			}
			if(!FragmentBSCellValue.isEmpty()){
				fragment = factory.createFragment(ArtefactName+"_Fragment_"+FragmentCellValue);
			}
			if(!FragmentRsCellValue.isEmpty()){
				fragment = factory.createFragment(ArtefactName+"_Fragment_"+FragmentRsCellValue);
			}
			if(!FragmentFragCellValue.isEmpty()){
				fragment = factory.createFragment(ArtefactName+"_Fragment_"+FragmentFragCellValue);
			}
			
		}
	}
	
	public void addInstancesFromForts(Sheet sheet,OntoMobileFactory factory){
		for(int i = 1; i<1609; i++)
		 {
			String FragmentTypeWS = "";
			String FragmentTypeBS = "";
			String FragmentTypeRS = "";
			String FragmentTypeOther = "";
			String ArtefactContext="";
			
			Cell ArtefacrContextCell = sheet.getRow(i).getCell(0);
			Cell FragmentTypeWSCell = sheet.getRow(i).getCell(14);
			Cell FragmentTypeRSCell = sheet.getRow(i).getCell(15);
			Cell FragmentTypeBSCell = sheet.getRow(i).getCell(16);
			Cell FragmentTypeOtherCell = sheet.getRow(i).getCell(17);
			
			if(ArtefacrContextCell!=null){ArtefactContext = fmt.formatCellValue(ArtefacrContextCell);}
			if(FragmentTypeWSCell!=null){FragmentTypeWS = fmt.formatCellValue(FragmentTypeWSCell);}
			if(FragmentTypeRSCell!=null){FragmentTypeRS = fmt.formatCellValue(FragmentTypeRSCell);}
			if(FragmentTypeBSCell!=null){FragmentTypeBS = fmt.formatCellValue(FragmentTypeBSCell);}
			if(FragmentTypeOtherCell!=null){FragmentTypeOther = fmt.formatCellValue(FragmentTypeOtherCell);}
			
			if(!FragmentTypeWS.isEmpty()){fragment=factory.createFragment(prefix+Values.Rottweil_Forts_+ArtefactContext+"_fragment_"
					+FragmentTypeWS);}
			if(!FragmentTypeRS.isEmpty()){fragment=factory.createFragment(prefix+Values.Rottweil_Forts_+ArtefactContext+"_fragment_"
					+FragmentTypeRS);}
			if(!FragmentTypeBS.isEmpty()){fragment=factory.createFragment(prefix+Values.Rottweil_Forts_+ArtefactContext+"_fragment_"
					+FragmentTypeBS);}
			if(!FragmentTypeOther.isEmpty()){fragment=factory.createFragment(prefix+Values.Rottweil_Forts_+ArtefactContext+"_fragment_"
					+FragmentTypeOther);}
			
		 }
	}
	private String FormateBSCellValue(String str) {
		String FormatedString = str;
		if(!FormatedString.isEmpty()){
			if(FormatedString.contains(" ")){
			String[] str1 =FormatedString.split("\\S+");
			FormatedString = str1[0].trim();
			}
			if(FormatedString.endsWith("?")){FormatedString = FormatedString.substring(0,FormatedString.lastIndexOf("?"));}
			}
		return FormatedString;
	}
	private String FormateArtefactString(String str) {
		String ContextNumber ="";
		String ArtefactClass ="";
		String FormatedString = "";
		 if(str.contains(",") && !str.isEmpty()){
			   String[] artz = str.split(",");  
			   ContextNumber = artz[0].trim();
			   ArtefactClass = artz[1].trim();   
		   }
		FormatedString = ContextNumber+","+ArtefactClass;
		if(FormatedString.endsWith("(18-45 Jahre)"))
			FormatedString="";
		return FormatedString;
	}
	private String FormateCellValue(String str) {
		String FormatedString = "";
		if( Character.isDigit(str.charAt(0)) )
		{
			FormatedString = str;
		}
		if(FormatedString.contains(",")){
			FormatedString = FormatedString.substring(0,FormatedString.lastIndexOf(","));
		}
		if(!FormatedString.isEmpty()){
		if(FormatedString.contains(" ")){
		String[] str1 =FormatedString.split("\\S+");
		FormatedString = str1[0].trim();
		}
		}
		return FormatedString;
	}
	
}
