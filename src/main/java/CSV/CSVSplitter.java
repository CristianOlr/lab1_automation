package CSV;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CSVSplitter {
    public static void main(String[] args)
    {
        String fileToParse = "students.csv";
        BufferedReader fileReader = null;
        final String DELIMITER = "\\,";

        try
        {
            String line = "";
            fileReader = new BufferedReader(new FileReader(fileToParse));

            while ((line = fileReader.readLine()) != null)
            {
                System.out.println("---------------");
                String[] tokens = line.split(DELIMITER);
                for(String token : tokens)
                {
                    System.out.println(token + " ");

                }
                System.out.println("---------------\n");
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally
        {
            try {
                fileReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
