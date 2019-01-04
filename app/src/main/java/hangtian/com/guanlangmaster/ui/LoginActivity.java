package hangtian.com.guanlangmaster.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.SurfaceHolder;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import hangtian.com.guanlangmaster.R;
import hangtian.com.guanlangmaster.sharedPreference.SharedPreferencesUtils;
import hangtian.com.guanlangmaster.widget.LoadingDialog;

/**
 *登录界面
 *Zxuuuuuu
 *2018/12/27,9:49
 */

public class LoginActivity extends Activity
        implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {

    private EditText user_name;
    private EditText mypassword;
    private Button mylogin;
    private CheckBox checkBox_password;
    private CheckBox checkBox_login;
    private ImageView password_see;

    //正在加载对话框
    private LoadingDialog mLoadingDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        initViews();
        setupEvents();
        initData();
    }



    private void initData() {
        //判断是否第一次登录
        if (firstLogin()) {
            checkBox_password.setChecked(false); //记住密码复选框默认取消
        }
        //判断是否记住密码
        if (rememberPassword()) {
            checkBox_password.setChecked(true);
            setTextNameAndPassword();
        } else {
            setTextName();
        }
        //尝试做下自动登录
        /*if (autologin()){
            checkBox_login.setChecked(true);
            login();
        }*/
    }



    //设置输入数据输入到输入框中
    private void setTextName() {
        user_name.setText("" + getLocalName());
    }



    //本地保存的数据输入到输入框中
    private void setTextNameAndPassword() {
        user_name.setText("" + getLocalName());
        mypassword.setText("" + getLocalPassword());
    }

    //保存本地密码
    private String getLocalPassword() {

        //获取SharedPreferences对象，使用自定义类的方法来获取对象
        SharedPreferencesUtils helper = new SharedPreferencesUtils(this, "setting");
        String password = helper.getString("password");

        /*
         * 考虑增加密码保护机制，比如增加简单的解码器之类的
         * */
        return password;
    }

    //保存本地用户名
    private String getLocalName() {
        //获取SharedPreferences对象，使用自定义类的方法来获取对象
        SharedPreferencesUtils helper = new SharedPreferencesUtils(this, "setting");
        String user_name = helper.getString("user_name");
        return user_name;

    }

    //判断是否记住密码
    private boolean rememberPassword() {
        //获取SharedPreferences对象，使用自定义类的方法来获取对象
        SharedPreferencesUtils helper = new SharedPreferencesUtils(this, "setting");
        boolean rememberPassword = helper.getBoolean("rememberPassword", false);
        return rememberPassword;
    }

    //判断是否第一次登陆
    private boolean firstLogin() {
        //获取SharedPreferences对象，使用自定义类的方法来获取对象
        SharedPreferencesUtils helper = new SharedPreferencesUtils(this, "setting");
        boolean firstLogin = helper.getBoolean("firstLogin", true);
        if (firstLogin) {
            //创建一个ContentValue自定义对象，设置不是第一次登录时，默认记住密码选项不选择，账号密码为空
            helper.putValues(new SharedPreferencesUtils.ContentValue("firstLogin", false),
                    new SharedPreferencesUtils.ContentValue("rememberPassword", false),
                    new SharedPreferencesUtils.ContentValue("user_name", ""),
                    new SharedPreferencesUtils.ContentValue("password", ""));
            return true;
        }
        return false;
    }

    private void setupEvents() {
        mylogin.setOnClickListener(this);
        checkBox_password.setOnCheckedChangeListener(this);
        password_see.setOnClickListener(this);

    }

    private void initViews() {
        mylogin = findViewById(R.id.mylogin);
        user_name = findViewById(R.id.user_name);
        mypassword = findViewById(R.id.password);
        checkBox_password = findViewById(R.id.checkbox_password);
        password_see = findViewById(R.id.password_see);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.mylogin:
                loadUsername(); // 保存用户名
                login(); //登陆
                break;
            case R.id.password_see:
                setPasswordVisibility(); //改变图片，并使密码输入框文本可见或不可见
                break;
        }

    }

    /*
     * 模拟登录条件
     * 设置登录权限
     * */
    private void login() {
        //做基本判断，用户名为空，密码为空，网络不可用等情况 提示
       if (getAccount().isEmpty()) {
            showToast("账号不能为空");
            return;
        }
        if (getPassword().isEmpty()) {
            showToast("密码不能为空");
            return;
        }

        //登录请求服务器判断密码正确，请求网络，要子线程
        showLoading(); //显示加载框
        Thread loginRunnable = new Thread() {
            @Override
            public void run() {
                super.run();
                setLoginBtnClickable(false); //点击登陆后，设置登陆按钮不可点击状态
                try {
                    Thread.sleep(500);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                //判断账号和密码,此处为示例 仅供参考  逻辑有问题 记得修改
                if (getAccount().equals("xunjian") && getPassword().equals("123456")) {
                    showToast("登陆成功");
                    loadCheckBoxState(); // 保存当下用户记住密码状态
                    startActivity(new Intent(LoginActivity.this, InspectionActivity.class));
                    finish();
                } else {
                    showToast("输入的账号或密码不正确");
                if (getAccount().equals("weixiu") && getPassword().equals("654321")) {
                    showToast("登陆成功");
                    loadCheckBoxState(); // 保存当下用户记住密码状态
                    startActivity(new Intent(LoginActivity.this, RepairActivity.class));
                    finish();
                }

                }
                setLoginBtnClickable(true); // 释放登陆按钮，可点击状态
                hideloading();
            }
        };
        loginRunnable.start();
    }

    //设置密码可见或不可见转换
    private void setPasswordVisibility() {
        if (password_see.isSelected()) {
            password_see.setSelected(false);
            //密码不可见
            mypassword.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
        } else {
            password_see.setSelected(true);
            mypassword.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
        }

    }

    //保存用户选择“记住密码”的状态
    private void loadCheckBoxState() {
        loadCheckBoxState(checkBox_password);
    }

    //保存按钮的状态值
    private void loadCheckBoxState(CheckBox checkBox_password) {
        //获取SharedPreferences对象，使用自定义类的方法来获取对象

        SharedPreferencesUtils helper = new SharedPreferencesUtils(this, "setting");
        //记住密码
        if (checkBox_password.isChecked()) {
            helper.putValues(
                    new SharedPreferencesUtils.ContentValue("rememberPassword", true),
                    new SharedPreferencesUtils.ContentValue("password", getPassword()),
                    new SharedPreferencesUtils.ContentValue("user_name",getLocalName())
            );
        }
    }

    //登录按钮是否可以点击
    public void setLoginBtnClickable(boolean clickable) {
        mylogin.setClickable(clickable);
    }

    // 隐藏加载进度框
    private void hideloading() {
        if (mLoadingDialog != null) {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    mLoadingDialog.hide();
                }
            });
        }
    }

    //显示加载的进度框
    private void showLoading() {
        if (mLoadingDialog == null) {
            mLoadingDialog = new LoadingDialog(this,
                    getString(R.string.loading), false);
        }
        mLoadingDialog.show();
    }

    // 获取密码
    public String getPassword() {
        return mypassword.getText().toString().trim();// 去掉空格
    }

    // 获取账号
    public String getAccount() {
        return user_name.getText().toString().trim();// 去掉空格
    }

    //保存用户账号
    private void loadUsername() {
        if (!getAccount().equals("") || !getAccount().equals("请输入您的账号")) {
            SharedPreferencesUtils helper = new SharedPreferencesUtils(this, "setting");
            helper.putValues(new SharedPreferencesUtils.ContentValue("name", getAccount()));
        }
    }

    /*
     * checkBox 点击回调方法，不管勾选还是取消勾选都会得到回调
     * @param buttonView 按钮对象
     * @param isCheckde  按钮的状态n
     *
     * */
    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (buttonView == checkBox_password){
            if(!isChecked){
                checkBox_login.setChecked(false);
            }
        }else if (buttonView == checkBox_login){
            if (isChecked){
                checkBox_password.setChecked(true);
            }
        }
    }

    public void showToast(final String msg) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(LoginActivity.this, msg, Toast.LENGTH_SHORT).show();
            }
        });
    }

    /*
     * 监听回退键
     * */

    @Override
    public void onBackPressed() {
        if (mLoadingDialog != null){
            if (mLoadingDialog.isShowing()){
                mLoadingDialog.cancel();
            }else{
                finish();
            }
        }else {
            finish();
        }
    }

    /*
     * 页面销毁前回调的方法
     * */

    @Override
    protected void onDestroy() {
        if (mLoadingDialog != null){
            mLoadingDialog.cancel();
            mLoadingDialog = null;
        }
        super.onDestroy();
    }
}
