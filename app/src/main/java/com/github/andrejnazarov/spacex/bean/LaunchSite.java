package com.github.andrejnazarov.spacex.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * @author Nazarov on 21.01.18.
 */

public final class LaunchSite implements Parcelable {

    public static final ClassCreator CREATOR = new ClassCreator();
    public static final String ID = "site_id";
    public static final String NAME = "site_name";
    public static final String NAME_LONG = "site_name_long";
    
    private final String mId;
    private final String mName;
    private final String mNameLong;

    public LaunchSite(String id, 
                      String name, 
                      String nameLong) {
        mId = id;
        mName = name;
        mNameLong = nameLong;
    }

    protected LaunchSite(Parcel in) {
        mId = in.readString();
        mName = in.readString();
        mNameLong = in.readString();
    }

    public String getId() {
        return mId;
    }

    public String getName() {
        return mName;
    }

    public String getNameLong() {
        return mNameLong;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LaunchSite that = (LaunchSite) o;

        if (mId != null ? !mId.equals(that.mId) : that.mId != null) return false;
        if (mName != null ? !mName.equals(that.mName) : that.mName != null) return false;
        return mNameLong != null ? mNameLong.equals(that.mNameLong) : that.mNameLong == null;
    }

    @Override
    public int hashCode() {
        int result = mId != null ? mId.hashCode() : 0;
        result = 31 * result + (mName != null ? mName.hashCode() : 0);
        result = 31 * result + (mNameLong != null ? mNameLong.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("LaunchSite{");
        sb.append("mId='").append(mId).append('\'');
        sb.append(", mName='").append(mName).append('\'');
        sb.append(", mNameLong='").append(mNameLong).append('\'');
        sb.append('}');
        return sb.toString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mId);
        dest.writeString(mName);
        dest.writeString(mNameLong);
    }

    private static final class ClassCreator implements Creator<LaunchSite> {
        @Override
        public LaunchSite createFromParcel(Parcel source) {
            return new LaunchSite(source);
        }

        @Override
        public LaunchSite[] newArray(int size) {
            return new LaunchSite[size];
        }
    }
}