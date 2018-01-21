package com.github.andrejnazarov.spacex.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * @author Nazarov on 21.01.18.
 */

public class LaunchItem implements Parcelable {

    public static final ClassCreator CREATOR = new ClassCreator();

    protected LaunchItem(Parcel in) {
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
    }

    private static final class ClassCreator implements Creator<LaunchItem> {
        @Override
        public LaunchItem createFromParcel(Parcel in) {
            return new LaunchItem(in);
        }

        @Override
        public LaunchItem[] newArray(int size) {
            return new LaunchItem[size];
        }
    }
}