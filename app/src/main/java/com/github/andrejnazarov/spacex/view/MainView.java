package com.github.andrejnazarov.spacex.view;

import com.github.andrejnazarov.spacex.bean.LaunchItem;

import java.util.List;

/**
 * @author Nazarov on 21.01.18.
 */

public interface MainView {

    void showData(List<LaunchItem> launchItems);
}