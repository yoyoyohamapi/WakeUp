package woo.com.wakeup.model.entitySugar;

import android.os.AsyncTask;

import woo.com.wakeup.model.entity.IBase;

/**
 * SaveTask
 * Desc:
 * Team: InHand
 * User: Wooxxx
 * Date: 2015-10-26
 * Time: 20:01
 */
public class SaveTask extends AsyncTask<Void, Integer, Void> {
    private IBase.SaveCallback<Exception> mCallback;

    public SaveTask(IBase.SaveCallback<Exception> callback) {
        this.mCallback = callback;
    }

    @Override
    protected void onPreExecute() {
        mCallback.pre();
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        mCallback.done(null);
    }

    @Override
    protected Void doInBackground(Void... voids) {
        return null;
    }
}
