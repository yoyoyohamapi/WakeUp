package woo.com.wakeup.ui.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.View;

import woo.com.wakeup.ui.activity.component.HasComponent;

/**
 * BaseFragment
 * Desc: Fragment基类
 * Team: InHand
 * User: Wooxxx
 * Date: 2015-10-07
 * Time: 14:50
 */
public abstract class BaseFragment extends Fragment {

    protected abstract void initialize();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.initialize();
    }

    /**
     * Gets a component for dependency injection by its type.
     */
    @SuppressWarnings("unchecked")
    protected <C> C getComponent(Class<C> componentType) {
        return componentType.cast(((HasComponent<C>) getActivity())
                .getComponent());
    }
}
