package woo.com.wakeup;

import javax.inject.Singleton;

import dagger.Component;

/**
 * AppComponent
 * Desc: App模块持有者，使得App模块能够注入到程序上下文
 * Date: 2015/10/6
 * Time: 9:46
 * Created by: Wooxxx
 */
@Singleton
@Component(
        modules = AppModule.class
)
public interface AppComponent {

    /**
     * 注入，被注入者来源于AppModule
     *
     * @param app 注入对象
     */
    void inject(App app);
}
