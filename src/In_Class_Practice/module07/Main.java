package In_Class_Practice.module07;
import java.util.*;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) throws Exception {
        ExecutorService pool = Executors.newFixedThreadPool(3);
        try {
            // TODO: Submit at least three independent Callable tasks.
            // TODO: Collect results and combine them on the main thread.
        } finally {
            pool.shutdown();
        }
    }
}
