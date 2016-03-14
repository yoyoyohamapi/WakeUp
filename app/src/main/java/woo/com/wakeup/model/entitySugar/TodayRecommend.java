package woo.com.wakeup.model.entitySugar;

import com.orm.SugarRecord;

import java.util.Date;

import woo.com.wakeup.model.entity.ITodayRecommend;

/**
 * TodayReccomend
 * Desc:
 * Team: InHand
 * User: Wooxxx
 * Date: 2015-10-26
 * Time: 19:43
 */
public class TodayRecommend extends SugarRecord<TodayRecommend>
        implements ITodayRecommend {
    private String artist;
    private String coverUrl;
    private String name;
    private Date createdAt, updatedAt;

    public TodayRecommend(){

    }

    public TodayRecommend(String artist, String coverUrl, String name) {
        this.artist = artist;
        this.coverUrl = coverUrl;
        this.name = name;
    }


    @Override
    public String getArtist() {
        return artist;
    }

    @Override
    public void setArtist(String artist) {
        this.artist = artist;
    }

    @Override
    public String getCoverUrl() {
        return coverUrl;
    }

    @Override
    public void setCoverUrl(String coverUrl) {
        this.coverUrl = coverUrl;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Date getCreatedAt() {
        return createdAt;
    }

    @Override
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public Date getUpdatedAt() {
        return updatedAt;
    }

    @Override
    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }


    @Override
    public void save(SaveCallback callback) {
        super.save();
    }
}
