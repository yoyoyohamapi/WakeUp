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
public interface IRecord<C extends ITodayRecommend> extends IBase {

    String KEY_DATE = "date";
    String KEY_DRINK = "drink";
    String KEY_ROLE = "role";
    String KEY_TODAY_RECOMMEND = "todayRecommend";
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
    int getRole();

    void setRole(int role);

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
