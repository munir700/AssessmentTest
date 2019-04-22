package android.assessment.test.models;

import android.arch.persistence.room.TypeConverters;
import android.assessment.test.typeconverters.DataTypeConverter;
import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class Media implements Parcelable {
    private String copyright;

    @TypeConverters(DataTypeConverter.class)
    @SerializedName("media-metadata")
    private MediaMetadata[] mediaMetadata;

    private String subtype;

    private String caption;

    private String type;

    private String approvedForSyndication;

    protected Media(Parcel in) {
        copyright = in.readString();
        subtype = in.readString();
        caption = in.readString();
        type = in.readString();
        approvedForSyndication = in.readString();
        mediaMetadata = in.createTypedArray(MediaMetadata.CREATOR);
    }

    public static final Creator<Media> CREATOR = new Creator<Media>() {
        @Override
        public Media createFromParcel(Parcel in) {
            return new Media(in);
        }

        @Override
        public Media[] newArray(int size) {
            return new Media[size];
        }
    };

    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    public MediaMetadata[] getMediaMetadata() {
        return mediaMetadata;
    }

    public void setMediaMetadata(MediaMetadata[] mediaMetadata) {
        this.mediaMetadata = mediaMetadata;
    }

    public String getSubtype() {
        return subtype;
    }

    public void setSubtype(String subtype) {
        this.subtype = subtype;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getApprovedForSyndication() {
        return approvedForSyndication;
    }

    public void setApprovedForSyndication(String approvedForSyndication) {
        this.approvedForSyndication = approvedForSyndication;
    }

    @Override
    public String toString() {
        return "ClassPojo [copyright = " + copyright + ", media-metadata = " + mediaMetadata + ", subtype = " + subtype + ", caption = " + caption + ", type = " + type + ", approvedForSyndication = " + approvedForSyndication + "]";
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(copyright);
        dest.writeString(subtype);
        dest.writeString(caption);
        dest.writeString(type);
        dest.writeString(approvedForSyndication);
        dest.writeTypedArray(mediaMetadata, flags);
    }
}
