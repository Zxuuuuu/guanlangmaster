package hangtian.com.guanlangmaster.ui;

import android.graphics.PixelFormat;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;

import com.chaychan.library.BottomBarLayout;

import java.util.ArrayList;
import java.util.List;

import hangtian.com.guanlangmaster.R;
import hangtian.com.guanlangmaster.adapters.BaseFragmentAdapter;
import hangtian.com.guanlangmaster.fragments.home.Setting;
import hangtian.com.guanlangmaster.fragments.home.homes.InspectionMissionFragment;
import hangtian.com.guanlangmaster.fragments.home.homes.InspectionPlanFragment;
import hangtian.com.guanlangmaster.utils.NoScrollViewPaper;


/**
 *巡检Activity
 *Zxuuuuuu
 *2018/12/27,15:55
 */
public class InspectionActivity extends AppCompatActivity {
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inspection);
        NoScrollViewPaper homeContent = findViewById(R.id.homeContent);
        BottomBarLayout mBottomBarLayout = findViewById(R.id.homeBottomBarLayout);
        getWindow().setFormat(PixelFormat.TRANSLUCENT);
        initState();
        List<Fragment> fragmentList = new ArrayList<>();
        fragmentList.add(new InspectionMissionFragment());
        fragmentList.add(new InspectionPlanFragment());
        fragmentList.add(new Setting());

        homeContent.setAdapter( new BaseFragmentAdapter(getSupportFragmentManager(),fragmentList));
        homeContent.setOffscreenPageLimit(2);//预加载fragment
        mBottomBarLayout.setSmoothScroll(true);
        mBottomBarLayout.setUnread(0,20);   // 第一个底部按钮显示消息条数
        mBottomBarLayout.setUnread(1,101);  // 第二个底部按钮显示消息条数，默认超过99显示为99+
        mBottomBarLayout.setMsg(2,"NEW");         //第三个按钮显示消息 字样为NEW
        mBottomBarLayout.setViewPager(homeContent);
    }
    /*
    * 沉浸式状态栏
    * */

    private void initState() {
        //透明状态
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        //透明导航栏
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);

    }
}
