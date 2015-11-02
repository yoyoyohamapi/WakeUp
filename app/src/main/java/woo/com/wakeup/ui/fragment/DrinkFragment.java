package woo.com.wakeup.ui.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.Bind;
import butterknife.ButterKnife;
import woo.com.wakeup.R;
import woo.com.wakeup.ui.activity.adapter.DrinkAdapter;
import woo.com.wakeup.ui.menu.DrinkMenu;

/**
 * DrinkDetailsFragment
 * Desc: 茶饮细节Fragment
 * Team: InHand
 * User: Wooxxx
 * Date: 2015-10-30
 * Time: 18:46
 */
public class DrinkFragment extends Fragment {
    @Bind(R.id.drinkList)
    RecyclerView mDrinkList;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_drink, container, false);
        ButterKnife.bind(this, view);
        // 初始化列表
        // 获得饮品选项列表
        RecyclerView.LayoutManager lm = new LinearLayoutManager(this.getActivity());
        DrinkAdapter drinkAdapter = new DrinkAdapter(DrinkMenu.items, lm);
        mDrinkList.setLayoutManager(lm);
        mDrinkList.setAdapter(drinkAdapter);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
