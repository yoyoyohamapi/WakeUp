package woo.com.wakeup.ui.widget;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;

/**
 * TextView
 * Desc: 自定义文本显示，主要用户更改字体
 * Team: InHand
 * User: Wooxxx
 * Date: 2015-10-22
 * Time: 11:42
 */
public class TextView extends android.widget.TextView {
    public TextView(Context context) {
        super(context);
        initFont(context);

    }

    public TextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initFont(context);

    }

    public TextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initFont(context);

    }

    public TextView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initFont(context);
    }

    private void initFont(Context ctx) {
        Typeface typeface = Typeface.createFromAsset(ctx.getAssets(), "tekai07.ttf");
        this.setTypeface(typeface);
    }
}
