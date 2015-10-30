package woo.com.wakeup.ui.presenter;

import java.util.List;

import woo.com.wakeup.model.entity.IRecord;

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

    @Override
    public void initialize() {
        //TODO:: presenter初始化时获取最近五天的早起记录
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
    }
}
