package hangtian.com.guanlangmaster.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 *Fragment适配器，搭配ViewPaper
 *Zxuuuuuu
 *2018/12/27,15:57
 */

public class BaseFragmentAdapter extends FragmentPagerAdapter {
    private List<Fragment> mFragmentList;

    public BaseFragmentAdapter(FragmentManager fragmentManager,
                               List<Fragment> fragmentList){
        super(fragmentManager);
        mFragmentList = fragmentList;
    }

    @Override
    public Fragment getItem(int position) {

        return mFragmentList.get(position);
    }

    @Override
    public int getCount() {
        return mFragmentList.size();
    }
}
