package retry;


import java.util.Objects;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

/**
 * Implements the retry logic for flaky tests.
 */
public class Retry implements IRetryAnalyzer {

    private static final int DEFAULT_COUNT = 3;
    private static String retryKeyName = "retry.skip";
    private static String retryCountKeyName = "retry.count";

    private int count;
    private boolean shouldRetry = true;
    private int retryCount = DEFAULT_COUNT;

    public Retry() {
        final String retry = System.getProperty(retryKeyName);
        if (Objects.nonNull(retry) && "true".equalsIgnoreCase(retry)) {
            this.shouldRetry = false;
            return;
        }

        final String retryCountStr = System.getProperty(retryCountKeyName);
        if (Objects.isNull(retryCountStr)) {
            return;
        }

        try {
            this.retryCount = Integer.parseInt(retryCountStr);
        } catch (final Exception e) {
            // Do nothing
        }

    }

    @Override
    public boolean retry(final ITestResult iTestResult) {
        if (!this.shouldRetry) {
            return false;
        }

        if (iTestResult.isSuccess()) {
            iTestResult.setStatus(ITestResult.SUCCESS);
            return false;
        }

        if (this.count >= this.retryCount) {
            iTestResult.setStatus(ITestResult.FAILURE);
            return false;
        }

        this.count++;
        iTestResult.setStatus(ITestResult.FAILURE);
        return true;
    }

}