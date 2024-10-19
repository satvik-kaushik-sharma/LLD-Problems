package Cache.EvictionPolicy;

import java.util.*;

public class LFUEvictionPolicy<K> implements EvictionPolicy<K> {
    List<FqNode<K>> lfuHeap;
    Map<K, Integer> map; // ,ap of key to index in the heap array

    public LFUEvictionPolicy() {
        lfuHeap = new ArrayList<>();
        map = new HashMap<>();
    }

    private void heapifyUp(int idx) {
        int parentIdx = (idx - 1) / 2;
        if (lfuHeap.get(parentIdx).getFq() > lfuHeap.get(idx).getFq()) {
            map.put(lfuHeap.get(parentIdx).getKey(), idx);
            map.put(lfuHeap.get(idx).getKey(), parentIdx);
            Collections.swap(lfuHeap, parentIdx, idx);
            heapifyUp(parentIdx);
        }
    }

    private void heapifyDown(int idx) {
        int left = 2 * idx + 1, right = 2 * idx + 2;
        int smallest = idx;
        if (left < lfuHeap.size() && lfuHeap.get(smallest).getFq() > lfuHeap.get(left).getFq()) smallest = left;
        if (right < lfuHeap.size() && lfuHeap.get(smallest).getFq() > lfuHeap.get(right).getFq()) smallest = right;
        if (smallest != idx) {
            map.put(lfuHeap.get(smallest).getKey(), idx);
            map.put(lfuHeap.get(idx).getKey(), smallest);
            Collections.swap(lfuHeap, smallest, idx);
            heapifyDown(smallest);
        }
    }

    private K pop() {
        FqNode<K> nodeToRemove = lfuHeap.get(0);
        System.out.println(nodeToRemove);
        Collections.swap(lfuHeap, 0, lfuHeap.size() - 1);
        lfuHeap.remove(lfuHeap.size() - 1);
        map.put(lfuHeap.get(0).getKey(), 0);
//        also remove new last node from map
        heapifyDown(0);
        System.out.println("debug" + this);
        return nodeToRemove.getKey();
    }

    @Override
    public void add(K key) {
        FqNode<K> node = new FqNode<K>(1, key);
        lfuHeap.add(node);
        map.put(key, lfuHeap.size() - 1);
        System.out.println("Pre Add Debug === " + this);

        heapifyUp(lfuHeap.size() - 1);
        System.out.println("Post Add Debug  === " + this);

    }

    @Override
    public void update(K key) {
        int idx = map.get(key);
        FqNode<K> node = lfuHeap.get(idx);
        node.setFq(node.getFq() + 1);
        heapifyDown(idx);
    }

    @Override
    public void delete(K key) {
        Integer idx = map.get(key);
        System.out.println(key + idx.toString());
        FqNode<K> node = lfuHeap.get(idx);
//        is this needed
//        why can't i just directly swap idx and last el - remove last - call heap-ify down on idx
        node.setFq(0);
        heapifyUp(idx);
        Collections.swap(lfuHeap, 0, lfuHeap.size() - 1);
        lfuHeap.remove(lfuHeap.size() - 1);
        map.put(lfuHeap.get(0).getKey(), 0);
        heapifyDown(0);
    }

    @Override
    public K evict() {
//        delete top element
        return this.pop();
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder("LRUEvictionPolicy{" +
                "List " +
                '}');
        for (FqNode node : lfuHeap) {
            s.append(node.getKey()).append(", ");
        }
        s.append('\n');
        for (Map.Entry<K, Integer> el : map.entrySet()) {
            s.append(el.getKey() + "->" + el.getValue() + ", ");
        }
        return s.toString();
    }
}
