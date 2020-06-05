package model;

import com.google.gson.annotations.SerializedName;

public class Exif {
    private final String make;
    private final String model;
    @SerializedName("exposure_time")
    private final String exposureTime;
    private final String aperture;
    @SerializedName("focal_length")
    private final String focalLength;
    private final Long iso;

    Exif(String make, String model, String exposureTime, String aperture, String focalLength, Long iso) {
        this.make = make;
        this.model = model;
        this.exposureTime = exposureTime;
        this.aperture = aperture;
        this.focalLength = focalLength;
        this.iso = iso;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public String getExposureTime() {
        return exposureTime;
    }

    public String getAperture() {
        return aperture;
    }

    public String getFocalLength() {
        return focalLength;
    }

    public Long getIso() {
        return iso;
    }

    @Override
    public String toString() {
        return "Exif{" +
                "make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", exposureTime='" + exposureTime + '\'' +
                ", aperture='" + aperture + '\'' +
                ", focalLength='" + focalLength + '\'' +
                ", iso=" + iso +
                '}';
    }
}

