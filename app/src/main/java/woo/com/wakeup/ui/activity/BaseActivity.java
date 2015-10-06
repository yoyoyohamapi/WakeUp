package woo.com.wakeup.ui.activity;

import android.app.Activity;

import woo.com.wakeup.App;
import woo.com.wakeup.AppComponent;
import woo.com.wakeup.ui.activity.module.ActivityModule;

/**
 * BaseActivity
 * Desc: Activity基类
 * Date: 2015/10/6
 * Time: 9:49
 * Created by: Wooxxx
 */
public abstract class BaseActivity extends Activity {

    /**
     * 获得AppComponent
     *
     * @return AppComponent
     */
    protected AppComponent getAppComponent() {
        return App.get(this).getAppComponent();
    }

    /**
     * 初始化当前Activity所需Component
     */
    protected abstract void setupActivityComponent();


    protected ActivityModule getActivityModule() {
        return new ActivityModule(this);
    }
}
