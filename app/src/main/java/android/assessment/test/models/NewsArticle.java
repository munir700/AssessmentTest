package android.assessment.test.models;

import com.google.gson.annotations.SerializedName;

public class NewsArticle {

    @SerializedName("per_facet")
    private String[] perFacet;

    @SerializedName("org_facet")
    private String[] orgFacet;

    private String column;

    private String section;

    private String abstractStr;

    private String source;

    @SerializedName("asset_Id")
    private String assetId;

    private Media[] media;

    private String type;

    private String title;

    @SerializedName("des_facet")
    private String[] desFacet;

    private String url;

    @SerializedName("adx_keywords")
    private String adxKeywords;

    @SerializedName("geo_facet")
    private String[] geoFacet;

    private String id;

    private String byline;

    @SerializedName("published_date")
    private String publishedDate;

    private String views;

    public String[] getPerFacet() {
        return perFacet;
    }

    public void setPerFacet(String[] perFacet) {
        this.perFacet = perFacet;
    }

    public String[] getOrgFacet() {
        return orgFacet;
    }

    public void setOrgFacet(String[] orgFacet) {
        this.orgFacet = orgFacet;
    }

    public String getColumn() {
        return column;
    }

    public void setColumn(String column) {
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

    public String[] getDesFacet() {
        return desFacet;
    }

    public void setDesFacet(String[] desFacet) {
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

    public String[] getGeoFacet() {
        return geoFacet;
    }

    public void setGeoFacet(String[] geoFacet) {
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
