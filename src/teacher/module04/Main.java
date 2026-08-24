package teacher.module04;
import java.util.*;
class Item implements Comparable<Item>{ final int id; final String name; final double price; Item(int i,String n,double p){id=i;name=n;price=p;} public int compareTo(Item o){return Integer.compare(id,o.id);} public String toString(){return id+":"+name+":"+price;} }
class Catalog implements Iterable<Item>{ private final List<Item> items; Catalog(List<Item> x){items=x;} public Iterator<Item> iterator(){return items.iterator();} }
public class Main{
 public static void main(String[] a){ List<Item> xs=new ArrayList<>(List.of(new Item(2,"Book",12),new Item(1,"Pen",3),new Item(3,"Bag",20))); Collections.sort(xs); System.out.println(xs); xs.sort(Comparator.comparing(i->i.name)); System.out.println(xs); xs.sort(Comparator.comparingDouble(i->i.price)); System.out.println(xs); for(Item i:new Catalog(xs)) System.out.println("iter "+i); }
}
