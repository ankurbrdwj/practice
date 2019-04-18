package labyak;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

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
