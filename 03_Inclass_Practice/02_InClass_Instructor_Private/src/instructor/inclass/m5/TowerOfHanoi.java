package instructor.inclass.m5;

/** Recursive Java program to solve the Tower of Hanoi problem. */
public class TowerOfHanoi {

    public static void towerOfHanoi(int n, char source, char auxiliary, char destination) {
        // Base case: move one disk directly to the destination
        if (n == 1) {
            System.out.println("Move disk 1 from " + source + " to " + destination);
            return;
        }

        // Move n-1 disks from source to auxiliary
        towerOfHanoi(n - 1, source, destination, auxiliary);

        // Move the nth disk from source to destination
        System.out.println("Move disk " + n + " from " + source + " to " + destination);

        // Move n-1 disks from auxiliary to destination
        towerOfHanoi(n - 1, auxiliary, source, destination);
    }

    public static void main(String[] args) {
        int numberOfDisks = 3;
        towerOfHanoi(numberOfDisks, 'A', 'B', 'C');
    }
}
