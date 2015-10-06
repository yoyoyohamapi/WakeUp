package woo.com.wakeup.ui.activity.module;

import android.app.Activity;

import dagger.Module;
import dagger.Provides;
import woo.com.wakeup.ui.activity.ActivityScope;

/**
 * ActivityModule
 * Desc:
 * Date: 2015/10/6
 * Time: 9:53
 * Created by: Wooxxx
 */
@Module
public class ActivityModule {
    private final Activity mActivity;

    public ActivityModule(Activity activity) {
        this.mActivity = activity;
    }

    @Provides
    @ActivityScope
    Activity activity() {
        return this.mActivity;
    }
}
