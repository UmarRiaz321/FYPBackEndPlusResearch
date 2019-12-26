package ontomobile.phd.reasearch.owlapi;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;

import ontomobile.phd.research.OntoMobileFactory;
import ontomobile.phd.research.Site;

public class SiteMapping {

	static DataFormatter fmt = new DataFormatter();
	static MintMapping mint = new MintMapping();
	static String prefix = "http://www.semanticweb.org/daan/ontologies/2016/3/BDRTontology#";
	static Site site;

	
	
	public Site AddInstance(Sheet sheet,OntoMobileFactory factory,int row){
		
	//Cell SiteInstanceCell = sheet.getRow(row).getCell()
		
		
		return site;
	}
}
