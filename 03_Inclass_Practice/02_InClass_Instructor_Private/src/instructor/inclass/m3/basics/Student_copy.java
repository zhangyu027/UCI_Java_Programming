package instructor.inclass.m3.basics;

public class Student_copy {
    private String make, model;
    private int year;
    public Student_copy (String make, String model, int year) {
        this.make = make;
        this.model = model;
        this.year = year;
    }
    public String getMake() {
        return make;
    }
    public void setMake(String x) {
        make = x;
    }
    public String getModel() {
        return model;
    }
    public int getYear() {
        return year;
    }
    public void setYear(int y) {
        year = y;
    }
    public void drive() {
        System.out.println(year+" "+make+" "+model+" is driving.");
    }
}