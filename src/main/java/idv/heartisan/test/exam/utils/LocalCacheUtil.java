package idv.heartisan.test.exam.utils;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;

import java.util.concurrent.TimeUnit;

/**
 * @author Jin Qi
 * @date 2023/11/29
 */
public class LocalCacheUtil {

    public static Cache<String, Object> caffeine =
            Caffeine.newBuilder()
                    .expireAfterWrite(15, TimeUnit.DAYS)
                    .maximumSize(1000)
                    .build();

    public static void put (String key, Object value) {
        caffeine.put(key, value);
    }

    public static Object get (String key) {
        return caffeine.getIfPresent(key);
    }

    public static void remove (String key) {
        caffeine.invalidate(key);
    }

    public static long size () {
        return caffeine.estimatedSize();
    }

    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
            put(i + "", i);
        }
        System.out.println("size1: " + size());
        System.out.println("333: " + get("333"));
        remove("333");
        System.out.println("size2: " + size());
        System.out.println("333: " + get("333"));

    }

}
