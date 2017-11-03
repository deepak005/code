package cache;

public class CacheManagerDemo {

    public static void main(String[] args) {

        // TODO  move to builder
        CacheProperties cp = new CacheProperties();
        cp.setCacheType(CacheType.DEFAULT);
        cp.setSize(10l);
     ICacheManager<String, String>  cacheManager =  CacheFactory.getCacheManager(cp);

     cacheManager.put("key1", "val1");

     cacheManager.logStats();

    }
}
