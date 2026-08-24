package TeacherFinalProject;
public abstract class Person implements Identifiable { private final int id; private final String name; protected Person(int id,String name){this.id=id;this.name=name;} public int getId(){return id;} public String getName(){return name;} public String toString(){return id+":"+name;} }
