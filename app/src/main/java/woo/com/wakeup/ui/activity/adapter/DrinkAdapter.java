package woo.com.wakeup.ui.activity.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import woo.com.wakeup.R;
import woo.com.wakeup.ui.menu.DrinkItem;

/**
 * DrinkAdapter
 * Desc:
 * Team: InHand
 * User: Wooxxx
 * Date: 2015-10-30
 * Time: 21:49
 */
public class DrinkAdapter extends RecyclerView.Adapter<DrinkViewHolder> {
    private List<DrinkItem> mList;

    public DrinkAdapter(List<DrinkItem> list) {
        this.mList = list;
    }

    @Override
    public DrinkViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(
                R.layout.item_drink, viewGroup, false
        );
        return new DrinkViewHolder(view);

    }

    @Override
    public void onBindViewHolder(DrinkViewHolder drinkViewHolder, int i) {
        drinkViewHolder.mImage.setImageResource(mList.get(i).getImage());
        drinkViewHolder.mImageUnselected.setImageResource(mList.get(i).getImageUnselected());
        drinkViewHolder.mDesc.setText(mList.get(i).getDesc());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }


}
