package woo.com.wakeup.utils;

import java.util.Calendar;

/**
 * DateUtils
 * Desc:
 * Team: InHand
 * User: Wooxxx
 * Date: 2015-10-07
 * Time: 14:59
 */
public class DateUtils {

    // 季节
    public static final int SEASON_SPRING = 0;
    public static final int SEASON_SUMMER = 1;
    public static final int SEASON_AUTUM = 2;
    public static final int SEASON_WINTER = 3;

    public static int getSeason(Calendar calendar) {
        int month = calendar.get(Calendar.MONTH) + 1;
        switch (month) {
            case 1:
            case 11:
            case 12:
                return SEASON_SPRING;
            case 2:
            case 3:
            case 4:
                return SEASON_SUMMER;
            case 5:
            case 6:
            case 7:
                return SEASON_AUTUM;
            case 8:
            case 9:
            case 10:
                return SEASON_WINTER;
        }
        return SEASON_SPRING;
    }
}
