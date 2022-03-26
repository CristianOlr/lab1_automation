package XLM_DOM;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class DomParserDemo {
    public static void main(String[] args) {

        try {
            File inputFile = new File("company.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
            NodeList nList = doc.getElementsByTagName("employee");

            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    System.out.println("\nEmployee ID: "
                            + eElement.getAttribute("emplId"));
                    System.out.println("Last Name: "
                            + eElement
                            .getElementsByTagName("lastName")
                            .item(0)
                            .getTextContent());
                    System.out.println("First Name: "
                            + eElement
                            .getElementsByTagName("firstName")
                            .item(0)
                            .getTextContent());
                    System.out.println("Birth Date: "
                            + eElement
                            .getElementsByTagName("birthDate")
                            .item(0)
                            .getTextContent());
                    System.out.println("Position: "
                            + eElement
                            .getElementsByTagName("position")
                            .item(0)
                            .getTextContent());

                    System.out.println("Skills:");
                    NodeList nList1 = eElement.getElementsByTagName("skill");
                    for (int temp1 = 0; temp1 < nList1.getLength(); temp1++) {
                        Node nNode1 = nList1.item(temp1);
                        if (nNode1.getNodeType() == Node.ELEMENT_NODE) {
                            Element eElement1 = (Element) nNode1;
                            System.out.println("\tSkill" + (temp1+1) + ": "
                                    + eElement1.getTextContent());
                        }
                    }
                    System.out.println("Manager ID: "
                            + eElement
                            .getElementsByTagName("managerId")
                            .item(0)
                            .getTextContent());
                    System.out.println();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
