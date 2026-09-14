package assignment.m1.sales;

/*
 * STUDENT HINTS
 * -------------
 * This starter follows the Canvas Weekly Sales Analyzer structure.
 * Suggested steps:
 * 1. Read sales_data.txt with BufferedReader/FileReader.
 * 2. Split each line by commas and parse the values as doubles.
 * 3. Store each week's values in a double[].
 * 4. Calculate each week's total and average daily sales.
 * 5. Track the highest and lowest weekly totals.
 * 6. Calculate the total and average for all weeks.
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/** Module 1 Assignment: Weekly Sales Analysis student starter. */
public class WeeklySalesAnalysis {

    public static void main(String[] args) {
        String fileName = "data/sales_data.txt";
        List<double[]> weeklySalesData = new ArrayList<>();

        // Read data from the file.
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;

            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty()) {
                    continue;
                }

                String[] sales = line.split(",");
                double[] weekSales = new double[sales.length];

                // TODO 1: Convert every String in sales[] to a double using
                // Double.parseDouble(sales[i].trim()) and store it in weekSales[].

                // TODO 2: Add weekSales to weeklySalesData.
            }
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
            return;
        } catch (NumberFormatException e) {
            System.out.println("Invalid sales value in the file: " + e.getMessage());
            return;
        }

        double totalAllWeeks = 0;
        double highestWeeklySales = Double.NEGATIVE_INFINITY;
        double lowestWeeklySales = Double.POSITIVE_INFINITY;
        int highestWeek = 0;
        int lowestWeek = 0;

        for (int week = 0; week < weeklySalesData.size(); week++) {
            double[] sales = weeklySalesData.get(week);
            double totalWeeklySales = 0;

            // TODO 3: Use a for-each loop to add all daily sales to totalWeeklySales.

            // TODO 4: Calculate averageDailySales.
            double averageDailySales = 0;

            // TODO 5: Add this week's total to totalAllWeeks.

            // TODO 6: Print the week number, total sales, and average daily sales.

            // TODO 7: Update highestWeeklySales/highestWeek when appropriate.
            // TODO 8: Update lowestWeeklySales/lowestWeek when appropriate.
        }

        // TODO 9: Calculate averageWeeklySales.
        double averageWeeklySales = 0;

        // TODO 10: Print:
        // - Total Sales for All Weeks
        // - Average Weekly Sales
        // - Week with Highest Sales
        // - Week with Lowest Sales

        /*
         * OUTPUT PATTERN FROM CANVAS:
         * Week 1 - Total Sales: ..., Average Daily Sales: ...
         * Total Sales for All Weeks: ...
         * Average Weekly Sales: ...
         * Week with Highest Sales: Week ... (...)
         * Week with Lowest Sales: Week ... (...)
         */
    }
}
