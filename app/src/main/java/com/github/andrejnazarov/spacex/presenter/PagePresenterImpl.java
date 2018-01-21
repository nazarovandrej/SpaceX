package com.github.andrejnazarov.spacex.presenter;

import android.graphics.Bitmap;

import com.github.andrejnazarov.spacex.model.PageModel;
import com.github.andrejnazarov.spacex.view.PageView;

/**
 * @author Nazarov on 21.01.18.
 */

public final class PagePresenterImpl implements PagePresenter {

    private final PageView mPageView;
    private final PageModel mPageModel;

    public PagePresenterImpl(PageView pageView) {
        mPageView = pageView;
        mPageModel = new PageModel(this);
    }

    @Override
    public void getBitmap(String url) {
        mPageModel.getBitmap(url);
    }

    @Override
    public void showImage(Bitmap bitmap) {
        mPageView.showImage(bitmap);
    }
}