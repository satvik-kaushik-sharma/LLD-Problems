package Cache.EvictionPolicy;

public class ListNode<K> {
    K item;
    ListNode<K> next;
    ListNode<K> prev;

    ListNode() {
    }

    ListNode(K key) {
        this.item = key;
    }
}
