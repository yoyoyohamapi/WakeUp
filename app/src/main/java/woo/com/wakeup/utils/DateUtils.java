package woo.com.wakeup.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

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
    public static final int SEASON_AUTUMN = 2;
    public static final int SEASON_WINTER = 3;

    private static Calendar c000 = Calendar.getInstance();

    // 早上六点
    private static Calendar c600 = Calendar.getInstance();


    // 早上六点半
    private static Calendar c630 = Calendar.getInstance();


    // 早上七点半
    private static Calendar c730 = Calendar.getInstance();

    // 早上八点半
    private static Calendar c830 = Calendar.getInstance();


    // 早上九点半
    private static Calendar c930 = Calendar.getInstance();


    // 早上十点
    private static Calendar c1000 = Calendar.getInstance();


    static {
        c000.set(Calendar.HOUR_OF_DAY, 0);
        c000.set(Calendar.MINUTE, 0);
        c000.set(Calendar.SECOND, 0);

        c600.set(Calendar.HOUR_OF_DAY, 6);
        c600.set(Calendar.MINUTE, 0);
        c600.set(Calendar.SECOND, 0);

        c630.set(Calendar.HOUR_OF_DAY, 6);
        c630.set(Calendar.MINUTE, 30);
        c630.set(Calendar.SECOND, 0);

        c730.set(Calendar.HOUR_OF_DAY, 7);
        c730.set(Calendar.MINUTE, 30);
        c730.set(Calendar.SECOND, 0);

        c830.set(Calendar.HOUR_OF_DAY, 8);
        c830.set(Calendar.MINUTE, 30);
        c830.set(Calendar.SECOND, 0);

        c930.set(Calendar.HOUR_OF_DAY, 9);
        c930.set(Calendar.MINUTE, 30);
        c930.set(Calendar.SECOND, 0);

        c1000.set(Calendar.HOUR_OF_DAY, 10);
        c1000.set(Calendar.MINUTE, 00);
        c1000.set(Calendar.SECOND, 0);
    }

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
                return SEASON_AUTUMN;
            case 8:
            case 9:
            case 10:
                return SEASON_WINTER;
        }
        return SEASON_SPRING;
    }

    public static String getStatus(Calendar now) {
        if (now.after(c000) && now.before(c600))
            return "通宵达旦";
        if (now.after(c600) && now.before(c630))
            return "东方欲晓";
        if (now.after(c630) && now.before(c730))
            return "晨光熹微";
        if (now.after(c730) && now.before(c830))
            return "霞光万道";
        if (now.after(c830) && now.before(c930))
            return "勉为其难";
        if (now.after(c930) && now.before(c1000))
            return "心慵意懒";
        return "无可救药";
    }

    public static boolean isToday(Date date){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.CHINA);
        return sdf.format(date).equals(sdf.format(new Date()));
    }
}
