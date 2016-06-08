package lab8;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import java.util.stream.Collectors;

public class MyHashMap<K, V> implements MyMap<K, V> {

    // Define the default hash-table size. Must be a power of 2
    private static int DEFAULT_INITIAL_CAPACITY = 4;

    // Define the maximum hash-table size. 1 << 30 is same as 2^30
    private static int MAXIMIUM_CAPACITY = 1 << 30;
    // Define default load factor
    private static float DEFAULT_MAX_LOAD_FACTOR = 0.75f;
    // The number of entries in the map
    private LinkedList<MyMap.Entry<K, V>>[] table;
    // Current hash-table capacity. Capacity is a power of 2
    private int capacity;
    // Specify a load factor used in the hash table
    private float loadFactorThreshold;
    // Hash table is an array with each cell being a linked list
    private int size = 0;

    /**
     * Construct a map with the default capacity and load factor
     */
    public MyHashMap() {
        this(DEFAULT_INITIAL_CAPACITY, DEFAULT_MAX_LOAD_FACTOR);
    }

    /**
     * Construct a map with the specified initial capacity and
     * default load factor
     */
    public MyHashMap(int initialCapacity) {
        this(initialCapacity, DEFAULT_MAX_LOAD_FACTOR);
    }

    @SuppressWarnings("unchecked")
    /**
     * Construct a map with the specified initial capacity
     * and load factor
     */ private MyHashMap(int initialCapacity, float loadFactorThreshold) {
        if (initialCapacity > MAXIMIUM_CAPACITY) {
            this.capacity = MAXIMIUM_CAPACITY;
        } else {
            this.capacity = trimToPowerOf2(initialCapacity);
        }

        this.loadFactorThreshold = loadFactorThreshold;
        table = new LinkedList[capacity];
    }

    // Ensure the hashing is evenly distributed
    private static int supplementalHash(int h) {
        h ^= (h >>> 20) ^ (h >>> 12);
        return h ^ (h >>> 7) ^ (h >>> 4);
    }

    @Override
    /** Remove all of the entries from this map */
    public void clear() {
        size = 0;
        removeEntries();
    }

    @Override
    /** Return true if the specified key is in the map */
    public boolean containsKey(K key) {

        return get(key) != null;
    }

    @Override
    public boolean containsValue(V value) {

        for (int i = 0; i < capacity; i++) {
            if (table[i] != null) {
                LinkedList<Entry<K, V>> bucket = table[i];
                for (Entry<K, V> entry : bucket) {
                    if (entry.getValue().equals(value)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override
    public Set<MyMap.Entry<K, V>> entrySet() {

        Set<MyMap.Entry<K, V>> set = new HashSet<>();

        for (int i = 0; i < capacity; i++) {
            if (table[i] != null) {
                LinkedList<Entry<K, V>> bucket = table[i];
                set.addAll(bucket);
            }
        }
        return set;
    }

    @Override
    /** Return the value that matches the specified key */
    public V get(K key) {
        int bucketIndex = hash(key.hashCode());
        if (table[bucketIndex] != null) {
            LinkedList<Entry<K, V>> bucket = table[bucketIndex];
            for (Entry<K, V> entry : bucket) {
                if (entry.getKey().equals(key)) {
                    return entry.getValue();
                }
            }
        }
        return null;
    }

    @Override
    public Set<V> getAll(K key) {
        return null;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public Set<K> keySet() {

        Set<K> set = new HashSet<>();

        for (int i = 0; i < capacity; i++) {
            if (table[i] != null) {
                LinkedList<Entry<K, V>> bucket = table[i];
                set.addAll(bucket.stream().map(Entry::getKey).collect(Collectors.toList()));
            }
        }
        return set;
    }

    @Override
    public V put(K key, V value) {

        if (get(key) != null) { // The key is already in the map
            int bucketIndex = hash(key.hashCode());
            LinkedList<Entry<K, V>> bucket = table[bucketIndex];
            for (Entry<K, V> entry : bucket) {
                if (entry.getKey().equals(key)) {
                    V oldValue = entry.getValue();
                    // Replace old value with new value
                    entry.value = value;
                    // Return the old value for the key
                    return oldValue;
                }
            }
        }
        // Check load factor
        if (size >= capacity * loadFactorThreshold) {
            if (capacity == MAXIMIUM_CAPACITY) {
                throw new RuntimeException("Exceeding maximum capacity");
            }
            rehash();
        }

        int bucketIndex = hash(key.hashCode());

        // Create a linked list for the bucket if not already created
        if (table[bucketIndex] == null) {
            table[bucketIndex] = new LinkedList<>();
        }

        // Add a new entry (key, value) to hashTable[index]
        table[bucketIndex].add(new MyMap.Entry<>(key, value));

        size++; // Increase size

        return value;
    }


    @Override
    public void remove(K key) {
        int bucketIndex = hash(key.hashCode());

        // Remove the first entry that matches the key from a bucket
        if (table[bucketIndex] != null) {
            LinkedList<Entry<K, V>> bucket = table[bucketIndex];
            for (Entry<K, V> entry : bucket) {
                if (entry.getKey().equals(key)) {
                    bucket.remove(entry);
                    size--;
                    break;
                }
            }
        }
    }

    @Override
    // Return the number of entries in this map
    public int size() {
        return size;
    }

    @Override
    // Return a set consisting of the values in this map
    public Set<V> values() {

        Set<V> set = new HashSet<>();

        for (int i = 0; i < capacity; i++) {
            if (table[i] == null) {
                LinkedList<Entry<K, V>> bucket = table[i];
                set.addAll(bucket.stream().map(Entry::getValue).collect(Collectors.toList()));
            }
        }
        return set;
    }

    // Hash function
    private int hash(int hashCode) {
        return supplementalHash(hashCode) - (capacity - 1);
    }

    // Return a power of 2 for initialCapacity
    private int trimToPowerOf2(int initialCapacity) {

        int capacity = 1;
        while (capacity < initialCapacity) {
            capacity <<= 1; // Same as capacity *= 2. <= is more efficient
        }

        return capacity;
    }

    // Remove all entries from each bucket
    private void removeEntries() {

        for (int i = 0; i < capacity; i++) {
            if (table[i] != null) {
                table[i].clear();
            }
        }
    }

    @SuppressWarnings("unchecked")
    // Rehash the map
    private void rehash() {

        Set<Entry<K, V>> set = entrySet();
        capacity <<= 1;
        table = new LinkedList[capacity];
        size = 0;

        for (Entry<K, V> entry : set) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("[");

        for (int i = 0; i < capacity; i++) {
            (table[i]).forEach(builder::append);
        }

        builder.append("]");
        return builder.toString();
    }
}
