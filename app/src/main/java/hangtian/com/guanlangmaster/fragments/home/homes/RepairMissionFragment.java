package hangtian.com.guanlangmaster.fragments.home.homes;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.RelativeLayout;
import android.widget.SearchView;
import android.widget.Toast;
import hangtian.com.guanlangmaster.R;
import hangtian.com.guanlangmaster.adapters.eventHanding.RepairMissionAdapter;
import hangtian.com.guanlangmaster.utils.MyApplication;
import hangtian.com.guanlangmaster.utils.ScreenManager;


/**
 * 维修任务Fragment
 * ExpandListView 组合菜单
 * Zxuuuuuu
 * 2018/12/27,15:55
 */

public class RepairMissionFragment extends Fragment {

    private ExpandableListView expandableListView;
    private SearchView msearchView;
    public String[] groupTitle = {"维修任务一","维修任务二","维修任务三","维修任务四"};
    public String[][] childTitle = {
            {"风机一","风机二","风机三","风机四"},
            {"管道一","管道二","管道三","管道四"},
            {"照明一","照明二","照明三","照明四"},
            {"消防一","消防二","消防三","消防四"}};
    public RepairMissionFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.repair_fragment, container, false);
        expandableListView = view.findViewById(R.id.expand_list);

        msearchView = view.findViewById(R.id.search_view);

        RelativeLayout statusLayout = view.findViewById(R.id.statusLayout2);
        ScreenManager.SetStatus(MyApplication.getContext(), statusLayout);
        initListView();
        return view;

    }

    private void initListView() {
        expandableListView.setAdapter(new  RepairMissionAdapter());

        //父列表监听
      expandableListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
          @Override
          public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {

              Toast.makeText(MyApplication.getContext(), groupTitle[groupPosition], Toast.LENGTH_SHORT).show();
              return false;
          }
      });
      //子列表监听
        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {

                Toast.makeText(MyApplication.getContext(),childTitle[groupPosition][childPosition],Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        //设置只能打开一个分组
        expandableListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            @Override
            public void onGroupExpand(int groupPosition) {
                int count = new RepairMissionAdapter().getGroupCount();
                for (int i=0;i<count;i++){
                    if (i!=groupPosition){
                        expandableListView.collapseGroup(i);
                    }
                }
            }
        });


    }
}
