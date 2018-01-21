package com.github.andrejnazarov.spacex.model;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author Nazarov on 21.01.18.
 */

final class WebExecutionThread extends Thread {

    private static final String SPACE_X_URL = "https://api.spacexdata.com/v2/launches?launch_year=2017";
    private Future mJsonFuture;

    @Override
    public void run() {
        super.run();

        ExecutorService service = Executors.newSingleThreadExecutor();

        mJsonFuture = service.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                StringBuilder builder = new StringBuilder();
                HttpURLConnection urlConnection = null;
                try {
                    URL url = new URL(SPACE_X_URL);
                    urlConnection = (HttpURLConnection) url.openConnection();
                    InputStream in = new BufferedInputStream(urlConnection.getInputStream());
                    BufferedReader reader = new BufferedReader(new InputStreamReader(in));

                    String line;
                    while ((line = reader.readLine()) != null) {
                        builder.append(line);
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    if (urlConnection != null) {
                        urlConnection.disconnect();
                    }
                }
                return builder.toString();
            }
        });
    }

    String getJson() {
        try {
            join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String json = null;
        try {
            json = (String) mJsonFuture.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return json;
    }
}