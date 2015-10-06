package woo.com.wakeup.ui.activity.component;

import dagger.Component;
import woo.com.wakeup.AppComponent;
import woo.com.wakeup.ui.activity.ActivityScope;
import woo.com.wakeup.ui.activity.module.ActivityModule;
import woo.com.wakeup.ui.activity.module.SplashModule;
import woo.com.wakeup.ui.fragment.SplashFragment;

/**
 * SplashComponent
 * Desc:
 * Date: 2015/10/6
 * Time: 9:57
 * Created by: Wooxxx
 */
@ActivityScope
@Component(
        dependencies = AppComponent.class,
        modules = {SplashModule.class, ActivityModule.class}
)
public interface SplashComponent {
    void inject(SplashFragment splashFragment);
}
