package woo.com.wakeup.ui.activity.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import woo.com.wakeup.R;
import woo.com.wakeup.ui.widget.TextView;

/**
 * DrinkParentViewHolder
 * Desc: 饮品一级菜单Holder
 * Team: InHand
 * User: Wooxxx
 * Date: 2015-10-30
 * Time: 21:52
 */
public class DrinkViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    public ImageView mImage, mImageUnselected;
    public TextView mDesc;

    public DrinkViewHolder(View itemView) {
        super(itemView);
        mImage = (ImageView) itemView.findViewById(R.id.ivSelected);
        mImageUnselected = (ImageView) itemView.findViewById(R.id.ivUnselected);
        mDesc = (TextView) itemView.findViewById(R.id.tvDesc);
        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

    }
}
