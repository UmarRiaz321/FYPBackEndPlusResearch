package owl.cs.OntoMobile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLDataFactory;
import org.semanticweb.owlapi.model.OWLException;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyManager;
import org.semanticweb.owlapi.model.OWLOntologyStorageException;
import org.semanticweb.owlapi.model.PrefixManager;
import org.semanticweb.owlapi.util.DefaultPrefixManager;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class OntoMobileController {


	public static OnotoEngineering OE = new OnotoEngineering();
	public static LoadSaveOntology loadSave= new LoadSaveOntology();
	public static OWLOntology newOntology = null;
	public static OWLOntologyManager man = OWLManager.createOWLOntologyManager();

	@RequestMapping("/CreateOntology")
	public String CreateOntology() throws OWLOntologyStorageException, FileNotFoundException {

		newOntology = OE.CreateOntologies();	
		return "Axioms: "+newOntology.getAxiomCount()+", Format:"+man.getOntologyFormat(newOntology);
	}

	@RequestMapping("/LoadOntology")
	public static String Load() throws IOException, OWLOntologyStorageException {

		System.out.println("Enter 1 to load from File");
		System.out.println("Enter 2 to load from Web");
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);  
		int choice	= in.nextInt();
		@SuppressWarnings("resource")
		Scanner st = new Scanner(System.in);  
		if(choice == 1) {
			System.out.println("Enter Path");
			String Path = st.nextLine();
			newOntology= loadSave.LoadOntologyFile(Path);
		}else {
			System.out.println("Enter Path");
			String Path = st.nextLine();
			newOntology= loadSave.LoadOntologyWeb(Path);
			System.out.println("Axioms: "+newOntology.getAxiomCount()+", Format:"+man.getOntologyFormat(newOntology));
		} 

		return "Axioms: "+newOntology.getAxiomCount()+", Format:"+man.getOntologyFormat(newOntology);

	}

	private static OWLOntology LoadOntology() throws OWLOntologyStorageException, FileNotFoundException  {
		return loadSave.LoadOntologyFile("/Users/umarriaz/Desktop/FinalYearProject/SavedOntologies/tmp/TempOnto.owl");
	}

	@RequestMapping("/SaveOntology")
	public static void Save(@RequestParam("OntologyName") String OntologyName) throws OWLOntologyStorageException, FileNotFoundException 
	{	
		newOntology =  loadSave.LoadOntologyFile("/Users/umarriaz/Desktop/FinalYearProject/SavedOntologies/tmp/TempOnto.owl.xml");

		loadSave.SaveOntology(newOntology, OntologyName);


	}

	@RequestMapping("/AddClass")
	public static void CreateClass( @RequestParam("ClassName") String ClassName) throws OWLOntologyStorageException, FileNotFoundException
	{    	
		newOntology = LoadOntology();
		newOntology =	OE.AddClass(newOntology, ClassName);
	
	}

	@RequestMapping("/AddSubClass")
	public static String CreateSubClass(@RequestParam("CClassName") String ClassName, @RequestParam("PClassName") String ParentClass) throws OWLOntologyStorageException, FileNotFoundException {
		
		
		newOntology = LoadOntology();	  
		newOntology = OE.AddSubClass(ParentClass, ClassName, newOntology);
		return "Axioms: "+newOntology.getAxiomCount()+", Format:"+man.getOntologyFormat(newOntology);
		
	}

	@RequestMapping("/AddInstance")
	public void AddInstance(@RequestParam("CName") String ClassName, @RequestParam("IName") String IName) throws OWLOntologyStorageException, FileNotFoundException {
		newOntology = LoadOntology();	  
		newOntology = OE.AddInstance(ClassName,IName , newOntology);
		System.out.println("Axioms: "+newOntology.getAxiomCount()+", Format:"+man.getOntologyFormat(newOntology));	  
	}
	
	@RequestMapping("/AddObjectProperty")
	public void AddObjectProperty(@RequestParam("AcName") String AcName, @RequestParam("PassName") String PassName,@RequestParam("Property") String Property) throws OWLOntologyStorageException, FileNotFoundException {
		
		newOntology = LoadOntology();
		newOntology = OE.AddObjectProperty(AcName, PassName, Property, newOntology);
		System.out.println("Axioms: "+newOntology.getAxiomCount()+", Format:"+man.getOntologyFormat(newOntology));	  
	}
	
	
	@RequestMapping("/AddDataProperty")
	public void AddDataProperty(@RequestParam("AcName") String AcName ,@RequestParam("Property") String Property, @RequestParam("Value") String value ) throws OWLOntologyStorageException, FileNotFoundException {
		newOntology = LoadOntology();
		newOntology = OE.AddDataProperty(AcName, Property, value, newOntology);
		System.out.println("Axioms: "+newOntology.getAxiomCount()+", Format:"+man.getOntologyFormat(newOntology));	  
	}
	
	@RequestMapping("/RemoveClass")
	public void RemoveClass(@RequestParam("ClassName") String ClassName ) throws OWLOntologyStorageException, FileNotFoundException {
		
		newOntology = LoadOntology();
		newOntology = OE.RemoveClass(newOntology, ClassName);
		System.out.println("Axioms: "+newOntology.getAxiomCount()+", Format:"+man.getOntologyFormat(newOntology));	  

	}
	
	@RequestMapping("/RemoveInstance")
	public void RemoveInstance(@RequestParam("InstanceName") String InstanceName ) throws OWLOntologyStorageException, FileNotFoundException {
		newOntology = LoadOntology();
		newOntology = OE.RemoveInstance(newOntology, InstanceName);
		System.out.println("Axioms: "+newOntology.getAxiomCount()+", Format:"+man.getOntologyFormat(newOntology));
	}
	
	@RequestMapping("/PrintClassH")
	public void PrintHierarchy() throws FileNotFoundException, InstantiationException, IllegalAccessException, ClassNotFoundException, OWLException {
		newOntology = LoadOntology();
		OE.PrintHierarchy(newOntology);
		}
	
	@RequestMapping("/getClass")
	public String getClass(@RequestParam("parent")  String parentClass){
		//if(parent is null) then get all top level classes
		//otherwise get the direct subclasses of the given class
		
	//  return a JSON class array  => render in a list view
		return null;
	}
	


}
