package model;

import com.google.gson.annotations.SerializedName;

public class Link {
    private final String self;
    private final String html;
    private final String download;
    @SerializedName("download_location")
    private final String downloadLocation;
    private final String photos;
    private final String likes;
    private final String portfolio;

    Link(String self, String html, String download, String downloadLocation) {
        this.self = self;
        this.html = html;
        this.download = download;
        this.downloadLocation = downloadLocation;
        this.photos = this.likes = this.portfolio = null;

    }

    Link(String self, String html, String photos, String likes, String portfolio) {
        this.self = self;
        this.html = html;
        this.photos = photos;
        this.likes = likes;
        this.portfolio = portfolio;
        this.download = this.downloadLocation = null;

    }

    public String getSelf() {
        return self;
    }

    public String getHtml() {
        return html;
    }

    public String getDownload() {
        return download;
    }

    public String getDownloadLocation() {
        return downloadLocation;
    }

    public String getPhotos() {
        return photos;
    }

    public String getLikes() {
        return likes;
    }

    public String getPortfolio() {
        return portfolio;
    }

    @Override
    public String toString() {
        return "Link{" +
                "self='" + self + '\'' +
                ", html='" + html + '\'' +
                ", download='" + download + '\'' +
                ", downloadLocation='" + downloadLocation + '\'' +
                ", photos='" + photos + '\'' +
                ", likes='" + likes + '\'' +
                ", portfolio='" + portfolio + '\'' +
                '}';
    }
}

