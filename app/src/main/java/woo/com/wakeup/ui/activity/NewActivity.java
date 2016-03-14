package woo.com.wakeup.ui.activity;

import android.os.Bundle;

import javax.inject.Inject;

import woo.com.wakeup.R;
import woo.com.wakeup.model.entity.IRecord;
import woo.com.wakeup.ui.activity.component.DaggerNewComponent;
import woo.com.wakeup.ui.activity.component.HasComponent;
import woo.com.wakeup.ui.activity.component.NewComponent;
import woo.com.wakeup.ui.activity.module.NewModule;
import woo.com.wakeup.ui.fragment.DrinkFragment;
import woo.com.wakeup.utils.FragmentUtils;

/**
 * NewActivity
 * Desc: 创建早起记录Activity
 * Team: InHand
 * User: Wooxxx
 * Date: 2015-10-22
 * Time: 21:07
 */
public class NewActivity extends BaseActivity implements HasComponent<NewComponent> {

    @Inject
    IRecord mRecord;

    private NewComponent mNewComponent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);
        FragmentUtils.replace(this, R.id.main_container,
                new DrinkFragment());
    }

    @Override
    protected void setupActivityComponent() {
        mNewComponent = DaggerNewComponent.builder()
                .appComponent(this.getAppComponent())
                .activityModule(this.getActivityModule())
                .newModule(new NewModule()).build();

        mNewComponent.inject(this);
    }

    public IRecord getRecord() {
        return mRecord;
    }

    @Override
    public NewComponent getComponent() {
        return mNewComponent;
    }
}
