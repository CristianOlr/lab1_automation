package JSON;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

public class JsonSimpleWriteOrdered {
    public static void main(String[] args) {
        JSONObject obj = new JSONObject();

        Map<Object, Object> map1 = new LinkedHashMap<>();
        JSONArray skills1 = new JSONArray();
        map1.put("lastName", "LastName1");
        map1.put("firstName", "FirstName1");
        map1.put("birthDate", "01.01.2000");
        map1.put("position", "Department Manager");
        skills1.add("Comunication");
        skills1.add("Java");
        map1.put("skills", skills1);
        map1.put("managerId", "0");
        obj.put("emplId=001", map1);

        Map<Object, Object> map2 = new LinkedHashMap<>();
        JSONArray skills2 = new JSONArray();
        map2.put("lastName", "LastName2");
        map2.put("firstName", "FirstName2");
        map2.put("birthDate", "01.01.2001");
        map2.put("position", "Developer");
        skills2.add("Sleeps only 2 hours per day");
        skills2.add("Overtimes without concerns");
        skills2.add("Works for food");
        map2.put("skills", skills2);
        map2.put("managerId", "001");
        obj.put("emplId=002", map2);

        JSONObject obj1 = new JSONObject();
        obj1.put("depId='1' name='Development'", obj);

        JSONObject obj2 = new JSONObject();
        obj1.put("depId='2' name='Accounting'", obj2);

        JSONObject obj3 = new JSONObject();
        obj3.put("company", obj1);


        try (FileWriter file = new FileWriter("company.json")) {
            file.write(obj3.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.print(obj3);


    }
}
