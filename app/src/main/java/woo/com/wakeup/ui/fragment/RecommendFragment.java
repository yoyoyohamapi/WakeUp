package woo.com.wakeup.ui.fragment;

import android.app.FragmentTransaction;
import android.graphics.drawable.AnimationDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.squareup.picasso.Picasso;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import woo.com.wakeup.R;
import woo.com.wakeup.model.entity.ITodayRecommend;
import woo.com.wakeup.ui.activity.component.NewComponent;
import woo.com.wakeup.ui.presenter.RecommendPresenter;
import woo.com.wakeup.ui.widget.LoadingView;
import woo.com.wakeup.ui.widget.TextView;

/**
 * RecommendFragment
 * Desc: 今日推荐Fragment
 * Team: InHand
 * User: Wooxxx
 * Date: 2015-12-03
 * Time: 09:11
 */
public class RecommendFragment extends AbstractNewFragment implements RecommendPresenter.View {

    @Inject
    RecommendPresenter mPresenter;

    @Bind(R.id.ivCover)
    ImageView mIvCover;
    @Bind(R.id.tvSong)
    TextView mTvSong;
    @Bind(R.id.tvArtist)
    TextView mTvArtist;
    @Bind(R.id.loadingView)
    LoadingView mLoadingView;
    @Bind(R.id.rlRetry)
    RelativeLayout mRlRetry;
    @Bind(R.id.rlMain)
    RelativeLayout mRlMain;

    @OnClick(R.id.btnRetry)
    public void retry() {
        this.showLoading();
    }

    @OnClick(R.id.btnOk)
    public void ok() {
        this.toComplete();
    }

    private AnimationDrawable mLoadingAnim;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_recommend, container, false);
        ButterKnife.bind(this, view);
        return view;
    }


    @Override
    protected void initialize() {
        this.getComponent(NewComponent.class).inject(this);
        this.mPresenter.setView(this);
        this.adjustCover();
        mLoadingAnim = (AnimationDrawable) this.getResources().getDrawable(R.drawable.common_loading);
        this.showLoading();
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }


    @Override
    public void showError() {
        this.stopLoading();
        mRlMain.setVisibility(View.GONE);
        mRlRetry.setVisibility(View.VISIBLE);
    }


    @Override
    public void showLoading() {
        mRlMain.setVisibility(View.GONE);
        mRlRetry.setVisibility(View.GONE);
        mLoadingView.startLoading(mLoadingAnim);
        mPresenter.getRecommend(RecommendFragment.this.getActivity());
    }

    @Override
    public void stopLoading() {
        mLoadingView.stopLoading(mLoadingAnim);
    }

    @Override
    public void renderRecommend(ITodayRecommend recommend) {
        String coverUrl = recommend.getCoverUrl();
        Picasso.with(this.getActivity()).load(Uri.parse(coverUrl)).into(mIvCover);
        mTvArtist.setText(recommend.getArtist());
        mTvSong.setText(recommend.getName());
        mRlMain.setVisibility(View.VISIBLE);
    }

    @Override
    public void toComplete() {
        // 跳转到完成页面
        FragmentTransaction ft = this.getFragmentManager().beginTransaction();
        ft.hide(this);
        ft.add(R.id.main_container, new CompleteFragment());
        ft.commit();
    }

    /**
     * 校正封面显示
     */
    private void adjustCover(){
        DisplayMetrics dm = new DisplayMetrics();

        this.getActivity().getWindowManager().getDefaultDisplay().getMetrics(dm);
        int coverLength = dm.widthPixels;
        mIvCover.setLayoutParams(new RelativeLayout.LayoutParams(coverLength, coverLength));
    }
}
