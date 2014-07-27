package org.ideademo.scenarios.services.util;


import org.apache.tapestry5.Asset;
import org.apache.tapestry5.annotations.Path;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.services.AssetSource;



import java.awt.Toolkit;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Iterator;
import java.util.TimeZone;

import com.itextpdf.text.Anchor;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.ListItem;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;



import org.ideademo.scenarios.entities.Scenario;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

public class PDFDocument {

	private static Logger logger = Logger.getLogger(PDFDocument.class);
	
	private PdfPTable table;
	private List <PdfPTable> tables;
	private String searchResult = "";
	private java.awt.Image awtImage;
	
	

	@Inject
	@Path("context:layout/images/image067.gif")
	private Asset logoAsset;
	  
	@Inject
	private AssetSource assetSource;
	  
	public PDFDocument(PdfPTable scenario) {
		this.table= scenario;
	}
	public PDFDocument(List <PdfPTable> list) {
		this.tables = list;
	}
	
	public void setSearchResult(String searchResult) {
		this.searchResult = searchResult;
	}
	public void setAwtImage(java.awt.Image awtImage) {
		this.awtImage = awtImage;
	}

	public ByteArrayOutputStream getPDFDocument()
	{
	      // step 1: creation of a document-object
	      Document document = new Document();

	      ByteArrayOutputStream baos = new ByteArrayOutputStream();

	      try {
	              // step 2:
	              // we create a writer that listens to the document
	              // and directs a PDF-stream to a file
	              PdfWriter writer = PdfWriter.getInstance(document, baos);
	              // step 3: we open the document
	              document.open();
	              
	              if (this.awtImage != null)
	              {
	            	  com.itextpdf.text.Image logo = com.itextpdf.text.Image.getInstance(awtImage, null); 
	            	  logo.scalePercent(50);
	            	  if (logo != null) document.add(logo);
	              }

	              DateFormat formatter = new SimpleDateFormat
	                      ("EEE MMM dd HH:mm:ss zzz yyyy");
	                  Date date = new Date(System.currentTimeMillis());
	                  TimeZone eastern = TimeZone.getTimeZone("Pacific/Honolulu");
	                  formatter.setTimeZone(eastern);

	              
	              if (this.table != null)
	              {
		              document.add(new Paragraph("PaCIS Scenario" + formatter.format(date)));
		              document.add(Chunk.NEWLINE);document.add(Chunk.NEWLINE);
	            	  document.add(table);
	              }
	              
	              if (this.tables != null && this.tables.size() > 0)
	              {
		              document.add(new Paragraph("PaCIS Scenarios" + formatter.format(date)));
	                  if (StringUtils.isNotBlank(searchResult))
	                  {
		                  document.add(new Paragraph(searchResult));
	                  }
	                  document.add(Chunk.NEWLINE);document.add(Chunk.NEWLINE);
	                  Iterator <PdfPTable> iterator = tables.iterator();
                      while(iterator.hasNext())
	              	  {
	               		PdfPTable taybool = iterator.next();
		            	document.add(taybool);
	              	  }	
	              }
	              
	              
	              
	              
	      } catch (DocumentException de) {
	              logger.fatal(de.getMessage());
	      }
	      catch (IOException ie)
	      {
	    	 logger.warn("Could not find NOAA logo (likely)");
	    	 logger.warn(ie);
	      }
	      document.close();
	      return baos;
	}
}
