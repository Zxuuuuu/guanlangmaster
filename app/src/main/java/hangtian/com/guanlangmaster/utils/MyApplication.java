package hangtian.com.guanlangmaster.utils;

import android.app.Application;

public class MyApplication extends Application {
    private static MyApplication instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }
    public static MyApplication getContext(){
        return instance;
    }
}
