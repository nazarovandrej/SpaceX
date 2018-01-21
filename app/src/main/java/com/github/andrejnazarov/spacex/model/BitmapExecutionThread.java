package com.github.andrejnazarov.spacex.model;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.InputStream;
import java.net.URL;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author Nazarov on 21.01.18.
 */

public class BitmapExecutionThread extends Thread {

    private final String mUrl;
    private final BitmapCallback mCallback;

    public BitmapExecutionThread(BitmapCallback callback, String url) {
        mCallback = callback;
        mUrl = url;
    }

    @Override
    public void run() {
        super.run();

        ExecutorService service = Executors.newSingleThreadExecutor();
        Future futureBitmap = service.submit(new Callable<Bitmap>() {
            @Override
            public Bitmap call() throws Exception {
                InputStream stream = new URL(mUrl).openStream();
                return BitmapFactory.decodeStream(stream);
            }
        });

        try {
            Bitmap bitmap = (Bitmap) futureBitmap.get();
            mCallback.provideBitmap(bitmap);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}