package woo.com.wakeup.model.entity;

import java.util.HashMap;
import java.util.Map;

/**
 * RECORD_DRINK
 * Desc: 早起记录---饮品
 * Team: InHand
 * User: Wooxxx
 * Date: 2015-10-26
 * Time: 19:53
 */
public final class RecordDrink {
    public static final int COFFEE = 0; //咖啡
    public static final int WATER = 1; //水
    public static final int TEA = 2; //茶

    public static Map<Integer,String> map;

    static {
        map = new HashMap<>();
        map.put(COFFEE,"咖啡");
        map.put(WATER, "水");
        map.put(TEA,"茶");
    }
}
