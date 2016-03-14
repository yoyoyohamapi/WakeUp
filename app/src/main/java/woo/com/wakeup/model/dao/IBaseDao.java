package woo.com.wakeup.model.dao;

import java.util.List;

import woo.com.wakeup.model.entity.IBase;

/**
 * IBaseDao
 * Desc:
 * Team: InHand
 * User: Wooxxx
 * Date: 2015-12-03
 * Time: 20:34
 */
public interface IBaseDao<C extends IBase> {

    /**
     * 获得所有记录
     * @param orderBy 排序字段
     * @param asc 是否正序
     * @return 记录列表
     */
    public List<C> findAll(String orderBy, boolean asc);


    /**
     * 异步获得所有记录
     * @param orderBy 排序字段
     * @param asc 是否正序
     * @param callback 回调接口
     */
    public void findAll(String orderBy, boolean asc, final FindCallback callback);

    /**
     * 根据Id获得记录
     * @param id id
     * @return 记录
     */
    public C getById(String id);

    /**
     * 异步地根据Id获得记录
     * @param id id
     * @param callback 回调接口
     */
    public void getById(String id, final GetCallback callback);

    /**
     * 批量查询回调接口
     */
    interface FindCallback<C extends IBase> {
        void done(List<C> results,Exception e);
    }

    /**
     * 单个查询回调接口
     */
    interface GetCallback<C extends IBase> {
        void done(List<C> result,Exception e);
    }

}
