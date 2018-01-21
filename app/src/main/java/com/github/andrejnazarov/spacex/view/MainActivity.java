package com.github.andrejnazarov.spacex.view;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.andrejnazarov.spacex.R;
import com.github.andrejnazarov.spacex.adapter.DataAdapter;
import com.github.andrejnazarov.spacex.bean.LaunchItem;
import com.github.andrejnazarov.spacex.presenter.MainPresenter;
import com.github.andrejnazarov.spacex.presenter.MainPresenterImpl;

import java.util.List;

public class MainActivity extends AppCompatActivity
        implements MainView, MainFragment.OnFragmentInteractionListener {

    private ViewPager mViewPager;
    private MainPresenter mMainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mViewPager = findViewById(R.id.view_pager);
        mMainPresenter = new MainPresenterImpl(this, this);
        mMainPresenter.onCreate();
    }

    @Override
    public void showData(List<LaunchItem> launchItems) {
        DataAdapter adapter = new DataAdapter(getSupportFragmentManager(), launchItems);
        mViewPager.setAdapter(adapter);
    }

    @Override
    public void onFragmentInteraction(String url) {
        // TODO: 21.01.18 fill out
    }
}