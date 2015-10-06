package woo.com.wakeup.ui.activity.module;

import dagger.Module;
import dagger.Provides;
import woo.com.wakeup.ui.activity.ActivityScope;
import woo.com.wakeup.ui.presenter.SplashPresenter;

/**
 * SplashModule
 * Desc:
 * Date: 2015/10/6
 * Time: 9:56
 * Created by: Wooxxx
 */
@Module
public class SplashModule {
    public SplashModule() {

    }

    @Provides
    @ActivityScope
    SplashPresenter providesSplashPresenter() {
        return new SplashPresenter();
    }
}
