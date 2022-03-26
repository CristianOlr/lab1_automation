package XML_XPath;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.io.File;
import java.io.IOException;

public class XPathQueryDemo {
    public static void main(String[] args) {

        try {
            File inputFile = new File("company.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder;

            dBuilder = dbFactory.newDocumentBuilder();

            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();

            XPath xPath =  XPathFactory.newInstance().newXPath();

            String expression = "//employee[@emplId='002']";
            NodeList nodeList = (NodeList) xPath.compile(expression).evaluate(
                    doc, XPathConstants.NODESET);
            System.out.println("Node list length is " + nodeList.getLength());

            for (int i = 0; i < nodeList.getLength(); i++) {
                Node nNode = nodeList.item(i);
                System.out.println("\nCurrent Element: " + nNode.getNodeName());

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    System.out.println("Employee ID: "
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
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (XPathExpressionException e) {
            e.printStackTrace();
        }
    }
}
