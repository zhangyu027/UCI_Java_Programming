package In_Class_Practice.answer06;
import java.lang.reflect.*; import java.util.*; import java.util.function.*;
class ScoreRecord { private final int score; ScoreRecord(int s){score=s;} int getScore(){return score;} }
public class Main{
 public static void main(String[] a){ List<Integer> scores=List.of(88,55,91,72,67,100,83,74,60,95,79,86); Predicate<Integer> pass=x->x>=70; Function<Integer,Integer> bonus=x->Math.min(100,x+2); Consumer<Integer> show=System.out::println; Supplier<String> label=()->"Passing adjusted scores"; System.out.println(label.get()); scores.stream().filter(pass).map(bonus).sorted().forEach(show); double avg=scores.stream().mapToInt(Integer::intValue).average().orElse(0); System.out.println("Average="+avg); Class<?> c=ScoreRecord.class; System.out.println("Class="+c.getName()); for(Field f:c.getDeclaredFields()) System.out.println("Field="+f.getName()+" type="+f.getType().getSimpleName()); }
}
