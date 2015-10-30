package woo.com.wakeup.ui.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import java.util.Date;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import woo.com.wakeup.R;
import woo.com.wakeup.model.entitySugar.Record;

/**
 * StorageActivity
 * Desc:
 * Team: InHand
 * User: Wooxxx
 * Date: 2015-10-26
 * Time: 11:11
 */
public class StorageActivity extends Activity {
    @Bind(R.id.btnSave)
    Button mBtnSave;

    @Bind(R.id.btnLoad)
    Button mBtnLoad;
    @Bind(R.id.tvDrink)
    TextView mTvDrink;

    @OnClick(R.id.btnSave)
    public void testSave() {
        Record record = new Record();
        record.setActivity(2);
        record.setDate(new Date());
        record.setCreatedAt(new Date());
        record.setUpdatedAt(new Date());
        record.setDrink(3);
        record.save();
        Record record1 = Record.findById(Record.class, (long) 1);
        mTvDrink.setText(String.valueOf(record1.getDrink()));
    }

    @OnClick(R.id.btnLoad)
    public void testLoad() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_storage);
        ButterKnife.bind(this);
    }
}
