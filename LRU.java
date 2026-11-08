
import java.util.ArrayList;

public class LRU {

    // LRU page replacement function
    public static void simulateLRU(int[] pages, int capacity) {

        ArrayList<Integer> memory = new ArrayList<>();

        int hits = 0;
        int faults = 0;

        System.out.println("LRU PAGE REPLACEMENT");
        System.out.println("--------------------");

        for (int page : pages) {

            if (memory.contains(page)) {

                // Page already exists: HIT
                hits++;

                // Move page to most recently used position
                memory.remove(Integer.valueOf(page));

                System.out.println(page + " : HIT");

            } else {

                // Page does not exist: MISS
                faults++;

                // Remove least recently used page if RAM is full
                if (memory.size() == capacity) {
                    memory.remove(0);
                }

                System.out.println(page + " : MISS");
            }

            // Add requested page
            memory.add(page);

            System.out.println("RAM: " + memory);
        }

        System.out.println("--------------------");
        System.out.println("Total Hits: " + hits);
        System.out.println("Total Page Faults: " + faults);
    }

    // Main method: test the algorithm
    public static void main(String[] args) {

        int[] pages = {1, 2, 3, 1, 4, 2, 5};

        int ramCapacity = 3;

        simulateLRU(pages, ramCapacity);
    }
}
