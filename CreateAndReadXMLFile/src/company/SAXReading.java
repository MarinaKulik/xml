package company;

import java.io.FileInputStream;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SAXReading {
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		SAXParserFactory factory = SAXParserFactory.newInstance();
		SAXParser saxParser = factory.newSAXParser();

		DefaultHandler handler = new DefaultHandler() {

			boolean bname = false;
			boolean bprice = false;
			boolean bdescription = false;

			public void startDocument() {
				System.out.println("Start document");
			}

			// этот метод взывается, когда получает открытый тег <
			// Receive notification of the start of an element.
			public void startElement(String uri, String localName, String qName, Attributes attributes)
					throws SAXException {
				if (qName.equalsIgnoreCase("Name")) {
					bname = true;

				}
				if (qName.equalsIgnoreCase("Price")) {
					bprice = true;
				}
				if (qName.equalsIgnoreCase("Description")) {
					bdescription = true;

				}

			}

			// Receive notification of the end of an element.
			public void endElement(String uri, String localName, String qName) throws SAXException {

			}

			// Receive notification of character data inside an element.
			public void characters(char[] ch, int start, int length) throws SAXException {
				if (bname) {
					System.out.println("name " + new String(ch, start, length));
					bname = false;
				}

				if (bprice) {
					System.out.println("price " + new String(ch, start, length));
					bprice = false;
				}
				if (bdescription) {
					System.out.println("description " + new String(ch, start, length));
					bdescription = false;
				}
			}

			public void endDocument() {
				System.out.println("End document");
			}
		};

		saxParser.parse(new FileInputStream("C:\\XML\\breakfast.xml"), handler);

	}
}
