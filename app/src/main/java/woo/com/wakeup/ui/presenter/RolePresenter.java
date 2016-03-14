package woo.com.wakeup.ui.presenter;

import woo.com.wakeup.ui.fragment.AbstractNewFragment;

/**
 * RolePresenter
 * Desc:
 * Team: InHand
 * User: Wooxxx
 * Date: 2015-12-01
 * Time: 20:10
 */
public class RolePresenter implements Presenter {
    private View mView;

    @Override
    public void initialize() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void pause() {

    }

    public void setView(View view) {
        mView = view;
    }

    public void refreshRole(int role){
        ((AbstractNewFragment) this.mView).getRecord().setRole(role);
    }
    public interface View {
        // 初始化pager
        void initPager();
        // 跳转到今日推荐
        void toTodayRecommend();
    }
}
