package XLM_SAX;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;


public class SaxParserDemo {
    public static void main(String[] args) {

        try {
            File inputFile = new File("company.xml");
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();
            UserHandler userhandler = new UserHandler();
            saxParser.parse(inputFile, userhandler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class UserHandler extends DefaultHandler {
    boolean bLastName = false;
    boolean bFirstName = false;
    boolean bBirthDate = false;
    boolean bPosition = false;
    boolean bManagerId = false;
    boolean bSkills = false;

    @Override
    public void startElement(
            String uri, String localName, String qName, Attributes attributes)
            throws SAXException {

        if (qName.equalsIgnoreCase("employee")) {
            String emplId = attributes.getValue("emplId");
            System.out.println("Employee ID: " + emplId);
        } else if (qName.equalsIgnoreCase("lastname")){
            bLastName = true;
        } else if (qName.equalsIgnoreCase("firstname")) {
            bFirstName = true;
        } else if (qName.equalsIgnoreCase("birthdate")) {
            bBirthDate = true;
        } else if (qName.equalsIgnoreCase("position")) {
            bPosition = true;
        } else if (qName.equalsIgnoreCase("managerId")) {
            bManagerId = true;
        } else if (qName.equalsIgnoreCase("skill")) {
            bSkills = true;
        }
    }

    @Override
    public void endElement(String uri,
                           String localName, String qName) throws SAXException {

        if (qName.equalsIgnoreCase("employee")) {
            System.out.println();
        }
    }

    @Override
    public void characters(char ch[], int start, int length) throws SAXException {

        if (bLastName) {
            System.out.println("Last Name: " + new String(ch, start, length));
            bLastName = false;
        } else if (bFirstName) {
            System.out.println("First Name: " + new String(ch, start, length));
            bFirstName = false;
        } else if (bBirthDate) {
            System.out.println("Birth Date: " + new String(ch, start, length));
            bBirthDate = false;
        } else if (bPosition) {
            System.out.println("Position: " + new String(ch, start, length));
            bPosition = false;
        } else if (bManagerId) {
            System.out.println("Manager ID: " + new String(ch, start, length));
            bManagerId = false;
        } else if (bSkills) {
            System.out.println("\tSkill: " + new String(ch, start, length));
            bSkills = false;
        }
    }
}
