package woo.com.wakeup.ui.activity;

import android.os.Bundle;

import woo.com.wakeup.R;
import woo.com.wakeup.ui.activity.component.DaggerSplashComponent;
import woo.com.wakeup.ui.activity.component.HasComponent;
import woo.com.wakeup.ui.activity.component.SplashComponent;
import woo.com.wakeup.ui.activity.module.SplashModule;

/**
 * SplashActivity
 * Desc: 启动Activity
 * Date: 2015/10/6
 * Time: 9:36
 * Created by: Wooxxx
 */
public class SplashActivity extends BaseActivity
        implements HasComponent<SplashComponent> {
    private SplashComponent mSplashComponent;

    @Override
    protected void setupActivityComponent() {
        mSplashComponent = DaggerSplashComponent.builder()
                .appComponent(this.getAppComponent())
                .activityModule(this.getActivityModule())
                .splashModule(new SplashModule())
                .build();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
    }

    @Override
    public SplashComponent getComponent() {
        return mSplashComponent;
    }
}
