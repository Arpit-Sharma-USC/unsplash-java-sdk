package unsplash;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;
import java.util.logging.Logger;

import com.google.common.base.Strings;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import util.ParameterStringBuilder;
import util.PlatformUtils;
import enums.RequestMethod;

import static util.Constants.*;
import static enums.RequestMethod.POST;

public class UnsplashClient {
    private Logger logger = Logger.getLogger(String.valueOf(this.getClass()));
    private PlatformUtils properties;
    String clientId;
    String redirectUrl;
    String clientSecret;
    String code;
    String accessToken;

    public UnsplashClient() {
        properties = new PlatformUtils();
        try {
            properties.getPropValues();
            this.clientId = properties.getClientId();
            this.clientSecret = properties.getClientSecret();
            this.redirectUrl = properties.getRedirectUrl();
            this.code = properties.getCode();
            this.accessToken = properties.getAccessToken();
            /*
             * If an access token exists in the config file the PlatformUtils::getPropValues() will get it and set the attribute here.
             * If not then generateAccessToken.*/
            if (Strings.isNullOrEmpty(this.accessToken)) {
                logger.info("The 'access_token' needs to be generated. \nGenerating access_token.");
                this.accessToken = generateAccessToken();
            }
        } catch (IOException e) {
            logger.warning("IOException occurred: " + e);
        }
    }

    /***
     * This method is a generic method that performs an HTTP request and returns the response as String.
     * Any request parameters can be passed along to be appended to the request URL.
     * @param urlLink The String equivalent of the api url to hit
     * @param methodType The HTTP method to use for the request expressed as the RequestMethod enum
     * @param params A HashMap containing all the request parameters that need to be added to the request
     * @return String equivalent of the response of the HTTP request
     * @throws IOException
     */
    public String request(String urlLink, RequestMethod methodType, Map<String, String> params) throws IOException {
        urlLink = ParameterStringBuilder.buildUrl(urlLink, params, clientId);
        URL url = new URL(urlLink);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod(methodType.toString());
        con.setConnectTimeout(5000);
        con.setReadTimeout(5000);
        con.setRequestProperty("Content-Type", "application/json; utf-8");
        con.setRequestProperty("Accept", "application/json");

        int status = con.getResponseCode();
        if (status == 201 || status == 200) {
            logger.info("Successfully executed the request.");
        }
        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer content = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }
        in.close();
        con.disconnect();
        return content.toString();
    }

    /*** This method generates an access token by /oauth/token endpoint.
     * Note: Use this only once. Why? Because then the access_token is stored in the config.
     *       If we run it again the config file needs to be updated with the result of the /oauth/authorize endpoint
     *       before calling it for a second time.
     *       In the future, it would make more sense to perform the OAuth 2.0 authentication as a service and reuse the bearer token.
     *       With the time constraints of this assignment I would prefer to keep it simple.
     *
     * @return String equivalent of the 'access_token' to be used for performing the non-public scoped operations
     * @throws IOException
     */
    public String generateAccessToken() throws IOException {
        String url = ACCESS_TOKEN_URL;
        Map<String, String> parameters = new HashMap();
        parameters.put("client_secret", clientSecret);
        parameters.put("redirect_uri", redirectUrl);
        parameters.put("code", code);
        parameters.put("grant_type", "authorization_code");
        String response = request(url, POST, parameters);

        Gson gson = new GsonBuilder().create();
        JsonObject node = gson.fromJson(response, JsonElement.class).getAsJsonObject();
        String accessToken = node.get("access_token").getAsString();

        properties.updateConfigWithAccessToken(accessToken);
        return accessToken;
    }

}
