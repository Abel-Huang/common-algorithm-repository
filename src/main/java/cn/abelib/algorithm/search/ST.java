package cn.abelib.algorithm.search;

/**
 * @author abel-huang
 * @date 2017/8/2
 */
public abstract class ST<K extends Comparable<K>, V> {

    public abstract void put(K key, V value);

    public abstract V get(K key);

    public abstract void delete(K k);

    public abstract boolean contains(K key);

    public abstract boolean isEmpty();

    public abstract int size();

    public abstract K min();

    public abstract K max();

    public abstract K floor(K key);

    public abstract K ceiling(K key);

    public abstract K rank(K key);

    public abstract K select(int i);

    public abstract void delMin();

    public abstract void delMax();

    public abstract int size(K low, K high);

    Iterable<K> keys(K low, K high) {
        return null;
    }

    Iterable<K> keys() {
        return null;
    }

}
