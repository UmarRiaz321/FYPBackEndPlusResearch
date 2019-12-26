package owl.cs.OntoMobile;

import java.io.FileNotFoundException;
import java.util.HashSet;
import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.model.AddAxiom;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLAxiom;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLClassAssertionAxiom;
import org.semanticweb.owlapi.model.OWLDataFactory;
import org.semanticweb.owlapi.model.OWLDataPropertyAssertionAxiom;
import org.semanticweb.owlapi.model.OWLDeclarationAxiom;
import org.semanticweb.owlapi.model.OWLException;
import org.semanticweb.owlapi.model.OWLIndividual;
import org.semanticweb.owlapi.model.OWLObjectProperty;
import org.semanticweb.owlapi.model.OWLObjectPropertyAssertionAxiom;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;
import org.semanticweb.owlapi.model.OWLOntologyManager;
import org.semanticweb.owlapi.model.OWLOntologyStorageException;
import org.semanticweb.owlapi.model.OWLSubClassOfAxiom;
import org.semanticweb.owlapi.model.PrefixManager;
import org.semanticweb.owlapi.util.DefaultPrefixManager;

public class OnotoEngineering {

	public static OWLOntologyManager man = OWLManager.createOWLOntologyManager();
	public static LoadSaveOntology loadSave = new LoadSaveOntology();
	String Path = "/Users/umarriaz/Desktop/FinalYearProject/SavedOntologies/tmp/OntoMobile/TempOnto.owl";
	IRI iri = IRI.create(Path);
	PrefixManager pm = new DefaultPrefixManager("/Users/umarriaz/Desktop/FinalYearProject/SavedOntologies/tmp/TempOnto.owl/#");
	
	public OWLOntology CreateOntologies() throws OWLOntologyStorageException, FileNotFoundException {

		OWLOntology newOntology = null;
		try {
			newOntology = man.createOntology(iri);
		} catch (OWLOntologyCreationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		loadSave.SaveTempOntology(newOntology,pm);
		return newOntology;
	}

	public OWLOntology AddClass(OWLOntology _onto, String _className) throws OWLOntologyStorageException, FileNotFoundException {
		
		OWLDataFactory df = _onto.getOWLOntologyManager().getOWLDataFactory();
		OWLDeclarationAxiom da = df.getOWLDeclarationAxiom(df.getOWLClass(_className,pm));
		AddAxiom addAxiom = new AddAxiom(_onto, da);
		man.applyChange(addAxiom);
		loadSave.SaveTempOntology(_onto,pm);
		return _onto;
	
	}
	public OWLOntology  AddSubClass(String _ParentClass, String _ClassName, OWLOntology _onto)throws OWLOntologyStorageException, FileNotFoundException
	{
        OWLDataFactory df = _onto.getOWLOntologyManager().getOWLDataFactory();
        OWLSubClassOfAxiom axiom = df.getOWLSubClassOfAxiom(df.getOWLClass(_ClassName,pm),df.getOWLClass(_ParentClass,pm));
        AddAxiom addAxiom = new AddAxiom(_onto, axiom);
        man.applyChange(addAxiom);
        System.out.println("Axioms: "+ _onto.getAxiomCount()+", Format:"+man.getOntologyFormat(_onto));
        loadSave.SaveTempOntology(_onto,pm);
		return _onto;
	
	}

	public OWLOntology AddInstance(String _ClassName, String InstanceName, OWLOntology _onto)throws OWLOntologyStorageException, FileNotFoundException {
		
		OWLDataFactory df = _onto.getOWLOntologyManager().getOWLDataFactory();
		OWLClassAssertionAxiom instance = df.getOWLClassAssertionAxiom(df.getOWLClass(_ClassName,pm),df.getOWLNamedIndividual(InstanceName,pm));
		man.applyChange(new AddAxiom(_onto,instance));
		loadSave.SaveTempOntology(_onto,pm);
		return _onto;
	}

	public OWLOntology AddObjectProperty(String ActiveIndName, String PassiveIndName, String Property, OWLOntology _onto) throws OWLOntologyStorageException, FileNotFoundException {
		
		OWLDataFactory df = _onto.getOWLOntologyManager().getOWLDataFactory();
		OWLObjectProperty property = df.getOWLObjectProperty(Property, pm);
		OWLIndividual Active = df.getOWLNamedIndividual(ActiveIndName, pm);
		OWLIndividual Passive = df.getOWLNamedIndividual(PassiveIndName, pm);
		OWLObjectPropertyAssertionAxiom propertyAssertion = df.getOWLObjectPropertyAssertionAxiom(property,Active,Passive);
        man.applyChange(new AddAxiom(_onto,propertyAssertion  ));
		loadSave.SaveTempOntology(_onto,pm);
		return _onto;
	}

	public OWLOntology AddDataProperty(String ActiveIndName, String Property, String value, OWLOntology _onto)throws OWLOntologyStorageException, FileNotFoundException {
		
		OWLDataFactory df = _onto.getOWLOntologyManager().getOWLDataFactory();
		OWLDataPropertyAssertionAxiom dataPropertyAssertion = df.getOWLDataPropertyAssertionAxiom(df.getOWLDataProperty(Property, pm), df.getOWLNamedIndividual(ActiveIndName, pm), value);
		man.applyChange(new AddAxiom(_onto, dataPropertyAssertion ));
		loadSave.SaveTempOntology(_onto,pm);
		return _onto;
	}
	
	public OWLOntology RemoveClass(OWLOntology _onto, String _ClassName) throws OWLOntologyStorageException, FileNotFoundException {

	for(OWLOntology o : _onto.getImportsClosure()){
      HashSet<OWLAxiom>  axiomsToRemove = new HashSet<OWLAxiom>();
      for (OWLAxiom ax : o.getAxioms())
      if (ax.getSignature().contains(_onto.getOWLOntologyManager().getOWLDataFactory().getOWLClass(_ClassName,pm))) {
                    axiomsToRemove.add(ax);
                    System.out.println("to remove from " + o.getOntologyID().getOntologyIRI() + ": " + ax);
                }
                
                
                 man.removeAxioms(o, axiomsToRemove);
        }
        
       
        
        loadSave.SaveTempOntology(_onto,pm);
        
		return _onto;
	}
	
public OWLOntology RemoveInstance(OWLOntology _onto, String InstanceName) throws OWLOntologyStorageException, FileNotFoundException{
	
	
	OWLDataFactory df = _onto.getOWLOntologyManager().getOWLDataFactory();
	for(OWLOntology o: _onto.getImportsClosure()){
	 HashSet<OWLAxiom>  axiomsToRemove = new HashSet<OWLAxiom>();
	 
	 for (OWLAxiom ax : o.getAxioms()){
	  if (ax.getSignature().contains(df.getOWLNamedIndividual(InstanceName,pm))) {
                    axiomsToRemove.add(ax);
	 } 
	}
	man.removeAxioms(o, axiomsToRemove);
	}
	loadSave.SaveTempOntology(_onto,pm);
	return _onto;
	
	}
	
	public void PrintHierarchy(OWLOntology _onto) throws OWLException, InstantiationException, IllegalAccessException, ClassNotFoundException{
		
	   OWLDataFactory df = _onto.getOWLOntologyManager().getOWLDataFactory();
	   OWLClass clas =df.getOWLThing();
	   ClassHierarchy CE = new ClassHierarchy(_onto);
	   CE.PrintClassHierarchy(clas);
	}

}
