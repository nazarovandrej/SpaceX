package com.github.andrejnazarov.spacex.presenter;

import com.github.andrejnazarov.spacex.view.PageView;

/**
 * @author Nazarov on 21.01.18.
 */

public interface PagePresenter extends PageView {

    void getBitmap(String url);
}