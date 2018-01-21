package com.github.andrejnazarov.spacex.bean;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * @author Nazarov on 21.01.18.
 */

public final class Payload implements Parcelable {

    public static final ClassCreator CREATOR = new ClassCreator();
    public static final String ID = "payload_id";
    public static final String REUSED = "reused";
    public static final String CUSTOMERS = "customers";
    public static final String TYPE = "payload_type";
    public static final String MASS = "payload_mass_kg";
    public static final String ORBIT = "orbit";

    private final String mId;
    private final boolean mReused;
    private final List<String> mCustomers;
    private final String mType;
    private final String mMass;
    private final String mOrbit;

    public Payload(String id,
                   boolean reused,
                   List<String> customers,
                   String type, String mass,
                   String orbit) {
        mId = id;
        mReused = reused;
        mCustomers = customers;
        mType = type;
        mMass = mass;
        mOrbit = orbit;
    }

    protected Payload(Parcel in) {
        mId = in.readString();
        mReused = in.readByte() != 0;
        mCustomers = in.createStringArrayList();
        mType = in.readString();
        mMass = in.readString();
        mOrbit = in.readString();
    }

    public String getId() {
        return mId;
    }

    public boolean isReused() {
        return mReused;
    }

    public List<String> getCustomers() {
        return mCustomers;
    }

    public String getType() {
        return mType;
    }

    public String getMass() {
        return mMass;
    }

    public String getOrbit() {
        return mOrbit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Payload payload = (Payload) o;

        if (mReused != payload.mReused) return false;
        if (mId != null ? !mId.equals(payload.mId) : payload.mId != null) return false;
        if (mCustomers != null ? !mCustomers.equals(payload.mCustomers) : payload.mCustomers != null)
            return false;
        if (mType != null ? !mType.equals(payload.mType) : payload.mType != null) return false;
        if (mMass != null ? !mMass.equals(payload.mMass) : payload.mMass != null) return false;
        return mOrbit != null ? mOrbit.equals(payload.mOrbit) : payload.mOrbit == null;
    }

    @Override
    public int hashCode() {
        int result = mId != null ? mId.hashCode() : 0;
        result = 31 * result + (mReused ? 1 : 0);
        result = 31 * result + (mCustomers != null ? mCustomers.hashCode() : 0);
        result = 31 * result + (mType != null ? mType.hashCode() : 0);
        result = 31 * result + (mMass != null ? mMass.hashCode() : 0);
        result = 31 * result + (mOrbit != null ? mOrbit.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Payload{");
        sb.append("mId='").append(mId).append('\'');
        sb.append(", mReused=").append(mReused);
        sb.append(", mCustomers=").append(mCustomers);
        sb.append(", mType='").append(mType).append('\'');
        sb.append(", mMass='").append(mMass).append('\'');
        sb.append(", mOrbit='").append(mOrbit).append('\'');
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
        dest.writeByte(mReused ? (byte) 1 : (byte) 0);
        dest.writeStringList(mCustomers);
        dest.writeString(mType);
        dest.writeString(mMass);
        dest.writeString(mOrbit);
    }

    private static final class ClassCreator implements Creator<Payload> {
        @Override
        public Payload createFromParcel(Parcel source) {
            return new Payload(source);
        }

        @Override
        public Payload[] newArray(int size) {
            return new Payload[size];
        }
    }
}
