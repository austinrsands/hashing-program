package project;

public class Main {
    /**
     * Entry point of program
     * @param args command line arguments
     */
    public static void main(String[] args) {
        int tableSize = 1019;
        int min = 2;
        int max = 10000;

        HashTable a = new LinearHashTable(tableSize);
        HashTable b = new LinearHashTable(tableSize);
        HashTable c = new QuadraticHashTable(tableSize);
        HashTable d = new QuadraticHashTable(tableSize);

        a.fillRandomlyToCapacity(0.6, min, max);
        b.fillRandomlyToCapacity(0.8, min, max);
        c.fillRandomlyToCapacity(0.6, min, max);
        d.fillRandomlyToCapacity(0.8, min, max);
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);
    }
}
