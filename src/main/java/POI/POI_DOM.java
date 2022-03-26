package POI;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.*;
import java.io.File;
import org.apache.poi.ss.util.CellRangeAddress;


public class POI_DOM {
    public static void main(String[] args) {

        Workbook wb = new XSSFWorkbook();

        try {
            File inputFile = new File("company.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
            NodeList nList = doc.getElementsByTagName("employee");

            CellStyle style = wb.createCellStyle();
            Font font = wb.createFont();
            font.setBold(true);
            style.setAlignment(HorizontalAlignment.CENTER);
            style.setWrapText(true);


            CellStyle style1 = wb.createCellStyle();
            Font font1 = wb.createFont();
            font1.setBold(false);
            style1.setAlignment(HorizontalAlignment.LEFT);

            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    String tempValueSheet = String.format("%s%s%s", "Employee ID = \"", eElement.getAttribute("emplId"), "\"");
                    Sheet newSheet = wb.createSheet(tempValueSheet);

                    Row row = newSheet.createRow(0);

                    style.setFont(font);
                    Cell cell = row.createCell(0);
                    cell.setCellValue("Last Name:");
                    cell.setCellStyle(style);

                    cell = row.createCell(1);
                    cell.setCellValue("First Name:");
                    cell.setCellStyle(style);

                    cell = row.createCell(2);
                    cell.setCellValue("Birth Date:");
                    cell.setCellStyle(style);

                    cell = row.createCell(3);
                    cell.setCellValue("Position:");
                    cell.setCellStyle(style);

                    cell = row.createCell(4);
                    cell.setCellValue("Manager ID:");
                    cell.setCellStyle(style);


                    row = newSheet.createRow(1);
                    System.out.println("\nEmployee ID: "
                            + eElement.getAttribute("emplId"));

                    System.out.println("Last Name: "
                            + eElement
                            .getElementsByTagName("lastName")
                            .item(0)
                            .getTextContent());
                    cell = row.createCell(0);
                    String tempValue = String.format("%s",
                            eElement.getElementsByTagName("lastName")
                                    .item(0)
                                    .getTextContent());
                    cell.setCellValue(tempValue);
                    System.out.println("First Name: "
                            + eElement
                            .getElementsByTagName("firstName")
                            .item(0)
                            .getTextContent());
                    cell = row.createCell(1);
                    tempValue = String.format("%s",
                            eElement.getElementsByTagName("firstName")
                                    .item(0)
                                    .getTextContent());
                    cell.setCellValue(tempValue);
                    System.out.println("Birth Date: "
                            + eElement
                            .getElementsByTagName("birthDate")
                            .item(0)
                            .getTextContent());
                    cell = row.createCell(2);
                    tempValue = String.format("%s",
                            eElement.getElementsByTagName("birthDate")
                                    .item(0)
                                    .getTextContent());
                    cell.setCellValue(tempValue);
                    System.out.println("Position: "
                            + eElement
                            .getElementsByTagName("position")
                            .item(0)
                            .getTextContent());
                    cell = row.createCell(3);
                    tempValue = String.format("%s",
                            eElement.getElementsByTagName("position")
                                    .item(0)
                                    .getTextContent());
                    cell.setCellValue(tempValue);

                    System.out.println("Manager ID: "
                            + eElement
                            .getElementsByTagName("managerId")
                            .item(0)
                            .getTextContent());
                    System.out.println();
                    cell = row.createCell(4);
                    tempValue = String.format("%s",
                            eElement.getElementsByTagName("managerId")
                                    .item(0)
                                    .getTextContent());
                    cell.setCellValue(tempValue);

                    row = newSheet.createRow(4);
                    cell = row.createCell(1);
                    cell.setCellValue("Skills: ");
                    cell.setCellStyle(style);


                    System.out.println("Skills:");
                    NodeList nList1 = eElement.getElementsByTagName("skill");
                    for (int temp1 = 0; temp1 < nList1.getLength(); temp1++) {
                        Node nNode1 = nList1.item(temp1);
                        if (nNode1.getNodeType() == Node.ELEMENT_NODE) {
                            Element eElement1 = (Element) nNode1;
                            System.out.println("\tSkill" + (temp1 + 1) + ": "
                                    + eElement1.getTextContent());

                            if (temp1 != 0) {
                                row = newSheet.createRow(temp1 + 4);
                            }
                            row.createCell(2).setCellValue(eElement1.getTextContent());
                            CellRangeAddress cellRangeAddress = new CellRangeAddress(temp1 + 4, temp1 + 4, 2, 4);
                            newSheet.addMergedRegion(cellRangeAddress);
                        }
                    }
                    for (int i = 0; i < 5; i++) {
                        newSheet.autoSizeColumn(i);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try (OutputStream fileOut = new FileOutputStream("company.xlsx")) {
            wb.write(fileOut);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
