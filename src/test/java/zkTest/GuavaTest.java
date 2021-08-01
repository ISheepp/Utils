package zkTest;

import com.google.common.cache.*;
import org.junit.Test;

import java.time.Duration;
import java.util.concurrent.ExecutionException;


/**
 * @author 林子洋靓
 * @create 2021-05-08 16:22:06
 */
public class GuavaTest {

    /**
     * LoadingCache
     */
    private LoadingCache<Integer, Long> cacheMap = CacheBuilder.newBuilder().initialCapacity(10)
            .concurrencyLevel(10)
            .expireAfterAccess(Duration.ofSeconds(10))
            .weakValues()
            .recordStats()
            .removalListener((RemovalListener<Integer, Long>) removalNotification -> System.out.println(removalNotification.getValue()))
            .build(new CacheLoader<Integer, Long>() {
                @Override
                public Long load(Integer integer) {
                    return System.currentTimeMillis();
                }
            });

    /**
     * 测试Multiset
     */
    @Test
    public void test() throws ExecutionException {

    }

}
