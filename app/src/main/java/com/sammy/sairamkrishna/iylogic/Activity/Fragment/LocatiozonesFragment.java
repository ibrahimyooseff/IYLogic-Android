package com.sammy.sairamkrishna.iylogic.Activity.Fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sammy.sairamkrishna.iylogic.Activity.Activity.MainActivity;
import com.sammy.sairamkrishna.iylogic.Activity.Constant.Constant;
import com.sammy.sairamkrishna.iylogic.R;


public class LocatiozonesFragment extends Fragment {
    MainActivity mainActivity;
    View view;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_locatiozones, container, false);
        Constant.toptext.setText("Location zones");

        mainActivity.imageHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainActivity.openFragment(new HomeFragment());
            }
        });
        return view;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.mainActivity=(MainActivity)context;
    }



}
