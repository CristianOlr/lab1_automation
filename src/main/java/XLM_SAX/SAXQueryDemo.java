package XLM_SAX;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class SAXQueryDemo {
    public static void main(String[] args) {

        try {
            File inputFile = new File("company.xml");
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();
            UserHandler2 userhandler = new UserHandler2();
            saxParser.parse(inputFile, userhandler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
class UserHandler2 extends DefaultHandler {
    boolean bLastName = false;
    boolean bFirstName = false;
    boolean bBirthDate = false;
    boolean bPosition = false;
    boolean bManagerId = false;
    boolean bSkills = false;
    String emplId = null;

    @Override
    public void startElement(String uri,
                             String localName, String qName, Attributes attributes)
            throws SAXException {

        if (qName.equalsIgnoreCase("employee")) {
            emplId = attributes.getValue("emplId");
        }
        if("001".equals(emplId) && qName.equalsIgnoreCase("employee")) {
            System.out.println("\nStart Element: " + qName);
        }
        if (qName.equalsIgnoreCase("lastname")) {
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
    public void endElement(
            String uri, String localName, String qName) throws SAXException {

        if (qName.equalsIgnoreCase("employee")) {
            if(("001").equals(emplId)
                    && qName.equalsIgnoreCase("employee"))
                System.out.println("End Element: " + qName);
        }
    }


    @Override
    public void characters(
            char ch[], int start, int length) throws SAXException {

        if (bLastName && ("001").equals(emplId)) {
            //age element, set Employee age
            System.out.println("Last Name: " + new String(ch, start, length));
            bLastName = false;
        } else if (bFirstName && ("001").equals(emplId)) {
            System.out.println("First Name: " + new String(ch, start, length));
            bFirstName = false;
        } else if (bBirthDate && ("001").equals(emplId)) {
            System.out.println("Birth Date: " + new String(ch, start, length));
            bBirthDate = false;
        } else if (bPosition && ("001").equals(emplId)) {
            System.out.println("Position: " + new String(ch, start, length));
            bPosition = false;
        } else if (bManagerId && ("001").equals(emplId)) {
            System.out.println("Manager ID: " + new String(ch, start, length));
            bManagerId = false;
        } else if (bSkills && ("001").equals(emplId)) {
            System.out.println("\tSkill: " + new String(ch, start, length));
            bSkills = false;
        }
    }
}