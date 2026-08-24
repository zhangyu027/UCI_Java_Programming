package teacher.module05;
import java.util.*;
class Repository<T>{ private final List<T> data=new ArrayList<>(); void add(T x){data.add(x);} T get(int i){return data.get(i);} List<T> all(){return List.copyOf(data);} }
public class Main{
 static <T> T first(List<T> xs){return xs.get(0);} static void printAll(List<?> xs){for(Object x:xs) System.out.println(x);} static double sumNumbers(List<? extends Number> xs){return xs.stream().mapToDouble(Number::doubleValue).sum();}
 public static void main(String[] a){ Repository<String> r=new Repository<>(); r.add("Java"); r.add("Generics"); System.out.println(r.get(0)); printAll(r.all()); System.out.println(first(r.all())); System.out.println(sumNumbers(List.of(1,2,3))); }
}
