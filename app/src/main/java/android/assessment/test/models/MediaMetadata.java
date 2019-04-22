package android.assessment.test.models;

import android.os.Parcel;
import android.os.Parcelable;

public class MediaMetadata implements Parcelable {
    private String format;

    private String width;

    private String url;

    private String height;

    protected MediaMetadata(Parcel in) {
        format = in.readString();
        width = in.readString();
        url = in.readString();
        height = in.readString();
    }

    public static final Creator<MediaMetadata> CREATOR = new Creator<MediaMetadata>() {
        @Override
        public MediaMetadata createFromParcel(Parcel in) {
            return new MediaMetadata(in);
        }

        @Override
        public MediaMetadata[] newArray(int size) {
            return new MediaMetadata[size];
        }
    };

    public String getFormat ()
    {
        return format;
    }

    public void setFormat (String format)
    {
        this.format = format;
    }

    public String getWidth ()
    {
        return width;
    }

    public void setWidth (String width)
    {
        this.width = width;
    }

    public String getUrl ()
    {
        return url;
    }

    public void setUrl (String url)
    {
        this.url = url;
    }

    public String getHeight ()
    {
        return height;
    }

    public void setHeight (String height)
    {
        this.height = height;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [format = "+format+", width = "+width+", url = "+url+", height = "+height+"]";
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(format);
        dest.writeString(width);
        dest.writeString(url);
        dest.writeString(height);
    }
}
