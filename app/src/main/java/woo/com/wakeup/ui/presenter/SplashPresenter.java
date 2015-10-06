package woo.com.wakeup.ui.presenter;

import android.view.View;

/**
 * SplashPresenter
 * Desc:
 * Date: 2015/10/6
 * Time: 9:37
 * Created by: Wooxxx
 */
public class SplashPresenter implements Presenter {

    private View mView;

    @Override
    public void initialize() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void pause() {

    }

    public interface view {
        // 标题文字淡入
        void titleFadeIn();

        // 延迟执行1s
        void deffer();
    }
}
