package model;

import com.google.gson.annotations.SerializedName;

public class User {
    private final String id;
    @SerializedName("updated_at")
    private final String updatedAt;
    private final String username;
    private final String name;
    @SerializedName("portfolio_url")
    private final String portfolioUrl;
    private final String bio;
    private final String location;
    @SerializedName("total_likes")
    private final Long totalLikes;
    @SerializedName("total_photos")
    private final Long totalPhotos;
    @SerializedName("total_collections")
    private final Long totalCollections;
    private final Link links;

    User(String id, String updatedAt, String username, String name, String portfolioUrl, String bio, String location, Long totalLikes, Long totalPhotos,
         Long totalCollections, Link links) {
        this.id = id;
        this.updatedAt = updatedAt;
        this.username = username;
        this.name = name;
        this.portfolioUrl = portfolioUrl;
        this.bio = bio;
        this.location = location;
        this.totalLikes = totalLikes;
        this.totalPhotos = totalPhotos;
        this.totalCollections = totalCollections;
        this.links = links;
    }

    public String getId() {
        return id;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public String getUsername() {
        return username;
    }

    public String getName() {
        return name;
    }

    public String getPortfolioUrl() {
        return portfolioUrl;
    }

    public String getBio() {
        return bio;
    }

    public String getLocation() {
        return location;
    }

    public Long getTotalLikes() {
        return totalLikes;
    }

    public Long getTotalPhotos() {
        return totalPhotos;
    }

    public Long getTotalCollections() {
        return totalCollections;
    }

    public Link getLinks() {
        return links;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", updatedAt='" + updatedAt + '\'' +
                ", username='" + username + '\'' +
                ", name='" + name + '\'' +
                ", portfolioUrl='" + portfolioUrl + '\'' +
                ", bio='" + bio + '\'' +
                ", location='" + location + '\'' +
                ", totalLikes=" + totalLikes +
                ", totalPhotos=" + totalPhotos +
                ", totalCollections=" + totalCollections +
                ", links=" + links +
                '}';
    }
}


