package hangtian.com.guanlangmaster;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import hangtian.com.guanlangmaster.ui.LoginActivity;

/**
 *
 *Zxuuuuuu
 *2018/12/27,15:53
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void login(View view){
        startActivity(new Intent( this,LoginActivity.class));
    }

    public void exit(View view){
        finish();
    }
}
