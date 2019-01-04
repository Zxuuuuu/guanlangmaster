package hangtian.com.guanlangmaster.adapters.eventHanding;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;
import hangtian.com.guanlangmaster.R;


/**
 * 维修任务列表
 * Zxuuuuuu
 * 2019/1/2,9:03
 */

public class RepairMissionAdapter extends BaseExpandableListAdapter {
    private Context mContext;
    private Resources mResource;
    public String[] groupTitle = {"维修任务一","维修任务二","维修任务三","维修任务四"};
    public String[][] childTitle = {
            {"风机一","风机二","风机三","风机四"},
            {"管道一","管道二","管道三","管道四"},
            {"照明一","照明二","照明三","照明四"},
            {"消防一","消防二","消防三","消防四"}};

  /*  public RepairMissionAdapter (Context context,Resources resources){
        this.mContext = context;
        this.mResource = resources;
    }*/

    // 获得父列表分组个数
    @Override
    public int getGroupCount() {
        return groupTitle.length;

    }

    //获得子列表分组个数
    @Override
    public int getChildrenCount(int groupPosition) {
        return childTitle[groupPosition].length;
    }

    //获得父列表项
    @Override
    public Object getGroup(int groupPosition) {
        return groupTitle[groupPosition];
    }

    //获得子列表项
    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return childTitle[groupPosition][childPosition];
    }

    //获得父列表ID ID唯一
    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    //获得子列表ID ID唯一
    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    //父列表和子列表是否持有稳定ID，底层数据的改变会不会影响到他们
    @Override
    public boolean hasStableIds() {
        return true;
    }

    //获得父列表项内容

    /**
     * groupPosition 组位置
     * isExpanded 该组是展开状态还是伸缩状态
     * convertView 重用已有的视图对象
     * parent 返回的视图对象始终依附于的视图组
     * Zxuuuuuu
     * 2019/1/2,10:55
     */
    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        GroupViewHolder groupViewHolder;
        if (convertView == null) {
            groupViewHolder = new GroupViewHolder();
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.repair_mission_expand_group,
                    parent, false);
            groupViewHolder.tvTitle = convertView.findViewById(R.id.repair_mission_group);
            convertView.setTag(groupViewHolder);
        } else {
            groupViewHolder = (GroupViewHolder) convertView
                    .getTag();
        }
        groupViewHolder.tvTitle.setText(groupTitle[groupPosition]);
        return convertView;
    }

    //获得子列表项内容

    /**
     * groupPosition 组位置
     * childPosition 子元素位置
     * isLastChild 子元素是否处于组中的最后一个
     * convertView 重用已有的视图(View)对象
     * parent 返回的视图(View)对象始终依附于的视图组
     * Zxuuuuuu
     * 2019/1/2,10:56
     */
    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {

        ChildViewHolder childViewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.repair_mission_expend_child, parent, false);
            childViewHolder = new ChildViewHolder();
            childViewHolder.tvTitle = convertView.findViewById(R.id.repair_mission_child);
            convertView.setTag(childViewHolder);
        } else {
            childViewHolder = (ChildViewHolder) convertView.getTag();

        }
        childViewHolder.tvTitle.setText(childTitle[groupPosition][childPosition]);

        return convertView;
    }

    //判断是否开启触发事件监听 return true 为开启
    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

    static class GroupViewHolder {
        TextView tvTitle;
    }

    static class ChildViewHolder {
        TextView tvTitle;
    }
}
