package assignments.m1.sales;

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
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty()) continue;
                String[] sales = line.split(",");
                double[] weekSales = new double[sales.length];
                // TODO 1: Parse each sales value into weekSales[].
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
        int highestWeek = 0, lowestWeek = 0;
        for (int week = 0; week < weeklySalesData.size(); week++) {
            double[] sales = weeklySalesData.get(week);
            double totalWeeklySales = 0;
            // TODO 3: Sum daily sales.
            // TODO 4: Calculate average daily sales.
            double averageDailySales = 0;
            // TODO 5: Update overall total and highest/lowest week statistics.
            // TODO 6: Print this week's results in the Canvas format.
        }
        double averageWeeklySales = 0; // TODO 7: Calculate average weekly sales.
        // TODO 8: Print overall total, average, highest week, and lowest week.
    }
}
