package com.github.andrejnazarov.spacex.bean;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * @author Nazarov on 21.01.18.
 */

public final class FirstStage implements Parcelable {

    public static final ClassCreator CREATOR = new ClassCreator();
    public static final String CORES = "cores";

    private final List<Core> mCores;

    public FirstStage(List<Core> cores) {
        mCores = cores;
    }

    protected FirstStage(Parcel in) {
        mCores = in.createTypedArrayList(Core.CREATOR);
    }

    public List<Core> getCores() {
        return mCores;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FirstStage that = (FirstStage) o;

        return mCores != null ? mCores.equals(that.mCores) : that.mCores == null;
    }

    @Override
    public int hashCode() {
        return mCores != null ? mCores.hashCode() : 0;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("FirstStage{");
        sb.append("mCores=").append(mCores);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedList(mCores);
    }

    private static final class ClassCreator implements Creator<FirstStage> {
        @Override
        public FirstStage createFromParcel(Parcel source) {
            return new FirstStage(source);
        }

        @Override
        public FirstStage[] newArray(int size) {
            return new FirstStage[size];
        }
    }
}