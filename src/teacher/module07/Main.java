package teacher.module07;
import java.util.*; import java.util.concurrent.*;
public class Main{
 public static void main(String[] a) throws Exception { ExecutorService pool=Executors.newFixedThreadPool(3); try { List<Callable<Integer>> tasks=List.of(()->"java streams".split("\\s+").length,()->"collections generics reflection".length(),()->List.of(1,2,3,4).stream().mapToInt(Integer::intValue).sum()); List<Future<Integer>> fs=pool.invokeAll(tasks); int total=0; for(Future<Integer> f:fs){int v=f.get(); System.out.println("Result="+v); total+=v;} System.out.println("Combined="+total); } finally { pool.shutdown(); }}
}
