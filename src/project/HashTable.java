package project;

import java.util.Arrays;
import java.util.Random;

/**
 * Abstract Hash Table
 */
public abstract class HashTable {
    
    // current number of elements in table
    double numKeys;

    // array containing keys
    int[] table;

    /**
     * Constructs a new hash table with given size
     * @param size the size of the hash table
     */
    public HashTable(int size) {
        table = new int[size];
        numKeys = 0;
    }

    // abstract methods
    abstract void addKey(int key);
    abstract boolean hasKey(int key);
    abstract int[] probesForKey(int key);

    /**
     * Returns the hash value of a given key
     * @param key the key to hash
     * @return the hash value of the key
     */
    int getHashValue(int key) {
        return key % table.length;
    }

    /**
     * Returns the load factor of the table
     * @return the load factor of the table
     */
    public double getLoadFactor() {
        return numKeys / table.length;
    }

    /**
     * Fills the hash table to the given capacity with random integers in the range [min...max] inclusive
     * @param capacity percent of table to fill in decimal form
     * @param min minimum number to fill table with
     * @param max maximum number to fill table with
     */
    public void fillRandomlyToCapacity(double capacity, int min, int max) {
        int numElements = (int) (capacity * table.length);
        Random rand = new Random();
        for (int i = 0; i < numElements; i++) {
            int key = rand.nextInt((max - min) + 1) + min;
            while (hasKey(key)) {
                key = rand.nextInt((max - min) + 1) + min;
            }
            addKey(key);
        }
    }

    /**
     * Prints data for the successful and unsuccessful searches of integers in the range [min...max] inclusive
     * @param min the minimum number to look for
     * @param max the maximum number to look for
     */
    public void printStatisticsForKeys(int min, int max) {
        int numSuccessful = 0;
        int successfulProbeCount = 0;
        int numUnsuccessful = 0;
        int unSuccessfulProbeCount = 0;
        
        // for each number in [min...max], count the number of probes necessary to find it or realize that it is not there
         for (int i = min; i <= max; i++) {
             int[] probeData = probesForKey(i);
             if (probeData[1] == 0) {
                 numSuccessful++;
                 successfulProbeCount += probeData[0];
             } else {
                 numUnsuccessful++;
                 unSuccessfulProbeCount += probeData[0];
             }
             //System.out.printf("Key: %d, Probes: %d\n", i, probeData[0]);
         }

         // display findings
         System.out.printf("Successful Searches: %d\n", numSuccessful);
         System.out.printf("Unsuccessful Searches: %d\n", numUnsuccessful);
         System.out.printf("Average Successful Number of Probes: %f\n", (double)successfulProbeCount / numSuccessful);
         System.out.printf("Average Unsuccessful Number of Probes: %f\n", (double)unSuccessfulProbeCount / numUnsuccessful);
    }

    /**
     * Returns string representation of table
     */
    public String toString() {
        return Arrays.toString(table);
    }
}
