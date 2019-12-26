package ontomobile.phd.reasearch.owlapi;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.model.AddAxiom;
import org.semanticweb.owlapi.model.OWLDataFactory;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyManager;
import org.semanticweb.owlapi.model.PrefixManager;
import org.semanticweb.owlapi.util.DefaultPrefixManager;

import ontomobile.phd.research.Material;
import ontomobile.phd.research.OntoMobileFactory;

public class MaterialMapping {

	static Material m ;
	static DataFormatter fmt = new DataFormatter();
	static String prefix = "http://www.semanticweb.org/daan/ontologies/2016/3/BDRTontology#";
	
	public Material AddInsFromForts(Sheet sheet, OntoMobileFactory factory, int RowNum, int CellNum){
		String Material = "";
		
		Cell MaterialCell = sheet.getRow(RowNum).getCell(CellNum);
		
		if(MaterialCell != null){
			
			Material  = fmt.formatCellValue(MaterialCell);
		}
		
		
		if(!Material .isEmpty()){
			Material  = Material.trim();
			Material  = Material.replaceAll("\\s+", "_").toLowerCase();
			
			m = factory.createMaterial(prefix+Material);
		}
		
		return m;
}
	
	public Material AddInsFromCementry(Sheet sheet, OntoMobileFactory factory, int RowNum, int CellNum){
		
		return m;
	}
	
	public void AddingSubClassesFromCementry(Sheet sheet, OntoMobileFactory factory, OWLOntology _Onto){
		OWLOntologyManager man = OWLManager.createOWLOntologyManager();
		OWLDataFactory df = _Onto.getOWLOntologyManager().getOWLDataFactory();
		PrefixManager pm = new DefaultPrefixManager("http://www.semanticweb.org/daan/ontologies/2016/3/BDRTontology#");
		
		for(int i = 1; i<7746; i++){
		String SubClass="";
		
		Cell SubClassCell = sheet.getRow(i).getCell(14);
		
		if(SubClassCell!=null){
			
			SubClass = FormateSubClassString(fmt.formatCellValue(SubClassCell));
		}
		if(!SubClass.isEmpty()){
			
			man.applyChange(new AddAxiom(_Onto, df.getOWLSubClassOfAxiom(df.getOWLClass(SubClass,pm),df.getOWLClass("Material",pm))));
		}
				
		}
	}

	private String FormateSubClassString(String str) {
		String FormatedString ="";
		
		if(!str.isEmpty()){
			FormatedString =str.trim();
		}
	    if(!FormatedString.isEmpty()){
	    	if(FormatedString.contains("TS(?)") || FormatedString.contains("TS?")){
	    		FormatedString = "Terra_Sigillata_or_Terra_Sigillata_Like";
	    	}
	    	if(FormatedString.contains("TS")){
	    		FormatedString = "Terra_Sigillata";
	    	}
	    	if(FormatedString.contains("TN(?)") || FormatedString.contains("TN?")){
	    		FormatedString = "Terra_Nigra_or_Terra_Nigra_Like";
	    	}
	    	if(FormatedString.contains("TN")){
	    		FormatedString = "Terra_Nigra";
	    	}
	    	if(FormatedString.contains("Glas")){  
	    		FormatedString = "Glass";
	    	}
	    	if(FormatedString.contains("Gebrauchskeramik")){  
	    		FormatedString = "Utilitarian";
	    	}
	    	if(FormatedString.contains("Handgeformt (?)") ||FormatedString.contains("Handgeformt?")){  
	    		FormatedString = "Handgeformt";
	    	}
	    	if(FormatedString.contains("Handgeformter (?)") ||FormatedString.contains("Handgeformter?")){  
	    		FormatedString = "Handgeformter";
	    	}
	    	
	    	FormatedString = FormatedString.replaceAll("\\s+", "_");
	    }
	
		return FormatedString;
	}
}
