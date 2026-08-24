package TeacherFinalProject;

import java.lang.reflect.*;
import java.nio.file.*;
import java.util.*;
import java.util.concurrent.*;

public class Main {

    static List<Resource> loadResources(Path path) throws Exception {
        List<Resource> result = new ArrayList<>();
        List<String> lines = Files.readAllLines(path);

        for (int i = 1; i < lines.size(); i++) {
            String[] p = lines.get(i).split(",");
            result.add(
                new Resource(
                    Integer.parseInt(p[0]),
                    p[1],
                    p[2]
                )
            );
        }

        return result;
    }

    public static void main(String[] args) throws Exception {

        Path data = Path.of(
            "/Users/yuzhang/Library/CloudStorage/GoogleDrive-zhangyu027@gmail.com/My Drive/Colab Notebooks/UCI/UCI_X460.17_JavaProgramming/03_Teacher_Package/02_Teacher_Final_Solution/FinalProject_Solution/data/resources.csv"
        );

        Repository<Resource> repo = new Repository<>();

        for (Resource r : loadResources(data)) {
            repo.add(r);
        }

        List<Resource> xs = repo.all();

        Collections.sort(xs);
        System.out.println("Natural: " + xs);

        xs.sort(Comparator.comparing(Resource::getName));
        System.out.println("By name: " + xs);

        long tech = xs.stream()
                      .filter(x -> x.getCategory().equals("Technology"))
                      .count();

        System.out.println("Technology count=" + tech);

        for (Field f : Resource.class.getDeclaredFields()) {
            System.out.println("Field=" + f.getName());
        }

        ExecutorService pool = Executors.newFixedThreadPool(2);

        try {
            Future<Integer> count = pool.submit(xs::size);

            Future<Integer> nameLen = pool.submit(
                () -> xs.stream()
                        .mapToInt(x -> x.getName().length())
                        .sum()
            );

            System.out.println(
                "Concurrent report=" + (count.get() + nameLen.get())
            );

        } finally {
            pool.shutdown();
        }
    }
}

//StudentFinalProject
//├── Main.java
//├── Identifiable.java
//├── Person.java
//├── Student.java          ← YES
//├── Staff.java            ← YES
//├── Resource.java
//├── Repository.java
//└── InvalidResourceException.java