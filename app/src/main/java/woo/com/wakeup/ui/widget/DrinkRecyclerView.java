package woo.com.wakeup.ui.widget;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;

import woo.com.wakeup.ui.activity.adapter.DrinkAdapter;

/**
 * DrinkRecyclerView
 * Desc:
 * Team: InHand
 * User: Wooxxx
 * Date: 2015-11-03
 * Time: 09:31
 */
public class DrinkRecyclerView extends RecyclerView {
    public DrinkRecyclerView(Context context) {
        super(context);
    }

    public DrinkRecyclerView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public DrinkRecyclerView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }
    @Override
    public boolean fling(int velocityX, int velocityY) {

        velocityY *= 0.7;

        return super.fling(velocityX, velocityY);
    }

    /**
     * 获得选中的饮品
     * @return 选中的饮品
     */
    public int getSelectedDrink(){
        return ((DrinkAdapter)this.getAdapter()).getSelected();
    }

}
