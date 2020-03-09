package project;

import java.util.Arrays;
import java.util.Random;

public abstract class HashTable {
    double numKeys;
    int[] table;

    public HashTable(int size) {
        table = new int[size];
        numKeys = 0;
    }

    abstract void addKey(int key);
    abstract boolean hasKey(int key);

    int getHashValue(int key) {
        return key % table.length;
    }

    public double getLoadFactor() {
        return numKeys / table.length;
    }

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

    public String toString() {
        return Arrays.toString(table);
    }
}
