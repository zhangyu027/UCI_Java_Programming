package instructor.assignments.m1.sales;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/** Module 1 Assignment: Weekly Sales Analysis instructor reference solution. */
public class WeeklySalesAnalysis {

    public static void main(String[] args) {
        // Keep the repository's portable data/ location so the same program works
        // in Eclipse and Codespaces without a personal absolute path.
        String fileName = "data/sales_data.txt";
        List<double[]> weeklySalesData = new ArrayList<>();

        // Read data from file using the same BufferedReader/FileReader approach as Canvas.
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;

            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty()) {
                    continue;
                }

                String[] sales = line.split(",");
                double[] weekSales = new double[sales.length];

                for (int i = 0; i < sales.length; i++) {
                    weekSales[i] = Double.parseDouble(sales[i].trim());
                }

                weeklySalesData.add(weekSales);
            }
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
            return;
        } catch (NumberFormatException e) {
            System.out.println("Invalid sales value in the file: " + e.getMessage());
            return;
        }

        if (weeklySalesData.isEmpty()) {
            System.out.println("No sales data was found.");
            return;
        }

        double totalAllWeeks = 0;
        // More robust than Double.MIN_VALUE while preserving the Canvas algorithm.
        double highestWeeklySales = Double.NEGATIVE_INFINITY;
        double lowestWeeklySales = Double.POSITIVE_INFINITY;
        int highestWeek = 0;
        int lowestWeek = 0;

        // Process each week's sales data.
        for (int week = 0; week < weeklySalesData.size(); week++) {
            double[] sales = weeklySalesData.get(week);
            double totalWeeklySales = 0;

            for (double sale : sales) {
                totalWeeklySales += sale;
            }

            double averageDailySales = totalWeeklySales / sales.length;
            totalAllWeeks += totalWeeklySales;

            System.out.printf(
                "Week %d - Total Sales: %.2f, Average Daily Sales: %.2f%n",
                week + 1,
                totalWeeklySales,
                averageDailySales
            );

            if (totalWeeklySales > highestWeeklySales) {
                highestWeeklySales = totalWeeklySales;
                highestWeek = week + 1;
            }

            if (totalWeeklySales < lowestWeeklySales) {
                lowestWeeklySales = totalWeeklySales;
                lowestWeek = week + 1;
            }
        }

        double averageWeeklySales = totalAllWeeks / weeklySalesData.size();

        System.out.printf("Total Sales for All Weeks: %.2f%n", totalAllWeeks);
        System.out.printf("Average Weekly Sales: %.2f%n", averageWeeklySales);
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
