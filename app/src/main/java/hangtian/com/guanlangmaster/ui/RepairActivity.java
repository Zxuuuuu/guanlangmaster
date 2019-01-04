package hangtian.com.guanlangmaster.ui;

import android.graphics.PixelFormat;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;

import com.chaychan.library.BottomBarItem;
import com.chaychan.library.BottomBarLayout;

import java.util.ArrayList;
import java.util.List;

import hangtian.com.guanlangmaster.R;
import hangtian.com.guanlangmaster.adapters.BaseFragmentAdapter;
import hangtian.com.guanlangmaster.fragments.home.Setting;
import hangtian.com.guanlangmaster.fragments.home.homes.RepairMissionFragment;
import hangtian.com.guanlangmaster.utils.NoScrollViewPaper;

/**
 *维修任务Activity
 *Zxuuuuuu
 *2018/12/27,15:54
 */
public class RepairActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.repair);
        NoScrollViewPaper homeContent = findViewById(R.id.homeContent);
        BottomBarLayout mBottomBarLayout = findViewById(R.id.homeBottomBarLayout);
        getWindow().setFormat(PixelFormat.TRANSLUCENT);
        initState();
        List<Fragment> fragmentList = new ArrayList<>();
        fragmentList.add(new RepairMissionFragment());
        fragmentList.add(new Setting());

        homeContent.setAdapter( new BaseFragmentAdapter(getSupportFragmentManager(),fragmentList));
        homeContent.setOffscreenPageLimit(1);
        mBottomBarLayout.setViewPager(homeContent);
        mBottomBarLayout.setUnread(0,20);
        mBottomBarLayout.setMsg(1,"NEW");
        mBottomBarLayout.setOnItemSelectedListener(new BottomBarLayout.OnItemSelectedListener() {
            @Override
            public void onItemSelected(BottomBarItem bottomBarItem, int i, int i1) {

            }
        });
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


