package cache;

import java.util.HashMap;
import java.util.Map;

public class DefaultCacheManager<K, V> extends AbstractCacheManager<K, V> {


    private final Map<K, V> cache;

    public DefaultCacheManager(long size) {
        super(size, CacheType.DEFAULT);

        // TODO: should we used a concurrent collection? Probably
        cache = new HashMap<>();
    }

    /**
     * TODO: Should we use better locking than synchronized?
     */
    @Override
    public synchronized void put(K k, V v) {
        if (cache.size() == getSize()) {
            throw new CacheRuntimeException(CacheExceptionCode.CACHE_FULL, null, getSize());
        }

        this.cache.put(k, v);


    }

    @Override
    public synchronized void delete(K k) {
        this.cache.remove(k);
    }

    @Override
    public V get(K k) {
        return this.cache.get(k);
    }

    @Override
    public void logStats() {
       super.logStats();

       System.out.println("Cache filled size = " + this.cache.size());
    }

}
