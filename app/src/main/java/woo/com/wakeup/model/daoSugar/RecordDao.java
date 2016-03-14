package woo.com.wakeup.model.daoSugar;

import android.os.AsyncTask;

import java.util.ArrayList;
import java.util.List;

import woo.com.wakeup.model.dao.IRecordDao;
import woo.com.wakeup.model.entity.IBase;
import woo.com.wakeup.model.entitySugar.Record;

/**
 * RecordDao
 * Desc:
 * Team: InHand
 * User: Wooxxx
 * Date: 2015-12-03
 * Time: 20:34
 */
public class RecordDao extends BaseDao
        implements IRecordDao{

    public RecordDao() {
    }

    @Override
    public List<Record> findLatest() {
        return Record.find(
                Record.class,
                null,
                null,
                null,
                null,
                String.valueOf(IRecordDao.LATEAST_LIMIT)
        );
    }

    @Override
    public void findLatest(final FindCallback callback) {
        final List<Record> records = new ArrayList<>();
        new AsyncTask<Void,Integer,List<Record>>(){

            @Override
            protected List<Record> doInBackground(Void... voids) {
                return Record.find(
                        Record.class,
                        null,
                        null,
                        null,
                        null,
                        String.valueOf(IRecordDao.LATEAST_LIMIT)
                );
            }

            @Override
            protected void onPostExecute(List<Record> records) {
                callback.done(records,null);
            }
        }.execute();
    }

    @Override
    public List<Record> findAll(String orderBy, boolean asc) {
        return null;
    }

    @Override
    public void findAll(String orderBy, boolean asc, FindCallback callback) {

    }

    @Override
    public IBase getById(String id) {
        return null;
    }

    @Override
    public void getById(String id, final GetCallback callback) {

    }
}
