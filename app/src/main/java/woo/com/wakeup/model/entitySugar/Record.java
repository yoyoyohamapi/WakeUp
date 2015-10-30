package woo.com.wakeup.model.entitySugar;

import com.orm.SugarRecord;

import java.util.Date;

import woo.com.wakeup.model.entity.IRecord;

/**
 * Record
 * Desc:
 * Team: InHand
 * User: Wooxxx
 * Date: 2015-10-26
 * Time: 19:49
 */
public class Record extends SugarRecord<Record>
        implements IRecord<TodayRecommend> {
    private TodayRecommend todayRecommend;
    private Date date;
    private Date createdAt, updatedAt;
    private int drink;
    private int activity;

    public Record() {
    }

    @Override
    public TodayRecommend getTodayRecommend() {
        return todayRecommend;
    }

    @Override
    public void setTodayRecommend(TodayRecommend todayRecommend) {
        this.todayRecommend = todayRecommend;
    }

    @Override
    public Date getDate() {
        return date;
    }

    @Override
    public void setDate(Date date) {
        this.date = date;
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
    public int getDrink() {
        return drink;
    }

    @Override
    public void setDrink(int drink) {
        this.drink = drink;
    }

    @Override
    public int getActivity() {
        return activity;
    }

    @Override
    public void setActivity(int activity) {
        this.activity = activity;
    }

    @Override
    public void save(final SaveCallback callback) {
        SaveTask saveTask = new SaveTask(callback) {
            @Override
            protected Void doInBackground(Void... voids) {
                Record.super.save();
                return null;
            }
        };
        saveTask.execute();
    }

}
