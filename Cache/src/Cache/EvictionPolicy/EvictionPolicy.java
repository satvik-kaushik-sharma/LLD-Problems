package Cache.EvictionPolicy;

public interface EvictionPolicy<K> {

    public abstract void add(K key); // this key was used

    public abstract void update(K key); // this key was used

    public abstract void delete(K key); // key deleted from cache

    public abstract K evict(); // make space for new entry
}
