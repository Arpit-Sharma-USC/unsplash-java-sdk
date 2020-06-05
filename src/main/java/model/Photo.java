package model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Photo {

    private final String id;
    @SerializedName("created_at")
    private final String createdAt;
    @SerializedName("updated_at")
    private final String updatedAt;
    private final Long width;
    private final Long height;
    private final String color;
    private final Long downloads;
    private final Long likes;
    @SerializedName("liked_by_user")
    private final boolean likedByUser;
    private final String description;
    @SerializedName("exif")
    private final Exif exif;
    @SerializedName("location")
    private final Location location;
    @SerializedName("current_user_collections")
    private final List<Collection> currentUserCollections;
    private final URL urls;
    private final Link links;
    private final User user;

    Photo(String id, String createdAt, String updatedAt, Long width, Long height, String color, Long downloads, Long likes, boolean likedByUser, String description,
          Exif exif, Location location, List<Collection> currentUserCollections, URL urls, Link links, User user) {
        this.id = id;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.width = width;
        this.height = height;
        this.color = color;
        this.downloads = downloads;
        this.likes = likes;
        this.likedByUser = likedByUser;
        this.description = description;
        this.exif = exif;
        this.location = location;
        this.currentUserCollections = currentUserCollections;
        this.urls = urls;
        this.links = links;
        this.user = user;
    }

    public String getId() {
        return id;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public Long getWidth() {
        return width;
    }

    public Long getHeight() {
        return height;
    }

    public String getColor() {
        return color;
    }

    public Long getDownloads() {
        return downloads;
    }

    public Long getLikes() {
        return likes;
    }

    public boolean isLikedByUser() {
        return likedByUser;
    }

    public String getDescription() {
        return description;
    }

    public Exif getExif() {
        return exif;
    }

    public Location getLocation() {
        return location;
    }

    public List<Collection> getCurrentUserCollections() {
        return currentUserCollections;
    }

    public URL getUrls() {
        return urls;
    }

    public Link getLinks() {
        return links;
    }

    public User getUser() {
        return user;
    }

    @Override
    public String toString() {
        return "Photo{" +
                "id='" + id + '\'' +
                ", createdAt='" + createdAt + '\'' +
                ", updatedAt='" + updatedAt + '\'' +
                ", width=" + width +
                ", height=" + height +
                ", color='" + color + '\'' +
                ", downloads=" + downloads +
                ", likes=" + likes +
                ", likedByUser=" + likedByUser +
                ", description='" + description + '\'' +
                ", exif=" + exif +
                ", location=" + location +
                ", currentUserCollections=" + currentUserCollections +
                ", urls=" + urls +
                ", links=" + links +
                ", user=" + user +
                '}';
    }

}

