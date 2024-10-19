package Cache.EvictionPolicy;

public class FqNode<K> {
    public int getFq() {
        return fq;
    }

    public void setFq(int fq) {
        this.fq = fq;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    int fq;
    K key;

    public FqNode(int fq, K key) {
        this.fq = fq;
        this.key = key;
    }

    @Override
    public String toString() {
        return "FqNode{" +
                "fq=" + fq +
                ", key=" + key +
                '}';
    }
}
