package woo.com.wakeup.utils;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;


/**
 * NeteaseUtils
 * Desc: 网易API工具类
 * Team: InHand
 * User: Wooxxx
 * Date: 2015-10-10
 * Time: 10:35
 */
public class TodayRecommendUtils {
    public static final String URL_TODAY_SONG = "http://www.xiami.com/musician/get-musician-daily-song";

    /**
     * 获得今日推荐
     *
     * @param context 上下文环境
     */
    public static void getTodayRecommend(Context context, final TodayRecommendSuccessCallback successCallback,
                                         final TodayRecommendFailCallback failCallback) {
        final RequestQueue reqQueue = Volley.newRequestQueue(context);
        JsonObjectRequest jsonReq = new JsonObjectRequest(Request.Method.GET, URL_TODAY_SONG, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {
                try {
                    // 解析今日推荐参数 ---> 专辑封面，歌曲名，演唱者
                    JSONObject today = response.getJSONObject("data").getJSONObject("song");
                    String songCover = today.getString("show_logo").replace(".jpg", "_4.jpg");
                    String songName = today.getString("song_name");
                    String songArtist = today.getString("artist_name");
                    successCallback.done(songCover, songName, songArtist);
                } catch (JSONException e) {
                    e.printStackTrace();
                    failCallback.done();
                }

            }

        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
                failCallback.done();
            }
        });

        reqQueue.add(jsonReq);
    }



}
