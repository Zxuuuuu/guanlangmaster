package hangtian.com.guanlangmaster.widget;

import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.TextView;

public class MissionStateTextView extends android.support.v7.widget.AppCompatTextView {

    private String mText;
    private Paint mPaint;
    private Rect mBound;

    public MissionStateTextView(Context context) {
        super(context);
    }

    public MissionStateTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        mText = (String) getText();
    }

    private void init() {
        int mTextColor = Color.GRAY;
        int mTextSize = 30;

        //排出空值异常
        if (mText.equals("")) {
            return;
        }
        String missionState = mText;
        if (missionState.equals("未查看")) {
            mTextColor = Color.RED;
        } else if (missionState.equals("进行中")) {
            mTextColor = Color.GREEN;
        }
        mPaint = new Paint();
        mPaint.setTextSize(mTextSize);
        mPaint.setColor(mTextColor);

        //绘制文本的宽和高
        mBound = new Rect();
        mPaint.getTextBounds(mText,0,mText.length(),mBound);

    }

    @Override
    public void setText(CharSequence text, BufferType type) {
        mText = (String)text;
        init();
        this.invalidate();
        super.setText(text, type);
    }

    @Override
    protected void onDraw(Canvas canvas) {
       canvas.drawText(mText,getWidth()/2-mBound.width()/2,
               getHeight()/2-mBound.height()/2,mPaint);
    }
}
