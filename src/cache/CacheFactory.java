package cache;

public class CacheFactory {

    public static <K, V> AbstractCacheManager<K, V> getCacheManager(CacheProperties cacheProperties) {
        switch (cacheProperties.getCacheType()) {
        case LRU:
            return new LRUCacheManager<K, V>(cacheProperties.getSize());
        case DEFAULT:
            return new DefaultCacheManager<K, V>(cacheProperties.getSize());
        }
        throw new IllegalArgumentException("Unsupported cache type: " + cacheProperties.getCacheType());
    }

}
