package hangtian.com.guanlangmaster.widget;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;

/**
 *登录loading界面，做个缓冲
 *Zxuuuuuu
 *2018/12/27,15:54
 */

import hangtian.com.guanlangmaster.R;

public class LoadingDialog  extends ProgressDialog {
    private String mMessage;
    private TextView mTitleTextView;

    public LoadingDialog(Context context,String message ,boolean cancleOnTouvhOutside) {

        super(context, R.style.Theme_AppCompat_Light_LoadingDialog);
        this.mMessage= message;

        //触摸屏幕其他区域，可以选择让这个progressDialog消失或者无变化
        setCanceledOnTouchOutside(cancleOnTouvhOutside);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loading_dialog);
        mTitleTextView = findViewById(R.id.loading_dialog);
        mTitleTextView.setText(mMessage);
        setCancelable(false); //不可取消
    }

    public  void setTitle(String message){
        this.mMessage = message;
        mTitleTextView.setText(mMessage);
    }

}
