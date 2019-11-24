package labyak;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

/*
 * /Handler for parse function
 */
public class MyHandler extends DefaultHandler {

	private List<Labyak> yaklist = null;
	private Labyak yak = null;

	boolean bAge = false;
	boolean bName = false;
	boolean bGender = false;

	@Override
	public void startElement(String namespaceURI, String localName, String qName, Attributes atts) throws SAXException {

		if (qName.equalsIgnoreCase("labyak")) {
			// initialize Employee object and set id attribute
			yak = new Labyak();
			// initialize list
			if (yaklist == null)
				yaklist = new ArrayList<Labyak>();
			// set boolean values for fields, will be used in setting Employee
			// variables
			String name = atts.getValue("name");
			String age = atts.getValue("age");

			String gender = atts.getValue("sex");
			yak.setName(name);
			yak.setAge(Double.parseDouble(age));
			yak.setGender(gender);
		}
	}


	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		if (qName.equalsIgnoreCase("labyak")) {
			// add Employee object to list
			yaklist.add(yak);
		}
	}

	@Override
	public void characters(char ch[], int start, int length) throws SAXException {

	}

	/**
	 * @return the yaklist
	 */
	public List<Labyak> getYaklist() {
		return yaklist;
	}

	/**
	 * @param yaklist
	 *            the yaklist to set
	 */
	public void setYaklist(List<Labyak> yaklist) {
		this.yaklist = yaklist;
	}

	/**
	 * @return the yak
	 */
	public Labyak getYak() {
		return yak;
	}

	/**
	 * @param yak
	 *            the yak to set
	 */
	public void setYak(Labyak yak) {
		this.yak = yak;
	}
}
