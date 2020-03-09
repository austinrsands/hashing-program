package project;

public class LinearHashTable extends HashTable {

    public LinearHashTable(int size) {
        super(size);
    }

    public void addKey(int key) {
        int hashValue = getHashValue(key);
        for (int i = 0; i < table.length; i++) {
            int index = (hashValue + i) % table.length;
            if (table[index] == 0) {
                table[index] = key;
                numKeys++;
                break;
            }
        }
    }

    public boolean hasKey(int key) {
        int hashValue = getHashValue(key);
        for (int numProbes = 0; numProbes < table.length; numProbes++) {
            int index = (hashValue + numProbes) % table.length;
            if (table[index] == key) {
                return true;
            } else if (table[index] == 0) {
                return false;
            }
        }
        return false;
    }
}