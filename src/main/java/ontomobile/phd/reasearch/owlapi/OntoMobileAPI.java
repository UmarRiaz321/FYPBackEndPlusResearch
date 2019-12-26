package ontomobile.phd.reasearch.owlapi;

import java.io.IOException;

import org.semanticweb.owlapi.model.OWLOntologyCreationException;
import org.semanticweb.owlapi.model.OWLOntologyStorageException;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;

public class OntoMobileAPI {
	


	public static void main(String[] args) throws OWLOntologyCreationException, InvalidFormatException, IOException, org.apache.poi.openxml4j.exceptions.InvalidFormatException, OWLOntologyStorageException {
		MappingData md = new MappingData();
	    md.ACMapingSheet1();
		md.SkeletalMaterialImpl();
		md.ArtefactMaping();
		md.Production_CenterImp();
		md.Fragment_TypeIml();
    	md.CoordinatesMaping();
    	md.MaterialIMP();
    	md.Form_TypeIMP();
    	md.Production_CenterImp();
		md.SaveOnto();
	}
		   
}
