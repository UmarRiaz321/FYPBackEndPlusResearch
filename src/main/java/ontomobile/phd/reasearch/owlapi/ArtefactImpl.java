package ontomobile.phd.reasearch.owlapi;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;

import ontomobile.phd.research.Archaeological_Context;
import ontomobile.phd.research.Artefact;
import ontomobile.phd.research.Building;
import ontomobile.phd.research.Building_Phase;
import ontomobile.phd.research.Ceramics_Production_Centre;
import ontomobile.phd.research.Date_Range;
import ontomobile.phd.research.Form_Label;
import ontomobile.phd.research.Form_Type;
import ontomobile.phd.research.Function;
import ontomobile.phd.research.Inscription_OR_Stamp;
import ontomobile.phd.research.Material;
import ontomobile.phd.research.Mint;
import ontomobile.phd.research.OntoMobileFactory;
import ontomobile.phd.research.Production_Centre;
import ontomobile.phd.research.Site;
import ontomobile.phd.research.Site_Phase;

public class ArtefactImpl {

static DataFormatter fmt = new DataFormatter();
static MintMapping mint = new MintMapping();
static String prefix = "http://www.semanticweb.org/daan/ontologies/2016/3/BDRTontology#";
static Artefact art ;
static Artefact art2 ;
static Site site;
static Function fun;
static Building b;
static Material m ;
static Ceramics_Production_Centre CPC;
Production_CenterMaping PCImp = new Production_CenterMaping();
BuildingMapping bm = new BuildingMapping();
DateRangeMapping drm = new DateRangeMapping();
Form_TypeMaping ftM = new Form_TypeMaping();
FormLabelMapping flM = new FormLabelMapping();
Building_PhaseMapping bpm = new Building_PhaseMapping();
MaterialMapping  Mimp = new MaterialMapping();
InscriptionORStampMapping InsImp = new InscriptionORStampMapping();
ArchaeologicalContextImpl acImp = new ArchaeologicalContextImpl();
FunctionMapping funM = new FunctionMapping();
static Archaeological_Context ac;
static Archaeological_Context ac1;
static Archaeological_Context ac3;
static Date_Range dr;
static Date_Range dr1;
static Building_Phase bp;
static Inscription_OR_Stamp ins;
static Form_Type ftype;
static Form_Label flabel;
static Mint mi;

public void AddFromForts(Sheet sheet,OntoMobileFactory factory) {
	
	for(int i = 1; i<1609; i++)
	 {
		String ArtefacrContext ="";
		String Catalogue_Number = "";
		String has_description ="";
        String has_description2 = "";
        String has_description_Loc = "";
        String has_description_Loc2 = "";
        String Gender ="";
        String military ="";
        String officer ="";
        String Decent ="";
        String Ethincity ="";
        String HasImageUrl ="";
        String Rim_Diameter="";
        String OtherDiameter="";
        String BaseDiameter="";
        String Height ="";
        String Length ="";
        String Breadth= "";
        String Thickness= "";
        String preserved_height ="";
        String Weight ="";
        String Reference ="";
        String ArtefacrContext2 ="";

		Cell ArtefacrContextCell = sheet.getRow(i).getCell(0);
	    Cell has_descriptionCell = sheet.getRow(i).getCell(12);
	    Cell has_description2Cell = sheet.getRow(i).getCell(13);
	    Cell has_description_LocCell = sheet.getRow(i).getCell(20);
	    Cell has_description_Loc2Cell = sheet.getRow(i).getCell(27);
	    Cell GenderCell = sheet.getRow(i).getCell(28);
	    Cell militaryCell = sheet.getRow(i).getCell(29);
	    Cell officerCell = sheet.getRow(i).getCell(30);
	    Cell DecentCell = sheet.getRow(i).getCell(31);
	    Cell EthincityCell = sheet.getRow(i).getCell(32);
	    Cell HasImageUrlCell = sheet.getRow(i).getCell(34);
	    Cell Rim_DiameterCell = sheet.getRow(i).getCell(35);
	    Cell OtherDiameterCell = sheet.getRow(i).getCell(36);
	    Cell BaseDiameterCell = sheet.getRow(i).getCell(37);
	    Cell HeightCell = sheet.getRow(i).getCell(38);
	    Cell LengthCell = sheet.getRow(i).getCell(39);
	    Cell BreadthCell = sheet.getRow(i).getCell(40);
	    Cell ThicknessCell = sheet.getRow(i).getCell(41);
	    Cell preserved_heightCell = sheet.getRow(i).getCell(42);
	    Cell WeightCell = sheet.getRow(i).getCell(43);
	    Cell ReferenceCell = sheet.getRow(i).getCell(44);
	    Cell ArtefacrContext2Cell = sheet.getRow(i).getCell(45);

	// Formation Strings for input
		if(ArtefacrContextCell!=null){
			ArtefacrContext = fmt.formatCellValue(ArtefacrContextCell);
			Catalogue_Number = ArtefacrContext.replaceAll("\\D+", "");
		}
		if(ArtefacrContext2Cell!=null){
			ArtefacrContext2 = fmt.formatCellValue(ArtefacrContext2Cell);
			ArtefacrContext2 = ArtefacrContext2.replaceAll("\\s+", "");
		}
	    if(has_descriptionCell!=null){
	    	
	    	has_description = FormateDescription(fmt.formatCellValue(has_descriptionCell));
	    }
        if(has_description2Cell!=null){
	    	has_description = FormateDescription(fmt.formatCellValue(has_descriptionCell));
	    }
        if(has_description_LocCell!=null){
        	has_description_Loc = FormateDescription(fmt.formatCellValue(has_description_LocCell));
        }
        if(has_description_Loc2Cell!=null){
        	has_description_Loc2 = FormateDescription(fmt.formatCellValue(has_description_Loc2Cell));
        }
        if(GenderCell!=null){
        	Gender = FormateLable(fmt.formatCellValue(GenderCell));
        }
        if(militaryCell!=null){
        	military = FormateLable(fmt.formatCellValue(militaryCell));
        }
        if(officerCell!=null){
        	officer = FormateLable(fmt.formatCellValue(officerCell));
        }
        if(DecentCell!=null){
        	Decent = FormateLable(fmt.formatCellValue(DecentCell));
        }
        if(EthincityCell!=null){
        	Ethincity = FormateLable(fmt.formatCellValue(EthincityCell));
        }
        if(HasImageUrlCell!=null){
        	HasImageUrl = fmt.formatCellValue(HasImageUrlCell);
        }
        if(Rim_DiameterCell!=null){
        	Rim_Diameter = FormateRimDiameter(fmt.formatCellValue(Rim_DiameterCell));
        }
        if(OtherDiameterCell!=null){
        	OtherDiameter = FormateRimDiameter(fmt.formatCellValue(OtherDiameterCell));
        }
        if(BaseDiameterCell!=null){
        	BaseDiameter = FormateRimDiameter(fmt.formatCellValue(BaseDiameterCell));
        }
        if(HeightCell!=null){
        	Height = FormateRimDiameter(fmt.formatCellValue(HeightCell));
        }
        if(LengthCell!=null){
        	Length = FormateRimDiameter(fmt.formatCellValue(LengthCell));
        }
        if(BreadthCell!=null){
        	Breadth = FormateRimDiameter(fmt.formatCellValue(BreadthCell));
        }
        if(ThicknessCell!=null){
        	
        	Thickness = FormateThickness(fmt.formatCellValue(ThicknessCell));
        }
        if(preserved_heightCell!=null){
        	
        	preserved_height = FormateRimDiameter(fmt.formatCellValue(preserved_heightCell));
        }
        if(WeightCell!=null){
        	
        	Weight = FormateRimDiameter(fmt.formatCellValue(WeightCell));
        }
       if(ReferenceCell!=null){
        	
    	   Reference = FormateDescription(fmt.formatCellValue(ReferenceCell));
        }
	   
	   
	    
	    
		// Adding Instances
		if(!ArtefacrContext.isEmpty()){
			art = factory.createArtefact(prefix+Values.Rottweil_Forts_+ArtefacrContext); 
			site= factory.createSite("Rottweil_(AF_V)");
		}
		
		//Data Properties
		if(!Catalogue_Number.isEmpty()){art.addHas_Catalogue_Number(Catalogue_Number);}
		if(!has_description.isEmpty()){art.addHas_Description(has_description);}
		if(!has_description2.isEmpty()){art.addHas_Description(has_description2);}
		if(!has_description_Loc.isEmpty()){art.addHas_Description(has_description_Loc);}
		if(!has_description_Loc2.isEmpty()){art.addHas_Description(has_description_Loc2);}
		if(!Gender.isEmpty()){art.addHas_identity_Label(Gender);}
		if(!military.isEmpty()){art.addHas_identity_Label(military);}
		if(!officer.isEmpty()){art.addHas_identity_Label(officer);}
		if(!Decent.isEmpty()){art.addHas_identity_Label(Decent);}
		if(!Ethincity.isEmpty()){art.addHas_identity_Label(Ethincity);}
		if(!HasImageUrl.isEmpty()){art.addHas_Image_URL(HasImageUrl);}
		if(!Rim_Diameter.isEmpty()){art.addHas_Rim_Diameter(Float.parseFloat(Rim_Diameter));}
		if(!OtherDiameter.isEmpty()){art.addHas_Diameter_other(Float.parseFloat(OtherDiameter));}
		if(!BaseDiameter.isEmpty()){art.addHas_Base_Diameter(Float.parseFloat(BaseDiameter));}
		if(!Height.isEmpty()){art.addHas_Height(Float.parseFloat(Height));}
		if(!Length.isEmpty()){art.addHas_Length(Float.parseFloat(Length));}
		if(!Breadth.isEmpty()){art.addHas_breadth(Float.parseFloat(Breadth));}
		if(!Thickness.isEmpty()){art.addHas_Thickness(Float.parseFloat(Thickness));}
		if(!preserved_height.isEmpty()){art.addHas_preserved_Height(Float.parseFloat(preserved_height));}
		if(!Weight.isEmpty()){art.addHas_weight(Float.parseFloat(Weight));}
		if(!Reference.isEmpty()){art.addHas_Reference(Reference);}
		
		
		//Object Properties
		art.addWas_found_at_Site(site);
		b = bm.InstancesFromForts(sheet, i, factory);
		if(b!=null){art.addIs_associated_with(b);}
		    ac1 = acImp.AddInstancesFromForts(sheet, factory, i, 22);
		    if(ac1!=null){ art.addWas_found_in_Archaeological_Context(ac1);}
		    ac = acImp.AddInstancesFromForts(sheet, factory, i,21);
		    if(ac!=null){ art.addWas_found_in_Archaeological_Context(ac);}
		    ac3 = acImp.AddInstancesFromForts(sheet, factory, i,23);
		    if(ac3!=null){ art.addWas_found_in_Archaeological_Context(ac3);}
		   dr = drm.AddingInstanceFromForts(sheet, factory, i,24);
		   if(dr!=null){art.addHas_Date_Range(dr);}
		   dr1 = drm.AddingInstanceFromForts(sheet, factory, i,25);
		   if(dr1!=null){art.addHas_Date_Range(dr1);}
		   bp = bpm.AddInsFromForts(sheet, factory, i);
		   if(bp!=null){art.addIs_associated_with_Phase(bp);}
		   ins = InsImp.addInstancesFromForts(sheet, factory, i);
		   if(ins!=null){art.addHas_Inscription_OR_Stamp(ins);}
		   if(!ArtefacrContext2.isEmpty()){
			   art2 = factory.createArtefact(prefix+Values.Rottweil_Forts_+ArtefacrContext2);
			   art.addHas_Artefact_relation_with(art2);
		   }
		   ftype = ftM.AddInsFromForts(sheet, factory, i);
		   if(ftype!=null){art.addHas_Form_Type(ftype);}
		   flabel = flM.AddInsFromForts(sheet, factory, i);
		   if(flabel!=null){art.addHas_Form_Label(flabel);}
		   fun = funM.AddInsFromForts(sheet, factory, i,5);
		   if(fun!=null){
			   art.addHas_Function(fun);
		   }
		   fun = funM.AddInsFromForts(sheet, factory, i,6);
		   if(fun!=null){
			   art.addHas_Function(fun);
		   }
		   fun = funM.AddInsFromForts(sheet, factory, i,7);
		   if(fun!=null){
			   art.addHas_Function(fun);
		   }
		   m = Mimp.AddInsFromForts(sheet, factory, i, 8);
		   if(m!=null){
			   art.addIs_made_from(m);
		   }
		   m = Mimp.AddInsFromForts(sheet, factory, i, 9);
		   if(m!=null){
			   art.addIs_made_from(m);
		   }
		   CPC =PCImp.AddInstofCPCFromForts(sheet, factory, i, 10);
		   if(CPC!=null){art.addWas_produced_at(CPC);}
		   
	}	

}


private String FormateLable(String str) {
	String FormatedString ="";
	str = str.trim();
	if(str.contains("N/A")){
		str = "";
	}
	if(!str.isEmpty()){
		
		FormatedString = str;
	}
	return FormatedString;
}


public void AddFromCemetry(Sheet sheet1,OntoMobileFactory factory){
	
	for(int i = 1; i<7746; i++){
		String ArtefactContext = "";
		String ArtefactContext2 ="";
		String CatelougNumber = "";
		String Description = "";
		String Description2 ="";
		String Decoration ="";
		String Decoration2 = "";
		String Descrpition_Met="";
		String Use_Wear ="";
		String has_Dimensions  ="";
		String has_Description_preservation ="";
		String has_Base_Diameter = "";
		String Rim_Diameter ="";
		String Diameter_other="";
		String Thickness ="";
		String Length="";
		String Breadth="";
		String Height ="";
		String Description_material ="";
		String weight="";
		String Reference ="";	
		String surrounding_material="";
		String surrounding_material2 ="";
		String colour = "";
		String Image_URL = "";
		String Decoration3 = "";
		String restoration_evidence ="";
		String associated_Emperor = "";
		String Current_Location ="";
		
		
		
		Cell AretfactInstance = sheet1.getRow(i).getCell(11);
		Cell AretfactInstance2 = sheet1.getRow(i).getCell(42);
		Cell Descriptioncell = sheet1.getRow(i).getCell(15);
		Cell DecorationCell = sheet1.getRow(i).getCell(18);
		Cell Desciption2Cell = sheet1.getRow(i).getCell(23);
		Cell Decoration2Cell = sheet1.getRow(i).getCell(24);
		Cell DescriptionMCell = sheet1.getRow(i).getCell(25);
		Cell HasUseWearCell = sheet1.getRow(i).getCell(26);
		Cell hasDescriptionpreservationCell = sheet1.getRow(i).getCell(27);
		Cell has_DimensionsCell = sheet1.getRow(i).getCell(28);
		Cell Base_DiameterCell = sheet1.getRow(i).getCell(29);
		Cell Rim_DiameterCell = sheet1.getRow(i).getCell(30);
		Cell Diameter_otherCell = sheet1.getRow(i).getCell(31);
		Cell ThicknessCell =sheet1.getRow(i).getCell(32);
		Cell LengthCell = sheet1.getRow(i).getCell(33);
		Cell BreadthCell = sheet1.getRow(i).getCell(34);
		Cell HeightCell = sheet1.getRow(i).getCell(35);
		Cell Description_materialCell = sheet1.getRow(i).getCell(36);
        Cell weightCell = sheet1.getRow(i).getCell(37);
        Cell ReferenceCell = sheet1.getRow(i).getCell(38);
        Cell surrounding_materialCell = sheet1.getRow(i).getCell(40);
        Cell surrounding_materialCell2 = sheet1.getRow(i).getCell(41);
        Cell colourCell = sheet1.getRow(i).getCell(42);
        Cell Image_URLCell = sheet1.getRow(i).getCell(45);
        Cell Decoration3Cell = sheet1.getRow(i).getCell(48);
        Cell restoration_evidenceCell = sheet1.getRow(i).getCell(49);
        Cell associated_EmperorCell = sheet1.getRow(i).getCell(50);
        Cell Current_LocationCell = sheet1.getRow(i).getCell(54);



		
	
		if(AretfactInstance!= null)
        {
			ArtefactContext = FormateArtefactString(fmt.formatCellValue(AretfactInstance));
	    }
		if(AretfactInstance2!= null)
        {
			ArtefactContext2 = FormateArtefactString(fmt.formatCellValue(AretfactInstance));
	    }
		if(Descriptioncell!=null)
		{
			Description = FormateDescription(fmt.formatCellValue(Descriptioncell));
		}
		if(Desciption2Cell!=null){
			
			Description2 = FormateDescription(fmt.formatCellValue(Desciption2Cell));
		}
		if(Description_materialCell!=null){
			Description_material = FormateDescription(fmt.formatCellValue(Description_materialCell));
		}
	    if(DescriptionMCell!=null){
			
			Description2 = FormateDescription(fmt.formatCellValue(DescriptionMCell));
		}
		if(DecorationCell!=null)
		{
			Decoration = FormateDecoration(fmt.formatCellValue(DecorationCell));
		}
		if(Decoration2Cell!=null)
		{
			Decoration2 = FormateDecoration(fmt.formatCellValue(Decoration2Cell));
		}
		if(HasUseWearCell!=null){
			Use_Wear = FormateDescription(fmt.formatCellValue(HasUseWearCell));
		}
		if(hasDescriptionpreservationCell!=null){
			has_Description_preservation = FormateDescription(fmt.formatCellValue(hasDescriptionpreservationCell));
		}
		if(has_DimensionsCell!=null){
			has_Dimensions = FormateDimention(fmt.formatCellValue(has_DimensionsCell));
		}
		if(Base_DiameterCell!=null){
			has_Base_Diameter = FormateDiameter(fmt.formatCellValue(Base_DiameterCell));
			
		}
		if(Rim_DiameterCell!=null){
			Rim_Diameter = FormateRimDiameter(fmt.formatCellValue(Rim_DiameterCell));
			
		}
		if(Diameter_otherCell!=null){
			Diameter_other = FormateDiameter(fmt.formatCellValue(Diameter_otherCell));
		}
		if(ThicknessCell!=null){
			Thickness = FormateThickness(fmt.formatCellValue(ThicknessCell));
		}
		if(LengthCell!=null){
			Length = FormateThickness(fmt.formatCellValue(LengthCell));
		}
		if(BreadthCell!=null){
			Breadth = FormateThickness(fmt.formatCellValue(BreadthCell));
		}
		if(HeightCell!=null){
			Height = FormateThickness(fmt.formatCellValue(HeightCell));
		}
		if(weightCell!=null){
			weight = FormateWeight(fmt.formatCellValue(weightCell));
		}
		if(ReferenceCell!=null){
			Reference = FormateReference(fmt.formatCellValue(ReferenceCell));
		}
		if(surrounding_materialCell!=null){
			surrounding_material = FormateSurroundingMaterialCell(fmt.formatCellValue(surrounding_materialCell));
		}
		if(surrounding_materialCell2!=null){
			surrounding_material2 = FormateSurroundingMaterialCell(fmt.formatCellValue(surrounding_materialCell2));
		}
		if(colourCell!= null){
			colour = FormateColour(fmt.formatCellValue(colourCell));
		}
		if(Image_URLCell!=null){
			
			Image_URL = fmt.formatCellValue(Image_URLCell);
		}
		if(Decoration3Cell!=null){
			Decoration3 = FormateDecoration(fmt.formatCellValue(Decoration3Cell));
		}
		if(restoration_evidenceCell!= null){
			restoration_evidence = fmt.formatCellValue(restoration_evidenceCell);
		}
		if(associated_EmperorCell!= null){
			associated_Emperor =fmt.formatCellValue(associated_EmperorCell);
		}
		if(Current_LocationCell!=null){
			Current_Location = fmt.formatCellValue(Current_LocationCell);
		}
		//// Adding Instances
		if(ArtefactContext!="")
		{      
			art =factory.createArtefact(prefix+Values.Rottweil_cemeteries_+ArtefactContext);
		}
		if(ArtefactContext2!="")
		{      
			art2 =factory.createArtefact(prefix+Values.Rottweil_cemeteries_+ArtefactContext2);
		}
		if(ArtefactContext.contains(",")){
		CatelougNumber = ArtefactContext.substring(0,ArtefactContext.indexOf(","));
		}
		
		
		/// Adding Data Properties
		if(!CatelougNumber.isEmpty()){art.addHas_Catalogue_Number(CatelougNumber);}
		if(!Description.isEmpty()){art.addHas_Description(Description);}
		if(!Description.isEmpty()){art.addHas_Description(Description2);}
		if(!Decoration.isEmpty()){art.addHas_Decoration(Decoration);}
		if(!Decoration2.isEmpty()){art.addHas_Decoration(Decoration2);}
		if(!Descrpition_Met.isEmpty()){art.addHas_Description_Material(Descrpition_Met);}
		if(!Description_material.isEmpty()){art.addHas_Description_Material(Description_material);}
		if(!Use_Wear.isEmpty()){art.addHas_Use_Wear(Use_Wear);}
		if(!has_Description_preservation.isEmpty()){art.addHas_Description_preservation(has_Description_preservation);}
		if(!has_Dimensions.isEmpty()){art.addHas_Dimensions(Float.parseFloat(has_Dimensions));}
		if(!has_Base_Diameter.isEmpty()){art.addHas_Base_Diameter(Float.parseFloat(has_Base_Diameter));}
		if(!Rim_Diameter.isEmpty()){art.addHas_Rim_Diameter(Float.parseFloat(Rim_Diameter));}
		if(!Diameter_other.isEmpty()){art.addHas_Diameter_other(Float.parseFloat(Diameter_other));}
		if(!Thickness.isEmpty()){art.addHas_Thickness(Float.parseFloat(Thickness));}
		if(!Length.isEmpty()){art.addHas_Length(Float.parseFloat(Length));}
		if(!Breadth.isEmpty()){art.addHas_breadth(Float.parseFloat(Breadth));}
		if(!Height.isEmpty()){art.addHas_Height(Float.parseFloat(Height));}
		if(!weight.isEmpty()){art.addHas_weight(Float.parseFloat(weight));}
		if(!Reference.isEmpty()){art.addHas_Reference(Reference);}
		if(!surrounding_material.isEmpty()){art.addHas_surrounding_material(surrounding_material);}
		if(!surrounding_material2.isEmpty()){art.addHas_surrounding_material(surrounding_material2);}
		if(!colour.isEmpty()){art.addHas_colour(colour);}
		if(!Image_URL.isEmpty()){art.addHas_Image_URL(Image_URL);}
		if(!Decoration3.isEmpty()){art.addHas_Decoration(Decoration3);}
		if(!associated_Emperor.isEmpty()){art.addAssociated_Emperor(associated_Emperor);}
		if(!restoration_evidence.isEmpty()){art.addrestoration_evidence(restoration_evidence);}
		if(!Current_Location.isEmpty()){art.addCurrent_Location(Current_Location);}
		

		
		// Object Properties
		
		flabel = flM.AddInsFromCementry(sheet1, factory, i);
		if(flabel!=null){
			art.addHas_Form_Label(flabel);
		}
		
		m = Mimp.AddInsFromCementry(sheet1, factory, i, 13);
		if(m!=null){
			
			art.addIs_made_from(m);
		}
		
		mi = mint.AddInstancesFromCemetry(sheet1, factory, i);
		
		if(mi != null){art.addWas_produced_at(mi);}
		 fun = funM.AddInsFromCementry(sheet1, factory, i,38);
		if(fun!=null){art.addHas_Function(fun);}
		if(art2!=null){art.addHas_Artefact_relation_with(art2);}
	    ins = InsImp.addInstancesFromCementry(sheet1, factory, i);
	    if(ins!=null){art.addHas_Inscription_OR_Stamp(ins);}
	    
	    Production_Centre m  = PCImp.AddInstofCPCFromCementries(sheet1, factory, i);
	    if(m!=null){art.addWas_produced_at(m);}
	    
	    dr = drm.AddingInstanceFromCementry(sheet1, factory, i, 46);
	    if(dr!=null){art.addHas_Date_Range(dr);}
	    SitePhaseIml sim = new SitePhaseIml();
	    Site_Phase sitePhase = sim.AddInstancesFromCementries(sheet1, factory, i);
	    if(sitePhase!=null){art.addIs_associated_with_Phase(sitePhase);}
	}
	
	
}



public String FormateColour(String str) {
	String FormatedString = str;
	
	if(!FormatedString.isEmpty()){
	  if(FormatedString.contains(",")){
		  String[] newS = FormatedString.split(",");
		  FormatedString = newS[0].trim();
	  }
		
	}
	
	return FormatedString;
}

public String FormateSurroundingMaterialCell(String str) {
	
	return str.trim();
}

public String FormateReference(String str) {
	
	return str;
}

public String FormateWeight(String str) {
	String FormatedString ="";
	FormatedString = str.replaceAll("\\D+","").trim();
	if(!FormatedString.isEmpty()){
		FormatedString ="0.055";
	}
	return FormatedString;
}

public String FormateThickness(String str) {
 String	FormatedString ="";
	if(!str.isEmpty()){
		if(!Character.isDigit(str.charAt(0))){
			int i =0;
			while(i < str.length() && !Character.isDigit(str.charAt(i))) i++;
			if(!str.isEmpty()){
			FormatedString = str.substring(i,str.length()).trim();}
		}else{
			FormatedString = str.trim();
		}
	}
	
	if(!FormatedString.isEmpty()){
		if(FormatedString.contains("m")){
			FormatedString = FormatedString.substring(0,FormatedString.indexOf("m"));
			FormatedString = FormatedString.replaceAll("m", "").trim();
		}
		if(FormatedString.contains("-")){
				String[] newS = FormatedString.split("-");
				FormatedString = newS[0].trim();
		} 
		
		if(FormatedString.contains("c")){
			FormatedString = FormatedString.substring(0,FormatedString.indexOf("c")).trim();
			FormatedString = FormatedString.replace("cm", "");
		}
		if(FormatedString.contains(",")){
			FormatedString = FormatedString.replace(",", ".");
		}
		if(FormatedString.contains("7 Nägel der Größe 2.1")){
			FormatedString = "2.1";
		}
		if(FormatedString.contains("x")){
			String[] newS = FormatedString.split("x");
			FormatedString = Float.toString((Float.parseFloat(newS[0].trim()) * Float.parseFloat(newS[0].trim())));
		}
		if(FormatedString.contains(";")){
			String[] newS = FormatedString.split(";");
			FormatedString = newS[0].trim();
		}
		if(FormatedString.contains("(")){
			FormatedString = FormatedString.substring(0,FormatedString.lastIndexOf("(")).trim();
		}
		if(FormatedString.endsWith(".")){FormatedString = FormatedString.substring(0,FormatedString.lastIndexOf(".")); }
	}
	return FormatedString;
	
}

private String FormateRimDiameter(String str) {
	String FormatedString ="";
	   if(!str.isEmpty()){
		if(!Character.isDigit(str.charAt(0))){
			int i =0;
			while(i < str.length() && !Character.isDigit(str.charAt(i))) i++;
			if(!str.isEmpty()){
			FormatedString = str.substring(i,str.length()).trim();}
		}else{
			FormatedString = str;
		}}
	   if(!FormatedString.isEmpty()){
		   if(FormatedString.contains("-")){
				String[] newS = FormatedString.split("-");
				FormatedString = newS[0].trim();
			} 
	
		   if(FormatedString.contains("–")){
				String[] newS = FormatedString.split("–");
				FormatedString = newS[0].trim();
			}
			if(FormatedString.contains("cm")){
				FormatedString = FormatedString.substring(0,FormatedString.lastIndexOf("c")).trim();
				FormatedString = FormatedString.replace("cm", "");
			}
			
			if(FormatedString.contains(",")){
				FormatedString = FormatedString.replace(",", ".").trim();

			}
		
			if(FormatedString.contains("(")){
				FormatedString = FormatedString.substring(0,FormatedString.lastIndexOf("(")).trim();
			}
			if(FormatedString.contains(". max")){
				FormatedString = FormatedString.replaceAll(". max", "").trim();			}
			if(FormatedString.contains("Nadel 4") || FormatedString.contains("L") ){
				FormatedString = FormatedString.substring(0,FormatedString.indexOf(".")+1);
				FormatedString = FormatedString.replaceAll(". L Nadel 4", "").trim();			}
			if(FormatedString.endsWith(".")){
				FormatedString = FormatedString.substring(0, FormatedString.lastIndexOf("."));
			    }
			   if(FormatedString.contains("x")){
					String[] newS = FormatedString.split("x");
					FormatedString = newS[0].trim();
				}
			   if(FormatedString.contains("/")){
					String[] newS = FormatedString.split("/");
					FormatedString = newS[0].trim();
				}
			   if(FormatedString.contains(";")){
					String[] newS = FormatedString.split(";");
					FormatedString = newS[0].trim();
				}
			
	   }
	return FormatedString;
}

private String FormateDiameter(String str) {
	String FormatedString ="";
   if(!str.isEmpty()){
	if(!Character.isDigit(str.charAt(0))){
		int i =0;
		while(i < str.length() && !Character.isDigit(str.charAt(i))) i++;
		if(!str.isEmpty()){
		FormatedString = str.substring(i,str.length()).trim();}
	}else{
		FormatedString = str;
	}
   }
	if(!FormatedString.isEmpty()){
		if(FormatedString.contains("-")){
			String[] newS = FormatedString.split("-");
			FormatedString = newS[0].trim();
		}
		if(FormatedString.contains("cm")){
			FormatedString = FormatedString.substring(0,FormatedString.lastIndexOf("c")).trim();
		}
		if(FormatedString.contains(",")){
			FormatedString = FormatedString.replace(",", ".");
		}
		if(FormatedString.endsWith("(innen)")){
			FormatedString = FormatedString.substring(0,5).trim();
		}
		if(FormatedString.contains("mm")){
			FormatedString = FormatedString.replace("mm", "").trim();
		}
		if(FormatedString.contains("Dicke")){
			FormatedString = FormatedString.replace("Dicke", "").trim();
		}
		if(FormatedString.contains("–")){
			FormatedString = FormatedString.substring(0,FormatedString.lastIndexOf("–")).trim();
		}
		if(FormatedString.contains(")")){
			FormatedString = FormatedString.substring(0,FormatedString.lastIndexOf(")")).trim();
		}
		if(FormatedString.contains(")")){
			FormatedString = FormatedString.substring(0,FormatedString.lastIndexOf(")")).trim();
		}
		
	}
	return FormatedString.trim();
}




private String FormateDimention(String str) {
	String FormatedString ="";
	FormatedString = str.replaceAll("\\D+","");
	if(!FormatedString.isEmpty()){
	if(FormatedString.contains("0612"))
	{
		FormatedString = "0.6" ;
	}
	else
	if(FormatedString.contains("290")){
		FormatedString = "2.0" ;
	}
	else
	if(FormatedString.contains("60634")){
		FormatedString = "6.0";
	}
	}
	
	return FormatedString;
}




private String FormateDecoration(String formatCellValue) {
	
	return formatCellValue;
}
private String FormateDescription(String str) {
	
	return str;
}
public String FormateArtefactString(String str){
	String ContextNumber ="";
	String ArtefactClass ="";
	String FormatedString = "";
	 if(str.contains(",") && !str.isEmpty()){
		   String[] artz = str.split(",");  
		   ContextNumber = artz[0].trim();
		   ArtefactClass = artz[1].trim();   
	   }
	FormatedString = ContextNumber+","+ArtefactClass;
	if(FormatedString.endsWith("(18-45 Jahre)"))
		FormatedString="";
	return FormatedString;
} 

}

