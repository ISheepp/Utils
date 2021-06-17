package Hutool;

import cn.hutool.cache.Cache;
import cn.hutool.cache.CacheUtil;
import cn.hutool.core.date.DateUnit;

/**
 * @author 林子洋
 * @create 2021-06-15 16:54:09
 */
public class CacheTest {

    public static void main(String[] args) {
        Cache<String, String> cache = CacheUtil.newFIFOCache(3);
        cache.put("1", "111", DateUnit.SECOND.getMillis() * 3);
        cache.put("2", "222", DateUnit.SECOND.getMillis() * 3);
        cache.put("3", "333", DateUnit.SECOND.getMillis() * 3);

        cache.put("4", "444", DateUnit.SECOND.getMillis() * 3);

        System.out.println(cache.get("1"));
    }

}
