package FlightRecorder;

import java.io.*;
import java.math.BigDecimal;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Application {

    private static List<Flight> processInputFile(String inputFilePath) {
        List<Flight> inputList = new ArrayList<Flight>();
        try {
            File inputF = new File(inputFilePath);
            BufferedReader br;
            try (InputStream inputFS = new FileInputStream(inputF)) {
                br = new BufferedReader(new InputStreamReader(inputFS));

                // skip the header of the csv
                inputList = br.lines().skip(1).map(mapToItem).collect(Collectors.toList());
                br.close();
            }
        }catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return inputList;
    }

    private static Function<String, Flight> mapToItem = (line) -> {
        String[] p = line.split("\\|");// a CSV has comma separated lines
        String flightNum = (p[0]);  //<-- this is the first column in the csv file
        String depLoc = (p[1]);
        String arrLoc = (p[2]);
        String validDate = (p[3]);
        String validTime = (p[4]);
        String duration = (p[5]);
        String fare = (p[6]);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate validTill = LocalDate.parse(validDate, dtf);
        dtf = DateTimeFormatter.ofPattern("HHMM");
        LocalTime flightTime = LocalTime.parse(validTime, dtf);
        Flight flight = new Flight(flightNum, depLoc, arrLoc, validTill, flightTime, Double.valueOf(duration), new BigDecimal(fare));
        return flight;
    };

    public static void main(String[] args) {
        List<Flight> list = new ArrayList<>();
        Path path = FileSystems.getDefault().getPath(System.getProperty("user.dir") + "/src/main/resources/flight1.csv");
        List<Flight> flights=processInputFile(path.toString());
        System.out.println(flights);
    }

}
