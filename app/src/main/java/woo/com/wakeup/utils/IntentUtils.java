package woo.com.wakeup.utils;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

/**
 * IntentUtils
 * Desc: Intent工具类
 * Date: 2015/9/5
 * Time: 10:15
 * Created by: Wooxxx
 */
public class IntentUtils {
    public static final String KEY_SWITCH = "switch";

    /**
     * Activity切换
     *
     * @param src 当前Activity
     * @param dst 目标Activity
     */
    public static void switchTo(Activity src, Class<?> dst) {
        Intent intent = new Intent();
        intent.setClass(src, dst);
        src.startActivity(intent);
    }

    /**
     * 携带简单信息的Activity跳转
     *
     * @param src 跳转源
     * @param dst 跳转目的地
     * @param msg 简单消息
     */
    public static void switchTo(
            Activity src, Class<?> dst, String msg) {
        Intent intent = new Intent();
        intent.setClass(src, dst);
        Bundle bundle = new Bundle();
        bundle.putString(KEY_SWITCH, msg);
        intent.putExtras(bundle);
        src.startActivity(intent);
    }

    /**
     * 获得Intent装载的切换消息
     *
     * @param intent intent
     * @return 消息
     */
    public static String getSwitchMessage(Intent intent) {
        Bundle bundle = intent.getExtras();
        return bundle.getString(KEY_SWITCH);
    }

    /**
     * 携带信息的Service跳转
     *
     * @param src    跳转源
     * @param dst    跳转目的地
     * @param bundle 消息
     */
    public static void switchTo(Activity src, Class<?> dst, Bundle bundle) {
        Intent intent = new Intent();
        intent.setClass(src, dst);
        intent.putExtras(bundle);
        src.startService(intent);
    }

    /**
     * 获得Intent装载的复数切换消息
     *
     * @param intent intent
     * @return 消息
     */
    public static Bundle getSwitchMessages(Intent intent) {
        Bundle bundle = intent.getExtras();
        return bundle;
    }
}
