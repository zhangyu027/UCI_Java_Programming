package assignment.m1.sales;

/*
* STUDENT HINTS
* -------------
* Suggested steps:
* 1. Read sales_data.txt.
* 2. Parse each numeric value.
* 3. Accumulate total sales.
* 4. Track highest/lowest values if required.
* 5. Calculate the requested summary values after reading all rows.
*
* CHECKPOINT:
* Handle file/input errors instead of allowing the program to crash silently.
*/
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

/** M1 Assignment: Weekly Sales Analysis starter. */
public class WeeklySalesAnalysis {
    public static void main(String[] args) throws Exception {
        Path file = Path.of("data", "sales_data.txt");
        List<String> lines = Files.readAllLines(file);
        double overallTotal = 0.0;
        int totalValues = 0;
        double highestWeekTotal = Double.NEGATIVE_INFINITY;
        double lowestWeekTotal = Double.POSITIVE_INFINITY;
        int highestWeek = -1;
        int lowestWeek = -1;
        for (int i = 0; i < lines.size(); i++) {
            String[] values = lines.get(i).split(", ");
            double weekTotal = 0.0;
            // TODO: Parse each value with Double.parseDouble(...).
            // TODO: Add values to weekTotal and overallTotal.
            // TODO: Calculate the weekly average.
            // TODO: Track the highest/lowest weekly total and week number.
            /*
            * HINT:
            * for (String value : values) {
            *     double sale = Double.parseDouble(value.trim());
            *     // update totals
            * }
            *
            * Weekly average = weekTotal / values.length
            */
            System.out.println("Week " + (i + 1) + " total so far: " + weekTotal);
        }
        // TODO: Print overall total, overall average, highest week, and lowest week.
        System.out.println("Data file: " + file.toAbsolutePath());
        System.out.println("Overall total so far: " + overallTotal);
        System.out.println("Values counted so far: " + totalValues);
        System.out.println("Highest week index: " + highestWeek + " / total=" + highestWeekTotal);
        System.out.println("Lowest week index: " + lowestWeek + " / total=" + lowestWeekTotal);
    }
}
