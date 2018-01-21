package com.github.andrejnazarov.spacex.model;

import android.content.Context;

import com.github.andrejnazarov.spacex.R;
import com.github.andrejnazarov.spacex.bean.LaunchItem;
import com.github.andrejnazarov.spacex.presenter.MainPresenter;

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

    public MainModel(MainPresenter presenter, Context context) {
        mPresenter = presenter;
        mContext = context;
    }

    public void getData() {
        List<LaunchItem> items = new ArrayList<>();
        if (hasConnection()) {
            // TODO: 21.01.18 get Data from web
        } else {
            Writer writer = new StringWriter();
            char[] buffer = new char[1024];
            try  {
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

            String jsonString = writer.toString();
        }
        mPresenter.showData(items);
    }

    private boolean hasConnection() {
        return false; // TODO: 21.01.18 implement later
    }
}