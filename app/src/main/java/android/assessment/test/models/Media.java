package android.assessment.test.models;

public class Media {
    private String copyright;

    private MediaMetadata[] mediaMetadata;

    private String subtype;

    private String caption;

    private String type;

    private String approvedForSyndication;

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
}
