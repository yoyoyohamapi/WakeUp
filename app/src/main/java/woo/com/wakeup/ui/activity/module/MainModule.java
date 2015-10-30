package woo.com.wakeup.ui.activity.module;

import dagger.Module;
import dagger.Provides;
import woo.com.wakeup.ui.activity.ActivityScope;
import woo.com.wakeup.ui.presenter.HomePresenter;

/**
 * MainModule
 * Desc: 主窗口Module
 * Team: InHand
 * User: Wooxxx
 * Date: 2015-10-22
 * Time: 11:37
 */
@Module
public class MainModule {
    public MainModule() {

    }

    @Provides
    @ActivityScope
    HomePresenter providesHomePresenter() {
        return new HomePresenter();
    }
}
