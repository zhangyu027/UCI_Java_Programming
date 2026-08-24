package Assignment.module07;

import java.util.*;
import java.util.concurrent.*;

public class Main {

    public static void main(String[] args) throws Exception {

        System.out.println("Module 7 starter ready.");

        ExecutorService pool = Executors.newFixedThreadPool(3);

        try {

            // TODO 1:
            // Create at least three independent Callable tasks.
            //
            // Possible tasks:
            // - Calculate the sum of several numbers.
            // - Find the maximum value.
            // - Calculate an average.


            // TODO 2:
            // Submit each Callable task to the ExecutorService.
            //
            // Store the returned Future objects.


            // TODO 3:
            // Use Future.get() to retrieve the result
            // from each task.


            // TODO 4:
            // Print the individual task results.


            // TODO 5:
            // Combine the results on the main thread
            // and print a final report.


            // TODO 6:
            // Observe that the tasks may execute on
            // different worker threads.
            //
            // Optional:
            // Print Thread.currentThread().getName()
            // inside each task.


            // TODO 7:
            // Explain briefly:
            //
            // ExecutorService:
            // What is its purpose?
            //
            // Callable:
            // How is it different from Runnable?
            //
            // Future:
            // What does it represent?
            //
            // shutdown():
            // Why should the executor be shut down?

        } finally {

            // The ExecutorService should always be shut down.
            pool.shutdown();
        }
    }
}

//Assignment.module07
//├── Main.java
//└── ScoreTasks.java