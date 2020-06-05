package util;

import java.io.*;
import java.util.*;
import java.util.logging.Logger;


public class PlatformUtils {

    private Logger logger = Logger.getLogger(String.valueOf(this.getClass()));
    private InputStream inputStream;
    private String clientId;
    private String clientSecret;
    private String redirectUrl;
    private String code;
    private String accessToken;
    private final String propFileName = "config.properties";
    private Properties props;

    public PlatformUtils() {
        this.props = new Properties();
    }

    public void getPropValues() throws IOException {
        try {
            inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
            if (inputStream != null) {
                props.load(inputStream);
                clientId = props.getProperty("client_id");
                clientSecret = props.getProperty("client_secret");
                redirectUrl = props.getProperty("redirect_url");
                code = props.getProperty("code");
                accessToken = props.getProperty("access_token");
            } else {
                logger.warning("This file does not exists!");
                throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
            }
        } catch (Exception e) {
            logger.warning("Something went wrong: " + e);
        } finally {
            inputStream.close();
        }
    }

    public void updateConfigWithAccessToken(String accessToken) {
        try {
            inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
            props.load(inputStream);
            String path = System.getProperty("user.dir") + "\\src\\main\\resources\\" + propFileName;
            props.setProperty("access_token", accessToken);
            FileWriter writer = new FileWriter(path);
            props.store(writer, "Updated on:");
            writer.close();
        } catch (FileNotFoundException e) {
            logger.warning("File does not exist: " + e);
        } catch (IOException e) {
            logger.warning("An IOException occurred: " + e);
        }
    }

    public String getClientId() {
        return clientId;
    }

    public String getClientSecret() {
        return clientSecret;
    }

    public String getRedirectUrl() {
        return redirectUrl;
    }

    public String getCode() {
        return code;
    }

    public String getAccessToken() {
        return accessToken;
    }

}
