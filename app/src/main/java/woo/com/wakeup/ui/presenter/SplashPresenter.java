package woo.com.wakeup.ui.presenter;


/**
 * SplashPresenter
 * Desc:
 * Date: 2015/10/6
 * Time: 9:37
 * Created by: Wooxxx
 */
public class SplashPresenter implements Presenter {

    private View mView;

    public void setView(View view) {
        this.mView = view;
    }

    @Override
    public void initialize() {
        // 初始化时设置季节
        this.mView.setSeason();
    }

    @Override
    public void resume() {

    }

    @Override
    public void pause() {

    }

    public interface View {
        // 设置季节
        void setSeason();
        // 标题文字淡入
        void titleFadeIn();

        // 延迟执行1s
        void deffer();
    }
}
