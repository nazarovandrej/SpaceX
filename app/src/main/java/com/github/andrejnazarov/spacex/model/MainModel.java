package com.github.andrejnazarov.spacex.model;

import android.content.Context;

import com.github.andrejnazarov.spacex.R;
import com.github.andrejnazarov.spacex.bean.LaunchItem;
import com.github.andrejnazarov.spacex.presenter.MainPresenter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Nazarov on 21.01.18.
 */

public class MainModel {

    private final MainPresenter mPresenter;
    private final LaunchItemMapper mMapper;
    private final RawResourceReader mReader;
    private List<LaunchItem> mLaunchItems;

    public MainModel(MainPresenter presenter, Context context) {
        mPresenter = presenter;
        mMapper = new LaunchItemMapper();
        mReader = new RawResourceReader(context);
    }

    public void getData() {
        mLaunchItems = new ArrayList<>();
        if (hasConnection()) {
            WebExecutionThread thread = new WebExecutionThread();
            thread.start();
            setData(thread.getJson());
        } else {
            String jsonStub = mReader.getJsonString(R.raw.response);
            setData(jsonStub);
        }
        mPresenter.showData(mLaunchItems);
    }

    private void setData(String jsonString) {
        try {
            JSONArray jsonArray = new JSONArray(jsonString);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                mLaunchItems.add(mMapper.getItem(jsonObject));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private boolean hasConnection() {
        return false; // TODO: 21.01.18 implement later
    }
}