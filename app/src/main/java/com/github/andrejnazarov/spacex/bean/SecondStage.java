package com.github.andrejnazarov.spacex.bean;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * @author Nazarov on 21.01.18.
 */

public final class SecondStage implements Parcelable {

    public static final ClassCreator CREATOR = new ClassCreator();
    public static final String PAYLOADS = "payloads";
    
    private final List<Payload> mPayloadList;
    
    public SecondStage(List<Payload> payloadList) {
        mPayloadList = payloadList;
    }

    protected SecondStage(Parcel in) {
        mPayloadList = in.createTypedArrayList(Payload.CREATOR);
    }
    
    public List<Payload> getPayloadList() {
        return mPayloadList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SecondStage that = (SecondStage) o;

        return mPayloadList != null ? mPayloadList.equals(that.mPayloadList) : that.mPayloadList == null;
    }

    @Override
    public int hashCode() {
        return mPayloadList != null ? mPayloadList.hashCode() : 0;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("SecondStage{");
        sb.append("mPayloadList=").append(mPayloadList);
        sb.append('}');
        return sb.toString();
    }
    
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedList(mPayloadList);
    }

    private static final class ClassCreator implements Creator<SecondStage> {
        @Override
        public SecondStage createFromParcel(Parcel source) {
            return new SecondStage(source);
        }

        @Override
        public SecondStage[] newArray(int size) {
            return new SecondStage[size];
        }
    }
}