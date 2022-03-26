package CSV;

import java.io.File;
import java.io.FileNotFoundException;

public class CSVScanner {
    public static void main(String[] args) throws FileNotFoundException
    {
        java.util.Scanner scanner = new java.util.Scanner(new File("students.csv"));
        scanner.useDelimiter("\\,");

        while (scanner.hasNext())
        {
            System.out.print(scanner.next() + ", ");
        }

        scanner.close();
    }
}
