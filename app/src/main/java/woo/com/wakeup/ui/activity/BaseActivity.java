package woo.com.wakeup.ui.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

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
public abstract class BaseActivity extends FragmentActivity {

    protected AppComponent getAppComponent() {
        return App.get(this).getAppComponent();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupActivityComponent();
    }

    protected abstract void setupActivityComponent();

    protected ActivityModule getActivityModule() {
        return new ActivityModule(this);
    }

}