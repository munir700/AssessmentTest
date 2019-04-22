package android.assessment.test.models;

import com.google.gson.annotations.SerializedName;

public class NewsArticle {

    @SerializedName("per_facet")
    private Object perFacet;

    @SerializedName("org_facet")
    private Object orgFacet;

    private Object column;

    private String section;

    private String abstractStr;

    private String source;

    @SerializedName("asset_Id")
    private String assetId;

    private Media[] media;

    private String type;

    private String title;

    @SerializedName("des_facet")
    private Object desFacet;

    private String url;

    @SerializedName("adx_keywords")
    private String adxKeywords;

    @SerializedName("geo_facet")
    private Object geoFacet;

    private String id;

    private String byline;

    @SerializedName("published_date")
    private String publishedDate;

    private String views;

    public Object getPerFacet() {
        return perFacet;
    }

    public void setPerFacet(Object perFacet) {
        this.perFacet = perFacet;
    }

    public Object getOrgFacet() {
        return orgFacet;
    }

    public void setOrgFacet(Object orgFacet) {
        this.orgFacet = orgFacet;
    }

    public Object getColumn() {
        return column;
    }

    public void setColumn(Object column) {
        this.column = column;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getAbstract() {
        return abstractStr;
    }

    public void setAbstract(String abstractStr) {
        this.abstractStr = abstractStr;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getAssetId() {
        return assetId;
    }

    public void setAssetId(String assetId) {
        this.assetId = assetId;
    }

    public Media[] getMedia() {
        return media;
    }

    public void setMedia(Media[] media) {
        this.media = media;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Object getDesFacet() {
        return desFacet;
    }

    public void setDesFacet(Object desFacet) {
        this.desFacet = desFacet;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getAdxKeywords() {
        return adxKeywords;
    }

    public void setAdxKeywords(String adxKeywords) {
        this.adxKeywords = adxKeywords;
    }

    public Object getGeoFacet() {
        return geoFacet;
    }

    public void setGeoFacet(Object geoFacet) {
        this.geoFacet = geoFacet;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getByline() {
        return byline;
    }

    public void setByline(String byline) {
        this.byline = byline;
    }

    public String getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(String publishedDate) {
        this.publishedDate = publishedDate;
    }

    public String getViews() {
        return views;
    }

    public void setViews(String views) {
        this.views = views;
    }

    @Override
    public String toString() {
        return "ClassPojo [perFacet = " + perFacet + ", orgFacet = " + orgFacet + ", column = " + column + ", section = " + section + ", abstract = " + abstractStr + ", source = " + source + ", assetId = " + assetId + ", media = " + media + ", type = " + type + ", title = " + title + ", desFacet = " + desFacet + ", url = " + url + ", adxKeywords = " + adxKeywords + ", geoFacet = " + geoFacet + ", id = " + id + ", byline = " + byline + ", publishedDate = " + publishedDate + ", views = " + views + "]";
    }
}
