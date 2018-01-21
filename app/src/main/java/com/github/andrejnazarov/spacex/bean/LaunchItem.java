package com.github.andrejnazarov.spacex.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * @author Nazarov on 21.01.18.
 */

public class LaunchItem implements Parcelable {

    public static final ClassCreator CREATOR = new ClassCreator();
    public static final String FLIGHT_NUMBER = "flight_number";
    public static final String LAUNCH_YEAR = "launch_year";
    public static final String LAUNCH_DATE_UTC = "launch_date_utc";
    public static final String ROCKET = "rocket";
    public static final String REUSE = "reuse";
    public static final String TELEMETRY = "telemetry";
    public static final String LAUNCH_SITE = "launch_site";
    public static final String LAUNCH_SUCCESS = "launch_success";
    public static final String LINKS = "links";
    public static final String DETAILS = "details";

    private final String mFlightNumber;
    private final String mLaunchYear;
    private final String mLaunchDateUTC;
    private final Rocket mRocket;
    private final Reuse mReuse;
    private final Telemetry mTelemetry;
    private final LaunchSite mLaunchSite;
    private final boolean mLaunchSuccess;
    private final Links mLinks;
    private final String mDetails;

    public LaunchItem(String flightNumber,
                      String launchYear,
                      String launchDateUTC,
                      Rocket rocket, 
                      Reuse reuse,
                      Telemetry telemetry, 
                      LaunchSite launchSite, 
                      boolean launchSuccess, 
                      Links links, 
                      String details) {
        mFlightNumber = flightNumber;
        mLaunchYear = launchYear;
        mLaunchDateUTC = launchDateUTC;
        mRocket = rocket;
        mReuse = reuse;
        mTelemetry = telemetry;
        mLaunchSite = launchSite;
        mLaunchSuccess = launchSuccess;
        mLinks = links;
        mDetails = details;
    }

    protected LaunchItem(Parcel in) {
        mFlightNumber = in.readString();
        mLaunchYear = in.readString();
        mLaunchDateUTC = in.readString();
        mRocket = in.readParcelable(Rocket.class.getClassLoader());
        mReuse = in.readParcelable(Reuse.class.getClassLoader());
        mTelemetry = in.readParcelable(Telemetry.class.getClassLoader());
        mLaunchSite = in.readParcelable(LaunchSite.class.getClassLoader());
        mLaunchSuccess = in.readByte() != 0;
        mLinks = in.readParcelable(Links.class.getClassLoader());
        mDetails = in.readString();
    }

    public String getFlightNumber() {
        return mFlightNumber;
    }

    public String getLaunchYear() {
        return mLaunchYear;
    }

    public String getLaunchDateUTC() {
        return mLaunchDateUTC;
    }

    public Rocket getRocket() {
        return mRocket;
    }

    public Reuse getReuse() {
        return mReuse;
    }

    public Telemetry getTelemetry() {
        return mTelemetry;
    }

    public LaunchSite getLaunchSite() {
        return mLaunchSite;
    }

    public boolean isLaunchSuccess() {
        return mLaunchSuccess;
    }

    public Links getLinks() {
        return mLinks;
    }

    public String getDetails() {
        return mDetails;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LaunchItem item = (LaunchItem) o;

        if (mLaunchSuccess != item.mLaunchSuccess) return false;
        if (mFlightNumber != null ? !mFlightNumber.equals(item.mFlightNumber) : item.mFlightNumber != null)
            return false;
        if (mLaunchYear != null ? !mLaunchYear.equals(item.mLaunchYear) : item.mLaunchYear != null)
            return false;
        if (mLaunchDateUTC != null ? !mLaunchDateUTC.equals(item.mLaunchDateUTC) : item.mLaunchDateUTC != null)
            return false;
        if (mRocket != null ? !mRocket.equals(item.mRocket) : item.mRocket != null) return false;
        if (mReuse != null ? !mReuse.equals(item.mReuse) : item.mReuse != null) return false;
        if (mTelemetry != null ? !mTelemetry.equals(item.mTelemetry) : item.mTelemetry != null)
            return false;
        if (mLaunchSite != null ? !mLaunchSite.equals(item.mLaunchSite) : item.mLaunchSite != null)
            return false;
        if (mLinks != null ? !mLinks.equals(item.mLinks) : item.mLinks != null) return false;
        return mDetails != null ? mDetails.equals(item.mDetails) : item.mDetails == null;
    }

    @Override
    public int hashCode() {
        int result = mFlightNumber != null ? mFlightNumber.hashCode() : 0;
        result = 31 * result + (mLaunchYear != null ? mLaunchYear.hashCode() : 0);
        result = 31 * result + (mLaunchDateUTC != null ? mLaunchDateUTC.hashCode() : 0);
        result = 31 * result + (mRocket != null ? mRocket.hashCode() : 0);
        result = 31 * result + (mReuse != null ? mReuse.hashCode() : 0);
        result = 31 * result + (mTelemetry != null ? mTelemetry.hashCode() : 0);
        result = 31 * result + (mLaunchSite != null ? mLaunchSite.hashCode() : 0);
        result = 31 * result + (mLaunchSuccess ? 1 : 0);
        result = 31 * result + (mLinks != null ? mLinks.hashCode() : 0);
        result = 31 * result + (mDetails != null ? mDetails.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("LaunchItem{");
        sb.append("mFlightNumber='").append(mFlightNumber).append('\'');
        sb.append(", mLaunchYear='").append(mLaunchYear).append('\'');
        sb.append(", mLaunchDateUTC='").append(mLaunchDateUTC).append('\'');
        sb.append(", mRocket=").append(mRocket);
        sb.append(", mReuse=").append(mReuse);
        sb.append(", mTelemetry=").append(mTelemetry);
        sb.append(", mLaunchSite=").append(mLaunchSite);
        sb.append(", mLaunchSuccess=").append(mLaunchSuccess);
        sb.append(", mLinks=").append(mLinks);
        sb.append(", mDetails='").append(mDetails).append('\'');
        sb.append('}');
        return sb.toString();
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mFlightNumber);
        dest.writeString(mLaunchYear);
        dest.writeString(mLaunchDateUTC);
        dest.writeParcelable(mRocket, flags);
        dest.writeParcelable(mReuse, flags);
        dest.writeParcelable(mTelemetry, flags);
        dest.writeParcelable(mLaunchSite, flags);
        dest.writeByte(mLaunchSuccess ? (byte) 1 : (byte) 0);
        dest.writeParcelable(mLinks, flags);
        dest.writeString(mDetails);
    }

    private static final class ClassCreator implements Creator<LaunchItem> {
        @Override
        public LaunchItem createFromParcel(Parcel source) {
            return new LaunchItem(source);
        }

        @Override
        public LaunchItem[] newArray(int size) {
            return new LaunchItem[size];
        }
    }
}