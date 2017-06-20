package attor.shoiron;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;

/**
 * Created by moshe on 15/05/2017.
 */

public class CustomMainButton extends android.support.v7.widget.AppCompatButton {
    public CustomMainButton(Context context) {
        super(context);
        Typeface typeface = Typeface.createFromAsset(context.getAssets(),"fonts/AmericanTypewriter.ttc");
        this.setTypeface(typeface);
    }

    public CustomMainButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        Typeface typeface = Typeface.createFromAsset(context.getAssets(),"fonts/AmericanTypewriter.ttc");
        this.setTypeface(typeface);
    }

    public CustomMainButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        Typeface typeface = Typeface.createFromAsset(context.getAssets(),"fonts/AmericanTypewriter.ttc");
        this.setTypeface(typeface);
    }
}
