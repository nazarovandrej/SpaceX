package com.github.andrejnazarov.spacex.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * @author Nazarov on 21.01.18.
 */

public final class Rocket implements Parcelable {

    public static final ClassCreator CREATOR = new ClassCreator();
    public static final String ID = "rocket_id";
    public static final String NAME = "rocket_name";
    public static final String TYPE = "rocket_type";
    public static final String FIRST_STAGE = "first_stage";
    public static final String SECOND_STAGE = "second_stage";

    private final String mId;
    private final String mName;
    private final String mType;
    private final FirstStage mFirstStage;
    private final SecondStage mSecondStage;

    public Rocket(String id,
                  String name,
                  String type,
                  FirstStage firstStage,
                  SecondStage secondStage) {
        mId = id;
        mName = name;
        mType = type;
        mFirstStage = firstStage;
        mSecondStage = secondStage;
    }

    protected Rocket(Parcel in) {
        mId = in.readString();
        mName = in.readString();
        mType = in.readString();
        mFirstStage = in.readParcelable(FirstStage.class.getClassLoader());
        mSecondStage = in.readParcelable(SecondStage.class.getClassLoader());
    }

    public String getId() {
        return mId;
    }

    public String getName() {
        return mName;
    }

    public String getType() {
        return mType;
    }

    public FirstStage getFirstStage() {
        return mFirstStage;
    }

    public SecondStage getSecondStage() {
        return mSecondStage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Rocket rocket = (Rocket) o;

        if (mId != null ? !mId.equals(rocket.mId) : rocket.mId != null) return false;
        if (mName != null ? !mName.equals(rocket.mName) : rocket.mName != null) return false;
        if (mType != null ? !mType.equals(rocket.mType) : rocket.mType != null) return false;
        if (mFirstStage != null ? !mFirstStage.equals(rocket.mFirstStage) : rocket.mFirstStage != null)
            return false;
        return mSecondStage != null ? mSecondStage.equals(rocket.mSecondStage) : rocket.mSecondStage == null;
    }

    @Override
    public int hashCode() {
        int result = mId != null ? mId.hashCode() : 0;
        result = 31 * result + (mName != null ? mName.hashCode() : 0);
        result = 31 * result + (mType != null ? mType.hashCode() : 0);
        result = 31 * result + (mFirstStage != null ? mFirstStage.hashCode() : 0);
        result = 31 * result + (mSecondStage != null ? mSecondStage.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Rocket{");
        sb.append("mId='").append(mId).append('\'');
        sb.append(", mName='").append(mName).append('\'');
        sb.append(", mType='").append(mType).append('\'');
        sb.append(", mFirstStage=").append(mFirstStage);
        sb.append(", mSecondStage=").append(mSecondStage);
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
        dest.writeString(mType);
        dest.writeParcelable(mFirstStage, flags);
        dest.writeParcelable(mSecondStage, flags);
    }

    private static final class ClassCreator implements Creator<Rocket> {
        @Override
        public Rocket createFromParcel(Parcel source) {
            return new Rocket(source);
        }

        @Override
        public Rocket[] newArray(int size) {
            return new Rocket[size];
        }
    }
}