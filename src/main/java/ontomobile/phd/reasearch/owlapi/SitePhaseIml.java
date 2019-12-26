package ontomobile.phd.reasearch.owlapi;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import ontomobile.phd.research.OntoMobileFactory;
import ontomobile.phd.research.Site_Phase;

public class SitePhaseIml {
	static DataFormatter fmt = new DataFormatter();
	static Site_Phase sitePhase;
	String prefix = "http://www.semanticweb.org/daan/ontologies/2016/3/BDRTontology#";

	
	
public Site_Phase AddInstancesFromCementries(Sheet sheet1,OntoMobileFactory factory, int RowNum) {
		
		String Site_Phase = "";
		
			Cell sf = sheet1.getRow(RowNum).getCell(8);
			Site_Phase = fmt.formatCellValue(sf);
			if(Site_Phase!=""){
				Site_Phase = FormateSitePhaseString(Site_Phase);
			}
			if(!Site_Phase.isEmpty()){
				sitePhase = factory.createSite_Phase(Site_Phase);
			}
		
		
		return sitePhase;
	}
	
	public String FormateSitePhaseString(String str){
		
		String FormatedString ="";
		String StringToFormate="";
		
		
        if(str.contains("(")){
        	StringToFormate= str.substring(0,str.lastIndexOf("("));
        }
        
        if(StringToFormate.contains("/")){
        	StringToFormate = StringToFormate.substring(0,StringToFormate.lastIndexOf("/"));
        }		
        StringToFormate = StringToFormate.replaceAll("\\s+", "_");

        
		if(StringToFormate.endsWith("_") ){
			StringToFormate = StringToFormate.substring(0,StringToFormate.length()-1);
		}
		if(StringToFormate.endsWith("?")){
			StringToFormate = StringToFormate.substring(0,StringToFormate.length()-1);
		}
		if(StringToFormate.startsWith("P")){
			
			FormatedString = StringToFormate;
			
		}
		if(FormatedString !="Phase_IV_(Basisseriation);_dabei_älteres_Material" && FormatedString!="" ){
			
			FormatedString = prefix + Values.Rottweil_cemeteries_ + FormatedString;
		} 
		return FormatedString;
	}
	

}
