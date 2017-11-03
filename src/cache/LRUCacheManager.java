package cache;

public class LRUCacheManager<K, V> extends AbstractCacheManager<K, V> {

    public LRUCacheManager(long size) {
        super(size, CacheType.LRU);
    }

}
