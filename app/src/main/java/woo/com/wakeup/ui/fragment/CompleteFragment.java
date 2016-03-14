package woo.com.wakeup.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.OnClick;
import woo.com.wakeup.R;
import woo.com.wakeup.ui.activity.MainActivity;
import woo.com.wakeup.ui.activity.component.NewComponent;
import woo.com.wakeup.ui.presenter.CompletePresenter;
import woo.com.wakeup.utils.IntentUtils;

/**
 * CompleteFragmant
 * Desc:
 * Team: InHand
 * User: Wooxxx
 * Date: 2015-12-03
 * Time: 10:19
 */
public class CompleteFragment extends AbstractNewFragment
        implements CompletePresenter.View {

    @Inject
    CompletePresenter mPresenter;

    @OnClick(R.id.btnOk)
    public void ok() {
        mPresenter.saveRecord();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_complete, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    protected void initialize() {
        this.getComponent(NewComponent.class).inject(this);
        mPresenter.setView(this);
    }

    @Override
    public void next() {
        IntentUtils.switchTo(getActivity(), MainActivity.class);
        this.getActivity().finish();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
