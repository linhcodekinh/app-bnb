package com.example.sslost.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.sslost.Activity.LoginActivity;
import com.example.sslost.Activity.SettingsActivity;
import com.example.sslost.R;

public class FragmentProfile  extends Fragment {
    LinearLayout llSetting;
    LinearLayout llLogin;


    public FragmentProfile() {
        // Required empty public constructor
    }

    public static FragmentProfile newInstance() {
        return new FragmentProfile();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        llSetting = view.findViewById(R.id.ll_settings);
        llLogin = view.findViewById(R.id.ll_login);

        llSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(getContext(), SettingsActivity.class);
                startActivity(it);
            }
        });
        llLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), LoginActivity.class));
            }
        });

        return view;
    }
}
