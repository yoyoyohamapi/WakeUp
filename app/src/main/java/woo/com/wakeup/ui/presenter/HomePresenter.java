package woo.com.wakeup.ui.presenter;

import java.util.List;

import javax.inject.Inject;

import woo.com.wakeup.model.dao.IBaseDao;
import woo.com.wakeup.model.dao.IRecordDao;
import woo.com.wakeup.model.entity.IRecord;
import woo.com.wakeup.ui.fragment.BaseFragment;

/**
 * HomePresenter
 * Desc:
 * Team: InHand
 * User: Wooxxx
 * Date: 2015-10-22
 * Time: 10:00
 */
public class HomePresenter implements Presenter {

    private View mView;

    @Inject
    IRecordDao mRecordDao;

    @Override
    public void initialize() {
        // 注入依赖
        ((BaseFragment)mView).getAppComponent().inject(this);
        // 获得最近早起记录
        mRecordDao.findLatest(new IBaseDao.FindCallback<IRecord>() {
            @Override
            public void done(List<IRecord> results, Exception e) {
                mView.showRecords(results);
            }
        });
    }

    @Override
    public void resume() {

    }

    @Override
    public void pause() {

    }

    public void setView(View view) {
        this.mView = view;
    }

    public interface View {
        /**
         * 跳转到创建“早起记录页面”
         */
        void switchToAdd();

        /**
         * 显示最近早起记录
         *
         * @param records
         */
        void showRecords(List<IRecord> records);

        void refreshStatus();

        /**
         * 显示添加按钮
         */
        void showBtnAdd();

    }
}
