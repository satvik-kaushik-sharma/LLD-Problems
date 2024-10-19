package Cache;

import Cache.EvictionPolicy.EvictionPolicy;

import java.util.HashMap;

public class ConcreteCache<K, V> extends ICache<K, V> {

    HashMap<K, V> cache;

    public ConcreteCache(EvictionPolicy<K> evictionPolicy, int capacity) {
        super(evictionPolicy, capacity);
        this.cache = new HashMap<>();
    }


    @Override
    public V get(K key) {
        if (!cache.containsKey(key)) return null;
        this.evictionPolicy.update(key);
        return this.cache.get(key);
    }

    @Override
    public void put(K key, V value) {
        if (cache.containsKey(key)) {
            this.cache.put(key, value);
            this.evictionPolicy.update(key);
            return;
        }
        if (this.cache.size() == this.capacity) {
            K removedKey = this.evictionPolicy.evict();
            this.cache.remove(removedKey);
        }
        this.cache.put(key, value);
        this.evictionPolicy.add(key);
    }

    @Override
    public V delete(K key) {
        this.evictionPolicy.delete(key);
        this.cache.remove(key);
        return null;
    }

}
