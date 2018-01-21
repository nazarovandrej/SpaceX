package com.github.andrejnazarov.spacex.model;

import android.content.Context;
import android.support.annotation.RawRes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;

/**
 * @author Nazarov on 21.01.18.
 */

final class RawResourceReader {

    private final Context mContext;

    RawResourceReader(Context context) {
        mContext = context;
    }

    String getJsonString(@RawRes int rawResId) {
        Writer writer = new StringWriter();
        char[] buffer = new char[1024];
        try {
            InputStream is = mContext.getResources().openRawResource(rawResId);
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
}