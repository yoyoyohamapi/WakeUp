package woo.com.wakeup.model.entity;

import java.util.Date;

/**
 * IBase
 * Desc: 基础实体接口
 * Team: InHand
 * User: Wooxxx
 * Date: 2015-10-22
 * Time: 14:46
 */
public interface IBase {

    /**
     * 获得创建日期
     *
     * @return 创建日期
     */
    Date getCreatedAt();

    void setCreatedAt(Date createdAt);

    /**
     * 获得更新日期
     *
     * @return 更新日期
     */
    Date getUpdatedAt();

    void setUpdatedAt(Date updatedAt);

    void save() throws Exception;

    void save(final SaveCallback callback);

    /**
     * 本地存储回调接口
     */
    interface SaveCallback<E extends Exception> {
        void pre();

        void done(E e);
    }


}
