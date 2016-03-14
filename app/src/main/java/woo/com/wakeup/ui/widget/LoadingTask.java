package woo.com.wakeup.ui.widget;

import android.graphics.drawable.AnimationDrawable;
import android.os.AsyncTask;
import android.view.View;

/**
 * LoadingTask
 * Desc:
 * Team: InHand
 * User: Wooxxx
 * Date: 2015-12-03
 * Time: 11:04
 */
public class LoadingTask extends AsyncTask<Void,Integer,Void> {

    private LoadingView mLoadingView;
    private AnimationDrawable mAnim;

    public void setAnim(AnimationDrawable anim) {
        this.mAnim = anim;
    }

    public void setLoadingView(LoadingView loadingView) {
        this.mLoadingView = loadingView;
    }

    @Override
    protected void onPreExecute() {
        mLoadingView.setVisibility(View.VISIBLE);
        mAnim.start();
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        mAnim.stop();
        mLoadingView.setVisibility(View.GONE);
    }

    @Override
    protected void onCancelled() {
        mAnim.stop();
    }

    @Override
    protected Void doInBackground(Void... voids) {
        return null;
    }
}
