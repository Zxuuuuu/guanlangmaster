package hangtian.com.guanlangmaster.adapters;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import hangtian.com.guanlangmaster.R;

/**
 *基础下拉框适配器
 *Zxuuuuuu
 *2018/12/27,15:34
 */
public class SpinnerAdapter extends ArrayAdapter<String> {

    Context context;
    List<String> mStringArray;
    public SpinnerAdapter(Context context ,int resource, List<String> objects){
        super(context,resource,objects);
        this.context = context;
        mStringArray = objects;
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {

        if (convertView == null){
            convertView = LayoutInflater.from(context).
                    inflate(R.layout.spinner_item_drop,parent,false);
        }
        LinearLayout dividerLine = convertView.findViewById(R.id.spinner_divider);
        if (position == 0){
            dividerLine.setVisibility(View.GONE);

        }else{
            dividerLine.setVisibility(View.VISIBLE);

        }
        TextView textView = convertView.findViewById(R.id.spinner_text1);
        textView.setText(mStringArray.get(position));
        return convertView;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView ==null){
            convertView = LayoutInflater.from(context).inflate
                    (android.R.layout.simple_spinner_item,parent,false);
        }

        TextView textView = convertView.findViewById(android.R.id.text1);
        textView.setText(mStringArray.get(position));
        textView.setTextColor(Color.parseColor("#000000"));
        textView.setTextSize(16);

        return convertView;
    }
}
