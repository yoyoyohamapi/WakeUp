package woo.com.wakeup.model.dao;

import java.util.List;

import woo.com.wakeup.model.entity.IRecord;

/**
 * IRecordDao
 * Desc: 早起记录数据访问层
 * Team: InHand
 * User: Wooxxx
 * Date: 2015-12-03
 * Time: 20:33
 */
public interface IRecordDao extends IBaseDao {
    int LATEAST_LIMIT = 3;

    public List<?extends IRecord> findLatest();

    public void findLatest(final FindCallback<IRecord> callback);
}
