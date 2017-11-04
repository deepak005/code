package cache;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class DefaultCacheManager<K, V> extends AbstractCacheManager<K, V> {

    private final Map<K, V> cache;

    private final ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    private final Lock readLock = readWriteLock.readLock();
    private final Lock writeLock = readWriteLock.writeLock();

    public DefaultCacheManager(long size) {
        super(size, CacheType.DEFAULT);

        // TODO: should we used a concurrent collection? Probably
        cache = new HashMap<>();
    }

    @Override
    public void put(K k, V v) {
        writeLock.lock();
        try {
            if (cache.size() == getSize()) {
                throw new CacheRuntimeException(CacheExceptionCode.CACHE_FULL, null, getSize());
            }

            this.cache.put(k, v);
        } finally {
            writeLock.unlock();
        }

    }

    @Override
    public synchronized void delete(K k) {
        writeLock.lock();
        try {
            this.cache.remove(k);
        } finally {
            writeLock.unlock();
        }
    }

    @Override
    public V get(K k) {
        readLock.lock();
        try {
            return this.cache.get(k);
        } finally {
            readLock.unlock();
        }
    }

    @Override
    public void logStats() {
        readLock.lock();
        try {
            super.logStats();

            System.out.println("Cache filled size = " + this.cache.size());
        } finally {
            readLock.unlock();
        }
    }

}
