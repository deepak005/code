package cache;

public interface ICacheManager<K, V> {

    void put(K k, V v);

    V get(K k);

    void delete(K k);

    /**
     * Logs the current cache state;
     */
    void logStats();

}
