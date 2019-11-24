package labyak;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

/*
 * /Custom SAX Parser
 */
public class MySaxParser {

	public MySaxParser() {

	}

	public MyHandler parsingInput() {
		SAXParserFactory factory = SAXParserFactory.newInstance();
		SAXParser saxParser;
		MyHandler handler = new MyHandler();
		try {
			saxParser = factory.newSAXParser();
			saxParser.parse(new File("input.xml"), handler);
		} catch (ParserConfigurationException | SAXException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return handler;

	}

}
