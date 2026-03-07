package session3.exercise5_2.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DataReader {

    private DataReader() {
    }

    public static Object[][] readLoginDataFromCsv(String csvPath) {
        List<Object[]> rows = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(csvPath))) {
            String line;
            boolean isHeader = true;
            while ((line = reader.readLine()) != null) {
                if (isHeader) {
                    isHeader = false;
                    continue;
                }
                String[] parts = line.split(",", -1);
                if (parts.length < 3) {
                    continue;
                }
                String username = parts[0].trim();
                String password = parts[1].trim();
                boolean expected = "SUCCESS".equalsIgnoreCase(parts[2].trim());
                rows.add(new Object[]{username, password, expected});
            }
        } catch (IOException exception) {
            throw new RuntimeException("Cannot read CSV: " + csvPath, exception);
        }
        return rows.toArray(new Object[0][0]);
    }
}
