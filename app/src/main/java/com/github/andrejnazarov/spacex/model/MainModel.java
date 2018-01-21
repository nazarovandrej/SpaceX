package com.github.andrejnazarov.spacex.model;

import android.content.Context;

import com.github.andrejnazarov.spacex.R;
import com.github.andrejnazarov.spacex.bean.LaunchItem;
import com.github.andrejnazarov.spacex.presenter.MainPresenter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Nazarov on 21.01.18.
 */

public class MainModel {

    private final MainPresenter mPresenter;
    private final Context mContext;
    private final LaunchItemMapper mMapper;
    private List<LaunchItem> mLaunchItems;

    public MainModel(MainPresenter presenter, Context context) {
        mPresenter = presenter;
        mContext = context;
        mMapper = new LaunchItemMapper();
    }

    public void getData() {
        mLaunchItems = new ArrayList<>();
        if (hasConnection()) {
            // TODO: 21.01.18 get Data from web
        } else {
            String jsonStub = getJsonString();
            try {
                setData(jsonStub);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        mPresenter.showData(mLaunchItems);
    }

    private void setData(String jsonStub) throws JSONException {
        JSONArray jsonArray = new JSONArray(jsonStub);
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            mLaunchItems.add(mMapper.getItem(jsonObject));
        }
    }

    private String getJsonString() {
        Writer writer = new StringWriter();
        char[] buffer = new char[1024];
        try {
            InputStream is = mContext.getResources().openRawResource(R.raw.response);
            Reader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            int n;
            while ((n = reader.read(buffer)) != -1) {
                writer.write(buffer, 0, n);
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return writer.toString();
    }

    private boolean hasConnection() {
        return false; // TODO: 21.01.18 implement later
    }
}