 
import java.io.InputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.InputSource;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

public class XMLParser implements ContentHandler {
	Logger logger = Logger.getLogger(this.getClass().getName());

	private PubTypes.AllTag openingTag = PubTypes.AllTag.unidentified, closingTag = PubTypes.AllTag.unidentified;
	
	private StringBuilder builder;
	
	private Publication dtdEntry;
	
	private ArrayList<Publication> dtdEntries;
		
	public XMLParser(InputStream xmlFile) throws SAXException{
		dtdEntries = new ArrayList<Publication>();
		try {
			InputSource xmlSource = new InputSource(xmlFile);
			XMLReader parser = XMLReaderFactory.createXMLReader();
			
			parser.setContentHandler(this);
			parser.parse(xmlSource);
		}
		catch (Exception e) {
			logger.log(Level.SEVERE, "Failed to process XML File: (0) ", e);
		}
	}
	
	public ArrayList<Publication> getDTDEntries() {
		return dtdEntries;
	}
	
	@Override
	public void characters(char[] arg0, int arg1, int arg2) throws SAXException{
		builder.append(new String(arg0, arg1, arg2));
	}

	@Override
	public void endDocument() throws SAXException{
		System.out.println("Parsing Ended");
	}


	@Override
	public void endPrefixMapping(String arg0) throws SAXException{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void ignorableWhitespace(char[] arg0, int arg1, int arg2) throws SAXException{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void processingInstruction(String arg0, String arg1) throws SAXException{
		// TODO Auto-generated method stub
		
	}



	@Override
	public void skippedEntity(String arg0) throws SAXException{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void startDocument() throws SAXException{
		logger.info("Parsing Started");
	}



	@Override
	public void startPrefixMapping(String arg0, String arg1) throws SAXException{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes atts) throws SAXException {
		try {
			openingTag = PubTypes.AllTag.valueOf(PubTypes.AllTag.class, qName);
		}
		catch (Exception e){
			openingTag = PubTypes.AllTag.unidentified;
		}
		
		if (isInEnum(qName)){
			dtdEntry = new Publication(qName);
			dtdEntry.putAttribute(PubTypes.KEY, atts.getValue("key"));
		}
		
		builder = new StringBuilder();
	}

	private boolean isInEnum(String qName) {
		try{
			PubTypes.TagType.valueOf(qName);
			return true;
		}
		catch (Exception e) {
			return false;
		}
	}

	@Override
	public void setDocumentLocator(Locator locator) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXParseException
			 {
		try {
			closingTag = PubTypes.AllTag.valueOf(PubTypes.AllTag.class, qName);
		}
		catch (Exception e){
			closingTag = PubTypes.AllTag.unidentified;
		}
		
		String content = builder.toString();
		
		switch (closingTag) {
			case article:
			case inproceedings:
			case proceedings:
			case book:
			case incollection:
			case phdthesis:
			case mastersthesis:
			case www:
				dtdEntries.add(dtdEntry);
				break;
			
			case author:
			case editor:
			case cite:
			case title:
			case booktitle:
			case pages:
			case year:
			case address:
			case journal:
			case volume:
			case number:
			case month:
			case url:
			case ee:
			case cdrom:
			case publisher:
			case note:
			case crossref:
			case isbn:
			case series:
			case school:
			case chapter:
				dtdEntry.putAttribute(closingTag.name(), content);
				break;
				
			case dblp:
				logger.info("Finished parsing all Entries");
				break;
				
			case unidentified:
				break;
					
			default:
				break;
		}
			
	}

	
}
