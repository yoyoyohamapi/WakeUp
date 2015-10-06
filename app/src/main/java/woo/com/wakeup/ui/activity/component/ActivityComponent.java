package woo.com.wakeup.ui.activity.component;

import android.app.Activity;

import dagger.Component;
import woo.com.wakeup.AppComponent;
import woo.com.wakeup.ui.activity.ActivityScope;
import woo.com.wakeup.ui.activity.module.ActivityModule;

/**
 * ActivityComponent
 * Desc:
 * Date: 2015/10/6
 * Time: 9:53
 * Created by: Wooxxx
 */
@ActivityScope
@Component(
        dependencies = AppComponent.class,
        modules = ActivityModule.class
)
public interface ActivityComponent {
    Activity activity();
}
