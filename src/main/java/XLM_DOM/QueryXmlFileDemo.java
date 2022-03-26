package XLM_DOM;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class QueryXmlFileDemo {
    public static void main(String argv[]) {

        try {
            File inputFile = new File("company.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
            System.out.println(doc.getDocumentElement().getNodeName());
            NodeList nList = doc.getElementsByTagName("employee");

            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    System.out.print("\nEmployee ID: ");
                    System.out.println(eElement.getAttribute("emplId"));

                    NodeList lastname = eElement.getElementsByTagName("lastName");
                    for (int count = 0; count < lastname.getLength(); count++) {
                        Node node1 = lastname.item(count);

                        if (node1.getNodeType() == node1.ELEMENT_NODE) {
                            Element employee = (Element) node1;
                            System.out.print("Last Name: ");
                            System.out.println(employee.getTextContent());
                        }
                    }

                    NodeList firstname = eElement.getElementsByTagName("firstName");
                    for (int count = 0; count < firstname.getLength(); count++) {
                        Node node1 = firstname.item(count);

                        if (node1.getNodeType() == node1.ELEMENT_NODE) {
                            Element employee = (Element) node1;
                            System.out.print("First Name: ");
                            System.out.println(employee.getTextContent());
                        }
                    }

                    NodeList birthdate = eElement.getElementsByTagName("birthDate");
                    for (int count = 0; count < birthdate.getLength(); count++) {
                        Node node1 = birthdate.item(count);

                        if (node1.getNodeType() == node1.ELEMENT_NODE) {
                            Element employee = (Element) node1;
                            System.out.print("Birth Date: ");
                            System.out.println(employee.getTextContent());
                        }
                    }

                    NodeList position = eElement.getElementsByTagName("position");
                    for (int count = 0; count < position.getLength(); count++) {
                        Node node1 = position.item(count);

                        if (node1.getNodeType() == node1.ELEMENT_NODE) {
                            Element employee = (Element) node1;
                            System.out.print("Position: ");
                            System.out.println(employee.getTextContent());
                        }
                    }

                    NodeList skills = eElement.getElementsByTagName("skills");
                    for (int count = 0; count < skills.getLength(); count++) {
                        Node node1 = skills.item(count);

                        if (node1.getNodeType() == node1.ELEMENT_NODE) {
                            Element employee = (Element) node1;
                            System.out.print("Skills: \n");

                            NodeList skill = eElement.getElementsByTagName("skill");
                            for (int count1 = 0; count1 < skill.getLength(); count1++) {
                                Node node2 = skill.item(count1);

                                if (node1.getNodeType() == node2.ELEMENT_NODE) {
                                    Element skilll = (Element) node2;
                                    System.out.print("\tSkill" + (count1+1) +": ");
                                    System.out.println(skilll.getTextContent());
                                }
                            }
                        }
                    }

                    NodeList managerid = eElement.getElementsByTagName("managerId");
                    for (int count = 0; count < managerid.getLength(); count++) {
                        Node node1 = managerid.item(count);

                        if (node1.getNodeType() == node1.ELEMENT_NODE) {
                            Element employee = (Element) node1;
                            System.out.print("Manager ID: ");
                            System.out.println(employee.getTextContent());
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
