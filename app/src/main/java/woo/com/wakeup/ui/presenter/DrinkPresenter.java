package woo.com.wakeup.ui.presenter;

import woo.com.wakeup.ui.fragment.AbstractNewFragment;

/**
 * DrinkPresenter
 * Desc:
 * Team: InHand
 * User: Wooxxx
 * Date: 2015-12-01
 * Time: 19:10
 */
public class DrinkPresenter implements Presenter {

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

    /**
     * 刷新记录 饮品
     *
     * @param drink 饮品ID
     */
    public void refreshDrink(int drink) {
        ((AbstractNewFragment) this.mView).getRecord().setDrink(drink);
    }

    public interface View {
        // 初始化列表
        void initDrinkList();

        // 跳转到选择角色
        void toRolePage();
    }
}
