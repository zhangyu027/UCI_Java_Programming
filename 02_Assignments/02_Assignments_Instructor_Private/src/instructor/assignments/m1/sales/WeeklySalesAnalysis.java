package instructor.assignments.m1.sales;

import java.io.*;
import java.nio.file.*;
import java.util.*;

public class WeeklySalesAnalysis {
    public static void main(String[] args) throws IOException {
        Path path = args.length > 0 ? Path.of(args[0]) : Path.of("data", "sales_data.txt");
        List<String> lines = Files.readAllLines(path);
        double grandTotal=0, high=Double.NEGATIVE_INFINITY, low=Double.POSITIVE_INFINITY;
        int highWeek=-1, lowWeek=-1;
        int week=0;
        for (String line: lines) {
            if (line.isBlank()) continue;
            week++;
            String[] parts=line.split("\\s*,\\s*");
            double total=0;
            for (String p:parts) total += Double.parseDouble(p.trim());
            double avg=total/parts.length;
            grandTotal += total;
            if (total>high) {
                high=total;
                highWeek=week;
            }
            if (total<low) {
                low=total;
                lowWeek=week;
            }
            System.out.printf("Week %d total: %.2f | daily average: %.2f%n", week, total, avg);
        }
        System.out.printf("All weeks total: %.2f%n", grandTotal);
        System.out.printf("Average weekly sales: %.2f%n", week==0?0:grandTotal/week);
        System.out.println("Highest sales week: " + highWeek);
        System.out.println("Lowest sales week: " + lowWeek);
    }
}
