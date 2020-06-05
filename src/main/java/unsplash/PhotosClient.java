package unsplash;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import model.Photo;

import java.io.IOException;
import java.util.*;

import static util.Constants.*;
import static enums.RequestMethod.GET;

public class PhotosClient extends UnsplashClient {

    public PhotosClient() {
        super();
    }

    /***
     * This is a method that wraps around the UnsplashClient::request to perform a 'List Photos' operation via the 'GET /photos' endpoint.
     * There are a couple of optional request parameters namely 'page' and 'per_page' that can be specified.
     * The String response from the UnsplashClient::request is transformed into json and then marshalled into a Photo bean.
     *
     * @param perPage An optional parameter to specify the page number out of the total pages of photos to get.
     * @param page An optional parameter that specify the total photos to return per page.
     * @return a List of 'Photo' (s) each marshalled into a bean of Photo.class
     * @throws IOException
     */
    public List<Photo> getPhotos(Optional<String> perPage, Optional<String> page) throws IOException {
        String url = API_URL + PHOTOS;
        Map<String, String> parameters = new HashMap();
        page.ifPresent(s -> parameters.put(PAGE_PARAM, s));
        perPage.ifPresent(s -> parameters.put(PER_PAGE_PARAM, s));
        String response = request(url, GET, parameters);
        Gson gson = new GsonBuilder().create();
        Photo[] photo = gson.fromJson(response, Photo[].class);
        return Arrays.asList(photo);
    }
}

