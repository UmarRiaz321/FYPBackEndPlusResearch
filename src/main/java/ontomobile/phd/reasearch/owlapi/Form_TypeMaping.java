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

import ontomobile.phd.research.Form_Type;
import ontomobile.phd.research.OntoMobileFactory;

public class Form_TypeMaping {
	static DataFormatter fmt = new DataFormatter();
	static String prefix = "http://www.semanticweb.org/daan/ontologies/2016/3/BDRTontology#";
    static Form_Type ftype;

	
public Form_Type AddInsFromForts(Sheet sheet, OntoMobileFactory factory, int RowNum){
	String FormType ="";
	
	Cell FormTypeCell = sheet.getRow(RowNum).getCell(19);
	
	if(FormTypeCell != null){
		
		FormType = fmt.formatCellValue(FormTypeCell);
	}
	if(!FormType.isEmpty()){
		FormType = FormType.trim();
		FormType = FormType.replaceAll("\\s+", "_").toLowerCase();
		
		ftype = factory.createForm_Type(prefix+FormType);
	}
	return ftype;
}

public void AddingSubClassesFromCementry(Sheet sheet, OntoMobileFactory factory, OWLOntology _Onto){
	OWLOntologyManager man = OWLManager.createOWLOntologyManager();
	OWLDataFactory df = _Onto.getOWLOntologyManager().getOWLDataFactory();
	PrefixManager pm = new DefaultPrefixManager("http://www.semanticweb.org/daan/ontologies/2016/3/BDRTontology#");
	
	for(int i = 2; i<7746; i++){
	String SubClass="";
	
	Cell SubClassCell = sheet.getRow(i).getCell(16);
	
	if(SubClassCell!=null){
		
		SubClass = FormateSubClassString(fmt.formatCellValue(SubClassCell));
	}
	if(SubClass!=""){
		
		man.applyChange(new AddAxiom(_Onto, df.getOWLSubClassOfAxiom(df.getOWLClass(SubClass,pm),df.getOWLClass("Form_Type",pm))));
	}
			
	}
}

private String FormateSubClassString(String str) {
	String FormatedString ="";
	
	if(!str.isEmpty()){
		FormatedString = str.trim();
	}
	
	if(!FormatedString.isEmpty()){
	  if(FormatedString.contains("(") || FormatedString.contains(")") ){
		  FormatedString = FormatedString.replace("(", "").trim();
		  FormatedString = FormatedString.replace(")", "").trim();
	 }
	 if(FormatedString.contains("/")){
		 String[] newS = FormatedString.split("/");
		 FormatedString = newS[0].trim();
	 }
	 if(FormatedString.endsWith("?")){
		 FormatedString = FormatedString.replace("?","").trim();
	 }
	 if(FormatedString.contains(".")){
		 
		 FormatedString = FormatedString.replace(".", "").trim();
		 
	 }
	 FormatedString = FormatedString.replaceAll("\\s+", "_");
	 FormatedString = FormatedString.replace("Drag_36", "").trim();
	 FormatedString = FormatedString.replace("Isings_8", "").trim();
	 FormatedString = FormatedString.replace("(?)", "").trim();
	}
	FormatedString = FormatedString.replaceAll("[\\s|\\u00A0]+","").trim();
	return FormatedString.trim();
}
	
}
