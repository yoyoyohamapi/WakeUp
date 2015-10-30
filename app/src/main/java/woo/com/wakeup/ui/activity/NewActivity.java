package woo.com.wakeup.ui.activity;

import android.app.Activity;
import android.os.Bundle;

import woo.com.wakeup.R;
import woo.com.wakeup.utils.FragmentUtils;

/**
 * NewActivity
 * Desc: 创建早起记录Activity
 * Team: InHand
 * User: Wooxxx
 * Date: 2015-10-22
 * Time: 21:07
 */
public class NewActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);
        // 默认为HomepageFragment
        FragmentUtils.replace(this, R.id.main_container,
                new DrinkOptionFragment());
    }
}
