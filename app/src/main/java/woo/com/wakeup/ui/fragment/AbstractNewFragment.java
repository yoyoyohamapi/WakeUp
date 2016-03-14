package woo.com.wakeup.ui.fragment;

import woo.com.wakeup.model.entity.IRecord;
import woo.com.wakeup.ui.activity.NewActivity;

/**
 * AbstractNewFragment
 * Desc:
 * Team: InHand
 * User: Wooxxx
 * Date: 2015-12-01
 * Time: 20:50
 */
public abstract class AbstractNewFragment extends BaseFragment{
    public IRecord getRecord(){
        return ((NewActivity)this.getActivity()).getRecord();
    }
}
