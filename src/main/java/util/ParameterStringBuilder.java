package util;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;

import static util.Constants.CLIENT_ID_PARAM;

public class ParameterStringBuilder {

    /***
     * This method creates a url for the request to hit.
     * @param url The base URL for the api endpoint as a String
     * @param params A key-value pair specified as a Map that contains the request parameters
     * @param clientId String equivalent of the 'client_id' that needs to be appended to each URL
     * @return The String equivalent of the final URL that the HTTP request hits
     * @throws UnsupportedEncodingException
     */
    public static String buildUrl(String url, Map<String, String> params, String clientId) throws UnsupportedEncodingException {
        url = url.concat("?");
        params.put(CLIENT_ID_PARAM, clientId);
        url = url.concat(ParameterStringBuilder.getParamsString(params));
        return url;
    }

    /***
     * This method generated the String equivalent of the request parameters that can be appended to the BASE url.
     * @param params A key-value pair specified as a Map that contains the request parameters
     * @return The String equivalent of the request parameters to be appended to URL that the HTTP request hits
     * @throws UnsupportedEncodingException
     */
    private static String getParamsString(Map<String, String> params)
            throws UnsupportedEncodingException {
        StringBuilder result = new StringBuilder();

        for (Map.Entry<String, String> entry : params.entrySet()) {
            result.append(URLEncoder.encode(entry.getKey(), "UTF-8"));
            result.append("=");
            result.append(URLEncoder.encode(entry.getValue(), "UTF-8"));
            result.append("&");
        }

        String resultString = result.toString();
        return resultString.length() > 0
                ? resultString.substring(0, resultString.length() - 1)
                : resultString;
    }
}
