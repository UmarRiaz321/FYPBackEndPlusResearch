package ontomobile.phd.reasearch.owlapi;

import java.io.FileNotFoundException;

import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.model.AddAxiom;
import org.semanticweb.owlapi.model.OWLDataFactory;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;
import org.semanticweb.owlapi.model.OWLOntologyManager;
import org.semanticweb.owlapi.model.OWLOntologyStorageException;
import org.semanticweb.owlapi.model.PrefixManager;
import org.semanticweb.owlapi.util.DefaultPrefixManager;

import owl.cs.OntoMobile.LoadSaveOntology;

public class ClassCreation {

	static String prefix = "http://www.semanticweb.org/daan/ontologies/2016/3/BDRTontology#";
	PrefixManager pm = new DefaultPrefixManager("http://www.semanticweb.org/daan/ontologies/2016/3/BDRTontology#");
	static OWLOntologyManager man = OWLManager.createOWLOntologyManager();
	LoadAndSave ls = new LoadAndSave();
	LoadSaveOntology OntoLoad = new LoadSaveOntology();
	OWLOntology _onto = null;
	OWLDataFactory df ;
	
	public  ClassCreation() throws OWLOntologyStorageException, FileNotFoundException {
		
		_onto = OntoLoad.LoadOntologyFile("/Users/umarriaz/Desktop/FinalYearProject/SavedOntologies/tmp/phd/PhdTempOnto.owl");
		df = _onto.getOWLOntologyManager().getOWLDataFactory();
	}
	public void ClassAssertion() throws OWLOntologyStorageException, OWLOntologyCreationException, FileNotFoundException{
		
		
		
		String[] ClassNames = new String[] {"Archaeological_Context", "Artefact" , "Building" , "Building_Phase", "Complex", 
		                                     "Coordinates", "Date_Range", "Form_Label", "Form_Type","Fragment","Fragment_Type",
		                                     "Function", "Inscription", "Inscription_OR_Stamp","Latin_Descriptive_Label","Maker",
		                                     "Material","Production_Centre","Site","Site_Phase","Skeletal_Material",
		                                     "Stamp","Structure" };
		
		for(int i=0 ; i<ClassNames.length; i++){
			man.applyChange(new AddAxiom(_onto,df.getOWLDeclarationAxiom(df.getOWLClass(ClassNames[i],pm)))); 
		}
		
	    
		// Adding Sub-Classes of Form_Type
		String[] SubClassForm_Type = new String[] {"Ceramic_Form_Type","Glass_Form_Type","Metal_Form_Type"};
		AddingSubClass(SubClassForm_Type,"Form_Type");
		// Adding Sub_Classes of Ceramic_Form_Type
		String[] Ceramic_Form_Type = new String[]{"Coarse_Ceramic_Form_Type","Fine_Ceramic_Form_Type","Medium_Ceramic_Form_Type","Utilitarian_Ceramic_Form_Type"};
		AddingSubClass(Ceramic_Form_Type,"Ceramic_Form_Type");
		// Adding Sub_Classes of Fine_Ceramic_Form_Type
		String[] Fine_Ceramic_Form_Type = new String[] {"'Engobierte_und_tongrundige'_Form_Type","Glazed_Form_Type","Imitation_Terra_Sigillata_Form_Type","Raetische_Ware_Form_Type","Terra_Nigra_or_Terra_Nigra_like_Form_Type","Terra_Sigillata_Form_Type"};
		AddingSubClass(Fine_Ceramic_Form_Type,"Fine_Ceramic_Form_Type");
		//Adding Sub_Classes of Imitation_Terra_Sigillata_Form_Type
		String[] Imitation_Terra_Sigillata = new String[]{"Curle_Form_Type","Dragendroff_Form_Type","Ludowici_Form_Type","Niederbiber_Form_Type"};
		AddingSubClass(Imitation_Terra_Sigillata,"Imitation_Terra_Sigillata_Form_Type");
		//Adding Sub_Classe of Raetische_Ware_Form_Type
		String[] Raetische_Ware_Form_Type = new String[]{"Drexel_I","Drexel_IIa","Drexel_IIb","Drexel_III","Niederbieber_Form_Type"};
		AddingSubClass(Raetische_Ware_Form_Type,"Raetische_Ware_Form_Type");
	    //Adding SubClass of Drexel_III
		man.applyChange(new AddAxiom(_onto, df.getOWLSubClassOfAxiom(df.getOWLClass("Rheinische_Ware",pm),df.getOWLClass("Drexel_III",pm))));
       //Adding SubClass of Terra_Nigra_or_Terra_Nigra_like_Form_Type
		man.applyChange(new AddAxiom(_onto, df.getOWLSubClassOfAxiom(df.getOWLClass("Dragendorff_Form_Type",pm),df.getOWLClass("Terra_Nigra_or_Terra_Nigra_like_Form_Type",pm))));
       //Adding SubClass of Terra_Sigillata_Form_Type
		String[] Terra_Sigillata_Form_Type = new String[]{"Curle_Form_Type","Dragendorff_Form_Type","Ludowici_Form_Type","Niederbieber_Form_Type"};
		AddingSubClass(Terra_Sigillata_Form_Type,"Terra_Sigillata_Form_Type");
		//Adding SubClass of Medium_Ceramic_Form_Type
		String[] Medium_Ceramic_Form_Type = new String[]{"'Engobierte_und_tongrundige'_Form_Type","Imitation_Terra_Sigillata_Form_Type","Raetische_Ware_Form_Type","Technik_b","Terra_Nigra_ot_Terra_Nigra_Like_Form_Type"};
		AddingSubClass(Medium_Ceramic_Form_Type,"Medium_Ceramic_Form_Type");
        //Adding SubClasses of Glass_Form_Type
		man.applyChange(new AddAxiom(_onto, df.getOWLSubClassOfAxiom(df.getOWLClass("Isings",pm),df.getOWLClass("Glass_Form_Type",pm))));
		
		//Adding SubClasses of Metal_Form_Type
		man.applyChange(new AddAxiom(_onto, df.getOWLSubClassOfAxiom(df.getOWLClass("Coin_Form_Type",pm),df.getOWLClass("Metal_Form_Type",pm))));
		//Adding Subclass of Material
		String[] Material = new String[]{"Ceramic","Glass","Metal"};
		AddingSubClass(Material,"Material");
		//Adding SubClasses of Ceramic
		String[] Ceramic = new String[]{"Coarse_Ceramic","Fine_Ceramic","Medium_Ceramic","Utilitarian_Ceramic"};
		AddingSubClass(Ceramic,"Ceramic");
        //Adding SubClass of Production_Center
		String[] Production_Center = new String[]{"Ceramic_Production_Centre","Glass_Production_Centre","Metal_Production_Centre"};
		AddingSubClass(Production_Center,"Production_Center");
		//Adding SubClasses of Ceramic_Production_Centre
		String[] Ceramic_Production_Centre = new String[]{"East_Gaul","Middle_Gaul","Raetia","South_Gaul","TempCategory","Upper_German"};
		AddingSubClass(Ceramic_Production_Centre,"Ceramic_Production_Centre");
		//Adding Sub Classes of TempCategory
		String[] TempCategory = new String[]{"Bernhard_Group_Ia","Bernhard_Group_Ib","Bernhard_Group_IIa","Bernhard_Group_IIb","Bernhard_Group_IIc","Bernhard_Group_III","Bernhard_Group_IIIa"};
		AddingSubClass(TempCategory,"TempCategory");
		//Adding SubClasses of Upper_German
        String[] Upper_German = new String[]{"Blickweiler","Chemery","Escweiler","Heiligenberg","Ittenweiler","Mittelborn","Rheinzabern","Schwäbische"};		
		AddingSubClass(Upper_German,"Upper_German");
        //Adding SubClasses of Metal_Production_Centre
		man.applyChange(new AddAxiom(_onto, df.getOWLSubClassOfAxiom(df.getOWLClass("Mint",pm),df.getOWLClass("Metal_Production_Centre",pm))));

		
        ls.SaveOntology(_onto);
		
	}
	
	public void AddingSubClass(String[] Children, String Parent){
		
		for(int i=0; i<Children.length; i++){
			man.applyChange(new AddAxiom(_onto, df.getOWLSubClassOfAxiom(df.getOWLClass(Children[i],pm),df.getOWLClass(Parent,pm))));
		}
		
	}

}
