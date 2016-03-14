package woo.com.wakeup.ui.activity.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.text.SimpleDateFormat;
import java.util.List;

import woo.com.wakeup.R;
import woo.com.wakeup.model.entity.IRecord;
import woo.com.wakeup.model.entity.RecordDrink;
import woo.com.wakeup.model.entity.RecordRole;
import woo.com.wakeup.ui.widget.TextView;

/**
 * RecordAdapter
 * Desc:
 * Team: InHand
 * User: Wooxxx
 * Date: 2015-12-04
 * Time: 09:15
 */
public class RecordAdapter extends BaseAdapter {
    private List<IRecord> mRecords;
    private LayoutInflater mInfater;

    public RecordAdapter(List<IRecord> records, LayoutInflater inflater){
        mRecords = records;
        mInfater = inflater;
    }

    @Override
    public int getCount() {
        return mRecords.size();
    }

    @Override
    public IRecord getItem(int i) {
        return mRecords.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if(view == null ){
            // 建立缓存
            holder = new ViewHolder();
            view = mInfater.inflate(R.layout.item_home_record, null);
            holder.tvDate = (TextView) view.findViewById(R.id.tvRecordDate);
            holder.tvDrink = (TextView) view.findViewById(R.id.tvRecordDrink);
            holder.tvRole = (TextView) view.findViewById(R.id.tvRecordRole);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        // 从Holder取得元素
        IRecord record = mRecords.get(i);
        SimpleDateFormat sdf=new SimpleDateFormat("HH时mm分");
        holder.tvDate.setText(sdf.format(record.getDate()));
        holder.tvDrink.setText(RecordDrink.map.get(record.getDrink()));
        holder.tvRole.setText(RecordRole.map.get(record.getRole()));
        return view;
    }

    static class ViewHolder{
        public TextView tvDate;
        public TextView tvDrink;
        public TextView tvRole;
    }
}
