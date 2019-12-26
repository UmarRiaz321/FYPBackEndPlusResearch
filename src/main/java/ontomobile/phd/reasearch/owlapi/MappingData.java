package ontomobile.phd.reasearch.owlapi;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyStorageException;

import ontomobile.phd.research.Archaeological_Context;
import ontomobile.phd.research.OntoMobileFactory;
import ontomobile.phd.research.Site_Phase;
import owl.cs.OntoMobile.LoadSaveOntology;

public class MappingData {

	static DataFormatter fmt = new DataFormatter();
	static Archaeological_Context ac;
	static Site_Phase sf;
	static OWLOntology _onto = null;
	static String prefix = "http://www.semanticweb.org/daan/ontologies/2016/3/BDRTontology#";
	static OntoMobileFactory factory = null;
	static Sheet sheet = null;
	static Sheet sheet1 = null;
	LoadAndSave save = null;
	Workbook workbook= null;
	Workbook workbook1= null;
	
	public MappingData() throws OWLOntologyStorageException, FileNotFoundException {
		
		LoadSaveOntology ls = new LoadSaveOntology();
		save = new LoadAndSave();
		_onto = ls.LoadOntologyFile("/Users/umarriaz/Desktop/FinalYearProject/SavedOntologies/tmp/phd/PhdOntology.owl");
		factory = new OntoMobileFactory(_onto);
		File XlsFile1 = new File("/Users/umarriaz/Desktop/FinalYearProject/Worksheets/Spreadsheet Rottweil Forts.xls");
	    try {
			workbook = WorkbookFactory.create(XlsFile1);
		} catch (InvalidFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		sheet = workbook.getSheetAt(2); //Forts
		File XlsFile2 = new File("/Users/umarriaz/Desktop/FinalYearProject/SpreadSheets/Spreadsheet Rottweil cemetery.xlsx");
		try {
			workbook1 = WorkbookFactory.create(XlsFile2);
		} catch (InvalidFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		sheet1= workbook1.getSheetAt(0); //Cementry
		
	}
	///Function to map Data from sheet1 Forts, to Archeology Context
	public void ACMapingSheet1(){
		ArchaeologicalContextImpl acIm = new ArchaeologicalContextImpl();
		acIm.MappingFromCementries(sheet1, factory);
}

	public void ArtefactMaping(){
		
		ArtefactImpl arc = new ArtefactImpl();
		arc.AddFromForts(sheet, factory);
		arc.AddFromCemetry(sheet1, factory);
	}
	
	public void CoordinatesMaping(){
		
		CoordinatesMapping cr = new CoordinatesMapping();
	//	cr.AddDataPropertiesFromCemetry(sheet1, factory);
		cr.AddDataPropertiesFromForts(sheet, factory);
		cr.AddDataPropertiesFromCementries(sheet1, factory);
	}
	
	public void Production_CenterImp(){
		Production_CenterMaping pc = new Production_CenterMaping();
		pc.AddingSubClassesFromCementry(sheet1, factory, _onto);
	}
	
	
	public void SkeletalMaterialImpl(){
		Skeletal_MaterialImpl sm = new Skeletal_MaterialImpl();
		sm.AddDataProperties(sheet1, factory);
	}
	public void Fragment_TypeIml(){
		Fragment_TypeMapping ft = new Fragment_TypeMapping();
		ft.addInstances(sheet1, factory);
		ft.addInstancesFromForts(sheet, factory);
	}
 public void MaterialIMP(){
	 MaterialMapping mp = new MaterialMapping();
	 
	 mp.AddingSubClassesFromCementry(sheet1, factory, _onto);
 }
 public void Form_TypeIMP(){
	 Form_TypeMaping f = new Form_TypeMaping();
	 f.AddingSubClassesFromCementry(sheet1, factory, _onto);
 }
	public void SaveOnto() throws OWLOntologyStorageException{
		
		save.SaveOntology(_onto);
	}
}
