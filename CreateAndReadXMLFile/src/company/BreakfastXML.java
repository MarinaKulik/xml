package company;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class BreakfastXML {

	public static void main(String[] args) {
		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
			
			//root element
			Document document = documentBuilder.newDocument();
			Element rootElement = document.createElement("breakfast");
			document.appendChild(rootElement);
			

			
			 addFood(document, "Waffeles", "3.4$", "You have never eaten waffeles with plenty of maple syrop");
			 addFood(document, "Toasts", "5.5$", "Try our franch toasts only today");
			 
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			
			DOMSource domSource = new DOMSource(document);
			StreamResult streamResult = new StreamResult(new File("C:\\XML\\breakfast.xml"));
			transformer.transform(domSource, streamResult);
			
			
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}
	
	private static void addFood(Document document, String name, String price, String description) {
	    Element food = document.createElement("Food");
	    document.getDocumentElement().appendChild(food);

	    Element nameEl = document.createElement("Name");
	    nameEl.appendChild(document.createTextNode(name));
	    food.appendChild(nameEl);

	    Element priceEl = document.createElement("Price");
	    priceEl.appendChild(document.createTextNode(price));
	    food.appendChild(priceEl);
	    
	    Element descr = document.createElement("Description");
	    descr.appendChild(document.createTextNode(description));
	    food.appendChild(descr);
	}

}
