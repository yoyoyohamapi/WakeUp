package woo.com.wakeup.ui.fragment;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import woo.com.wakeup.R;
import woo.com.wakeup.ui.activity.adapter.RoleAdapter;
import woo.com.wakeup.ui.activity.component.NewComponent;
import woo.com.wakeup.ui.presenter.RolePresenter;

/**
 * RoleFragment
 * Desc: 角色Fragment
 * Team: InHand
 * User: Wooxxx
 * Date: 2015-11-11
 * Time: 10:28
 */
public class RoleFragment extends AbstractNewFragment implements RolePresenter.View{
    @Inject
    RolePresenter mPresenter;

    @Bind(R.id.viewPager)
    ViewPager mViewPager;

    private RoleAdapter mRoleAdapter = null;

    @OnClick(R.id.btnSelected)
    public void onRoleSelected(){
        this.toTodayRecommend();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_role, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @Override
    protected void initialize() {
        this.getComponent(NewComponent.class).inject(this);
        this.mPresenter.setView(this);
        this.initPager();
    }

    @Override
    public void initPager() {
        mRoleAdapter = new RoleAdapter(this.getActivity());
        mViewPager.setAdapter(mRoleAdapter);
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                // 刷新角色选中请情况
                mPresenter.refreshRole(mRoleAdapter.getMenu().get(position).getId());
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    public void toTodayRecommend() {
        FragmentTransaction ft = this.getFragmentManager().beginTransaction();
        ft.hide(this);
        ft.add(R.id.main_container, new RecommendFragment());
        ft.commit();
    }
}
