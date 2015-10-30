package woo.com.wakeup.model.entity;

/**
 * ITodayRecommend
 * Desc: 今日推荐
 * Team: InHand
 * User: Wooxxx
 * Date: 2015-10-26
 * Time: 08:50
 */
public interface ITodayRecommend extends IBase {

    /**
     * 歌手
     *
     * @return
     */
    String getArtist();

    void setArtist(String artist);

    /**
     * 专辑封面地址
     *
     * @return
     */
    String getCoverUrl();

    void setCoverUrl(String coverUrl);

    /**
     * 歌曲
     *
     * @return
     */
    String getName();

    void setName(String name);
}
