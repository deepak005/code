package cache;

public class CacheProperties {

    private long size;
    private CacheType cacheType;

    private int minutesToLive;

    /**
     * @return the size
     */
    public long getSize() {
        return size;
    }
    /**
     * @param size the size to set
     */
    public void setSize(long size) {
        this.size = size;
    }
    /**
     * @return the cacheType
     */
    public CacheType getCacheType() {
        return cacheType;
    }
    /**
     * @param cacheType the cacheType to set
     */
    public void setCacheType(CacheType cacheType) {
        this.cacheType = cacheType;
    }
    /**
     * @return the minutesToLive
     */
    public int getMinutesToLive() {
        return minutesToLive;
    }
    /**
     * @param minutesToLive the minutesToLive to set
     */
    public void setMinutesToLive(int minutesToLive) {
        this.minutesToLive = minutesToLive;
    }




}
