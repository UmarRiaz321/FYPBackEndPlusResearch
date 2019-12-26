package ontomobile.phd.reasearch.owlapi;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyStorageException;

import ontomobile.phd.research.OntoMobileFactory;
import owl.cs.OntoMobile.LoadSaveOntology;

public class LoadFiles {

	OWLOntology _onto = null;
	String prefix = "http://www.semanticweb.org/daan/ontologies/2016/3/BDRTontology#";
	OntoMobileFactory factory = null;
	Sheet sheet = null;
	LoadAndSave save = null;
	Workbook workbook= null;
	Workbook workbook1= null;
    Sheet sheet1 = null;
	public LoadFiles() {
		
		LoadSaveOntology ls = new LoadSaveOntology();
		try {
			_onto = ls.LoadOntologyFile("/Users/umarriaz/Desktop/FinalYearProject/SavedOntologies/tmp/phd/PhdOntology.owl");
		} catch (OWLOntologyStorageException | FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		factory = new OntoMobileFactory(_onto);
		File XlsFile1 = new File("/Users/umarriaz/Desktop/FinalYearProject/Worksheets/Spreadsheet Rottweil Forts.xls");
	    try {
			workbook = WorkbookFactory.create(XlsFile1);
		} catch (InvalidFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		sheet = workbook.getSheetAt(2);
		
		File XlsFile2 = new File("/Users/umarriaz/Desktop/FinalYearProject/SpreadSheets/Spreadsheet Rottweil cemetery.xlsx");
		try {
			workbook1 = WorkbookFactory.create(XlsFile2);
		} catch (InvalidFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		sheet1= workbook1.getSheetAt(0);
	}

}
