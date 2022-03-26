package JSON;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

public class JsonSimpleRead {
    public static void main(String[] args) {

        JSONParser parser = new JSONParser();

        try {

            Object obj = parser.parse(new FileReader("company.json"));

            JSONObject jsonObject = (JSONObject) obj;
            System.out.println(jsonObject);

            JSONObject jsonObject1 = (JSONObject) ((JSONObject) jsonObject).get("company");
            JSONObject jsonObject2 = (JSONObject) ((JSONObject) jsonObject1).get("depId='1' name='Development'");
            JSONObject jsonObject3 = (JSONObject) ((JSONObject) jsonObject2).get("emplId=002");

            System.out.println();
            System.out.println("Info about employee with \"emplId = 002\":");
            System.out.println("----------------------------------------");
            String lName = (String) jsonObject3.get("lastName");
            System.out.println("Last name: " + lName);

            String fName = (String) jsonObject3.get("firstName");
            System.out.println("First Name: " + fName);

            String bDate = (String) jsonObject3.get("birthDate");
            System.out.println("Birth Date: " + bDate);

            String pos = (String) jsonObject3.get("position");
            System.out.println("Position: " + pos);

            JSONArray skills = (JSONArray) jsonObject3.get("skills");
            System.out.println("Skills:");
            Iterator<String> iterator = skills.iterator();
            while (iterator.hasNext()) {
                System.out.println("\t" + iterator.next());
            }

            String mId = (String) jsonObject3.get("managerId");
            System.out.println("Manager ID: " + mId);


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }
}
