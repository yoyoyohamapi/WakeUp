package woo.com.wakeup.ui.activity.adapter;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;

import java.util.List;

import woo.com.wakeup.R;
import woo.com.wakeup.ui.menu.DrinkItem;
import woo.com.wakeup.ui.widget.DrinkRecyclerView;

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

    private DrinkRecyclerView mRecyclerView;

    private FloatingActionButton mBtnSelected;

    private final static int ANIMATION_DURATION = 500;


    public DrinkAdapter(List<DrinkItem> list, DrinkRecyclerView recyclerView,
                        FloatingActionButton button) {
        this.mList = list;
        mRecyclerView = recyclerView;
        mBtnSelected = button;
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
        // 折叠之前的
        drinkViewHolder.mImage.setVisibility(View.INVISIBLE);
        drinkViewHolder.mImage.setImageResource(item.getImage());
        drinkViewHolder.mImageUnselected.setVisibility(View.VISIBLE);
        drinkViewHolder.mImageUnselected.setImageResource(item.getImageUnselected());
        drinkViewHolder.mDesc.setVisibility(View.GONE);
        drinkViewHolder.mDesc.setText(item.getDesc());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    // 切换选择函数
    public void toggleSelection(View clickedView, final int pos) {
        final View tvDesc = clickedView.findViewById(R.id.tvDesc);
        final ImageView ivSelected = (ImageView) clickedView.findViewById(R.id.ivSelected);

        if (mSelectedPos == pos) {
            if (tvDesc.getVisibility() == View.GONE) {
                // 如果本次不是取消选中
                final android.view.animation.Animation animation = new AlphaAnimation(0f, 1.0f);
                animation.setDuration(ANIMATION_DURATION);
                animation.setFillAfter(true);
                animation.setAnimationListener(new android.view.animation.Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(android.view.animation.Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(android.view.animation.Animation animation) {
                        tvDesc.setVisibility(View.VISIBLE);
                        // 显示选中按钮
                        mBtnSelected.setVisibility(View.VISIBLE);

                    }

                    @Override
                    public void onAnimationRepeat(android.view.animation.Animation animation) {

                    }
                });
                ivSelected.startAnimation(animation);
            } else {
                // 若为取消选中
                notifyItemChanged(mSelectedPos);
                // 隐藏选中按钮
                mBtnSelected.setVisibility(View.GONE);
            }
        } else {
            // 如果本次不是取消选中
            final android.view.animation.Animation animation = new AlphaAnimation(0.0f, 1.0f);
            animation.setDuration(ANIMATION_DURATION);
            animation.setFillAfter(true);
            animation.setAnimationListener(new android.view.animation.Animation.AnimationListener() {
                @Override
                public void onAnimationStart(android.view.animation.Animation animation) {
                    notifyItemChanged(mSelectedPos);
                    tvDesc.setVisibility(View.VISIBLE);
                    // 显示选中按钮
                    mBtnSelected.setVisibility(View.VISIBLE);
                }

                @Override
                public void onAnimationEnd(android.view.animation.Animation animation) {
                    // 刷新选中位置
                    mSelectedPos = pos;
                    mRecyclerView.smoothScrollToPosition(pos);
                }

                @Override
                public void onAnimationRepeat(android.view.animation.Animation animation) {

                }
            });
            ivSelected.startAnimation(animation);
        }

    }

    /**
     * 返回当前选中位置
     * @return
     */
    public int getSelected() {
        return mList.get(mSelectedPos).getId();
    }
}
