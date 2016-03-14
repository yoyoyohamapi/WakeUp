package woo.com.wakeup.ui.presenter;

import java.util.Date;

import woo.com.wakeup.model.entity.IBase;
import woo.com.wakeup.model.entity.IRecord;
import woo.com.wakeup.ui.fragment.AbstractNewFragment;

/**
 * CompletePresenter
 * Desc:
 * Team: InHand
 * User: Wooxxx
 * Date: 2015-12-03
 * Time: 20:18
 */
public class CompletePresenter implements Presenter {
    private View mView;

    @Override
    public void initialize() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void pause() {

    }

    public void setView(View view){
        this.mView = view;
    }

    /**
     * 存储
     */
    public void saveRecord(){
        IRecord record = ((AbstractNewFragment)this.mView).getRecord();
        Date date = new Date();
        record.setCreatedAt(date);
        record.setUpdatedAt(date);
        record.setDate(date);
        record.save(new IBase.SaveCallback() {
            @Override
            public void pre() {

            }

            @Override
            public void done(Exception e) {
                if (e == null) {
                    mView.next();
                }
            }
        });
    }

    public interface View{
        /**
         * 进行下一步
         */
        void next();
    }
}
