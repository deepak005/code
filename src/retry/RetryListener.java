package retry;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import org.testng.IAnnotationTransformer;
import org.testng.IRetryAnalyzer;
import org.testng.annotations.ITestAnnotation;

/**
 * Retry Listener.
 */
public class RetryListener implements IAnnotationTransformer {

    public RetryListener() {
    }

    @SuppressWarnings("rawtypes")
    @Override
    public void transform(final ITestAnnotation annotation,
            final Class testClass,
            final Constructor testConstructor,
            final Method testMethod) {
        final IRetryAnalyzer retry = annotation.getRetryAnalyzer();
        if (retry == null) {
            annotation.setRetryAnalyzer(Retry.class);
        }
    }
}