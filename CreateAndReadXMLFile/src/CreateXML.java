
import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class CreateXML {

	public static void main(String[] args) throws ParserConfigurationException, TransformerException {
		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();

		Document document = documentBuilder.newDocument();
		Element element = document.createElement("Developer");
		document.appendChild(element);

		Attr attr = document.createAttribute("id");
		attr.setValue("one");
		element.setAttributeNode(attr);

		Element name = document.createElement("Name");
		name.appendChild(document.createTextNode("Sasha"));
		element.appendChild(name);

		Element lastname = document.createElement("LastName");
		lastname.appendChild(document.createTextNode("Settle"));
		element.appendChild(lastname);

		Element age = document.createElement("Age");
		age.appendChild(document.createTextNode("29"));
		element.appendChild(age);

		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		
		DOMSource domSource = new DOMSource(document);
		
		StreamResult streamResult = new StreamResult(new File("C:\\XML\\data.xml"));
		transformer.transform(domSource, streamResult);

	}

}
