package ontomobile.phd.reasearch.owlapi;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import ontomobile.phd.research.Archaeological_Context;
import ontomobile.phd.research.Coordinates;
import ontomobile.phd.research.OntoMobileFactory;
import ontomobile.phd.research.Site_Phase;

public class ArchaeologicalContextImpl {
	
	
	static DataFormatter fmt = new DataFormatter();
	static Archaeological_Context ac;
	static Coordinates cord;
	static String prefix = "http://www.semanticweb.org/daan/ontologies/2016/3/BDRTontology#";
	static Site_Phase sitePhase;
	
	SitePhaseIml Simp = new SitePhaseIml();
	
	public Archaeological_Context AddInstancesFromForts(Sheet sheet ,OntoMobileFactory factory, int RowNum,int CellNum)  {
	
			String ArcheologyContex = "";
			Cell  ArcheologyContexCell = sheet.getRow(RowNum).getCell(CellNum);
			if(ArcheologyContexCell != null){
				ArcheologyContex = FormateContex(fmt.formatCellValue(ArcheologyContexCell));
			}
			/// Adding Instances
			if(!ArcheologyContex.isEmpty()){
				
				ac = factory.createArchaeological_Context(prefix + Values.Rottweil_Forts_+ArcheologyContex);
			}
		
		   return ac;
			
	}
	
	private String FormateContex(String str) {
		String FormatedString = "";
		
		if(!str.isEmpty()){
			if(str.contains("Keller")){str = str.substring(0,str.indexOf("("));}
			if(str.contains("Latrine")){str = str.substring(0,str.indexOf("("));}
			if(str.contains("Feuerstelle")){str = str.substring(0,str.indexOf("("));}
			
			str = str.trim();
			FormatedString = str.replaceAll("\\s+", "").toLowerCase();
		}

		return FormatedString;
	}

	
   public Archaeological_Context AddInstanceFromCementry(Sheet sheet1,OntoMobileFactory factory,int RowNum){
	   String ArechelogyContext = "";
	   Cell ArechelogyContextCell = sheet1.getRow(RowNum).getCell(0);
	   
	   if(ArechelogyContextCell!=null){
		   ArechelogyContext = fmt.formatCellValue(ArechelogyContextCell);
	   }
	   if(!ArechelogyContext.isEmpty()){
		   if(ArechelogyContext.contains(",")){
		    	 ArechelogyContext = ArechelogyContext.substring(0,ArechelogyContext.lastIndexOf(","));
		     }
		     if(ArechelogyContext.contains("(")){
		    	 ArechelogyContext = ArechelogyContext.substring(0,ArechelogyContext.lastIndexOf("("));
		     }
		     
		     ArechelogyContext = ArechelogyContext.replaceAll("\\s+", "_");
		     
		     ac = factory.createArchaeological_Context(prefix + Values.Rottweil_cemeteries_ + ArechelogyContext);
	   }
	   return ac;
   }
   ///// Mapping From Cementries
	public void MappingFromCementries( Sheet sheet1,OntoMobileFactory factory){
		String ArechelogyContext = "";
		String Context_number = "";
		String Type_Of_Context = "";
		String Has_Refrance ="";
		String Grave_Description="";
		String Feature_Description="";
		
			for(int i = 1 ;i<7745; i++){
				Cell ContextNumber = sheet1.getRow(i).getCell(0);
				Cell TypeOfContext = sheet1.getRow(i).getCell(1);
				Cell Reference = sheet1.getRow(i).getCell(2);
				//Cell ElevationLimit = sheet1.getRow(i).getCell(3);
				Cell GraveDescription = sheet1.getRow(i).getCell(6);
				Cell FeaturDescrition = sheet1.getRow(i).getCell(7);
				     Type_Of_Context = fmt.formatCellValue(TypeOfContext );
				     ArechelogyContext = fmt.formatCellValue(ContextNumber);
				    // Elevation = fmt.formatCellValue(ElevationLimit);
				     Has_Refrance = fmt.formatCellValue(Reference);
				     Grave_Description = fmt.formatCellValue(GraveDescription);
				     Feature_Description = fmt.formatCellValue(FeaturDescrition);
				     //////////////////////////////// Formation
				     if(ArechelogyContext.contains(",")){
				    	 ArechelogyContext = ArechelogyContext.substring(0,ArechelogyContext.lastIndexOf(","));
				     }
				     if(ArechelogyContext.contains("(")){
				    	 ArechelogyContext = ArechelogyContext.substring(0,ArechelogyContext.lastIndexOf("("));
				     }
				     
				     ArechelogyContext = ArechelogyContext.replaceAll("\\s+", "_");
				     if(ArechelogyContext!= ""){
				    	 String[] r = ArechelogyContext.split("_");
					     Context_number = r[1];
				     }
				     

				     ///////////////// Adding to AC 
				     if(ArechelogyContext!= ""){
				        ac = factory.createArchaeological_Context(prefix + Values.Rottweil_cemeteries_ + ArechelogyContext);
				        }  
				     if(Context_number!= ""){ac.addHas_Context_Number(Context_number );}
				     if(Type_Of_Context!=""){ac.addType_of_Archaeological_Context(Type_Of_Context);}
				     if(Has_Refrance!="")  {ac.addHas_Reference(Has_Refrance);}
				     if(Grave_Description!=""){
				    	 Grave_Description = FormateGraveDec(Grave_Description);
				    	 ac.addHas_Description(Grave_Description); 
				     }
				     if(Feature_Description!=""){ 
				    	 Feature_Description = FormateFeaturDescription(Feature_Description);
				    	 ac.addHas_Description(Feature_Description);	 
				     }
				     
				    /// Adding Object Property
				     

				     
			}
			
		}		

	public String FormateGraveDec(String str){
	
		return  "Grave Description("+str+")";
		
	}
	
	public String FormateFeaturDescription(String str){
		return  "Feature Description("+str+")";
	}
	
	
	

}
