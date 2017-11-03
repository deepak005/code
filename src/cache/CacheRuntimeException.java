package cache;

public class CacheRuntimeException extends RuntimeException {

    private static final long serialVersionUID = 1L;
    private CacheExceptionCode exceptionCode;

    public CacheRuntimeException(CacheExceptionCode exceptionCode, Throwable th, Object... objects) {
        super(exceptionCode.getExceptionMessage(objects), th);
        this.exceptionCode = exceptionCode;
    }

    public CacheExceptionCode getExceptionCode() {
        return exceptionCode;
    }

    public void setExceptionCode(CacheExceptionCode exceptionCode) {
        this.exceptionCode = exceptionCode;
    }

}
