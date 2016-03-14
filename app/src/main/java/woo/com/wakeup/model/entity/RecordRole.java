package woo.com.wakeup.model.entity;

import java.util.HashMap;
import java.util.Map;

/**
 * Desc: 早期记录--角色
 * Team: InHand
 * User: Wooxxx
 * Date: 2015-10-26
 * Time: 19:54
 */
public final class RecordRole {
    public static final int HUNGRY = 0;
    public static final int SPORTS = 1;
    public static final int LEARNING = 2;

    public static final Map<Integer,String> map;

    static {
        map = new HashMap<>();
        map.put(HUNGRY,"饿死鬼");
        map.put(SPORTS,"牛头");
        map.put(LEARNING,"科场鬼");
    }

}
