package XLM_DOM;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class CreateXmlFileDemo {
    public static void main(String argv[]) {

        try {
            DocumentBuilderFactory dbFactory =
                    DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.newDocument();

            Element rootElement = doc.createElement("company");
            doc.appendChild(rootElement);

            Element dep01 = doc.createElement("department");
            rootElement.appendChild(dep01);

            Element dep02 = doc.createElement("department");
            rootElement.appendChild(dep02);

            Attr attr01 = doc.createAttribute("name");
            attr01.setValue("Development");
            dep01.setAttributeNode(attr01);

            Attr attr02 = doc.createAttribute("depId");
            attr02.setValue("1");
            dep01.setAttributeNode(attr02);

            Attr attr03 = doc.createAttribute("name");
            attr03.setValue("Accounting");
            dep02.setAttributeNode(attr03);

            Attr attr04 = doc.createAttribute("depId");
            attr04.setValue("2");
            dep02.setAttributeNode(attr04);

            Element empl01 = doc.createElement("employee");
            Attr attrType01 = doc.createAttribute("emplId");
            attrType01.setValue("001");
            empl01.setAttributeNode(attrType01);
//            tag21.appendChild(doc.createTextNode("AAA"));
            dep01.appendChild(empl01);

            Element last_name01 = doc.createElement("lastName");
            last_name01.appendChild(doc.createTextNode("LastName1"));
            empl01.appendChild(last_name01);

            Element first_name01 = doc.createElement("firstName");
            first_name01.appendChild(doc.createTextNode("FirstName1"));
            empl01.appendChild(first_name01);

            Element birth_date01 = doc.createElement("birthDate");
            birth_date01.appendChild(doc.createTextNode("01.01.2000"));
            empl01.appendChild(birth_date01);

            Element position01 = doc.createElement("position");
            position01.appendChild(doc.createTextNode("Department Manager"));
            empl01.appendChild(position01);

            Element skills01 = doc.createElement("skills");
            empl01.appendChild(skills01);

            Element skill01 = doc.createElement("skill");
            skill01.appendChild(doc.createTextNode("Comunication"));
            skills01.appendChild(skill01);

            Element skill02 = doc.createElement("skill");
            skill02.appendChild(doc.createTextNode("Java"));
            skills01.appendChild(skill02);

            Element managerId01 = doc.createElement("managerId");
            managerId01.appendChild(doc.createTextNode("0"));
            empl01.appendChild(managerId01);


            Element empl02 = doc.createElement("employee");
            Attr attrType02 = doc.createAttribute("emplId");
            attrType02.setValue("002");
            empl02.setAttributeNode(attrType02);
            dep01.appendChild(empl02);

            Element last_name02 = doc.createElement("lastName");
            last_name02.appendChild(doc.createTextNode("LastName2"));
            empl02.appendChild(last_name02);

            Element first_name02 = doc.createElement("firstName");
            first_name02.appendChild(doc.createTextNode("FirstName2"));
            empl02.appendChild(first_name02);

            Element birth_date02 = doc.createElement("birthDate");
            birth_date02.appendChild(doc.createTextNode("01.01.2001"));
            empl02.appendChild(birth_date02);

            Element position02 = doc.createElement("position");
            position02.appendChild(doc.createTextNode("Developer"));
            empl02.appendChild(position02);

            Element skills02 = doc.createElement("skills");
            empl02.appendChild(skills02);

            Element skill10 = doc.createElement("skill");
            skill10.appendChild(doc.createTextNode("Sleeps only 2 hours per day"));
            skills02.appendChild(skill10);

            Element skill11 = doc.createElement("skill");
            skill11.appendChild(doc.createTextNode("Overtimes without concerns"));
            skills02.appendChild(skill11);

            Element skill12 = doc.createElement("skill");
            skill12.appendChild(doc.createTextNode("Works for food"));
            skills02.appendChild(skill12);


            Element managerId02 = doc.createElement("managerId");
            managerId02.appendChild(doc.createTextNode("001"));
            empl02.appendChild(managerId02);



            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("company.xml"));
            transformer.transform(source, result);

            StreamResult consoleResult = new StreamResult(System.out);
            transformer.transform(source, consoleResult);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
