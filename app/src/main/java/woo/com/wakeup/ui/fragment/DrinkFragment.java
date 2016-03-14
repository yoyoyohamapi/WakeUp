package woo.com.wakeup.ui.fragment;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import woo.com.wakeup.R;
import woo.com.wakeup.ui.activity.adapter.DrinkAdapter;
import woo.com.wakeup.ui.activity.component.NewComponent;
import woo.com.wakeup.ui.menu.DrinkMenu;
import woo.com.wakeup.ui.presenter.DrinkPresenter;
import woo.com.wakeup.ui.widget.DrinkRecyclerView;

/**
 * DrinkDetailsFragment
 * Desc: 茶饮细节Fragment
 * Team: InHand
 * User: Wooxxx
 * Date: 2015-10-30
 * Time: 18:46
 */
public class DrinkFragment
        extends AbstractNewFragment implements DrinkPresenter.View {

    @Inject
    DrinkPresenter mPresenter;
    @Bind(R.id.drinkList)
    DrinkRecyclerView mDrinkList;
    @Bind(R.id.btnSelected)
    FloatingActionButton mBtnSelected;

    @OnClick(R.id.btnSelected)
    public void onClick() {
        // 获得选择项
        int drink = mDrinkList.getSelectedDrink();
        this.mPresenter.refreshDrink(drink);
        this.toRolePage();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_drink, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    protected void initialize() {
        // 初始化时注入依赖
        this.getComponent(NewComponent.class).inject(this);
        this.initDrinkList();
        this.mPresenter.setView(this);
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

    @Override
    public void initDrinkList() {
        // 获得饮品选项列表
        LinearLayoutManager lm = new LinearLayoutManager(this.getActivity());
        DrinkAdapter drinkAdapter = new DrinkAdapter(DrinkMenu.items, mDrinkList, mBtnSelected);
        mDrinkList.setLayoutManager(lm);
        mDrinkList.setAdapter(drinkAdapter);
    }

    @Override
    public void toRolePage() {
        // 跳转到活动页面
        FragmentTransaction ft = this.getFragmentManager().beginTransaction();
        // 首先隐藏当前页
        ft.hide(this);
        RoleFragment roleFragment = new RoleFragment();
        ft.add(R.id.main_container, roleFragment);
        ft.commit();
    }
}
