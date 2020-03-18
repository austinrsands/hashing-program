package project;

/**
 * Driver class containing main method
 */
public class Main {
    /**
     * Entry point of program
     * @param args command line arguments
     */
    public static void main(String[] args) {
        // Given Table Size (prime in the form 4j + 3, j >= 1)
        int tableSize = 1019;

        // minimum and maximum numbers to look for
        int min = 1;
        int max = 10000;

        // create tables with given probing method
        HashTable a = new LinearHashTable(tableSize);
        HashTable b = new LinearHashTable(tableSize);
        HashTable c = new QuadraticHashTable(tableSize);
        HashTable d = new QuadraticHashTable(tableSize);

        // fill tables to given capacities
        a.fillRandomlyToCapacity(0.6, min, max);
        b.fillRandomlyToCapacity(0.8, min, max);
        c.fillRandomlyToCapacity(0.6, min, max);
        d.fillRandomlyToCapacity(0.8, min, max);

        // print statistics about the tables
        System.out.println("\n60% full Hash Table using Linear probing:");
        a.printStatisticsForKeys(min, max);
        System.out.println("\n80% full Hash Table using Linear probing:");
        b.printStatisticsForKeys(min, max);
        System.out.println("\n60% full Hash Table using Quadratic probing:");
        c.printStatisticsForKeys(min, max);
        System.out.println("\n80% full Hash Table using Quadratic probing:");
        d.printStatisticsForKeys(min, max);
    }
}
