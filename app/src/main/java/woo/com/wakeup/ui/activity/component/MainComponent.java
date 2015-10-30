package woo.com.wakeup.ui.activity.component;

import dagger.Component;
import woo.com.wakeup.AppComponent;
import woo.com.wakeup.ui.activity.ActivityScope;
import woo.com.wakeup.ui.activity.module.ActivityModule;
import woo.com.wakeup.ui.activity.module.MainModule;
import woo.com.wakeup.ui.fragment.HomeFragment;

/**
 * MainComponent
 * Desc:
 * Team: InHand
 * User: Wooxxx
 * Date: 2015-10-22
 * Time: 10:00
 */
@ActivityScope
@Component(
        dependencies = AppComponent.class,
        modules = {MainModule.class, ActivityModule.class}
)
public interface MainComponent {
    void inject(HomeFragment homeFragment);
}
