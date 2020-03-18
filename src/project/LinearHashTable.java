package project;

/**
 * Represents a hash table that uses linear probing
 */
public class LinearHashTable extends HashTable {

    /**
     * Constructs a linear hash table of the given size
     * @param size the size of the hash table
     */
    public LinearHashTable(int size) {
        super(size);
    }

    /**
     * Adds a key to the hash table
     * @param key the key to add
     */
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

    /**
     * Determines the number of probes necessary to locate key or determine that it is not in the table
     * @param key the key to look for
     * @return an array of two elements, the first element being the number of probes and the second being 0 if the key was found or 1 if it was not
     */
    public int[] probesForKey(int key) {
        int hashValue = getHashValue(key);
        for (int numProbes = 0; numProbes < table.length; numProbes++) {
            int index = (hashValue + numProbes) % table.length;
            if (table[index] == key) {
                return new int[] {numProbes, 0};
            } else if (table[index] == 0) {
                return new int[] {numProbes, 1};
            }
        }
        return new int[] {0, 1};
    }

    /**
     * Determines if a key is in the table
     * @param key the key to look for
     * @return true if key is found, false otherwise
     */
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