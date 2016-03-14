package woo.com.wakeup.ui.widget;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

/**
 * LoadingView
 * Desc:
 * Team: InHand
 * User: Wooxxx
 * Date: 2015-12-03
 * Time: 10:41
 */
public class LoadingView extends LinearLayout {

    private ImageView mImageView;

    public LoadingView(Context context) {
        super(context);
        initView(context);
    }

    public LoadingView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public LoadingView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    public LoadingView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initView(context);
    }


    private void initView(Context ctx){
        this.setOrientation(VERTICAL);
        this.setGravity(Gravity.CENTER);
        this.mImageView = new ImageView(ctx);
        this.mImageView.setLayoutParams(
                new ViewGroup.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT
                )
        );
        this.mImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.addView(mImageView,0);

    }


    /**
     * 播放加载动画（异步地）
     * @param anim 加载帧动画
     * @param task 异步加载任务
     */
    public void loading(final AnimationDrawable anim,final LoadingTask task){
        mImageView.setImageDrawable(anim);
        task.setAnim(anim);
        task.setLoadingView(this);
        task.execute();
    }

    public void startLoading(final AnimationDrawable anim){
        mImageView.setImageDrawable(anim);
        this.setVisibility(VISIBLE);
        anim.start();
    }

    public void stopLoading(final AnimationDrawable anim){
        anim.stop();
        this.setVisibility(GONE);
    }


}
