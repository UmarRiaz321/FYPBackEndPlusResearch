package ontomobile.phd.reasearch.owlapi;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;

import ontomobile.phd.research.Coordinates;
import ontomobile.phd.research.OntoMobileFactory;

public class CoordinatesMapping {

	static DataFormatter fmt = new DataFormatter();
	static MintMapping mint = new MintMapping();
	static String prefix = "http://www.semanticweb.org/daan/ontologies/2016/3/BDRTontology#";
	static Coordinates cor ;
	
	
	public void AddDataPropertiesFromCementries(Sheet sheet1, OntoMobileFactory factory){
		for(int i = 1; i<7746; i++)
		 {
			String[] X_Coordinate = null;
			String[] Elevation = null;
			String[] Y_Coordinate = null;
			String ElevationLowerLimit = "";
	
		    
		    Cell ElevationCell = sheet1.getRow(i).getCell(3);
		    Cell X_CoordinatesCell = sheet1.getRow(i).getCell(4);
		    Cell Y_CoordinatesCell = sheet1.getRow(i).getCell(5);
		    Cell ElevationLowerLimitCell = sheet1.getRow(i).getCell(52);
		    
		    if(ElevationCell!=null){
		    	Elevation = FormateCementryElevation(fmt.formatCellValue(ElevationCell));	
		    }
		    if(ElevationLowerLimitCell!=null){
		    	ElevationLowerLimit = FormateLowerElevation(fmt.formatCellValue(ElevationLowerLimitCell));
		    }
		    if(X_CoordinatesCell !=null){X_Coordinate = FormateCordinatesCementry(fmt.formatCellValue(X_CoordinatesCell));}
		    if(X_CoordinatesCell !=null){Y_Coordinate = FormateCordinatesCementry(fmt.formatCellValue(Y_CoordinatesCell));}
		    if(Elevation!=null){
		    	cor = factory.createCoordinates(prefix+Values.Rottweil_cemeteries_+i);
		    	cor.addHas_Elevation_lower_limit(Float.parseFloat(Elevation[0]));
		    	cor.addHas_Elevation_upper_limit(Float.parseFloat(Elevation[1]));
		    }
		    if(X_Coordinate!=null){
		    	cor.addHas_Lower_X_Coordinate(Float.parseFloat(X_Coordinate[0]));
		    	cor.addHas_Upper_X_Coordinate(Float.parseFloat(X_Coordinate[1]));
		    }
		    if(Y_Coordinate!=null){
		    	cor.addHas_Lower_Y_Coordinate(Float.parseFloat(Y_Coordinate[0]));
		    	cor.addHas_Upper_Y_Coordinate(Float.parseFloat(Y_Coordinate[1]));
		    }
		    if(!ElevationLowerLimit.isEmpty()){
		    	
		    	cor.addHas_Elevation_lower_limit(Float.parseFloat(ElevationLowerLimit));
		    }
		 }
		
	}

	private String FormateLowerElevation(String str) {
		String Fs ="";
		if(!str.isEmpty()){
			if(str.contains("Pl.")){
				str = str.substring(str.indexOf("."), str.length());
			}
			if(str.startsWith(".")){
				str = str.replace(".", "").trim(); 
			}
			str = str.substring(0, 1);
			if(Character.isDigit(str.charAt(0))){
				Fs = str;
			}
		}
		
		return Fs;
	}

	private String[] FormateCordinatesCementry(String str) {
		String FS ="";
		String Lower ="";
		String Upper ="";
		String[] arr =null;
		
		if(!str.isEmpty()){
			if(!Character.isDigit(str.charAt(0))){str ="";}
			if(!str.isEmpty()){
				FS =str;
			}
		}
		if(!FS.isEmpty()){
			if(FS.contains(",")){
				FS = FS.replace(",",".");
			}
			if(FS.contains("-")){
				String[] newS = FS.split("-");
				Lower = newS[0].trim();
				Upper = newS[1].trim();
			}else{Lower = FS; Upper = FS;}
		}
		if(!Lower.isEmpty() && !Upper.isEmpty()){
			
			arr = new String[]{Lower,Upper};
		}
	
		return arr;
	}

	private String[] FormateCementryElevation(String str) {
		
		String FS ="";
		String Lower ="";
		String Upper ="";
		String[] arr =null;
		if(!str.isEmpty()){
			FS = str.trim();
		}
		if(!FS.isEmpty()){
			if(FS.contains(";")){
				String[] newS = FS.split(";");
				Upper = newS[0].trim();
		        	for(int i=1; i<newS.length; i++){
		        		if(newS[i].startsWith(" Sohle")|| Character.isDigit(FS.charAt(i))){
		        			Lower = newS[i].trim();
		        		}
		        	} 
			}
		}
		
		if(!Upper.isEmpty()){
			if(Upper.contains("-")){
				String[] newS = Upper.split("-");
				Upper = newS[0].trim();
			}
			
			if(Upper.endsWith("m ü.M.")){
				Upper = Upper.replaceAll("m ü.M.", "").trim();
			}
			if(Upper.contains(":")){
				String s = Upper.substring(0,Upper.indexOf(":")+1).trim();
				Upper= Upper.replaceAll(s, "").trim();
				if(Upper.contains("(„Bef. 322“)")){ Upper = "584,63";}
			}
			if(Upper.contains(".")){
				Upper = Upper.substring(Upper.indexOf(".")+1,Upper.length()-1).trim();
			}
			if(Upper.startsWith("Pl. 1.")){
				Upper = Upper.replace("Pl. 1.", "").trim();
			}
			if(Upper.startsWith("Pl. 1")){
				Upper = Upper.replace("Pl. 1", "").trim();
			}
			if(Upper.endsWith("nicht dokumentier")){
				Upper = "";
			}
			if(Upper.endsWith(",")){
				Upper = Upper.replace(",", "").trim();
			}
			Upper = Upper.replace("Pl.", "").trim();
			Upper = Upper.replace(",", ".").trim();
			Upper = Upper.replaceAll("\\s+", "").trim();
			
		}
		if(!Lower.isEmpty()){
			if(!Character.isDigit(Lower.charAt(0))){
				int i =0;
				while(i < Lower.length() && !Character.isDigit(Lower.charAt(i))) i++;
				if(!Lower.isEmpty()){
					Lower = Lower.substring(i,Lower.length()).trim();}
			}
			if(Lower.contains("-")){
				Lower = Lower.substring(0,Lower.indexOf("-")).trim();
			}
			if(Lower.endsWith("m ü.M.")){
				Lower = Lower.replace("m ü.M.", "").trim();
			}
			if(Lower.endsWith("m ü.M..")){
				Lower = Lower.replace("m ü.M..", "").trim();
			}
		
			
			
		}else{Lower = Upper;}
		Lower = Lower.replace(",", ".").trim();
		
		if(!Lower.isEmpty()&& !Upper.isEmpty()){
			if(Lower.endsWith("m ü. M.") || Upper.endsWith("m ü. M.")){
				Lower = Lower.replaceAll("m ü. M.","").trim();
				Upper = Upper.replaceAll("m ü. M.","").trim();
			}
			arr = new String[]{Lower,Upper};
		}
		
		
		return arr;
	}
///Mapping DATA from Forts
	public void AddDataPropertiesFromForts(Sheet sheet, OntoMobileFactory factory){
		for(int i = 1; i<1609; i++)
		 {
			String[] X_Coordinate = null;
			String Lower_X_Coordinate ="";
			String Upper_X_Coordinate ="";
			String[] Elevation = null;
		    String LowerElevation="";
		    String UpperElevation="";
			
			Cell X_CoordinateCell = sheet.getRow(i).getCell(1);
			Cell ElevationCell = sheet.getRow(i).getCell(2);
			
			
			if(X_CoordinateCell!=null){
				X_Coordinate = FormateCoordinate(fmt.formatCellValue(X_CoordinateCell));	
			}
			if(ElevationCell!=null){
				Elevation = FormateCoordinate(fmt.formatCellValue(ElevationCell));
			}
			if(X_Coordinate!=null){
				Lower_X_Coordinate = X_Coordinate[0];
				Upper_X_Coordinate = X_Coordinate[1];	
			}
			if(Elevation!=null){
				LowerElevation=Elevation[0];
			    UpperElevation=Elevation[1];
			}
			if(!Lower_X_Coordinate.isEmpty()){
				cor = factory.createCoordinates(prefix+Values.Rottweil_Forts_+i);
				cor.addHas_Lower_X_Coordinate(Float.parseFloat(Lower_X_Coordinate));
			}
			if(!Lower_X_Coordinate.isEmpty()){cor.addHas_Upper_X_Coordinate(Float.parseFloat(Upper_X_Coordinate));}
			if(!LowerElevation.isEmpty()){cor.addHas_Elevation_lower_limit(Float.parseFloat(LowerElevation));}
			if(!UpperElevation.isEmpty()){cor.addHas_Elevation_upper_limit(Float.parseFloat(UpperElevation));}
			}
		 
		
	}
	
	private String[] FormateCoordinate(String str) {
		String FormatedString ="";
		String Lower ="";
		String Upper ="";
		String[] arr =null;
		if(!str.isEmpty()){
			if(str.contains("streufunde")){
				FormatedString = "";
			}
			else{
				FormatedString = str;
			}
		}
		if(!FormatedString.isEmpty()){
			
			if(FormatedString.contains(",")){
			  String[] newS = FormatedString.split(",");
			  FormatedString = newS[0].trim();
			}
			if(FormatedString.contains("/")){
				String[] newS = FormatedString.split("/");
				Lower = newS[0];
				Upper = newS[1];
			}
			if(FormatedString.contains("-")){
				if(Character.isDigit(str.charAt(0))){
					
					String[] newS = FormatedString.split("-");
					Lower = newS[0];
					Upper = newS[1];
				}
			}
		}
		if(!Lower.isEmpty() && !Upper.isEmpty() ){
			if(Upper.endsWith("(?)")){Upper = Upper.substring(0,Upper.indexOf("(")).trim();}
			arr =new String[]{Lower,Upper};}
		
		return arr;
	}
//private String FormateLimit(String str) {
//	 String	FormatedString ="";
//		if(!str.isEmpty()){
//			if(!Character.isDigit(str.charAt(0))){
//				int i =0;
//				while(i < str.length() && !Character.isDigit(str.charAt(i))) i++;
//				if(!str.isEmpty()){
//				FormatedString = str.substring(i,str.length()).trim();}
//			}else{
//				FormatedString = str;
//			}
//		
//			if(!FormatedString.isEmpty()){
//				if(FormatedString.contains("-")){
//						String[] newS = FormatedString.split("-");
//						FormatedString = newS[0].trim();
//				} 
//				if(FormatedString.contains(";")){
//					String[] newS = FormatedString.split(";");
//					FormatedString = newS[0].trim();
//			     } 
//				if(FormatedString.endsWith(")")){
//					
//					FormatedString =FormatedString.replace(")","").trim();
//			} 
//				if(FormatedString.contains("cm")){
//					FormatedString = FormatedString.substring(0,FormatedString.indexOf("c")).trim();
//					FormatedString = FormatedString.replace("cm", "");
//				}
//				
//				if(FormatedString.contains(",")){
//					String[] newS = FormatedString.split(",");
//					FormatedString = newS[0].trim();
//				}
//				
//				if(FormatedString.contains("u") ){
//					FormatedString = FormatedString.substring(0,FormatedString.indexOf("u"));
//				} 
//				if(FormatedString.contains("b") ){
//					FormatedString = FormatedString.substring(0,FormatedString.indexOf("b"));
//				}
//				FormatedString = FormatedString.replaceAll("\\D+","").trim();
//				if(FormatedString =="663"){
//					FormatedString = "663.87";
//				}
//				}
//	}
//	
//	return FormatedString;
//		
//}
	
}
