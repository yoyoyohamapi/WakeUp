package woo.com.wakeup.ui.activity.module;

import dagger.Module;
import dagger.Provides;
import woo.com.wakeup.model.entity.IRecord;
import woo.com.wakeup.model.entitySugar.Record;
import woo.com.wakeup.model.entitySugar.TodayRecommend;
import woo.com.wakeup.ui.activity.ActivityScope;
import woo.com.wakeup.ui.presenter.CompletePresenter;
import woo.com.wakeup.ui.presenter.DrinkPresenter;
import woo.com.wakeup.ui.presenter.RecommendPresenter;
import woo.com.wakeup.ui.presenter.RolePresenter;

/**
 * NewModule
 * Desc:
 * Team: InHand
 * User: Wooxxx
 * Date: 2015-12-01
 * Time: 20:05
 */
@Module
public class NewModule {
    public NewModule(){

    }

    @Provides
    @ActivityScope
    DrinkPresenter providesDrinkPresenter(){
        return new DrinkPresenter();
    }

    @Provides
    @ActivityScope
    RolePresenter providesRolePresenter() {
        return new RolePresenter();
    }

    @Provides
    @ActivityScope
    RecommendPresenter providesRecommendPresenter(){
        return new RecommendPresenter(new TodayRecommend());
    }

    @Provides
    @ActivityScope
    CompletePresenter providesCompletePresenter(){
        return new CompletePresenter();
    }

    @Provides
    @ActivityScope
    IRecord providesRecord(){
        return new Record();
    }


}
