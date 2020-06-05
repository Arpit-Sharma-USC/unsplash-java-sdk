package model;

import com.google.gson.annotations.SerializedName;

public class Collection {
    private final Long id;
    private final String title;
    private final String description;
    @SerializedName("published_at")
    private final String publishedAt;
    @SerializedName("last_collected_at")
    private final String lastCollectionAt;
    @SerializedName("private")
    private final boolean isPrivate;
    @SerializedName("share_key")
    private final String shareKey;
    @SerializedName("total_photos")
    private final Long totalPhotos;
    private final Link link;
    private final User user;
    @SerializedName("cover_photo")
    private final Photo coverPhoto;

    Collection(Long id, String title, String description, String publishedAt, String lastCollectionAt, boolean isPrivate,
               String shareKey, Long totalPhotos, Link link, User user, Photo coverPhoto) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.publishedAt = publishedAt;
        this.lastCollectionAt = lastCollectionAt;
        this.isPrivate = isPrivate;
        this.shareKey = shareKey;
        this.totalPhotos = totalPhotos;
        this.link = link;
        this.user = user;
        this.coverPhoto = coverPhoto;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getPublishedAt() {
        return publishedAt;
    }

    public String getLastCollectionAt() {
        return lastCollectionAt;
    }

    public boolean isPrivate() {
        return isPrivate;
    }

    public String getShareKey() {
        return shareKey;
    }

    public Long getTotalPhotos() {
        return totalPhotos;
    }

    public Link getLink() {
        return link;
    }

    public User getUser() {
        return user;
    }

    public Photo getCoverPhoto() {
        return coverPhoto;
    }

    @Override
    public String toString() {
        return "Collection{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", publishedAt='" + publishedAt + '\'' +
                ", lastCollectionAt='" + lastCollectionAt + '\'' +
                ", isPrivate=" + isPrivate +
                ", shareKey='" + shareKey + '\'' +
                ", totalPhotos=" + totalPhotos +
                ", link=" + link +
                ", user=" + user +
                ", coverPhoto=" + coverPhoto +
                '}';
    }
}

