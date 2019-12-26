package owl.cs.OntoMobile;

import java.io.File;
import java.io.FileNotFoundException;
import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.io.RDFXMLOntologyFormat;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;
import org.semanticweb.owlapi.model.OWLOntologyManager;
import org.semanticweb.owlapi.model.OWLOntologyStorageException;
import org.semanticweb.owlapi.model.PrefixManager;

public class LoadSaveOntology {

	
	public static OWLOntologyManager man = OWLManager.createOWLOntologyManager();
	
	public OWLOntology LoadOntologyFile(String Path) throws OWLOntologyStorageException, FileNotFoundException {
		File file = new File(Path);
		IRI iri = IRI.create(file);
		OWLOntology onto = null;
		try {
			 onto = man.loadOntologyFromOntologyDocument(iri);
			System.out.println(onto);
		} catch (OWLOntologyCreationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//SaveTempOntology(onto,pm);
		return onto;
		
	}
	
	public OWLOntology LoadOntologyWeb(String Path) {
		IRI pizzaontology = IRI.create("http://protege.stanford.edu/ontologies/pizza/pizza.owl");
		OWLOntology onto = null;
		try 
		{
			onto = man.loadOntology(pizzaontology);
		} 
		catch (OWLOntologyCreationException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		return onto;
	}
	
	public void SaveOntology(OWLOntology newOntology, String name) throws OWLOntologyStorageException, FileNotFoundException {
		File file = new File("/Users/umarriaz/Desktop/FinalYearProject/SavedOntologies/Ontologies/"+name+".owl");
		RDFXMLOntologyFormat owlxmlFormat = new RDFXMLOntologyFormat();
		man.saveOntology(newOntology, owlxmlFormat, IRI.create(file.toURI()));
		System.out.println("Saved");
		man.removeOntology(newOntology);
	}
	public void SaveTempOntology(OWLOntology newOntology, PrefixManager pm) throws OWLOntologyStorageException, FileNotFoundException {
		
		File file = new File("/Users/umarriaz/Desktop/FinalYearProject/SavedOntologies/tmp/TempOnto.owl"); 
		RDFXMLOntologyFormat owlxmlFormat = new RDFXMLOntologyFormat();
		owlxmlFormat.copyPrefixesFrom(pm);
		man.saveOntology(newOntology, owlxmlFormat, IRI.create(file.toURI()));
		System.out.println("Saved");
		man.removeOntology(newOntology);
		System.out.println("Ontology Removed from Manger");
		
	}
	
	
}
