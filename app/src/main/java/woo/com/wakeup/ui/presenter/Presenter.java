package woo.com.wakeup.ui.presenter;

/**
 * Presenter
 * Desc: Presenter接口，为presenter提供会话期
 * Date: 2015/10/6
 * Time: 10:50
 * Created by: Wooxxx
 */
public interface Presenter {
    /**
     * Called when the Presenter is initialized,
     * this method represents the start of the Presenter
     * lifecycle.
     */
    void initialize();

    /**
     * Called when the Presenter is resumed.
     * After the initialization and when the Presenter comes
     * from a pause state.
     */
    void resume();

    /**
     * Called when the Presenter is paused.
     */
    void pause();
}
