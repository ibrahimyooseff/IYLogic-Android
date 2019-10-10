package com.sammy.sairamkrishna.iylogic.Activity.Activity;

import androidx.annotation.NonNull;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;
import com.sammy.sairamkrishna.iylogic.Activity.Constant.Constant;
import com.sammy.sairamkrishna.iylogic.Activity.Dilaog.Logout;
import com.sammy.sairamkrishna.iylogic.Activity.Fragment.FragmentCrops;
import com.sammy.sairamkrishna.iylogic.Activity.Fragment.FragmentIrrigation;
import com.sammy.sairamkrishna.iylogic.Activity.Fragment.FragmentNutrition;
import com.sammy.sairamkrishna.iylogic.Activity.Fragment.FragmentSoils;
import com.sammy.sairamkrishna.iylogic.Activity.Fragment.HomeFragment;
import com.sammy.sairamkrishna.iylogic.Activity.Fragment.LeafwetnessFragment;
import com.sammy.sairamkrishna.iylogic.Activity.Fragment.LocatiozonesFragment;
import com.sammy.sairamkrishna.iylogic.Activity.Fragment.WaterlevelFragment;
import com.sammy.sairamkrishna.iylogic.Activity.Fragment.WeatherFragment;
import com.sammy.sairamkrishna.iylogic.R;

import java.util.ArrayList;

public class MainActivity extends FragmentActivity implements View.OnClickListener , NavigationView.OnNavigationItemSelectedListener{
    private ImageView imageMenu;
    public ImageView imageHome;
    DrawerLayout drawerLayout;
    NavigationView nvMenu;
    View menuHeader;

    Fragment currentFragment1;
    Fragment currentFragment2;
    Fragment currentFragment3;
    Fragment currentFragment4;
    Fragment currentFragment5;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout = (DrawerLayout)findViewById(R.id.drawerLayout);

        nvMenu = (NavigationView)findViewById(R.id.nvMenu); nvMenu.setNavigationItemSelectedListener(this);
        menuHeader = nvMenu.getHeaderView(0);


        imageMenu = (ImageView) findViewById(R.id.imv_menu); imageMenu.setOnClickListener(this);
        imageHome = (ImageView) findViewById(R.id.imv_home);
        Constant.toptext = findViewById(R.id.topTxt);

        openFragment(new HomeFragment());
    }

    public void openFragment(Fragment frm){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frmContainer, frm);
        transaction.commit();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.imv_menu:
                drawerLayout.openDrawer(GravityCompat.START);
                break;

        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull final MenuItem menuItem) {

        drawerLayout.closeDrawers();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                showFragment(menuItem);
                //drawerLayout.closeDrawers();
            }
        }, 300);

        return true;
    }
    private void showFragment(MenuItem menuItem){

        switch (menuItem.getItemId()){
            case R.id.waterleve:
                currentFragment1 =new  WaterlevelFragment();
                openFragment(currentFragment1);
                break;
            case R.id.weather:

                currentFragment2 = new WeatherFragment();
                openFragment(currentFragment2);
                break;
            case R.id.leafwitness:
                currentFragment3 = new LeafwetnessFragment();
                openFragment(currentFragment3);
                break;

            case R.id.locationzones:
                currentFragment4 = new LocatiozonesFragment();
                openFragment(currentFragment4);
                break;
            case R.id.logout:

                Logout pcdd = new Logout( this );
                pcdd.getWindow().setBackgroundDrawable( new ColorDrawable( Color.TRANSPARENT ) );
                pcdd.show();

//            case R.id.weather:
//                currentFragment2 = WeatherFragment.newInstance();
//                openFragment(currentFragment2);
//                break;
//
//            case R.id.leafwitness:
//                currentFragment3 = LeafwetnessFragment.newInstance();
//                openFragment(currentFragment3);
//                break;
//            case R.id.locationzones:
//                currentFragment4 = LocatiozonesFragment.newInstance();
//                openFragment(currentFragment4);
        }
    }
}