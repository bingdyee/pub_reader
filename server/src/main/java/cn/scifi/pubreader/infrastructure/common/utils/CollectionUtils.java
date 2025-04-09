package cn.scifi.novelogic.infrastructure.common.utils;

import java.util.Collection;
import java.util.Map;

/**
 * 集合工具
 *
 * @author Bing D. Yee
 * @since 2021/04/07
 */
public final class CollectionUtils {

    private CollectionUtils() {
    }

    public static boolean isEmpty(Collection<?> coll) {
        return (coll == null || coll.isEmpty());
    }

    public static boolean isNotEmpty(Collection<?> coll) {
        return !CollectionUtils.isEmpty(coll);
    }

    public static boolean isEmpty(Map<?, ?> map) {
        return map == null || map.isEmpty();
    }

}
