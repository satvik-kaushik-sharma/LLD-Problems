package Cache;

import Cache.EvictionPolicy.EvictionPolicy;

public abstract class ICache<K, V> {
    int capacity;
    EvictionPolicy<K> evictionPolicy;


    ICache() {}
    ICache(EvictionPolicy<K> evictionPolicy,int capacity) {
        this.evictionPolicy = evictionPolicy;
        this.capacity = capacity;
    }

    public abstract V get(K key);
    public abstract void put(K key, V value);
    public abstract V delete(K key);
}
