package woo.com.wakeup.utils;

/**
 * TodayRecommendSuccessCallback
 * Desc: 今日推荐回调接口
 * Team: InHand
 * User: Wooxxx
 * Date: 2015-10-12
 * Time: 15:42
 */
public interface TodayRecommendSuccessCallback {
    // 成功获得今日推荐时推荐
    void done(String cover, String songName, String artist);
}
