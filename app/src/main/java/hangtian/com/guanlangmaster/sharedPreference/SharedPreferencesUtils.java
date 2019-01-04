package hangtian.com.guanlangmaster.sharedPreference;

import android.content.Context;
import android.content.SharedPreferences;

/**
 *数据库存储账号密码
 *Zxuuuuuu
 *2018/12/27,15:55
 */

public class SharedPreferencesUtils {
    //定义一个SharePreference对象
    //定义一个上下文对象
    //创建SharePreference对象时要上下文和存储的模式
    //通过构造方法传入一个上下文


    SharedPreferences sharedPreferences;

    public SharedPreferencesUtils(Context context, String fileName) {
        //实例化SharePreference对象，使用的是get方法，而不是new创建
        //第一个参数是文件的名字
        //第二个参数是存储的模式，一般都是使用私有方式：Context.MODE_PRIVATE
        sharedPreferences = context.getSharedPreferences(fileName, Context.MODE_PRIVATE);
    }

    /**
     * 存储数据
     * 这里要对存储的数据进行判断在存储
     * 只能存储简单的几种数据
     * 这里使用的是自定义的ContentValue类，来进行对多个数据的处理
     */
    //创建一个内部类使用，里面有key和value这两个值
    public static class ContentValue {

        String key;
        Object value;

        public ContentValue(String key, Object value) {
            this.key = key;
            this.value = value;
        }
    }

    //一次可以传入多个ContentValue对象的值
    public void putValues(ContentValue... contentValues) {
        //获取SharePreference对象的编辑对象，才能惊醒数据的存储
        SharedPreferences.Editor editor = sharedPreferences.edit();

        //数据分类和存储
        for (ContentValue contentValue : contentValues) {
            //字符型
            if (contentValue.value instanceof String) {
                editor.putString(contentValue.key, contentValue.value.toString()).apply();
            }
            //int型
            if (contentValue.value instanceof Integer) {
                editor.putInt(contentValue.key, Integer.parseInt
                        (contentValue.value.toString())).commit();
            }
            // long型
            if (contentValue.value instanceof Long) {
                editor.putLong(contentValue.key, Long.parseLong
                        (contentValue.value.toString())).commit();

            }
            // 布尔型
            if (contentValue.value instanceof Boolean) {
                editor.putBoolean(contentValue.key, Boolean.parseBoolean
                        (contentValue.value.toString())).commit();
            }

        }
    }

    /**
     * 获取数据的方法
     * Zxuuuuuu
     * 2018/12/26,8:59
     */
    public String getString(String key) {
        return sharedPreferences.getString(key, null);
    }

    public boolean getBoolean(String key, Boolean b) {
        return sharedPreferences.getBoolean(key, b);
    }

    public int getInt(String key) {
        return sharedPreferences.getInt(key, -1);
    }

    public long getLong(String key) {
        return sharedPreferences.getLong(key, -1);

    }

    //清除当前所有数据
    public void clear() {
        sharedPreferences.edit().clear().apply();
    }
}
