package ontomobile.phd.reasearch.owlapi;

import java.io.File;

import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.io.RDFXMLOntologyFormat;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLDataFactory;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;
import org.semanticweb.owlapi.model.OWLOntologyManager;
import org.semanticweb.owlapi.model.OWLOntologyStorageException;
import org.semanticweb.owlapi.model.PrefixManager;
import org.semanticweb.owlapi.util.DefaultPrefixManager;

public class LoadAndSave {

	static OWLOntologyManager man = OWLManager.createOWLOntologyManager();
	static OWLDataFactory df = man.getOWLDataFactory();
	static OWLOntology _onto = null;
	static String prefix = "http://www.semanticweb.org/daan/ontologies/2016/3/BDRTontology#";
	PrefixManager pm = new DefaultPrefixManager("http://www.semanticweb.org/daan/ontologies/2016/3/BDRTontology#");
	String Path = "/Users/umarriaz/Desktop/FinalYearProject/SavedOntologies/tmp/phd/PhdTempOnto.owl";
	IRI iri = IRI.create(Path);
	
	public OWLOntology CreateOntology() throws OWLOntologyCreationException, OWLOntologyStorageException{
		_onto = man.createOntology(iri);
		SaveOntology(_onto);
		return _onto;
	}
	
	public OWLOntology LoadOntology() throws OWLOntologyStorageException, OWLOntologyCreationException{
			
		//_onto= man.loadOntologyFromOntologyDocument(iri);
		return _onto;
	}
	
	public void SaveOntology(OWLOntology onto) throws OWLOntologyStorageException{
	
		File file = new File("/Users/umarriaz/Desktop/FinalYearProject/SavedOntologies/tmp/phd/PhdTempOnto.owl"); 
		RDFXMLOntologyFormat owlxmlFormat = new RDFXMLOntologyFormat();
		owlxmlFormat.copyPrefixesFrom(pm);
		man.saveOntology(onto, owlxmlFormat, IRI.create(file.toURI()));
		System.out.println("Saved");
		man.removeOntology(onto);
	}

}
