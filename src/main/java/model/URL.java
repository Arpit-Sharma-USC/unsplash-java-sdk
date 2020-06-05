package model;

public class URL {
    private final String raw;
    private final String full;
    private final String regular;
    private final String small;
    private final String thumb;

    URL(String raw, String full, String regular, String small, String thumb) {
        this.raw = raw;
        this.full = full;
        this.regular = regular;
        this.small = small;
        this.thumb = thumb;
    }

    public String getRaw() {
        return raw;
    }

    public String getFull() {
        return full;
    }

    public String getRegular() {
        return regular;
    }

    public String getSmall() {
        return small;
    }

    public String getThumb() {
        return thumb;
    }

    @Override
    public String toString() {
        return "URL{" +
                "raw='" + raw + '\'' +
                ", full='" + full + '\'' +
                ", regular='" + regular + '\'' +
                ", small='" + small + '\'' +
                ", thumb='" + thumb + '\'' +
                '}';
    }
}


