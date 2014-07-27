package org.ideademo.scenarios.services.util;

import org.apache.commons.lang.StringUtils;
import org.apache.tapestry5.internal.TapestryInternalUtils;
import org.ideademo.scenarios.entities.Scenario;
import org.apache.tapestry5.ioc.Messages;


import org.apache.tapestry5.ioc.annotations.Inject;

import com.itextpdf.text.Anchor;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.ListItem;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;

import org.apache.log4j.Logger;
/**
 * This is a PDFTable wrapper to the entity class 
 * @author Uday
 *
 */
public class PDFTable {
	
	  private static Logger logger = Logger.getLogger(PDFTable.class);
	
	@Inject
	Messages messages;
	
	private Scenario scenario;
	
	public PDFTable(Scenario scenario) {
		this.scenario = scenario;
	}

	public Scenario getScenario() {
		return scenario;
	}

	public void setScenario(Scenario scenario) {
		this.scenario = scenario;
	}

	public PdfPTable getPDFTable()
	{
        // create table, 2 columns
        String acronym = StringUtils.trimToEmpty(scenario.getCode());
        String name = StringUtils.trimToEmpty(scenario.getName());
        String description = StringUtils.trimToEmpty(scenario.getDescription());
        String leadAgencies = StringUtils.trimToEmpty(scenario.getOrganization());
        String contacts = StringUtils.trimToEmpty(scenario.getContact());
        String url = StringUtils.trimToEmpty(scenario.getUrl());
    		
    		
          PdfPTable table = new PdfPTable(2);
          try
          {
            table.setWidths(new int[]{1, 4});
          }
          catch (Exception e)
          {
        	  logger.fatal("Could not setWidths???" + e );
          }
          
          table.setSplitRows(false);
          
          PdfPCell nameTitle = new PdfPCell(new Phrase("Name")); 
          
          if (StringUtils.isNotBlank(acronym)) name = name + " (" + acronym + ")";
          PdfPCell nameCell = new PdfPCell(new Phrase(name));
          
          nameTitle.setBackgroundColor(BaseColor.CYAN);  nameCell.setBackgroundColor(BaseColor.LIGHT_GRAY);
          
          table.addCell(nameTitle);  table.addCell(nameCell);          		          		
    		


    		//region
    		com.itextpdf.text.List regions = new com.itextpdf.text.List(com.itextpdf.text.List.UNORDERED);
    		if (scenario.isCentralNorthPacific())
    		{
    			ListItem item = new ListItem(getLabel("centralNorthPacific")); regions.add(item);
    		}
    		if (scenario.isStateOfHawaii())
    		{
    			ListItem item = new ListItem(getLabel("stateOfHawaii")); regions.add(item);
    		}
    		if (scenario.isNorthWestHawaiianIslands())
    		{
    			ListItem item = new ListItem(getLabel("northWesternHawaiianIslands")); regions.add(item);
    		}
    		if (scenario.isPacificRemoteIslands())
    		{
    			ListItem item = new ListItem(getLabel("pacificRemoteIslands")); regions.add(item);
    		}
    		if (scenario.isWesternNorthPacific())
    		{
    			ListItem item = new ListItem(getLabel("westernNorthPacific")); regions.add(item);
    		}
    		if (scenario.isCnmi())
    		{
    			ListItem item = new ListItem(getLabel("cnmi")); regions.add(item);
    		}
    		if (scenario.isFsm())
    		{
    			ListItem item = new ListItem(getLabel("fsm")); regions.add(item);
    		}
    		if (scenario.isGuam())
    		{
    			ListItem item = new ListItem(getLabel("guam")); regions.add(item);
    		}
    		if (scenario.isPalau())
    		{
    			ListItem item = new ListItem(getLabel("palau")); regions.add(item);
    		}
    		if (scenario.isRmi())
    		{
    			ListItem item = new ListItem(getLabel("rmi")); regions.add(item);
    		}
    		if (scenario.isOtherWesternNorthPacific())
    		{
    			ListItem item = new ListItem(getLabel("otherWesternNorthPacific")); regions.add(item);
    		}
    		if (scenario.isSouthPacific())
    		{
    			ListItem item = new ListItem(getLabel("southPacific")); regions.add(item);
    		}
    		if (scenario.isAmericanSamoa())
    		{
    			ListItem item = new ListItem(getLabel("americanSamoa")); regions.add(item);
    		}
    		if (scenario.isAustralia())
    		{
    			ListItem item = new ListItem(getLabel("australia")); regions.add(item);
    		}
    		if (scenario.isCookIslands())
    		{
    			ListItem item = new ListItem(getLabel("cookIslands")); regions.add(item);
    		}
    		if (scenario.isFiji())
    		{
    			ListItem item = new ListItem(getLabel("fiji")); regions.add(item);
    		}
    		if (scenario.isFrenchPolynesia())
    		{
    			ListItem item = new ListItem(getLabel("frenchPolynesia")); regions.add(item);
    		}
    		if (scenario.isKiribati())
    		{
    			ListItem item = new ListItem(getLabel("kiribati")); regions.add(item);
    		}
    		if (scenario.isNewZealand())
    		{
    			ListItem item = new ListItem(getLabel("newZealand")); regions.add(item);
    		}
    		if (scenario.isPng())
    		{
    			ListItem item = new ListItem(getLabel("png")); regions.add(item);
    		}
    		if (scenario.isSamoa())
    		{
    			ListItem item = new ListItem(getLabel("samoa")); regions.add(item);
    		}
    		if (scenario.isSolomonIslands())
    		{
    			ListItem item = new ListItem(getLabel("solomonIslands")); regions.add(item);
    		}
    		if (scenario.isTonga())
    		{
    			ListItem item = new ListItem(getLabel("tonga")); regions.add(item);
    		}
    		if (scenario.isTuvalu())
    		{
    			ListItem item = new ListItem(getLabel("tuvalu")); regions.add(item);
    		}
    		if (scenario.isVanuatu())
    		{
    			ListItem item = new ListItem(getLabel("vanuatu")); regions.add(item);
    		}
    		if (scenario.isOtherSouthPacific())
    		{
    			ListItem item = new ListItem(getLabel("otherSouthPacific")); regions.add(item);
    		}
    		if (scenario.isPacificBasin())
    		{
    			ListItem item = new ListItem(getLabel("pacificBasin")); regions.add(item);
    		}
    		if (scenario.isGlobal())
    		{
    			ListItem item = new ListItem(getLabel("global")); regions.add(item);
    		}
    		
  		
    		if (regions.size() > 0)
    		{
     		  PdfPCell rCell = new PdfPCell(); rCell.addElement(regions);
     		  table.addCell(new PdfPCell(new Phrase("Regions")));  table.addCell(rCell);
    		}

    	    // ecv
    		com.itextpdf.text.List ecv = new com.itextpdf.text.List(com.itextpdf.text.List.UNORDERED);
    		if (scenario.isAtmosphericData()) 
    		{
    			ListItem item = new ListItem(getLabel("atmosphericData")); ecv.add(item);
    		}
    		if (scenario.isOceanicData()) 
    		{
    			ListItem item = new ListItem(getLabel("oceanicData")); ecv.add(item);
    		}
    		if (scenario.isTerrestrialData()) 
    		{
    			ListItem item = new ListItem(getLabel("terrestrialData")); ecv.add(item);
    		}

    		if(ecv.size() > 0)
    		{
    		  PdfPCell pdfCell = new PdfPCell(); pdfCell.addElement(ecv);
    		  table.addCell(new PdfPCell(new Phrase("Essential Climate Variable")));  table.addCell(pdfCell);
    		}

    		// phenomena/impacts
    		com.itextpdf.text.List impacts = new com.itextpdf.text.List(com.itextpdf.text.List.UNORDERED);
    		if (scenario.isDrought()) 
    		{
    			ListItem item = new ListItem(getLabel("drought")); impacts.add(item);
    		}
    		if (scenario.isRainfall()) 
    		{
    			ListItem item = new ListItem(getLabel("rainfall")); impacts.add(item);
    		}
    		if (scenario.isFlooding()) 
    		{
    			ListItem item = new ListItem(getLabel("flooding")); impacts.add(item);
    		}
    		if (scenario.isBleaching()) 
    		{
    			ListItem item = new ListItem(getLabel("bleaching")); impacts.add(item);
    		}
    		if (scenario.isOtherPhenomena()) 
    		{
    			ListItem item = new ListItem(getLabel("otherPhenomena")); impacts.add(item);
    		}

    		if(impacts.size() > 0)
    		{
    		  PdfPCell pdfCell = new PdfPCell(); pdfCell.addElement(impacts);
    		  table.addCell(new PdfPCell(new Phrase("Phenomena/Impacts")));  table.addCell(pdfCell);
    		}
    		
    		
    		
    		// spatial/scale
    		com.itextpdf.text.List scales = new com.itextpdf.text.List(com.itextpdf.text.List.UNORDERED);
   		
    		if (scenario.isGrid()) 
    		{
    			ListItem item = new ListItem(getLabel("grid")); scales.add(item);
    		}
    		if (scenario.isPoint()) 
    		{
    			ListItem item = new ListItem(getLabel("point")); scales.add(item);
    		}
    		
    		if(scales.size() > 0)
    		{
    		  PdfPCell pdfCell = new PdfPCell(); pdfCell.addElement(scales);
    		  table.addCell(new PdfPCell(new Phrase("Spatial/Scale")));  table.addCell(pdfCell);
    		}

    		// timescale
    		com.itextpdf.text.List timescale = new com.itextpdf.text.List(com.itextpdf.text.List.UNORDERED);
    		if (scenario.isPast()) 
    		{
    			ListItem item = new ListItem(getLabel("past")); timescale.add(item);
    		}
    		if (scenario.isCurrent()) 
    		{
    			ListItem item = new ListItem(getLabel("current")); timescale.add(item);
    		}
    		if (scenario.isFuture()) 
    		{
    			ListItem item = new ListItem(getLabel("future")); timescale.add(item);
    		}
    		if (scenario.isOneMonth()) 
    		{
    			ListItem item = new ListItem(getLabel("oneMonth")); timescale.add(item);
    		}
    		if (scenario.isThreeMonths()) 
    		{
    			ListItem item = new ListItem(getLabel("threeMonths")); timescale.add(item);
    		}
    		if (scenario.isSixMonths()) 
    		{
    			ListItem item = new ListItem(getLabel("sixMonths")); timescale.add(item);
    		}

    		
    		if(timescale.size() > 0)
    		{
    		  PdfPCell pdfCell = new PdfPCell(); pdfCell.addElement(timescale);
    		  table.addCell(new PdfPCell(new Phrase("Time Scale")));  table.addCell(pdfCell);
    		}
    		
    		// methodologies
    		com.itextpdf.text.List methodologies = new com.itextpdf.text.List(com.itextpdf.text.List.UNORDERED);
    		if (scenario.isInsitu()) 
    		{
    			ListItem item = new ListItem(getLabel("insitu")); methodologies.add(item);
    		}
    		if (scenario.isRemote()) 
    		{
    			ListItem item = new ListItem(getLabel("remote")); methodologies.add(item);
    		}
    		if (scenario.isStatistical()) 
    		{
    			ListItem item = new ListItem(getLabel("statistical")); methodologies.add(item);
    		}
    		if (scenario.isDynamical()) 
    		{
    			ListItem item = new ListItem(getLabel("dynamical")); methodologies.add(item);
    		}

    		
    		if(methodologies.size() > 0)
    		{
    		  PdfPCell pdfCell = new PdfPCell(); pdfCell.addElement(methodologies);
    		  table.addCell(new PdfPCell(new Phrase("Methodology")));  table.addCell(pdfCell);
    		}
    		
    		
    	    // sectors
    		com.itextpdf.text.List sectors = new com.itextpdf.text.List(com.itextpdf.text.List.UNORDERED);
    		if (scenario.isHealth()) 
    		{
    			ListItem item = new ListItem(getLabel("health")); sectors.add(item);
    		}
    		if (scenario.isFreshWater()) 
    		{
    			ListItem item = new ListItem(getLabel("freshWater")); sectors.add(item);
    		}
    		if (scenario.isEnergy()) 
    		{
    			ListItem item = new ListItem(getLabel("energy")); sectors.add(item);
    		}
    		if (scenario.isTransportation()) 
    		{
    			ListItem item = new ListItem(getLabel("transportation")); sectors.add(item);
    		}
    		if (scenario.isPlanning()) 
    		{
    			ListItem item = new ListItem(getLabel("planning")); sectors.add(item);
    		}
    		if (scenario.isSocioCultural()) 
    		{
    			ListItem item = new ListItem(getLabel("socioCultural")); sectors.add(item);
    		}
    		if (scenario.isAgriculture()) 
    		{
    			ListItem item = new ListItem(getLabel("agriculture")); sectors.add(item);
    		}
    		if (scenario.isRecreation()) 
    		{
    			ListItem item = new ListItem(getLabel("recreation")); sectors.add(item);
    		}
    		if (scenario.isEcological()) 
    		{
    			ListItem item = new ListItem(getLabel("ecological")); sectors.add(item);
    		}
    		if (scenario.isOtherSector()) 
    		{
    			ListItem item = new ListItem(getLabel("otherSector")); sectors.add(item);
    		}


    		if(sectors.size() > 0)
    		{
    		  PdfPCell pdfCell = new PdfPCell(); pdfCell.addElement(sectors);
    		  table.addCell(new PdfPCell(new Phrase("Sectors")));  table.addCell(pdfCell);
    		}
    		
    		
    		
    		
    		if (StringUtils.isNotBlank(description))
    		{
    		  table.addCell(new PdfPCell(new Phrase("Description")));  table.addCell(new PdfPCell(new Phrase(description)));
    		}

    		if (StringUtils.isNotBlank(url))
    		{
      	          Anchor link = new Anchor(StringUtils.trimToEmpty(url)); link.setReference(StringUtils.trimToEmpty(url));
    		  table.addCell(new PdfPCell(new Phrase("Url")));  table.addCell(new PdfPCell(link));
    		}
                  if (StringUtils.isNotBlank(leadAgencies))
    		{
    		  table.addCell(new PdfPCell(new Phrase("Lead Agencies")));  table.addCell(new PdfPCell(new Phrase(leadAgencies)));
    		}

    		if (StringUtils.isNotBlank(contacts))
    		{
    		  table.addCell(new PdfPCell(new Phrase("Contacts")));  table.addCell(new PdfPCell(new Phrase(contacts)));
    		}
    		
    		return table;

	}
	
	  private String getLabel (String varName)
	  {
		   String key = varName + "-label";
		   String value = "";
		   if (messages.contains(key)) value = messages.get(key);
		   else value = TapestryInternalUtils.toUserPresentable(varName);
		   return StringUtils.trimToEmpty(value);
	  }
	
}
