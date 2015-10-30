package woo.com.wakeup.ui.widget;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;

/**
 * TextClock
 * Desc: 自定义时钟
 * Team: InHand
 * User: Wooxxx
 * Date: 2015-10-15
 * Time: 10:35
 */
public class TextClock extends android.widget.TextClock {
    public TextClock(Context context) {
        super(context);
        initFont(context);

    }

    public TextClock(Context context, AttributeSet attrs) {
        super(context, attrs);
        initFont(context);

    }

    public TextClock(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initFont(context);
    }

    public TextClock(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initFont(context);
    }

    private void initFont(Context ctx) {
        Typeface typeface = Typeface.createFromAsset(ctx.getAssets(), "tekai07.ttf");
        this.setTypeface(typeface);
    }
}
