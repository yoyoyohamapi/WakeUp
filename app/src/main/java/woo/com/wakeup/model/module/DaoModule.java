package woo.com.wakeup.model.module;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import woo.com.wakeup.model.dao.IRecordDao;
import woo.com.wakeup.model.daoSugar.RecordDao;

/**
 * DaoModule
 * Desc:
 * Team: InHand
 * User: Wooxxx
 * Date: 2015-12-04
 * Time: 08:53
 */
@Module
public class DaoModule {
    public DaoModule(){

    }

    @Provides
    @Singleton
    public IRecordDao providesRecordDao(){
        return new RecordDao();
    }
}
