package woo.com.wakeup.ui.activity;

import android.os.Bundle;

import woo.com.wakeup.R;
import woo.com.wakeup.ui.activity.component.DaggerMainComponent;
import woo.com.wakeup.ui.activity.component.HasComponent;
import woo.com.wakeup.ui.activity.component.MainComponent;
import woo.com.wakeup.ui.activity.module.MainModule;
import woo.com.wakeup.ui.fragment.HomeFragment;
import woo.com.wakeup.utils.FragmentUtils;

/**
 * MainActivity
 * Desc:
 * Team: InHand
 * User: Wooxxx
 * Date: 2015-10-10
 * Time: 14:26
 */
public class MainActivity extends BaseActivity implements HasComponent<MainComponent> {
    private MainComponent mMainComponent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // 默认为HomepageFragment
        FragmentUtils.replace(this, R.id.main_container,
                new HomeFragment());
    }

    @Override
    protected void setupActivityComponent() {
        mMainComponent = DaggerMainComponent.builder()
                .appComponent(getAppComponent())
                .activityModule(getActivityModule())
                .mainModule(new MainModule())
                .build();
    }


    @Override
    public MainComponent getComponent() {
        return mMainComponent;
    }
}
