package cache;

public class AbstractCacheManager<K, V> implements ICacheManager<K, V> {

    private volatile long size;
    private CacheType cacheType;

    public AbstractCacheManager(long size, CacheType cacheType) {
        this.size = size;
        this.cacheType = cacheType;
    }

    public CacheType getCacheType() {
        return cacheType;
    }

    public void setCacheType(CacheType cacheType) {
        this.cacheType = cacheType;
    }

    protected long getSize() {
        return this.size;
    }


    @Override
    public void put(K k, V v) {
        throw new UnsupportedOperationException("Not yet supported");
    }

    @Override
    public V get(K k) {
        throw new UnsupportedOperationException("Not yet supported");
    }

    @Override
    public void delete(K k) {
        throw new UnsupportedOperationException("Not yet supported");
    }

    @Override
    public void logStats() {
       System.out.println("Cache Size = " + this.size + ", type = " + this.cacheType );
    }

}
