package CSV;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class CSVReaderWithHeader {
    private static final String SAMPLE_CSV_FILE_PATH = "students.csv";

    public static void main(String[] args) throws IOException {
        try (
                Reader reader = new BufferedReader(new FileReader(SAMPLE_CSV_FILE_PATH));
                CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT
                        .withFirstRecordAsHeader()
                        .withIgnoreHeaderCase()
                        .withTrim());
        ) {
            for (CSVRecord csvRecord : csvParser) {
                // Accessing values by Header names
                String id = csvRecord.get("ID");
                String name = csvRecord.get("Nume");
                String lname = csvRecord.get("Prenume");
                String favObj = csvRecord.get("Obiect Preferat");
                String med = csvRecord.get("Media Anuala");

                String ID = csvRecord.get("ID");

                System.out.println("Record No - " + csvRecord.getRecordNumber());
                System.out.println("------------------------------");
                System.out.println("ID:  " + id);
                System.out.println("Nume:  " + name);
                System.out.println("Prenume:  " + lname);
                System.out.println("Obiect Preferat:  " + favObj);
                System.out.println("Media Anuala:  " + med);
                System.out.println("------------------------------\n\n");
            }
        }
    }
}
