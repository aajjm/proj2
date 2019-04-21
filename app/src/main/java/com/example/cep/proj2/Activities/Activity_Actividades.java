package com.example.cep.proj2.Activities;

import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import com.example.cep.proj2.Clases.ClaseActividad;
import com.example.cep.proj2.Clases.ClaseEntidad;
import com.example.cep.proj2.Clases.utils;
import com.example.cep.proj2.Fragments.actividades_assignadas;
import com.example.cep.proj2.Fragments.actividades_demandadas;
import com.example.cep.proj2.R;

import java.util.ArrayList;

public class Activity_Actividades extends AppCompatActivity implements ActionBar.TabListener, ViewPager.OnPageChangeListener {


    private SectionsPagerAdapter mSectionsPagerAdapter;
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__actividades);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(mViewPager));
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        getSupportActionBar().setSelectedNavigationItem(position);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {

    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }

    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {

            Fragment tabFragment = null;

            switch (position){
                case 0:
                    tabFragment = new actividades_assignadas();
                    break;
                case 1:
                    tabFragment = new actividades_demandadas();
                    break;
            }
            return tabFragment;
        }

        //--------CANTIDAD DE PESTAÑAS--------//
        @Override
        public int getCount()
        {
            return 2;
        }

        //--------TITULOS PESTAÑAS---------//
        @Override
        public CharSequence getPageTitle(int position)
        {
            String section = null;

            switch (position)
            {
                case 0:
                    section = "Actividades assignadas";
                    break;
                case 1:
                    section = "Actividades demandadas";
                    break;
            }
            return section;
        }
    }
}
