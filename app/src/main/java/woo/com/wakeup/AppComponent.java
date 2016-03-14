package woo.com.wakeup;

import javax.inject.Singleton;

import dagger.Component;
import woo.com.wakeup.model.module.DaoModule;
import woo.com.wakeup.ui.presenter.HomePresenter;

/**
 * AppComponent
 * Desc: App模块持有者，使得App模块能够注入到程序上下文
 * Date: 2015/10/6
 * Time: 9:46
 * Created by: Wooxxx
 */
@Singleton
@Component(
        modules = {AppModule.class, DaoModule.class}
)
public interface AppComponent {

    /**
     * 注入，被注入者来源于AppModule
     *
     * @param app 注入对象
     */
    void inject(App app);

    /**
     * DaoModule内的模块可注入Presenter的实现中
     * @param presenter Presenter
     */
    void inject(HomePresenter presenter);
}
