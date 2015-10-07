package woo.com.wakeup;

import android.app.Application;
import android.content.Context;

/**
 * App
 * Desc:程序上下文
 * Date: 2015/10/6
 * Time: 9:48
 * Created by: Wooxxx
 */
public class App extends Application {

    private AppComponent mAppComponent;

    /**
     * 获得当前程序上下文
     *
     * @param context 上下文
     * @return App
     */
    public static App get(Context context) {
        return (App) context.getApplicationContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();

        // 构建程序上下文时，需要先初始化AppComponent, 才能注入依赖
        mAppComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();

        this.injectDependencies();
    }

    /**
     * 依赖注入
     */
    private void injectDependencies() {
        this.getAppComponent().inject(this);
    }

    public AppComponent getAppComponent() {
        return mAppComponent;
    }
}
