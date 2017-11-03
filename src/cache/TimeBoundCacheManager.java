package cache;

public class TimeBoundCacheManager<K, V> extends AbstractCacheManager<K, V> {

    public TimeBoundCacheManager(int size) {
        super(size, CacheType.TIME_BOUND);
    }

}