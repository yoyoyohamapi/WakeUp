package woo.com.wakeup.ui.activity.component;

import dagger.Component;
import woo.com.wakeup.AppComponent;
import woo.com.wakeup.ui.activity.ActivityScope;
import woo.com.wakeup.ui.activity.NewActivity;
import woo.com.wakeup.ui.activity.module.ActivityModule;
import woo.com.wakeup.ui.activity.module.NewModule;
import woo.com.wakeup.ui.fragment.CompleteFragment;
import woo.com.wakeup.ui.fragment.DrinkFragment;
import woo.com.wakeup.ui.fragment.RecommendFragment;
import woo.com.wakeup.ui.fragment.RoleFragment;

/**
 * NewComponent
 * Desc:
 * Team: InHand
 * User: Wooxxx
 * Date: 2015-12-01
 * Time: 20:04
 */
@ActivityScope
@Component(
        dependencies = AppComponent.class,
        modules = {NewModule.class, ActivityModule.class}
)
public interface NewComponent {
    void inject(DrinkFragment drinkFragment);
    void inject(RoleFragment roleFragment);
    void inject(RecommendFragment recommendFragment);
    void inject(CompleteFragment completeFragment);
    void inject(NewActivity newActivity);
}
