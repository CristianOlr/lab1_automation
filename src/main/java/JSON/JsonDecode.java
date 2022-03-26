package JSON;

import java.io.FileReader;
import java.io.IOException;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.*;

public class JsonDecode {
    public static void main(String[] args) {
        JSONParser parser = new JSONParser();

        try {
            Object obj = parser.parse(new FileReader("company.json"));
            JSONObject jsonObject = (JSONObject) obj;
            String company = jsonObject.toJSONString();

            String[] splits = company.split("\"emplId=001\":");
            String[] splits2 = splits[1].split("},", 2);
            System.out.println("\nemplId = \"001\":\n" + splits2[0] + "}");

            splits = company.split("\"skills\":");
            splits2 = splits[1].split("]", 2);
            System.out.println("\nskills for emplID = \"001\":\n"+splits2[0] + "]");

            System.out.println("\n-------------------------------------------------------------------------------------");

            splits = company.split("\"emplId=002\":");
            splits2 = splits[1].split("}", 2);
            System.out.println("\nemplId = \"002\":\n"+splits2[0] + "}");

            splits = company.split("\"skills\":");
            splits2 = splits[2].split("]", 2);
            System.out.println("\nskills for emplID = \"002\":\n"+splits2[0] + "]");


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
