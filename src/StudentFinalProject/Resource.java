package StudentFinalProject;

public class Resource
        implements Identifiable, Comparable<Resource> {

    private int id;
    private String name;
    private String category;

    public Resource(int id, String name, String category) {
        this.id = id;
        this.name = name;
        this.category = category;
    }

    @Override
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    @Override
    public int compareTo(Resource other) {

        // TODO:
        // Define the natural ordering for Resource.

        return 0;
    }

    @Override
    public String toString() {
        return id + ":" + name + ":" + category;
    }
}