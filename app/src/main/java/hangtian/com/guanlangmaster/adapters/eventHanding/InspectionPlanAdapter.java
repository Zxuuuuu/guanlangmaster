package hangtian.com.guanlangmaster.adapters.eventHanding;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.List;
import hangtian.com.guanlangmaster.R;
import hangtian.com.guanlangmaster.javabeans.InspectionPlanTitleAndMessage;

public class InspectionPlanAdapter extends ArrayAdapter<InspectionPlanTitleAndMessage>{
    private Context mContext;
    private int mResource;

    public InspectionPlanAdapter(@NonNull Context context, int resource,
                                        @NonNull List<InspectionPlanTitleAndMessage> objects) {
        super(context, resource, objects);
        mContext = context;
        mResource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        InspectionPlanTitleAndMessage titleAndMessage = getItem(position);
        View view;
        ViewHolder viewHolder;
        if (convertView == null) {
            view = LayoutInflater.from(mContext).inflate(mResource, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.tvTitle = view.findViewById(R.id.title);
            viewHolder.tvStartTime = view.findViewById(R.id.start_time);
            viewHolder.tvActionCycle = view.findViewById(R.id.action_cycle);
            viewHolder.tvArea = view.findViewById(R.id.area);
            viewHolder.tvMissionState = view.findViewById(R.id.mission_state);
            view.setTag(viewHolder);
        } else {
            view = convertView;
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.tvTitle.setText(titleAndMessage.getTitle());
        viewHolder.tvStartTime.setText(titleAndMessage.getStartTime());
        viewHolder.tvActionCycle.setText(titleAndMessage.getActionCycle());
        viewHolder.tvArea.setText(titleAndMessage.getArea());
        viewHolder.tvMissionState.setText(titleAndMessage.getMissionState());

        return view;
    }

    class ViewHolder {
        TextView tvTitle;
        TextView tvStartTime;
        TextView tvActionCycle;
        TextView tvArea;
        TextView tvMissionState;
    }


}