package cache;

public enum CacheExceptionCode {

    CACHE_FULL("the cache size {} is reached");

    private String message;

    private CacheExceptionCode(final String message) {
        this.message = message;
    }

    public String getExceptionMessage(Object... objects) {
        return String.format(this.message, objects);
    }
}
