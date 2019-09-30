package utils;

import java.util.HashMap;
import java.util.Map;

public class ResponseUtil {
    public static <K, V> Map<K, V> createSingleEntryMap(K key, V value) {
        Map<K, V> map = new HashMap<>();
        map.put(key, value);
        return map;
    }
}
