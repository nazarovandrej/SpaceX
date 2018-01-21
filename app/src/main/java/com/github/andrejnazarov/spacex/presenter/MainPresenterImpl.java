package com.github.andrejnazarov.spacex.presenter;

import android.content.Context;

import com.github.andrejnazarov.spacex.bean.LaunchItem;
import com.github.andrejnazarov.spacex.model.MainModel;
import com.github.andrejnazarov.spacex.view.MainView;

import java.util.List;

/**
 * @author Nazarov on 21.01.18.
 */

public class MainPresenterImpl implements MainPresenter {

    private final MainView mMainView;
    private final MainModel mMainModel;

    public MainPresenterImpl(MainView mainView, Context context) {
        mMainView = mainView;
        mMainModel = new MainModel(this, context);
    }

    @Override
    public void onCreate() {
        mMainModel.getData();
    }

    @Override
    public void showData(List<LaunchItem> launchItems) {
        mMainView.showData(launchItems);
    }
}