package woo.com.wakeup.ui.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import woo.com.wakeup.R;

/**
 * DrinkDetailsFragment
 * Desc: 茶饮细节Fragment
 * Team: InHand
 * User: Wooxxx
 * Date: 2015-10-30
 * Time: 18:46
 */
public class DrinkFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_drink, container, false);
        ButterKnife.bind(view);
        ////// TODO: 15/10/30 初始化饮品菜单 
        return view;
    }

}
