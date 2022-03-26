package CSV;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;

public class CSVWriter {
    private static final String SAMPLE_CSV_FILE = "students.csv";

    public static void main(String[] args) throws IOException {
        try (
                BufferedWriter writer = Files.newBufferedWriter(Paths.get(SAMPLE_CSV_FILE), StandardOpenOption.CREATE_NEW);
                CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT
                        .withHeader("ID", "Nume", "Prenume", "Obiect Preferat", "Media Anuala"))
        ) {
            csvPrinter.printRecord("1", "Petrache", "Adrian", "Matematica", "8.54");
            csvPrinter.printRecord("2", "Trohin", "Liliana", "Geografia", "9.68");
            csvPrinter.printRecord("3", "Florian", "Eugen", "Limba Engleza", "7.25");
            csvPrinter.printRecord("4", "Marian", "Mihail", "Matematica", "8.75");
            csvPrinter.printRecord("5", "Echim", "Eva", "Fizica", "9.42");
            csvPrinter.printRecord("6", "Lupu", "Valeria", "Informatica", "9.87");
            csvPrinter.printRecord("7", "Negru", "Catalin", "Chimia", "8.12");
            csvPrinter.printRecord("8", "Popov", "Andrei", "Informatica", "7.07");
            csvPrinter.printRecord("9", "Cazacu", "Mihaela", "Biologia", "8.93");
            csvPrinter.printRecord(Arrays.asList("10", "Frunza", "Alexandru", "Fizica", "9.36"));
            csvPrinter.flush();
        }
    }
}
