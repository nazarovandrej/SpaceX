package com.github.andrejnazarov.spacex.model;

import android.graphics.Bitmap;

import com.github.andrejnazarov.spacex.presenter.PagePresenter;

/**
 * @author Nazarov on 21.01.18.
 */

public final class PageModel implements BitmapCallback {

    private final PagePresenter mPagePresenter;

    public PageModel(PagePresenter pagePresenter) {
        mPagePresenter = pagePresenter;
    }

    public void getBitmap(String url) {
        BitmapExecutionThread thread = new BitmapExecutionThread(this, url);
        thread.start();
    }

    @Override
    public void provideBitmap(Bitmap bitmap) {
        mPagePresenter.showImage(bitmap);
    }
}