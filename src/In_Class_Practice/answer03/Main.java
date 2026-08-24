package In_Class_Practice.answer03;
import java.util.*;
public class Main {
    public static void main(String[] args){
        List<String> roster=new ArrayList<>(); Set<Integer> ids=new HashSet<>(); Map<Integer,String> map=new HashMap<>();
        int[] id={3,1,2}; String[] name={"Mina","Alex","Bo"};
        for(int i=0;i<id.length;i++){ if(ids.add(id[i])){ roster.add(name[i]); map.put(id[i],name[i]); }}
        map.remove(99); System.out.println("Roster: "+roster); System.out.println("Search 2: "+map.get(2)); System.out.println("Sorted: "+new TreeMap<>(map));
        System.out.println("Unique IDs sorted: "+new TreeSet<>(ids));
    }
}
