package com.github.andrejnazarov.spacex.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * @author Nazarov on 21.01.18.
 */

public final class Reuse implements Parcelable {

    public static final ClassCreator CREATOR = new ClassCreator();
    public static final String CORE = "core";
    public static final String SIDE_CORE_1 = "side_core1";
    public static final String SIDE_CORE_2 = "side_core2";
    public static final String FAIRINGS = "fairings";
    public static final String CAPSULE = "capsule";

    private final boolean mCore;
    private final boolean mSideCore1;
    private final boolean mSideCore2;
    private final boolean mFairings;
    private final boolean mCapsule;

    public Reuse(boolean core,
                 boolean sideCore1,
                 boolean sideCore2,
                 boolean fairiings,
                 boolean capsule) {
        mCore = core;
        mSideCore1 = sideCore1;
        mSideCore2 = sideCore2;
        mFairings = fairiings;
        mCapsule = capsule;
    }

    protected Reuse(Parcel in) {
        mCore = in.readByte() != 0;
        mSideCore1 = in.readByte() != 0;
        mSideCore2 = in.readByte() != 0;
        mFairings = in.readByte() != 0;
        mCapsule = in.readByte() != 0;
    }

    public boolean isCore() {
        return mCore;
    }

    public boolean isSideCore1() {
        return mSideCore1;
    }

    public boolean isSideCore2() {
        return mSideCore2;
    }

    public boolean isFairings() {
        return mFairings;
    }

    public boolean isCapsule() {
        return mCapsule;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Reuse reuse = (Reuse) o;

        if (mCore != reuse.mCore) return false;
        if (mSideCore1 != reuse.mSideCore1) return false;
        if (mSideCore2 != reuse.mSideCore2) return false;
        if (mFairings != reuse.mFairings) return false;
        return mCapsule == reuse.mCapsule;
    }

    @Override
    public int hashCode() {
        int result = (mCore ? 1 : 0);
        result = 31 * result + (mSideCore1 ? 1 : 0);
        result = 31 * result + (mSideCore2 ? 1 : 0);
        result = 31 * result + (mFairings ? 1 : 0);
        result = 31 * result + (mCapsule ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Reuse{");
        sb.append("mCore=").append(mCore);
        sb.append(", mSideCore1=").append(mSideCore1);
        sb.append(", mSideCore2=").append(mSideCore2);
        sb.append(", mFairings=").append(mFairings);
        sb.append(", mCapsule=").append(mCapsule);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeByte(mCore ? (byte) 1 : (byte) 0);
        dest.writeByte(mSideCore1 ? (byte) 1 : (byte) 0);
        dest.writeByte(mSideCore2 ? (byte) 1 : (byte) 0);
        dest.writeByte(mFairings ? (byte) 1 : (byte) 0);
        dest.writeByte(mCapsule ? (byte) 1 : (byte) 0);
    }

    private static final class ClassCreator implements Creator<Reuse> {
        @Override
        public Reuse createFromParcel(Parcel source) {
            return new Reuse(source);
        }

        @Override
        public Reuse[] newArray(int size) {
            return new Reuse[size];
        }
    }
}