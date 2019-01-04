package hangtian.com.guanlangmaster.fragments.home;


import android.app.Activity;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import hangtian.com.guanlangmaster.R;
import hangtian.com.guanlangmaster.sharedPreference.SharedPreferencesUtils;
import hangtian.com.guanlangmaster.ui.LoginActivity;
import hangtian.com.guanlangmaster.utils.MyApplication;
import hangtian.com.guanlangmaster.utils.ScreenManager;

public class Setting extends Fragment {

    private Button logout;
    private EditText ipAddress;
    private EditText portNumber;

    public Setting() {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.setting_fragment, container, false);
        logout = view.findViewById(R.id.logout);
        ipAddress = view.findViewById(R.id.ip_address);
        portNumber = view.findViewById(R.id.port_number);
        final LinearLayout statusLayout = view.findViewById(R.id.statusLayout);
        ScreenManager.SetStatus(MyApplication.getContext(), statusLayout);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), LoginActivity.class));
                SharedPreferencesUtils helper = new SharedPreferencesUtils(MyApplication.getContext(),
                        "setting");
                helper.putValues(
                        new SharedPreferencesUtils.ContentValue("remember", false),
                        new SharedPreferencesUtils.ContentValue("user+name", ""),
                        new SharedPreferencesUtils.ContentValue("password", ""));
            }
        });
        return view;

    }

}
