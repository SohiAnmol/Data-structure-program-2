/**
 * Anmoldeep Singh
 * 3149800
 */
import java.util.AbstractMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class LinkedChainHashMap<K, V> extends AbstractMap<K, V> {
    private static final int DEFAULT_CAPACITY = 3000;
    private int size;
    private LinkedList<Entry<K, V>>[] table;
    private int collisions;

    public LinkedChainHashMap() {
        this(DEFAULT_CAPACITY);
    }

    public LinkedChainHashMap(int capacity) {
        table = new LinkedList[capacity];
        for (int i = 0; i < capacity; i++) {
            table[i] = new LinkedList<>();
        }
    }

    public int size() {
        return size;
    }

    public boolean containsKey(Object key) {
        int hash = hash(key);
        LinkedList<Entry<K, V>> list = table[hash];
        for (Entry<K, V> entry : list) {
            if (entry.getKey().equals(key)) {
                return true;
            }
        }
        return false;
    }

    public V get(Object key) {
        int hash = hash(key);
        LinkedList<Entry<K, V>> list = table[hash];
        for (Entry<K, V> entry : list) {
            if (entry.getKey().equals(key)) {
                return entry.getValue();
            }
        }
        return null;
    }

    public V put(K key, V value) {
        int hash = hash(key);
        LinkedList<Entry<K, V>> list = table[hash];
        for (Entry<K, V> entry : list) {
            if (entry.getKey().equals(key)) {
                V oldValue = entry.getValue();
                entry.setValue(value);
                return oldValue;
            }
        }
        list.add(new AbstractMap.SimpleEntry<>(key, value));
        size++;
        if (list.size() > 1) {
            collisions++;
        }
        return null;
    }

    public V remove(Object key) {
        int hash = hash(key);
        LinkedList<Entry<K, V>> list = table[hash];
        for (Entry<K, V> entry : list) {
            if (entry.getKey().equals(key)) {
                V value = entry.getValue();
                list.remove(entry);
                size--;
                return value;
            }
        }
        return null;
    }

    public Set<Entry<K, V>> entrySet() {
        Set<Entry<K, V>> entrySet = new HashSet<>();
        for (LinkedList<Entry<K, V>> list : table) {
            if (list != null) {
                entrySet.addAll(list);
            }
        }
        return entrySet;
    }

    private int hash(Object key) {
        return Math.abs(key.hashCode()) % table.length;
    }

    public int getCollisions() {
        return collisions;
    }
}