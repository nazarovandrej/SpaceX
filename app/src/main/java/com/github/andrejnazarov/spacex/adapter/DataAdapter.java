package com.github.andrejnazarov.spacex.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.github.andrejnazarov.spacex.bean.LaunchItem;
import com.github.andrejnazarov.spacex.view.MainFragment;

import java.util.List;

/**
 * @author Nazarov on 21.01.18.
 */

public class DataAdapter extends FragmentStatePagerAdapter {

    private final List<LaunchItem> mItems;

    public DataAdapter(FragmentManager fm, List<LaunchItem> items) {
        super(fm);
        mItems = items;
    }

    @Override
    public Fragment getItem(int position) {
        LaunchItem item = null;
        if (mItems != null && !mItems.isEmpty() && mItems.size() > position) {
            item = mItems.get(position);
        }
        return MainFragment.newInstance(item);
    }

    @Override
    public int getCount() {
        return mItems == null ? 0 : mItems.size();
    }
}