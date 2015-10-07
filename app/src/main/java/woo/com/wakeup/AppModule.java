package woo.com.wakeup;

import android.app.Application;

import dagger.Module;

/**
 * AppModule
 * Desc: 注入到App（程序上下文）的模块
 * Date: 2015/10/6
 * Time: 9:45
 * Created by: Wooxxx
 */
@Module
public class AppModule {
    private Application mApplication;

    public AppModule(Application mApplication) {
        this.mApplication = mApplication;
    }
}
