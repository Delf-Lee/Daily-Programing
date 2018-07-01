package DP004;

import java.util.HashMap;

public class OneToOneHashMap<K,V> {
    private HashMap<K, V> keyHashMap;
    private HashMap<V, K> valueHashMap;

    public OneToOneHashMap() {
        keyHashMap = new HashMap<K, V>();
        valueHashMap = new HashMap<V, K>();
    }

    public boolean isContain(Object object) {
        return (keyHashMap.containsKey(object) || valueHashMap.containsKey(object));
    }

    public void put(K left, V right) {
        keyHashMap.put(left, right);
        valueHashMap.put(right, left);
    }

    public V get(K key) {
        return keyHashMap.get(key);
    }
}
