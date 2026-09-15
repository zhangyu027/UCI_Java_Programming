package assignments.m1.sales;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Module 1 Assignment: Weekly Sales Analysis student starter.
 */
public class WeeklySalesAnalysis {

    public static void main(String[] args) {

        String fileName = "data/sales_data.txt";

        // Debug: show exactly where Java is looking for the file
        File file = new File(fileName);
        System.out.println("Looking for sales file at:");
        System.out.println(file.getAbsolutePath());

        List<double[]> weeklySalesData = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {

            String line;

            while ((line = br.readLine()) != null) {

                if (line.trim().isEmpty()) {
                    continue;
                }

                String[] sales = line.split(",");
                double[] weekSales = new double[sales.length];

                // TODO 1: Parse each sales value into weekSales[].
                for (int i = 0; i < sales.length; i++) {
                    weekSales[i] = Double.parseDouble(sales[i].trim());
                }

                // TODO 2: Add weekSales to weeklySalesData.
                weeklySalesData.add(weekSales);
            }

        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
            return;

        } catch (NumberFormatException e) {
            System.out.println("Invalid sales value in the file: " + e.getMessage());
            return;
        }

        // Important: stop if no data was loaded
        if (weeklySalesData.isEmpty()) {
            System.out.println("No sales data was found.");
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

            // TODO 3: Sum daily sales.
            for (double sale : sales) {
                totalWeeklySales += sale;
            }

            // TODO 4: Calculate average daily sales.
            double averageDailySales = totalWeeklySales / sales.length;

            // TODO 5: Update overall total and highest/lowest statistics.
            totalAllWeeks += totalWeeklySales;

            if (totalWeeklySales > highestWeeklySales) {
                highestWeeklySales = totalWeeklySales;
                highestWeek = week + 1;
            }

            if (totalWeeklySales < lowestWeeklySales) {
                lowestWeeklySales = totalWeeklySales;
                lowestWeek = week + 1;
            }

            // TODO 6: Print this week's results.
            System.out.printf(
                    "Week %d - Total Sales: %.2f, Average Daily Sales: %.2f%n",
                    week + 1,
                    totalWeeklySales,
                    averageDailySales
            );
        }

        // TODO 7: Calculate average weekly sales.
        double averageWeeklySales =
                totalAllWeeks / weeklySalesData.size();

        // TODO 8: Print overall statistics.
        System.out.printf(
                "Total Sales for All Weeks: %.2f%n",
                totalAllWeeks
        );

        System.out.printf(
                "Average Weekly Sales: %.2f%n",
                averageWeeklySales
        );

        System.out.printf(
                "Week with Highest Sales: Week %d (%.2f)%n",
                highestWeek,
                highestWeeklySales
        );

        System.out.printf(
                "Week with Lowest Sales: Week %d (%.2f)%n",
                lowestWeek,
                lowestWeeklySales
        );
    }
}