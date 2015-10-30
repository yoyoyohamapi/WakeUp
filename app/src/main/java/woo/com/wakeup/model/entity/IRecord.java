package woo.com.wakeup.model.entity;

import java.util.Date;

/**
 * IRecord
 * Desc: 每日记录接口
 * Team: InHand
 * User: Wooxxx
 * Date: 2015-10-22
 * Time: 14:43
 */
// TODO: 15/10/22 记录接口设计
public interface IRecord<C extends ITodayRecommend> extends IBase {

    /**
     * 茶饮
     *
     * @return
     */
    int getDrink();

    void setDrink(int drink);

    /**
     * 今日活动
     *
     * @return
     */
    int getActivity();

    void setActivity(int activity);

    /**
     * 今日推荐
     *
     * @return
     */
    C getTodayRecommend();

    void setTodayRecommend(C todayRecommend);

    /**
     * 早起日期
     *
     * @return
     */
    Date getDate();

    void setDate(Date date);
}
