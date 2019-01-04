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
import hangtian.com.guanlangmaster.javabeans.InspectionMissionTitleAndMessage;

public class InspectionMissionListAdapter extends ArrayAdapter<InspectionMissionTitleAndMessage> {
    private Context mContext;
    private int mResource;
    public InspectionMissionListAdapter(@NonNull Context context, int resource,
                                        @NonNull List<InspectionMissionTitleAndMessage> objects) {
        super(context, resource, objects);
        mContext = context;
        mResource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        InspectionMissionTitleAndMessage titleAndMessage = getItem(position);
        View view;
        ViewHolder viewHolder;
        if (convertView == null) {
            view = LayoutInflater.from(mContext).inflate(mResource, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.tvTitle = view.findViewById(R.id.title);
            viewHolder.tvStartTime = view.findViewById(R.id.start_time);
            viewHolder.tvEstimatedTime = view.findViewById(R.id.estimated_time);
            viewHolder.tvArea = view.findViewById(R.id.area);
            viewHolder.tvMissionState = view.findViewById(R.id.mission_state);
            view.setTag(viewHolder);
        } else {
            view = convertView;
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.tvTitle.setText(titleAndMessage.getTitle());
        viewHolder.tvStartTime.setText(titleAndMessage.getStartTime());
        viewHolder.tvEstimatedTime.setText(titleAndMessage.getEstimatedTime());
        viewHolder.tvArea.setText(titleAndMessage.getArea());
        viewHolder.tvMissionState.setText(titleAndMessage.getMissionState());

        return view;
    }

    class ViewHolder{
        TextView tvTitle;
        TextView tvStartTime;
        TextView tvEstimatedTime;
        TextView tvArea;
        TextView tvMissionState;
    }


}
