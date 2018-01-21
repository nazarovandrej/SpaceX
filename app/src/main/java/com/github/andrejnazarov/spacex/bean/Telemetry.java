package com.github.andrejnazarov.spacex.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * @author Nazarov on 21.01.18.
 */

public final class Telemetry implements Parcelable {

    public static final ClassCreator CREATOR = new ClassCreator();
    public static final String FLIGHT_CLUB = "flight_club";
    
    private final String mFlightClub;

    public Telemetry(String flightClub) {
        mFlightClub = flightClub;
    }

    protected Telemetry(Parcel in) {
        mFlightClub = in.readString();
    }

    public String getFlightClub() {
        return mFlightClub;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Telemetry telemetry = (Telemetry) o;

        return mFlightClub != null ? mFlightClub.equals(telemetry.mFlightClub) : telemetry.mFlightClub == null;
    }

    @Override
    public int hashCode() {
        return mFlightClub != null ? mFlightClub.hashCode() : 0;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Telemetry{");
        sb.append("mFlightClub='").append(mFlightClub).append('\'');
        sb.append('}');
        return sb.toString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mFlightClub);
    }

    private static final class ClassCreator implements Creator<Telemetry> {
        @Override
        public Telemetry createFromParcel(Parcel source) {
            return new Telemetry(source);
        }

        @Override
        public Telemetry[] newArray(int size) {
            return new Telemetry[size];
        }
    }
}