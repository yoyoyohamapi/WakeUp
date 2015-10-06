package woo.com.wakeup.ui.fragment;

import android.app.Fragment;
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

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import woo.com.wakeup.R;
import woo.com.wakeup.ui.presenter.SplashPresenter;

/**
 * SplashFragment
 * Desc:
 * Date: 2015/10/6
 * Time: 9:36
 * Created by: Wooxxx
 */
public class SplashFragment extends Fragment
        implements SplashPresenter.view {

    @Inject
    SplashPresenter mPresenter;
    @Bind(R.id.ivBkg)
    ImageView mIvBkg;
    @Bind(R.id.ivTitle)
    ImageView mIvTitle;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_splash, container, true);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // 标题淡入
        this.titleFadeIn();
        // 延迟执行
        this.deffer();

    }

    @Override
    public void titleFadeIn() {

        new Handler().postDelayed(new Runnable() {

            public void run() {

                new FadeInAnimation(mIvTitle)
                        .setDuration(2000)
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

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
