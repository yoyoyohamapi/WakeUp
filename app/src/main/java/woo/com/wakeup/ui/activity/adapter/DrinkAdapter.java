package woo.com.wakeup.ui.activity.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.easyandroidanimations.library.FadeInAnimation;
import com.easyandroidanimations.library.FadeOutAnimation;

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

    // 饮品列表
    private List<DrinkItem> mList;

    // 选中位置
    private int mSelectedPos = -1;

    private RecyclerView.LayoutManager mLayoutManager;


    public DrinkAdapter(List<DrinkItem> list, RecyclerView.LayoutManager layoutManager) {
        this.mList = list;
        mLayoutManager = layoutManager;
    }

    @Override
    public DrinkViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(
                R.layout.item_drink, viewGroup, false
        );
        return new DrinkViewHolder(view) {
            @Override
            public void onClick(View v) {
                super.onClick(v);
                toggleSelection(v, getLayoutPosition());
            }
        };

    }

    @Override
    public void onBindViewHolder(final DrinkViewHolder drinkViewHolder, int i) {
        DrinkItem item = mList.get(i);
        drinkViewHolder.mImage.setImageResource(item.getImage());
        drinkViewHolder.mImageUnselected.setImageResource(item.getImageUnselected());
        drinkViewHolder.mDesc.setText(item.getDesc());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    // 切换选择函数
    public void toggleSelection(View clickedView, int pos) {
        View tvDesc = clickedView.findViewById(R.id.tvDesc);
        View ivSelected = clickedView.findViewById(R.id.ivSelected);
        View selectedView = mLayoutManager.getChildAt(mSelectedPos);
        // 先取消之前选中的
//        if( mSelectedPos>=0 && mSelectedPos<getItemCount()) {
//            Log.d("Opr ","1");
//            new FadeOutAnimation(selectedView.findViewById(R.id.ivSelected)).animate();
//            selectedView.findViewById(R.id.tvDesc).setVisibility(View.GONE);
//        }
        if (mSelectedPos == pos) {
            if (tvDesc.getVisibility() == View.GONE) {
                // 如果本次不是取消选中
                new FadeInAnimation(ivSelected).animate();
                tvDesc.setVisibility(View.VISIBLE);
            } else {
                new FadeOutAnimation(ivSelected).animate();
                tvDesc.setVisibility(View.GONE);
            }
        } else {
            notifyItemChanged(mSelectedPos);
            new FadeInAnimation(ivSelected).animate();
            tvDesc.setVisibility(View.VISIBLE);
        }


        // 刷新选中位置
        mSelectedPos = pos;
        mLayoutManager.scrollToPosition(mSelectedPos);

    }

    //

}
