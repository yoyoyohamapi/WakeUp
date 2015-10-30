package woo.com.wakeup.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextClock;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import woo.com.wakeup.R;
import woo.com.wakeup.model.entity.IRecord;
import woo.com.wakeup.ui.activity.NewActivity;
import woo.com.wakeup.ui.activity.component.MainComponent;
import woo.com.wakeup.ui.presenter.HomePresenter;
import woo.com.wakeup.utils.DateUtils;
import woo.com.wakeup.utils.IntentUtils;

/**
 * HomeFragment
 * Desc: 主页Fragment
 * Team: InHand
 * User: Wooxxx
 * Date: 2015-10-22
 * Time: 09:41
 */
public class HomeFragment extends BaseFragment implements HomePresenter.View {

    private static final int HANDLE_MSG_REFRESH_STATUS = 0;
    @Inject
    HomePresenter mPresenter;

    @Bind(R.id.clock)
    TextClock mClock;

    @Bind(R.id.tvStatus)
    TextView mTvStatus;

    @Bind(R.id.lvRecords)
    ListView mLvRecords;

    @Bind(R.id.btnAdd)
    FloatingActionButton mBtnAdd;

    @Bind(R.id.viewRecords)
    LinearLayout mViewRecords;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_homepage, container, false);
        ButterKnife.bind(this, view);
        return view;
    }


    @Override
    protected void initialize() {
        // 初始化时注入依赖
        this.getComponent(MainComponent.class).inject(this);
        mPresenter.setView(this);
        mPresenter.initialize();
        // 初始化records
        List<Map<String, String>> records = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            Map<String, String> map = new HashMap<>();
            map.put("date", "2015/10/22");
            map.put("drink", "咖啡");
            map.put("activity", "饿死鬼");
            records.add(map);
        }
        SimpleAdapter simpleAdapter = new SimpleAdapter(
                this.getActivity(),
                records,
                R.layout.item_home_record,
                new String[]{"date", "drink", "activity"},
                new int[]{R.id.tvRecordDate, R.id.tvRecordDrink, R.id.tvRecordActivity}
        );
        mLvRecords.setAdapter(simpleAdapter);
        // 设置TextBlock
        mClock.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                refreshStatus();
            }
        });
    }

    @Override
    public void switchToAdd() {
        IntentUtils.switchTo(this.getActivity(), NewActivity.class);
    }

    @Override
    public void showRecords(List<IRecord> records) {

    }

    @Override
    public void refreshStatus() {
        // 利用线程监听状态变化
        Calendar now = Calendar.getInstance();
        String status = DateUtils.getStatus(now);
        // 刷新UI显示
        mTvStatus.setText(status);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
