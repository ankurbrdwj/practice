package SapientPerCapita.java8;

import SapientPerCapita.java8.domain.AverageIncome;
import SapientPerCapita.java8.domain.Gender;
import SapientPerCapita.java8.domain.Income;
import com.opencsv.CSVWriter;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
/convert sample input to sample out put
if country is not present then use city name instead
system can take input form diff formats like csv, xml , excel ,pipe seperated etc
 */
public class Application {

    public static void main(String[] args) {
        String filePath = System.getProperty("user.dir") + "/src/main/resources/System_Input.csv";
        Path path = new File(filePath).toPath();
        List<Income> list = null;
        try (Stream<String> lines = Files.lines(path)) {
            list = lines
                    .skip(1)
                    .map(mapToItem)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            System.out.println(e);
        }
        Map<String, Map<Gender, Double>> list1 = list.stream()
                .map(mapCity())
                .collect(Collectors.groupingBy(Income::getCountry,
                        Collectors.groupingBy(Income::getGender,
                                Collectors.averagingDouble(Income::getAverageIncome))));
        System.out.println(list1);
        List<AverageIncome> finalResult = new ArrayList<>();
        list1.forEach((s, entry) -> {
            entry.forEach((gender, income) -> {
                AverageIncome avgIncome = new AverageIncome(s, gender, income);
                finalResult.add(avgIncome);
            });
        });
        String outPath = System.getProperty("user.dir") + "/src/main/resources/System_Output.csv";
        try {
            FileWriter fileWriter = new FileWriter(outPath);
            CSVWriter writer = new CSVWriter(fileWriter);
            String[] array = {"City/Country", "Gender", "AverageIncome"};
            writer.writeNext(array);
            for (AverageIncome income : finalResult) {
                array[0] = income.getRegion();
                array[1] = income.getGender().toString();
                array[2] = String.valueOf(income.getAverageIncome());
                writer.writeNext(array);
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static Function<Income, Income> mapCity() {
        return income -> {
            if (income.getCountry().isEmpty()) {
                income.setCountry(income.getCity());
            }
            return income;
        };
    }


    private static Function<String, Income> mapToItem = (line) -> {
        String[] a = line.split(",");
        return new Income(a[0], a[1], a[2], Gender.valueOf(a[3]), Double.parseDouble(a[4]));
    };
}
