package woo.com.wakeup.ui.activity;

import android.app.Activity;
import android.os.Bundle;

import woo.com.wakeup.R;

/**
 * UITestActivity
 * Desc:
 * Team: InHand
 * User: Wooxxx
 * Date: 2015-10-30
 * Time: 17:18
 */
public class UITestActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_drink);
    }
}
