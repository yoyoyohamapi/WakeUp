package woo.com.wakeup.ui.presenter;

import android.content.Context;

import java.util.Date;

import woo.com.wakeup.model.entity.ITodayRecommend;
import woo.com.wakeup.ui.fragment.AbstractNewFragment;
import woo.com.wakeup.utils.TodayRecommendFailCallback;
import woo.com.wakeup.utils.TodayRecommendSuccessCallback;
import woo.com.wakeup.utils.TodayRecommendUtils;

/**
 * RecommendPresenter
 * Desc:
 * Team: InHand
 * User: Wooxxx
 * Date: 2015-12-03
 * Time: 09:21
 */
public class RecommendPresenter implements Presenter {

    private ITodayRecommend mRecommend;

    private View mView;

    public RecommendPresenter(ITodayRecommend recommend) {
        this.mRecommend = recommend;
    }

    @Override
    public void initialize() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void pause() {

    }

    public void setView(View view){
        this.mView = view;
    }

    public void getRecommend(Context ctx){
        TodayRecommendUtils.getTodayRecommend(
                ctx,
                new TodayRecommendSuccessCallback() {
                    @Override
                    public void done(String cover, String songName, String artist) {
                        mRecommend.setCoverUrl(cover);
                        mRecommend.setName(songName);
                        mRecommend.setArtist(artist);
                        mRecommend.setCreatedAt(new Date());
                        mRecommend.setUpdatedAt(new Date());
                        mView.renderRecommend(mRecommend);
                        refreshRecommend(mRecommend);
                    }
                },
                new TodayRecommendFailCallback() {
                    @Override
                    public void done() {
                        mView.stopLoading();
                        mView.showError();
                    }
                }
        );
    }

    public void refreshRecommend(ITodayRecommend todayRecommend){
        ((AbstractNewFragment)this.mView).getRecord().setTodayRecommend(todayRecommend);
    }

    public interface View {

        /**
         * 显示加载动画
         */
        void showLoading();

        /**
         * 结束加载动画
         */
        void stopLoading();

        /**
         * 如果获得今日推荐失败，需要显示错误
         */
        void showError();

        /**
         * 渲染推荐页面
         */
        void renderRecommend(ITodayRecommend recommend);

        /**
         * 至完成页面
         */
        void toComplete();
    }
}
