package woo.com.wakeup.ui.activity.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

import woo.com.wakeup.R;
import woo.com.wakeup.ui.menu.RoleItem;
import woo.com.wakeup.ui.menu.RoleMenu;

/**
 * RoleAdapter
 * Desc:
 * Team: InHand
 * User: Wooxxx
 * Date: 2015-11-11
 * Time: 11:01
 */
public class RoleAdapter extends PagerAdapter {
    // 角色列表
    private List<RoleItem> mMenu = RoleMenu.items;

    private Context mContext;

    public RoleAdapter(Context context) {
        this.mContext = context;
    }

    @Override
    public int getCount() {
        return mMenu.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == (View)object;
    }


    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        // 初始话角色图像
        ImageView imageView = new ImageView(mContext);
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        RoleItem role = mMenu.get(position);
        final int id = role.getId();
        imageView.setImageDrawable(mContext.getDrawable(role.getImage()));
        imageView.setId(id);
        imageView.setBackground(mContext.getDrawable(R.drawable.role_border));
        container.addView(imageView, position);
        return imageView;
    }

    public List<RoleItem> getMenu(){
        return this.mMenu;
    }

}
