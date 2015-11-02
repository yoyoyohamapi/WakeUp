package woo.com.wakeup.ui.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.easyandroidanimations.library.Animation;
import com.easyandroidanimations.library.AnimationListener;
import com.easyandroidanimations.library.FadeInAnimation;

import java.util.Calendar;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import woo.com.wakeup.R;
import woo.com.wakeup.ui.activity.MainActivity;
import woo.com.wakeup.ui.activity.component.SplashComponent;
import woo.com.wakeup.ui.presenter.SplashPresenter;
import woo.com.wakeup.utils.DateUtils;
import woo.com.wakeup.utils.IntentUtils;

/**
 * SplashFragment
 * Desc: 启动页Fragment
 * Date: 2015/10/6
 * Time: 9:36
 * Created by: Wooxxx
 */
public class SplashFragment extends BaseFragment
        implements SplashPresenter.View {

    @Inject
    SplashPresenter mPresenter;
    @Bind(R.id.ivBkg)
    ImageView mIvBkg;
    @Bind(R.id.ivTitle)
    ImageView mIvTitle;

    private static final int TITLE_FADE = 2000;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_splash, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    protected void initialize() {
        // 初始化时注入依赖
        this.getComponent(SplashComponent.class).inject(this);
        mPresenter.setView(this);
        mPresenter.initialize();
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // 标题淡入
        this.titleFadeIn();
    }

    @Override
    public void setSeason() {
        int season = DateUtils.getSeason(Calendar.getInstance());
//        switch (season) {
//            case DateUtils.SEASON_SPRING:
//                mIvBkg.setImageResource(R.drawable.splash_spring);
//                mIvTitle.setImageResource(R.drawable.splash_spring_title);
//                break;
//            case DateUtils.SEASON_SUMMER:
//                mIvBkg.setImageResource(R.drawable.splash_summer);
//                mIvTitle.setImageResource(R.drawable.splash_summer_title);
//                break;
//            case DateUtils.SEASON_AUTUMN:
//                mIvBkg.setImageResource(R.drawable.splash_autum);
//                mIvTitle.setImageResource(R.drawable.splash_autum_title);
//                break;
//            case DateUtils.SEASON_WINTER:
//                mIvBkg.setImageResource(R.drawable.splash_winter);
//                mIvTitle.setImageResource(R.drawable.splash_winter_title);
//                break;
//        }
    }

    @Override
    public void titleFadeIn() {

        new Handler().postDelayed(new Runnable() {

            public void run() {
                new FadeInAnimation(mIvTitle)
                        .setDuration(TITLE_FADE)
                        .setListener(new AnimationListener() {
                            @Override
                            public void onAnimationEnd(Animation animation) {
                                deffer();
                            }
                        })
                        .animate();
            }

        }, 1000);


    }

    @Override
    public void deffer() {
        // 跳转到MainActivity
        IntentUtils.switchTo(getActivity(), MainActivity.class);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
