package Cache.EvictionPolicy;

import java.util.HashMap;
import java.util.Map;

public class LRUEvictionPolicy<K> implements EvictionPolicy<K> {

    ListNode<K> headDummy; // doubly linked list in order of LRU - least recently used at the start of the list
    ListNode<K> tail;
    Map<K, ListNode<K>> map;

    public LRUEvictionPolicy() {
        this.map = new HashMap<>();
        this.headDummy = new ListNode<K>(null);
        this.tail = headDummy;
    }

    @Override
    public void add(K key) {
        ListNode<K> node = new ListNode<K>(key);
        map.put(key, node);
        this.tail.next = node;
        node.prev = this.tail;
        this.tail = node;
    }

    @Override
    public void update(K key) {
        ListNode<K> node = map.get(key);
        if (node == null) return;
//        break from current place
        node.prev.next = node.next;
        if (node.next != null) node.next.prev = node.prev;
//        put at last
        tail.next = node;
        node.prev = tail;
        node.next = null; // don't forget
//        update new tail
        tail = node;
    }

    @Override
    public void delete(K key) {
        ListNode<K> node = map.get(key);
        node.prev.next = node.next;
        if (node.next != null) node.next.prev = node.prev;
        map.remove(key);
    }

    @Override
    public K evict() {
//        evict the first node i.e. headDummy->next
        ListNode<K> toRemove = headDummy.next;
        this.delete(toRemove.item);
        return toRemove.item;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder("LRUEvictionPolicy{" +
                "List " +
                '}');
        ListNode t = headDummy;
        while (t != null) {
            s.append(t.item).append("-> ");
            t = t.next;
        }
        return s.toString();
    }
}
