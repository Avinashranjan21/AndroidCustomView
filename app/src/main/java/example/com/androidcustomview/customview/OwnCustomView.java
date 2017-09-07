package example.com.androidcustomview.customview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import example.com.androidcustomview.R;

public class OwnCustomView extends View {

    private static final String TAG = "OwnCustomView";
    int fillColor;


    private Paint backgroundPaint;

    public OwnCustomView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
//        setBackgroundColor();
        setColorFromXML(context, attributeSet);

    }

    private void setBackgroundColor() {
        backgroundPaint = new Paint();
        backgroundPaint.setColor(0xffff0000);
        backgroundPaint.setStyle(Paint.Style.FILL);
    }

    private void setColorFromXML(Context context, AttributeSet attributeSet) {
        TypedArray ta = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.OwnCustomView, 0, 0);
        try {
            int DEFAULT_FILL_COLOR = R.color.colorAccent;
            fillColor = ta.getColor(R.styleable.OwnCustomView_fillColor,
                    getResources().getColor(DEFAULT_FILL_COLOR));
            setBackgroundColor(fillColor);
        } finally {
            ta.recycle();
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
//        canvas.drawRect(0, 0, getWidth(), getHeight(), backgroundPaint);
        super.onDraw(canvas);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        Log.d(TAG, "width spec: " + MeasureSpec.toString(widthMeasureSpec));

        Log.d(TAG, "height spec: " + MeasureSpec.toString(heightMeasureSpec));

        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

    }
}
