package cache;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

/**
 * @author brucebat
 * @version 1.0
 * @since Created at 2022/3/28 3:08 PM
 */
public class CacheTest {

    public static void main(String[] args) {
        Cache<String, String> cache = CacheBuilder.newBuilder().removalListener(new TestCacheRemovalListener()).build();
        cache.put("test", "testOld");
        System.out.println("获取更新前的缓存值: " + cache.getIfPresent("test"));
        cache.put("test", "testNew");
        System.out.println("获取更新后的缓存值: " + cache.getIfPresent("test"));
    }
}
