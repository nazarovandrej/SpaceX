package com.github.andrejnazarov.spacex.bean;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * @author Nazarov on 21.01.18.
 */

public final class Links implements Parcelable {

    public static final ClassCreator CREATOR = new ClassCreator();
    private final List<String> mLinks;

    public Links(List<String> links) {
        mLinks = links;
    }

    public List<String> getLinks() {
        return mLinks;
    }

    protected Links(Parcel in) {
        mLinks = in.createStringArrayList();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Links links = (Links) o;

        return mLinks != null ? mLinks.equals(links.mLinks) : links.mLinks == null;
    }

    @Override
    public int hashCode() {
        return mLinks != null ? mLinks.hashCode() : 0;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Links{");
        sb.append("mLinks=").append(mLinks);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeStringList(mLinks);
    }

    private static final class ClassCreator implements Creator<Links> {
        @Override
        public Links createFromParcel(Parcel source) {
            return new Links(source);
        }

        @Override
        public Links[] newArray(int size) {
            return new Links[size];
        }
    }
}
