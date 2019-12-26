


package owl.cs.OntoMobile;
import java.io.PrintStream;
import java.util.Set;

import org.json.JSONArray;
import org.json.JSONObject;
import org.semanticweb.HermiT.Reasoner;
import org.semanticweb.owlapi.model.OWLAnnotation;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.reasoner.Node;
import org.semanticweb.owlapi.reasoner.NodeSet;
import org.semanticweb.owlapi.reasoner.OWLReasoner;
import org.semanticweb.owlapi.reasoner.OWLReasonerFactory;

import uk.ac.manchester.cs.jfact.JFactFactory;

public class ClassHierarchy {
	
	   
	    private final OWLReasonerFactory reasonerFactory;
	    private final OWLOntology ontology;
	    private final PrintStream out;
	    
	    public ClassHierarchy (OWLOntology _ontology) {
			//OWLReasonerFactory reasonerFactory = new Reasoner.ReasonerFactory();
	    	OWLReasonerFactory reasonerFactory = new JFactFactory();
	    	this.reasonerFactory = reasonerFactory;
	        ontology = _ontology;
	        out = System.out;
	       
	    }
	public void PrintClassHierarchy(OWLClass clazz) {
		
		OWLReasoner reasoner = reasonerFactory.createNonBufferingReasoner(ontology);
		printHierarchy(reasoner, clazz, 0);
		for (OWLClass cl : ontology.getClassesInSignature()) {
			if (!reasoner.isSatisfiable(cl)) {
                out.println("XXX: " +labelFor( cl));
            }
		}
		

		
	}
	
	private String labelFor(OWLClass clazz) {
	        /*
	         * Use a visitor to extract label annotations
	         */
	        LabelExtractor le = new LabelExtractor();
			Set<OWLAnnotation> annotations = clazz.getAnnotations(ontology);
	        for (OWLAnnotation anno : annotations) {
	            anno.accept(le);
	        }
	        /* Print out the label if there is one. If not, just use the class URI */
	        if (le.getResult() != null) {
	            return le.getResult().toString();
	        } else {
	            return clazz.getIRI().toString();
	        }
	    }
	
	private void printHierarchy(OWLReasoner reasoner, OWLClass clazz, int level) {
		JSONObject Ob = new JSONObject();
		JSONArray Parentc = new JSONArray();
		JSONArray childC = new JSONArray();
		if (reasoner.isSatisfiable(clazz)) {
			
			Parentc = printH(reasoner, clazz, level);
			 for (OWLClass child : reasoner.getSubClasses(clazz, true).getFlattened()) {
				 childC = printH(reasoner, child, level+1);
			 }
		}
		

		
		out.println(Parentc);
	}
	
	private JSONArray printH(OWLReasoner reasoner, OWLClass clazz, int level) {
		JSONObject Parentc = new JSONObject();
		JSONObject childC = new JSONObject();
		if (reasoner.isSatisfiable(clazz)) {
			String[] ParentArr = labelFor(clazz).split("#");
	        String Parrent = ParentArr[1].trim();
	        Parentc.put("Name", Parrent);
	        for (OWLClass child : reasoner.getSubClasses(clazz, true).getFlattened()) {
                if (!child.equals(clazz)) {
                	String[] childar = labelFor(clazz).split("#");
        	        String chilName = childar[1].trim();
        	        childC.put("Name",chilName );
        	        
                }
            }
            
            Parentc.put("Children", childC );
		}
		
	return Parentc;
	}
}


