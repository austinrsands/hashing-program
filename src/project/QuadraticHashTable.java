package project;

/**
 * Represents a hash table that uses quadratic probing
 */
public class QuadraticHashTable extends HashTable {

    /**
     * Constructs a quadratic hash table of the given size
     * @param size the size of the hash table
     */
    public QuadraticHashTable(int size) {
        super(size);
    }

    /**
     * Adds a key to the hash table
     * @param key the key to add
     */
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

    
    /**
     * Determines the number of probes necessary to locate key or determine that it is not in the table
     * @param key the key to look for
     * @return an array of two elements, the first element being the number of probes and the second being 0 if the key was found or 1 if it was not
     */
    public int[] probesForKey(int key) {
        int hashValue = getHashValue(key);
        for (int i = 0; i < (table.length - 1) / 2; i++) {
            int upperIndex = (hashValue + (i * i)) % table.length;
            int lowerIndex = (hashValue - (i * i)) % table.length;
            if (lowerIndex < 0)
                lowerIndex += table.length;

            if (table[upperIndex] == key) {
                return new int[] {i == 0 ? 0 : 2 * i - 1, 0};
            } else if (table[lowerIndex] == key) {
                return new int[] {2 * i, 0};
            } else if (table[upperIndex] == 0 || table[lowerIndex] == 0) {
                return new int[] {table[upperIndex] == 0 ? (i == 0 ? 0 : 2 * i - 1) : 2 * i, 1};
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