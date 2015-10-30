package woo.com.wakeup.utils;

import android.app.Activity;
import android.app.Fragment;

/**
 * FragmentUtils
 * Desc: Fragment工具类
 * Date: 2015/9/5
 * Time: 10:04
 * Created by: Wooxxx
 */
public class FragmentUtils {
    /**
     * 替换Fragment
     *
     * @param activity    fragment所在activity
     * @param containerId fragment容器
     * @param to          替换为
     */
    public static void replace(
            Activity activity,
            int containerId,
            Fragment to) {
        activity.getFragmentManager().beginTransaction()
                .replace(containerId, to).commit();
    }
}
