package ontomobile.phd.research.impl;

import java.util.Collection;

import org.protege.owl.codegeneration.WrappedIndividual;
import org.protege.owl.codegeneration.impl.WrappedIndividualImpl;
import org.protege.owl.codegeneration.inference.CodeGenerationInference;
import org.semanticweb.owlapi.model.IRI;

import ontomobile.phd.research.Bernhard_Group_Ib;
import ontomobile.phd.research.Coordinates;
import ontomobile.phd.research.Date_Range;
import ontomobile.phd.research.Latin_Descriptive_Label;
import ontomobile.phd.research.Vocabulary;


/**
 * Generated by Protege (http://protege.stanford.edu).<br>
 * Source Class: DefaultBernhard_Group_Ib <br>
 * @version generated on Tue Nov 26 14:33:01 GMT+00:00 2019 by umarriaz
 */
public class DefaultBernhard_Group_Ib extends WrappedIndividualImpl implements Bernhard_Group_Ib {

    public DefaultBernhard_Group_Ib(CodeGenerationInference ontology, IRI iri) {
        super(ontology, iri);
    }





    /* ***************************************************
     * Object Property http://www.semanticweb.org/daan/ontologies/2016/3/BDRTontology#has_Coordinate
     */
     
    public Collection<? extends Coordinates> getHas_Coordinate() {
        return getDelegate().getPropertyValues(getOwlIndividual(),
                                               Vocabulary.OBJECT_PROPERTY_HAS_COORDINATE,
                                               DefaultCoordinates.class);
    }

    public boolean hasHas_Coordinate() {
	   return !getHas_Coordinate().isEmpty();
    }

    public void addHas_Coordinate(Coordinates newHas_Coordinate) {
        getDelegate().addPropertyValue(getOwlIndividual(),
                                       Vocabulary.OBJECT_PROPERTY_HAS_COORDINATE,
                                       newHas_Coordinate);
    }

    public void removeHas_Coordinate(Coordinates oldHas_Coordinate) {
        getDelegate().removePropertyValue(getOwlIndividual(),
                                          Vocabulary.OBJECT_PROPERTY_HAS_COORDINATE,
                                          oldHas_Coordinate);
    }


    /* ***************************************************
     * Object Property http://www.semanticweb.org/daan/ontologies/2016/3/BDRTontology#has_Date_Range
     */
     
    public Collection<? extends Date_Range> getHas_Date_Range() {
        return getDelegate().getPropertyValues(getOwlIndividual(),
                                               Vocabulary.OBJECT_PROPERTY_HAS_DATE_RANGE,
                                               DefaultDate_Range.class);
    }

    public boolean hasHas_Date_Range() {
	   return !getHas_Date_Range().isEmpty();
    }

    public void addHas_Date_Range(Date_Range newHas_Date_Range) {
        getDelegate().addPropertyValue(getOwlIndividual(),
                                       Vocabulary.OBJECT_PROPERTY_HAS_DATE_RANGE,
                                       newHas_Date_Range);
    }

    public void removeHas_Date_Range(Date_Range oldHas_Date_Range) {
        getDelegate().removePropertyValue(getOwlIndividual(),
                                          Vocabulary.OBJECT_PROPERTY_HAS_DATE_RANGE,
                                          oldHas_Date_Range);
    }


    /* ***************************************************
     * Object Property http://www.semanticweb.org/daan/ontologies/2016/3/BDRTontology#has_Latin_Descriptive_Label
     */
     
    public Collection<? extends Latin_Descriptive_Label> getHas_Latin_Descriptive_Label() {
        return getDelegate().getPropertyValues(getOwlIndividual(),
                                               Vocabulary.OBJECT_PROPERTY_HAS_LATIN_DESCRIPTIVE_LABEL,
                                               DefaultLatin_Descriptive_Label.class);
    }

    public boolean hasHas_Latin_Descriptive_Label() {
	   return !getHas_Latin_Descriptive_Label().isEmpty();
    }

    public void addHas_Latin_Descriptive_Label(Latin_Descriptive_Label newHas_Latin_Descriptive_Label) {
        getDelegate().addPropertyValue(getOwlIndividual(),
                                       Vocabulary.OBJECT_PROPERTY_HAS_LATIN_DESCRIPTIVE_LABEL,
                                       newHas_Latin_Descriptive_Label);
    }

    public void removeHas_Latin_Descriptive_Label(Latin_Descriptive_Label oldHas_Latin_Descriptive_Label) {
        getDelegate().removePropertyValue(getOwlIndividual(),
                                          Vocabulary.OBJECT_PROPERTY_HAS_LATIN_DESCRIPTIVE_LABEL,
                                          oldHas_Latin_Descriptive_Label);
    }


    /* ***************************************************
     * Object Property http://www.semanticweb.org/daan/ontologies/2016/3/BDRTontology#has_Stratigraphic_Relation_with
     */
     
    public Collection<? extends WrappedIndividual> getHas_Stratigraphic_Relation_with() {
        return getDelegate().getPropertyValues(getOwlIndividual(),
                                               Vocabulary.OBJECT_PROPERTY_HAS_STRATIGRAPHIC_RELATION_WITH,
                                               WrappedIndividualImpl.class);
    }

    public boolean hasHas_Stratigraphic_Relation_with() {
	   return !getHas_Stratigraphic_Relation_with().isEmpty();
    }

    public void addHas_Stratigraphic_Relation_with(WrappedIndividual newHas_Stratigraphic_Relation_with) {
        getDelegate().addPropertyValue(getOwlIndividual(),
                                       Vocabulary.OBJECT_PROPERTY_HAS_STRATIGRAPHIC_RELATION_WITH,
                                       newHas_Stratigraphic_Relation_with);
    }

    public void removeHas_Stratigraphic_Relation_with(WrappedIndividual oldHas_Stratigraphic_Relation_with) {
        getDelegate().removePropertyValue(getOwlIndividual(),
                                          Vocabulary.OBJECT_PROPERTY_HAS_STRATIGRAPHIC_RELATION_WITH,
                                          oldHas_Stratigraphic_Relation_with);
    }


    /* ***************************************************
     * Object Property http://www.semanticweb.org/daan/ontologies/2016/3/BDRTontology#is_overlain_by
     */
     
    public Collection<? extends WrappedIndividual> getIs_overlain_by() {
        return getDelegate().getPropertyValues(getOwlIndividual(),
                                               Vocabulary.OBJECT_PROPERTY_IS_OVERLAIN_BY,
                                               WrappedIndividualImpl.class);
    }

    public boolean hasIs_overlain_by() {
	   return !getIs_overlain_by().isEmpty();
    }

    public void addIs_overlain_by(WrappedIndividual newIs_overlain_by) {
        getDelegate().addPropertyValue(getOwlIndividual(),
                                       Vocabulary.OBJECT_PROPERTY_IS_OVERLAIN_BY,
                                       newIs_overlain_by);
    }

    public void removeIs_overlain_by(WrappedIndividual oldIs_overlain_by) {
        getDelegate().removePropertyValue(getOwlIndividual(),
                                          Vocabulary.OBJECT_PROPERTY_IS_OVERLAIN_BY,
                                          oldIs_overlain_by);
    }


    /* ***************************************************
     * Object Property http://www.semanticweb.org/daan/ontologies/2016/3/BDRTontology#is_part_of
     */
     
    public Collection<? extends WrappedIndividual> getIs_part_of() {
        return getDelegate().getPropertyValues(getOwlIndividual(),
                                               Vocabulary.OBJECT_PROPERTY_IS_PART_OF,
                                               WrappedIndividualImpl.class);
    }

    public boolean hasIs_part_of() {
	   return !getIs_part_of().isEmpty();
    }

    public void addIs_part_of(WrappedIndividual newIs_part_of) {
        getDelegate().addPropertyValue(getOwlIndividual(),
                                       Vocabulary.OBJECT_PROPERTY_IS_PART_OF,
                                       newIs_part_of);
    }

    public void removeIs_part_of(WrappedIndividual oldIs_part_of) {
        getDelegate().removePropertyValue(getOwlIndividual(),
                                          Vocabulary.OBJECT_PROPERTY_IS_PART_OF,
                                          oldIs_part_of);
    }


    /* ***************************************************
     * Object Property http://www.semanticweb.org/daan/ontologies/2016/3/BDRTontology#is_part_of_spatial
     */
     
    public Collection<? extends WrappedIndividual> getIs_part_of_spatial() {
        return getDelegate().getPropertyValues(getOwlIndividual(),
                                               Vocabulary.OBJECT_PROPERTY_IS_PART_OF_SPATIAL,
                                               WrappedIndividualImpl.class);
    }

    public boolean hasIs_part_of_spatial() {
	   return !getIs_part_of_spatial().isEmpty();
    }

    public void addIs_part_of_spatial(WrappedIndividual newIs_part_of_spatial) {
        getDelegate().addPropertyValue(getOwlIndividual(),
                                       Vocabulary.OBJECT_PROPERTY_IS_PART_OF_SPATIAL,
                                       newIs_part_of_spatial);
    }

    public void removeIs_part_of_spatial(WrappedIndividual oldIs_part_of_spatial) {
        getDelegate().removePropertyValue(getOwlIndividual(),
                                          Vocabulary.OBJECT_PROPERTY_IS_PART_OF_SPATIAL,
                                          oldIs_part_of_spatial);
    }


    /* ***************************************************
     * Object Property http://www.semanticweb.org/daan/ontologies/2016/3/BDRTontology#is_part_of_temporal
     */
     
    public Collection<? extends WrappedIndividual> getIs_part_of_temporal() {
        return getDelegate().getPropertyValues(getOwlIndividual(),
                                               Vocabulary.OBJECT_PROPERTY_IS_PART_OF_TEMPORAL,
                                               WrappedIndividualImpl.class);
    }

    public boolean hasIs_part_of_temporal() {
	   return !getIs_part_of_temporal().isEmpty();
    }

    public void addIs_part_of_temporal(WrappedIndividual newIs_part_of_temporal) {
        getDelegate().addPropertyValue(getOwlIndividual(),
                                       Vocabulary.OBJECT_PROPERTY_IS_PART_OF_TEMPORAL,
                                       newIs_part_of_temporal);
    }

    public void removeIs_part_of_temporal(WrappedIndividual oldIs_part_of_temporal) {
        getDelegate().removePropertyValue(getOwlIndividual(),
                                          Vocabulary.OBJECT_PROPERTY_IS_PART_OF_TEMPORAL,
                                          oldIs_part_of_temporal);
    }


    /* ***************************************************
     * Object Property http://www.semanticweb.org/daan/ontologies/2016/3/BDRTontology#is_subset_of
     */
     
    public Collection<? extends WrappedIndividual> getIs_subset_of() {
        return getDelegate().getPropertyValues(getOwlIndividual(),
                                               Vocabulary.OBJECT_PROPERTY_IS_SUBSET_OF,
                                               WrappedIndividualImpl.class);
    }

    public boolean hasIs_subset_of() {
	   return !getIs_subset_of().isEmpty();
    }

    public void addIs_subset_of(WrappedIndividual newIs_subset_of) {
        getDelegate().addPropertyValue(getOwlIndividual(),
                                       Vocabulary.OBJECT_PROPERTY_IS_SUBSET_OF,
                                       newIs_subset_of);
    }

    public void removeIs_subset_of(WrappedIndividual oldIs_subset_of) {
        getDelegate().removePropertyValue(getOwlIndividual(),
                                          Vocabulary.OBJECT_PROPERTY_IS_SUBSET_OF,
                                          oldIs_subset_of);
    }


    /* ***************************************************
     * Object Property http://www.semanticweb.org/daan/ontologies/2016/3/BDRTontology#is_superset_of
     */
     
    public Collection<? extends WrappedIndividual> getIs_superset_of() {
        return getDelegate().getPropertyValues(getOwlIndividual(),
                                               Vocabulary.OBJECT_PROPERTY_IS_SUPERSET_OF,
                                               WrappedIndividualImpl.class);
    }

    public boolean hasIs_superset_of() {
	   return !getIs_superset_of().isEmpty();
    }

    public void addIs_superset_of(WrappedIndividual newIs_superset_of) {
        getDelegate().addPropertyValue(getOwlIndividual(),
                                       Vocabulary.OBJECT_PROPERTY_IS_SUPERSET_OF,
                                       newIs_superset_of);
    }

    public void removeIs_superset_of(WrappedIndividual oldIs_superset_of) {
        getDelegate().removePropertyValue(getOwlIndividual(),
                                          Vocabulary.OBJECT_PROPERTY_IS_SUPERSET_OF,
                                          oldIs_superset_of);
    }


    /* ***************************************************
     * Object Property http://www.semanticweb.org/daan/ontologies/2016/3/BDRTontology#overlays
     */
     
    public Collection<? extends WrappedIndividual> getOverlays() {
        return getDelegate().getPropertyValues(getOwlIndividual(),
                                               Vocabulary.OBJECT_PROPERTY_OVERLAYS,
                                               WrappedIndividualImpl.class);
    }

    public boolean hasOverlays() {
	   return !getOverlays().isEmpty();
    }

    public void addOverlays(WrappedIndividual newOverlays) {
        getDelegate().addPropertyValue(getOwlIndividual(),
                                       Vocabulary.OBJECT_PROPERTY_OVERLAYS,
                                       newOverlays);
    }

    public void removeOverlays(WrappedIndividual oldOverlays) {
        getDelegate().removePropertyValue(getOwlIndividual(),
                                          Vocabulary.OBJECT_PROPERTY_OVERLAYS,
                                          oldOverlays);
    }


    /* ***************************************************
     * Data Property http://www.semanticweb.org/daan/ontologies/2016/3/BDRTontology#has_Description
     */
     
    public Collection<? extends String> getHas_Description() {
		return getDelegate().getPropertyValues(getOwlIndividual(), Vocabulary.DATA_PROPERTY_HAS_DESCRIPTION, String.class);
    }

    public boolean hasHas_Description() {
		return !getHas_Description().isEmpty();
    }

    public void addHas_Description(String newHas_Description) {
	    getDelegate().addPropertyValue(getOwlIndividual(), Vocabulary.DATA_PROPERTY_HAS_DESCRIPTION, newHas_Description);
    }

    public void removeHas_Description(String oldHas_Description) {
		getDelegate().removePropertyValue(getOwlIndividual(), Vocabulary.DATA_PROPERTY_HAS_DESCRIPTION, oldHas_Description);
    }


    /* ***************************************************
     * Data Property http://www.semanticweb.org/daan/ontologies/2016/3/BDRTontology#has_Description_Location
     */
     
    public Collection<? extends String> getHas_Description_Location() {
		return getDelegate().getPropertyValues(getOwlIndividual(), Vocabulary.DATA_PROPERTY_HAS_DESCRIPTION_LOCATION, String.class);
    }

    public boolean hasHas_Description_Location() {
		return !getHas_Description_Location().isEmpty();
    }

    public void addHas_Description_Location(String newHas_Description_Location) {
	    getDelegate().addPropertyValue(getOwlIndividual(), Vocabulary.DATA_PROPERTY_HAS_DESCRIPTION_LOCATION, newHas_Description_Location);
    }

    public void removeHas_Description_Location(String oldHas_Description_Location) {
		getDelegate().removePropertyValue(getOwlIndividual(), Vocabulary.DATA_PROPERTY_HAS_DESCRIPTION_LOCATION, oldHas_Description_Location);
    }


    /* ***************************************************
     * Data Property http://www.semanticweb.org/daan/ontologies/2016/3/BDRTontology#has_Reference
     */
     
    public Collection<? extends String> getHas_Reference() {
		return getDelegate().getPropertyValues(getOwlIndividual(), Vocabulary.DATA_PROPERTY_HAS_REFERENCE, String.class);
    }

    public boolean hasHas_Reference() {
		return !getHas_Reference().isEmpty();
    }

    public void addHas_Reference(String newHas_Reference) {
	    getDelegate().addPropertyValue(getOwlIndividual(), Vocabulary.DATA_PROPERTY_HAS_REFERENCE, newHas_Reference);
    }

    public void removeHas_Reference(String oldHas_Reference) {
		getDelegate().removePropertyValue(getOwlIndividual(), Vocabulary.DATA_PROPERTY_HAS_REFERENCE, oldHas_Reference);
    }


}
