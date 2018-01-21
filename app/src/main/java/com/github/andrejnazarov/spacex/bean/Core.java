package com.github.andrejnazarov.spacex.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * @author Nazarov on 21.01.18.
 */

public final class Core implements Parcelable {

    public static final ClassCreator CREATOR = new ClassCreator();
    public static final String CORE_SERIAL = "core_serial";
    public static final String REUSED = "reused";
    public static final String LAND_SUCCESS = "land_success";
    public static final String LANDING_TYPE = "landing_type";
    public static final String LANDING_VEHICLE = "landing_vehicle";

    private final String mCoreSerial;
    private final boolean mReused;
    private final boolean mLandSuccess;
    private final String mLandingType;
    private final String mLandingVehicle;

    Core(Parcel in) {
        mCoreSerial = in.readString();
        mReused = in.readByte() != 0;
        mLandSuccess = in.readByte() != 0;
        mLandingType = in.readString();
        mLandingVehicle = in.readString();
    }

    public Core(String coreSerial,
                boolean reused,
                boolean landSuccess,
                String landingType,
                String landingVehicle) {
        mCoreSerial = coreSerial;
        mReused = reused;
        mLandSuccess = landSuccess;
        mLandingType = landingType;
        mLandingVehicle = landingVehicle;
    }

    public String getCoreSerial() {
        return mCoreSerial;
    }

    public boolean isReused() {
        return mReused;
    }

    public boolean isLandSuccess() {
        return mLandSuccess;
    }

    public String getLandingType() {
        return mLandingType;
    }

    public String getLandingVehicle() {
        return mLandingVehicle;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Core core = (Core) o;

        if (mReused != core.mReused) return false;
        if (mLandSuccess != core.mLandSuccess) return false;
        if (mCoreSerial != null ? !mCoreSerial.equals(core.mCoreSerial) : core.mCoreSerial != null)
            return false;
        if (mLandingType != null ? !mLandingType.equals(core.mLandingType) : core.mLandingType != null)
            return false;
        return mLandingVehicle != null ? mLandingVehicle.equals(core.mLandingVehicle) : core.mLandingVehicle == null;
    }

    @Override
    public int hashCode() {
        int result = mCoreSerial != null ? mCoreSerial.hashCode() : 0;
        result = 31 * result + (mReused ? 1 : 0);
        result = 31 * result + (mLandSuccess ? 1 : 0);
        result = 31 * result + (mLandingType != null ? mLandingType.hashCode() : 0);
        result = 31 * result + (mLandingVehicle != null ? mLandingVehicle.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Core{");
        sb.append("mCoreSerial='").append(mCoreSerial).append('\'');
        sb.append(", mReused=").append(mReused);
        sb.append(", mLandSuccess=").append(mLandSuccess);
        sb.append(", mLandingType='").append(mLandingType).append('\'');
        sb.append(", mLandingVehicle='").append(mLandingVehicle).append('\'');
        sb.append('}');
        return sb.toString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mCoreSerial);
        dest.writeByte(mReused ? (byte) 1 : (byte) 0);
        dest.writeByte(mLandSuccess ? (byte) 1 : (byte) 0);
        dest.writeString(mLandingType);
        dest.writeString(mLandingVehicle);
    }

    private static final class ClassCreator implements Creator<Core> {
        @Override
        public Core createFromParcel(Parcel source) {
            return new Core(source);
        }

        @Override
        public Core[] newArray(int size) {
            return new Core[size];
        }
    }
}