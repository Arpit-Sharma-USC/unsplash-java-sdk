package enums;

public enum RequestMethod {
    GET("GET"),
    POST("POST"),
    PUT("PUT"),
    DELETE("DELETE"),
    PATCH("PATCH");

    private String requestMethodType;

    RequestMethod(String requestMethodType) {
        this.requestMethodType = requestMethodType;
    }

    public String toString() {
        return this.requestMethodType;
    }

}




