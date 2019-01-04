package hangtian.com.guanlangmaster.utils;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 *禁止滑动ViewPaper
 *Zxuuuuuu
 *2018/12/27,10:34
 */

public class NoScrollViewPaper extends ViewPager  {


    public NoScrollViewPaper( Context context) {
        super(context);
    }
    public NoScrollViewPaper(Context context , AttributeSet attributeSet){
        super(context,attributeSet);
    }

    @Override
    public boolean onTouchEvent(MotionEvent arg0) {
        return false;
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent arg0) {
        return false;
    }
}
