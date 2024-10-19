import Cache.ConcreteCache;
import Cache.EvictionPolicy.EvictionPolicy;
import Cache.EvictionPolicy.LFUEvictionPolicy;
import Cache.EvictionPolicy.LRUEvictionPolicy;

public class Main {
    public static void main(String[] args) {
        EvictionPolicy<Character> ep = new LFUEvictionPolicy<>();
        ConcreteCache<Character, Number> cache = new ConcreteCache<Character, Number>(
                ep, 5
        );
        for (int i = 0; i < 5; i++) {
            cache.put((char) ('A' + i), i + 1);
        }
        System.out.println(ep);
        System.out.println(cache.get('A'));
        System.out.println(ep);
        System.out.println(cache.get('B'));
//        System.out.println(cache.get('B'));
//        System.out.println(cache.get('B'));
        System.out.println(ep);
        System.out.println(cache.get('C'));
        System.out.println(ep);
        System.out.println(cache.get('D'));
        System.out.println(ep);
        cache.put('F', 6);
        System.out.println(ep);
//        cache.delete('F');
//
//        System.out.println(ep);
//        System.out.println(cache.get('D'));
    }
}