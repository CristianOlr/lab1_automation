package XML_CUSTOM_PLANTS;

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

public class CreateXmlFilePlants {
    public static void main(String argv[]) {

        try {
            DocumentBuilderFactory dbFactory =
                    DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.newDocument();

            Element rootElement = doc.createElement("plants");
            doc.appendChild(rootElement);

            Element makeseeds = doc.createElement("make_seeds");
            rootElement.appendChild(makeseeds);

            Attr attr = doc.createAttribute("plants_with_Seeds");
            attr.setValue("yes");
            makeseeds.setAttributeNode(attr);

            Element have_flow = doc.createElement("Angiosperms");
            Attr attrType2 = doc.createAttribute("have_flowers");
            attrType2.setValue("yes");

            have_flow.setAttributeNode(attrType2);
            Element dicotyledons = doc.createElement("Dicotyledons");
            Attr attr10 = doc.createAttribute("class");
            attr10.setValue("Magnoliopsida");
            dicotyledons.setAttributeNode(attr10);
            have_flow.appendChild(dicotyledons);

            Element magnoliidae = doc.createElement("Magnoliidae");
            Attr attr12 = doc.createAttribute("subclass");
            attr12.setValue("I");
            magnoliidae.setAttributeNode(attr12);
            dicotyledons.appendChild(magnoliidae);


            Element magnoliales = doc.createElement("Magnoliales");
            Attr attr23 = doc.createAttribute("order");
            attr23.setValue("I");
            magnoliales.setAttributeNode(attr23);
            magnoliidae.appendChild(magnoliales);


            Element winteraceae = doc.createElement("Winteraceae");
            Attr attr31 = doc.createAttribute("family");
            attr31.setValue("1");
            winteraceae.setAttributeNode(attr31);
            magnoliales.appendChild(winteraceae);

            Element degeneriaceae = doc.createElement("Degeneriaceae");
            Attr attr32 = doc.createAttribute("family");
            attr32.setValue("2");
            degeneriaceae.setAttributeNode(attr32);
            magnoliales.appendChild(degeneriaceae);

            Element himantandraceae = doc.createElement("Himantandraceae");
            Attr attr33 = doc.createAttribute("family");
            attr33.setValue("3");
            himantandraceae.setAttributeNode(attr33);
            magnoliales.appendChild(himantandraceae);

            Element eupomatiaceae = doc.createElement("Eupomatiaceae");
            Attr attr34 = doc.createAttribute("family");
            attr34.setValue("4");
            eupomatiaceae.setAttributeNode(attr34);
            magnoliales.appendChild(eupomatiaceae);

            Element austrobaileyaceae = doc.createElement("Austrobaileyaceae");
            Attr attr35 = doc.createAttribute("family");
            attr35.setValue("5");
            austrobaileyaceae.setAttributeNode(attr35);
            magnoliales.appendChild(austrobaileyaceae);

            Element magnoliaceae = doc.createElement("Magnoliaceae");
            Attr attr36 = doc.createAttribute("family");
            attr36.setValue("6");
            magnoliaceae.setAttributeNode(attr36);

            Element plantName = doc.createElement("PlantName");
            plantName.appendChild(doc.createTextNode("Yellow poplar (Liriodendron tulipifera)"));
            magnoliaceae.appendChild(plantName);

            Element plantName1 = doc.createElement("PlantName");
            plantName1.appendChild(doc.createTextNode("Tulip tree"));
            magnoliaceae.appendChild(plantName1);

            Element plantName2 = doc.createElement("PlantName");
            plantName2.appendChild(doc.createTextNode("Champac (Michelia champaca)"));
            magnoliaceae.appendChild(plantName2);

            magnoliales.appendChild(magnoliaceae);



            Element lactoridaceae = doc.createElement("Lactoridaceae");
            Attr attr37 = doc.createAttribute("family");
            attr37.setValue("7");
            lactoridaceae.setAttributeNode(attr37);
            magnoliales.appendChild(lactoridaceae);

            Element annonaceae = doc.createElement("Annonaceae");
            Attr attr38 = doc.createAttribute("family");
            attr38.setValue("8");
            annonaceae.setAttributeNode(attr38);

            Element plantName3 = doc.createElement("PlantName");
            plantName3.appendChild(doc.createTextNode("Alligator apple (A. glabra)"));
            annonaceae.appendChild(plantName3);

            Element plantName4 = doc.createElement("PlantName");
            plantName4.appendChild(doc.createTextNode("Custard apple (A. reticulata)"));
            annonaceae.appendChild(plantName4);

            Element plantName5 = doc.createElement("PlantName");
            plantName5.appendChild(doc.createTextNode("Cherimoya (A. cherimola)"));
            annonaceae.appendChild(plantName5);

            Element plantName6 = doc.createElement("PlantName");
            plantName6.appendChild(doc.createTextNode("Soursop (A. muricata)"));
            annonaceae.appendChild(plantName6);

            Element plantName7 = doc.createElement("PlantName");
            plantName7.appendChild(doc.createTextNode("Sweetsop (A. squamosa)"));
            annonaceae.appendChild(plantName7);

            magnoliales.appendChild(annonaceae);




            Element myristicaceae = doc.createElement("Myristicaceae");
            Attr attr39 = doc.createAttribute("family");
            attr39.setValue("9");
            myristicaceae.setAttributeNode(attr39);
            magnoliales.appendChild(myristicaceae);

            Element canellaceae = doc.createElement("Canellaceae");
            Attr attr40 = doc.createAttribute("family");
            attr40.setValue("10");
            canellaceae.setAttributeNode(attr40);
            magnoliales.appendChild(canellaceae);




            Element laurales = doc.createElement("Laurales");
            Attr attr24 = doc.createAttribute("order");
            attr24.setValue("II");
            laurales.setAttributeNode(attr24);
            magnoliidae.appendChild(laurales);

            Element piperales = doc.createElement("Piperales");
            Attr attr25 = doc.createAttribute("order");
            attr25.setValue("III");
            piperales.setAttributeNode(attr25);
            magnoliidae.appendChild(piperales);

            Element aristolochiales = doc.createElement("Aristolochiales");
            Attr attr26 = doc.createAttribute("order");
            attr26.setValue("IV");
            aristolochiales.setAttributeNode(attr26);
            magnoliidae.appendChild(aristolochiales);

            Element illiciales = doc.createElement("Illiciales");
            Attr attr27 = doc.createAttribute("order");
            attr27.setValue("V");
            illiciales.setAttributeNode(attr27);
            magnoliidae.appendChild(illiciales);

            Element nymphaeales = doc.createElement("Nymphaeales");
            Attr attr28 = doc.createAttribute("order");
            attr28.setValue("VI");
            nymphaeales.setAttributeNode(attr28);
            magnoliidae.appendChild(nymphaeales);

            Element ranunculales = doc.createElement("Ranunculales");
            Attr attr29 = doc.createAttribute("order");
            attr29.setValue("VII");
            ranunculales.setAttributeNode(attr29);
            magnoliidae.appendChild(ranunculales);

            Element papaverales = doc.createElement("Papaverales");
            Attr attr30 = doc.createAttribute("order");
            attr30.setValue("VIII");
            papaverales.setAttributeNode(attr30);
            magnoliidae.appendChild(papaverales);




            Element hamamelidae = doc.createElement("Hamamelidae");
            Attr attr13 = doc.createAttribute("subclass");
            attr13.setValue("II");
            hamamelidae.setAttributeNode(attr13);
            dicotyledons.appendChild(hamamelidae);

            Element caryophyllidae = doc.createElement("Caryophyllidae");
            Attr attr14 = doc.createAttribute("subclass");
            attr14.setValue("III");
            caryophyllidae.setAttributeNode(attr14);
            dicotyledons.appendChild(caryophyllidae);

            Element dilleniidae = doc.createElement("Dilleniidae");
            Attr attr15 = doc.createAttribute("subclass");
            attr15.setValue("IV");
            dilleniidae.setAttributeNode(attr15);
            dicotyledons.appendChild(dilleniidae);

            Element rosidae = doc.createElement("Rosidae");
            Attr attr16 = doc.createAttribute("subclass");
            attr16.setValue("V");
            rosidae.setAttributeNode(attr16);
            dicotyledons.appendChild(rosidae);

            Element asteridae = doc.createElement("Asteridae");
            Attr attr17 = doc.createAttribute("subclass");
            attr17.setValue("VI");
            asteridae.setAttributeNode(attr17);
            dicotyledons.appendChild(asteridae);



            Element monocotyledons = doc.createElement("Monocotyledons");
            Attr attr11 = doc.createAttribute("class");
            attr11.setValue("Liliopsida");
            monocotyledons.setAttributeNode(attr11);
            have_flow.appendChild(monocotyledons);

            Element alismatidae = doc.createElement("Alismatidae");
            Attr attr18 = doc.createAttribute("subclass");
            attr18.setValue("I");
            alismatidae.setAttributeNode(attr18);
            monocotyledons.appendChild(alismatidae);

            Element arecidae = doc.createElement("Arecidae");
            Attr attr19 = doc.createAttribute("subclass");
            attr19.setValue("II");
            arecidae.setAttributeNode(attr19);
            monocotyledons.appendChild(arecidae);

            Element commelinidae = doc.createElement("Commelinidae");
            Attr attr20 = doc.createAttribute("subclass");
            attr20.setValue("III");
            commelinidae.setAttributeNode(attr20);

            Element commelinales = doc.createElement("Commelinales");
            Attr attr41 = doc.createAttribute("order");
            attr41.setValue("I");
            commelinales.setAttributeNode(attr41);
            commelinidae.appendChild(commelinales);

            Element eriocaulales = doc.createElement("Eriocaulales");
            Attr attr42 = doc.createAttribute("order");
            attr42.setValue("II");
            eriocaulales.setAttributeNode(attr42);

            Element rapateaceae = doc.createElement("Rapateaceae");
            Attr attr48 = doc.createAttribute("family");
            attr48.setValue("1");
            rapateaceae.setAttributeNode(attr48);
            commelinales.appendChild(rapateaceae);

            Element xyridaceae = doc.createElement("Xyridaceae");
            Attr attr49 = doc.createAttribute("family");
            attr49.setValue("2");
            xyridaceae.setAttributeNode(attr49);
            commelinales.appendChild(xyridaceae);

            Element mayacaceae = doc.createElement("Mayacaceae");
            Attr attr50 = doc.createAttribute("family");
            attr50.setValue("3");
            mayacaceae.setAttributeNode(attr50);
            commelinales.appendChild(mayacaceae);

            Element commelinaceae = doc.createElement("Commelinaceae");
            Attr attr51 = doc.createAttribute("family");
            attr51.setValue("4");
            commelinaceae.setAttributeNode(attr51);

            Element plantName8 = doc.createElement("PlantName");
            plantName8.appendChild(doc.createTextNode("Spiderwort (T.virginiana)"));
            commelinaceae.appendChild(plantName8);

            Element plantName9 = doc.createElement("PlantName");
            plantName9.appendChild(doc.createTextNode("T.fluminensis"));
            commelinaceae.appendChild(plantName9);

            Element plantName10 = doc.createElement("PlantName");
            plantName10.appendChild(doc.createTextNode("T.pallida"));
            commelinaceae.appendChild(plantName10);

            Element plantName11 = doc.createElement("PlantName");
            plantName11.appendChild(doc.createTextNode("T.zebrina"));
            commelinaceae.appendChild(plantName11);

            Element plantName12 = doc.createElement("PlantName");
            plantName12.appendChild(doc.createTextNode("Moses-in-the-cradle"));
            commelinaceae.appendChild(plantName12);

            Element plantName13 = doc.createElement("PlantName");
            plantName13.appendChild(doc.createTextNode("C.coelestis"));
            commelinaceae.appendChild(plantName13);

            Element plantName14 = doc.createElement("PlantName");
            plantName14.appendChild(doc.createTextNode("C.diffusa"));
            commelinaceae.appendChild(plantName14);

            Element plantName15 = doc.createElement("PlantName");
            plantName15.appendChild(doc.createTextNode("C.erecta"));
            commelinaceae.appendChild(plantName15);

            Element plantName16 = doc.createElement("PlantName");
            plantName16.appendChild(doc.createTextNode("D.mosaica"));
            commelinaceae.appendChild(plantName16);

            Element plantName17 = doc.createElement("PlantName");
            plantName17.appendChild(doc.createTextNode("D.thyrsiflora"));
            commelinaceae.appendChild(plantName17);

            Element plantName18 = doc.createElement("PlantName");
            plantName18.appendChild(doc.createTextNode("C.fragrans"));
            commelinaceae.appendChild(plantName18);

            commelinales.appendChild(commelinaceae);

            commelinidae.appendChild(eriocaulales);


            Element restionales = doc.createElement("Restionales");
            Attr attr43 = doc.createAttribute("order");
            attr43.setValue("III");
            restionales.setAttributeNode(attr43);
            commelinidae.appendChild(restionales);

            Element juncales = doc.createElement("Juncales");
            Attr attr44 = doc.createAttribute("order");
            attr44.setValue("IV");
            juncales.setAttributeNode(attr44);
            commelinidae.appendChild(juncales);

            Element cyperales = doc.createElement("Cyperales");
            Attr attr45 = doc.createAttribute("order");
            attr45.setValue("V");
            cyperales.setAttributeNode(attr45);
            commelinidae.appendChild(cyperales);

            Element hydatellales = doc.createElement("Hydatellales");
            Attr attr46 = doc.createAttribute("order");
            attr46.setValue("VI");
            hydatellales.setAttributeNode(attr46);
            commelinidae.appendChild(hydatellales);

            Element typhales = doc.createElement("Typhales");
            Attr attr47 = doc.createAttribute("order");
            attr47.setValue("VII");
            typhales.setAttributeNode(attr47);
            commelinidae.appendChild(typhales);

            monocotyledons.appendChild(commelinidae);


            Element zingiberidae = doc.createElement("Zingiberidae");
            Attr attr21 = doc.createAttribute("subclass");
            attr21.setValue("IV");
            zingiberidae.setAttributeNode(attr21);
            monocotyledons.appendChild(zingiberidae);

            Element liliidae = doc.createElement("Liliidae");
            Attr attr22 = doc.createAttribute("subclass");
            attr22.setValue("V");
            liliidae.setAttributeNode(attr22);
            monocotyledons.appendChild(liliidae);





            makeseeds.appendChild(have_flow);

            Element no_flow = doc.createElement("Gymnosperms");
            Attr attrType3 = doc.createAttribute("have_flowers");
            attrType3.setValue("no");
            no_flow.setAttributeNode(attrType3);
            no_flow.appendChild(doc.createTextNode("Conifers"));
            makeseeds.appendChild(no_flow);


            Element noseeds = doc.createElement("dont_make_seeds");
            rootElement.appendChild(noseeds);

            Attr attr1 = doc.createAttribute("plants_with_Seeds");
            attr1.setValue("no");
            noseeds.setAttributeNode(attr1);

            Element have_rsl = doc.createElement("have_roots_stems_leaves");
            Attr attrType = doc.createAttribute("have_all");
            attrType.setValue("yes");
            have_rsl.setAttributeNode(attrType);
            have_rsl.appendChild(doc.createTextNode("Ferns"));
            noseeds.appendChild(have_rsl);

            Element no_rsl = doc.createElement("no_roots_stems_or_leaves");
            Attr attrType1 = doc.createAttribute("have_all");
            attrType1.setValue("no");
            no_rsl.setAttributeNode(attrType1);
            noseeds.appendChild(no_rsl);


            Element some_rsl_struct = doc.createElement("have_some_roots_stems_or_leaves_struct");
            Attr attrType4 = doc.createAttribute("have_some_struct");
            attrType4.setValue("yes");
            some_rsl_struct.setAttributeNode(attrType4);
            some_rsl_struct.appendChild(doc.createTextNode("Algae"));
            no_rsl.appendChild(some_rsl_struct);

            Element no_rsl_struct = doc.createElement("no_roots_stems_or_leaves_struct");
            Attr attrType5 = doc.createAttribute("have_some_struct");
            attrType5.setValue("no");
            no_rsl_struct.setAttributeNode(attrType5);
            no_rsl_struct.appendChild(doc.createTextNode("Mosses"));
            no_rsl.appendChild(no_rsl_struct);

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("plants.xml"));
            transformer.transform(source, result);

            StreamResult consoleResult = new StreamResult(System.out);
            transformer.transform(source, consoleResult);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
