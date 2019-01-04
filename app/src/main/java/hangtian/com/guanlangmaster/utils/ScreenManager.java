package hangtian.com.guanlangmaster.utils;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

/**
 *屏幕信息类
 * 获取屏幕信息，包括顶部栏高度，屏幕高度，宽度等。
 *Zxuuuuuu
 *2018/12/27,17:36
 */
public class ScreenManager {

    //获取手机状态栏高度，单位为PX
    public static  int getPxStatusHeight(Context context){
        Resources resources = context.getResources();
        int resourceId = resources.getIdentifier("status_bar_height",
                "dimen","android");
        int height = resources.getDimensionPixelSize(resourceId); // height表示顶部状态栏的高度，单位是PX
        return height;
    }

    //获取手机状态栏高度，单位为pt
    public static int getPtStatusHeight(Context context){
        int height = getPxStatusHeight(context);
        return pxToDp(context,height);
    }
    //将px单位转换成pt单位
    public static int pxToDp(Context context, float pxValue) {
        final float scale =  context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }
    //将dp单位转换成px单位
    public static int dpToPx(Context context, float dpValue) {
        final float scale =  context.getResources().getDisplayMetrics().density;
        return (int) ((dpValue-0.5f)*scale);
    }

    /**获取屏幕高度*/
    public static int getScreenHeight(Context context) {
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics outMetrics = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(outMetrics);
        return outMetrics.heightPixels;
    }

    /**获取屏幕宽度*/
    public static int getScreenWidth(Context context) {
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics outMetrics = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(outMetrics);
        return outMetrics.widthPixels;
    }



    /**将statusLayout设置成状态栏的高度*/
    public static void SetStatus(Context context, View statusLayout) {
        Resources resources = context.getResources();
        int resourceId = resources.getIdentifier("status_bar_height", "dimen","android");
        int height = resources.getDimensionPixelSize(resourceId);

        ViewGroup.LayoutParams params = statusLayout.getLayoutParams();
        params.height = height;
        statusLayout.setLayoutParams(params);//将statusLayout设置成状态栏的高度
    }
}
