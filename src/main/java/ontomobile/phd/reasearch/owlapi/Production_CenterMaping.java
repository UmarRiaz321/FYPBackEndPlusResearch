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

import ontomobile.phd.research.Ceramics_Production_Centre;
import ontomobile.phd.research.OntoMobileFactory;
import ontomobile.phd.research.Production_Centre;

public class Production_CenterMaping {

	static DataFormatter fmt = new DataFormatter();
	static String prefix = "http://www.semanticweb.org/daan/ontologies/2016/3/BDRTontology#";
	static Production_Centre m ;
	static Ceramics_Production_Centre CPC;

public Production_Centre AddInstofCPCFromCementries(Sheet sheet, OntoMobileFactory factory, int RowNum){
	
	String ProductionCentre ="";
	
	Cell ProductionCentreCell = sheet.getRow(RowNum).getCell(45);
	
	if(ProductionCentreCell != null){
		
		ProductionCentre = fmt.formatCellValue(ProductionCentreCell);
	}
	if(!ProductionCentre.isEmpty()){
		ProductionCentre = ProductionCentre.trim();
		ProductionCentre = ProductionCentre.replaceAll("\\s+", "_").toLowerCase();
		
		m = factory.createProduction_Centre(prefix+ProductionCentre);
	}
	
	return m;
}

public Ceramics_Production_Centre AddInstofCPCFromForts(Sheet sheet, OntoMobileFactory factory, int RowNum, int CellNum){
	
	String ProductionCentre ="";
	
	Cell ProductionCentreCell = sheet.getRow(RowNum).getCell(CellNum);
	
	if(ProductionCentreCell != null){
		
		ProductionCentre = fmt.formatCellValue(ProductionCentreCell);
	}
	if(!ProductionCentre.isEmpty()){
		ProductionCentre = ProductionCentre.trim();
		ProductionCentre = ProductionCentre.replaceAll("\\s+", "_").toLowerCase();
		
		CPC = factory.createCeramics_Production_Centre(prefix+ProductionCentre);
	}
	
	return CPC;
}

public void AddingSubClassesFromCementry(Sheet sheet, OntoMobileFactory factory, OWLOntology _Onto){
	OWLOntologyManager man = OWLManager.createOWLOntologyManager();
	OWLDataFactory df = _Onto.getOWLOntologyManager().getOWLDataFactory();
	PrefixManager pm = new DefaultPrefixManager("http://www.semanticweb.org/daan/ontologies/2016/3/BDRTontology#");
	
	for(int i = 1; i<7746; i++){
	String SubClass="";
	
	Cell SubClassCell = sheet.getRow(i).getCell(17);
	
	if(SubClassCell!=null){
		
		SubClass = FormateSubClassString(fmt.formatCellValue(SubClassCell));
	}
	if(!SubClass.isEmpty()){
		
		man.applyChange(new AddAxiom(_Onto, df.getOWLSubClassOfAxiom(df.getOWLClass(SubClass,pm),df.getOWLClass("Production_Centre",pm))));
	}
			
	}
}

private String FormateSubClassString(String str) {
	
	if(!str.isEmpty()){
		
		str = str.replaceAll("\\s+", "_");
		str = str.replace("(?)", "").trim();
	}

	return str;
}



}
