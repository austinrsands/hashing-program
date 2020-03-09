package project;

public class QuadraticHashTable extends HashTable {

    public QuadraticHashTable(int size) {
        super(size);
    }

    public void addKey(int key) {
        int hashValue = getHashValue(key);
        for (int i = 0; i < (table.length - 1) / 2; i++) {
            int upperIndex = (hashValue + (i * i)) % table.length;
            int lowerIndex = (hashValue - (i * i)) % table.length;
            if (lowerIndex < 0)
                lowerIndex += table.length;

            if (table[upperIndex] == 0) {
                table[upperIndex] = key;
                numKeys++;
                break;
            } else if (table[lowerIndex] == 0) {
                table[lowerIndex] = key;
                numKeys++;
                break;
            }
        }
    }

    public boolean hasKey(int key) {
        int hashValue = getHashValue(key);
        for (int i = 0; i < (table.length - 1) / 2; i++) {
            int upperIndex = (hashValue + (i * i)) % table.length;
            int lowerIndex = (hashValue - (i * i)) % table.length;
            if (lowerIndex < 0)
                lowerIndex += table.length;

            if (table[upperIndex] == key) {
                return true;
            } else if (table[lowerIndex] == key) {
                return true;
            } else if (table[upperIndex] == 0 || table[lowerIndex] == 0) {
                return false;
            }
        }
        return false;
    }
}