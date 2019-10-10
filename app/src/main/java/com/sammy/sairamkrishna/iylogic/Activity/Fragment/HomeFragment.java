package com.sammy.sairamkrishna.iylogic.Activity.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.sammy.sairamkrishna.iylogic.Activity.Activity.MainActivity;
import com.sammy.sairamkrishna.iylogic.R;

import java.util.ArrayList;


public class HomeFragment extends Fragment {
    MainActivity mainActivity;

    View frm;

    private ViewPager mViewPager;
    private TabLayout mTabLayout_1;
    private ArrayList<Fragment> mFragments = new ArrayList<>();
    String mTitles[]= new String[]{"Soils","Nutrition","Crops","Irrigation"};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        frm = inflater.inflate(R.layout.fragment_home, container, false);



        return frm;
    }

    @Override
    public void onResume() {
        super.onResume();
        mViewPager=(ViewPager)frm.findViewById(R.id.viewpager);
        mTabLayout_1=(TabLayout) frm.findViewById(R.id.tab);
        mTabLayout_1.setupWithViewPager(mViewPager);

        mainActivity.imageHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mViewPager.setCurrentItem(0, true);
            }
        });


        mFragments.add(new FragmentSoils());
        mFragments.add(new FragmentNutrition());
        mFragments.add(new FragmentCrops());
        mFragments.add(new FragmentIrrigation());

        mViewPager.setAdapter(new MyPagerAdapter(getChildFragmentManager()));
    }

    private class MyPagerAdapter extends FragmentPagerAdapter {
        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public int getCount() {
            return mFragments.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mTitles[position];
        }

        @Override
        public Fragment getItem(int position) {
            return mFragments.get(position);
        }
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.mainActivity=(MainActivity)context;
    }
}
