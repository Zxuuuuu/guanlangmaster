package hangtian.com.guanlangmaster.fragments.home.homes;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.SearchView;

import java.util.ArrayList;
import java.util.List;

import hangtian.com.guanlangmaster.R;
import hangtian.com.guanlangmaster.adapters.eventHanding.InspectionPlanAdapter;
import hangtian.com.guanlangmaster.javabeans.InspectionPlanTitleAndMessage;
import hangtian.com.guanlangmaster.utils.MyApplication;
import hangtian.com.guanlangmaster.utils.ScreenManager;

/**
 *巡检计划Fragment
 *Zxuuuuuu
 *2018/12/27,15:56
 */


public class InspectionPlanFragment extends Fragment {

    private ListView mListView;
    public InspectionPlanFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.inspection_fragment, container, false);
        mListView = view.findViewById(R.id.listView);

        SearchView searchView = view.findViewById(R.id.search_view); //搜索框

        RelativeLayout statusLayout = view.findViewById(R.id.statusLayout);
        ScreenManager.SetStatus(MyApplication.getContext(),statusLayout);

        initListView();
        return view;
    }

    private void initListView() {
        List<InspectionPlanTitleAndMessage> titleAndMessageList = new ArrayList<>();
        for (int i=1;i<11;i++) {
            String title = i+"XX设备巡检计划";
            String startTime = "开始时间：2018.10.12";
            String actionCycle = "周期：30天";
            String area = "区域：XX地区";
            String missionState;
            if (i<3){
                missionState ="未查看";
            }else if (i>=3&&i<6) {
                missionState = "进行中";
            }else {
                missionState = "已完成";
            }


            InspectionPlanTitleAndMessage titleAndMessage = new InspectionPlanTitleAndMessage(title,startTime,
                    actionCycle,area,missionState);
            titleAndMessageList.add(titleAndMessage);
        }
        InspectionPlanAdapter adapter = new InspectionPlanAdapter(MyApplication.getContext(),
                R.layout.item_inspection_plan, titleAndMessageList);
        mListView.setAdapter(adapter);
    }


}