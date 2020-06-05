package unsplash;

import com.google.api.client.util.Strings;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import exceptions.RequiredParameterException;
import model.Collection;

import java.io.IOException;
import java.util.*;

import static util.Constants.*;
import static enums.RequestMethod.GET;
import static enums.RequestMethod.POST;

public class CollectionsClient extends UnsplashClient {

    public CollectionsClient() {
        super();
    }

    /***
     * This method wraps around the UnsplashClient::request to perform a 'List Collections' operation via the 'GET /collections' endpoint.
     * There are a couple of optional request parameters namely 'page' and 'per_page' that can be specified.
     * The String response from the UnsplashClient::request is transformed into json and then marshalled into a Collection bean.
     *
     * @param perPage An optional parameter to specify the page number out of the total pages of collections to get.
     * @param page An optional parameter that specify the total collections to return per page.
     * @return a List of 'Collection'(s) each marshalled into a bean of Collection.class
     * @throws IOException
     */
    public List<Collection> getCollections(Optional<String> perPage, Optional<String> page) throws IOException {
        String url = API_URL + COLLECTIONS;
        Map<String, String> parameters = new HashMap();
        page.ifPresent(s -> parameters.put(PAGE_PARAM, s));
        perPage.ifPresent(s -> parameters.put(PER_PAGE_PARAM, s));
        String res = request(url, GET, parameters);
        Gson gson = new GsonBuilder().create();
        Collection[] collection = gson.fromJson(res, Collection[].class);
        return Arrays.asList(collection);
    }

    /***
     * This method wraps around the UnsplashClient::request to perform a 'Create Collection' operation via the 'POST /collections' endpoint.
     * A title of this collection is required to create it. There are a couple of optional request parameters namely 'description'
     * and 'private' that can be specified if required.
     * This method utilizes the 'access_token' to be set.
     * The String response from the UnsplashClient::request is transformed into json and then marshalled into a Collection bean.
     *
     * @param title The title of the collection to be created.
     * @param description An optional description of this collection.
     * @param isPrivate An optional parameter specifying whether this collection is private or not.
     * @return A 'Collection' marshalled into a bean of Collection.class that the endpoint creates.
     * @throws IOException,RequiredParameterException
     */
    public Collection createCollection(String title, Optional<String> description, Optional<Boolean> isPrivate) throws IOException, RequiredParameterException {
        if (Strings.isNullOrEmpty(title))
            throw new RequiredParameterException("Title is a required field and cannot be null or empty!", new NullPointerException());

        String url = API_URL + COLLECTIONS;
        Map<String, String> parameters = new HashMap();
        parameters.put(TITLE_PARAM, title);
        description.ifPresent(s -> parameters.put(DESCRIPTION_PARAM, description.get()));
        isPrivate.ifPresent(s -> parameters.put(PRIVATE_PARAM, String.valueOf(isPrivate.get())));
        parameters.put(ACCESS_TOKEN_PARAM, accessToken);
        String response = request(url, POST, parameters);
        Gson gson = new GsonBuilder().create();
        Collection collection = gson.fromJson(response, Collection.class);
        return collection;
    }

    /***
     * This method wraps around the UnsplashClient::request to perform a 'Add a Photo to a Collection' operation
     * via the 'POST /collections/:collectionId/add' endpoint.
     * A required 'photo_id' needs to be specified which will be added to a collection specified by the 'collection_id'
     * @param photoId String equivalent of the 'photo_id' that needs to be added to a collection.
     * @param collectionId String equivalent of a 'collection_id' to which the photo needs to be added.
     * @throws IOException,RequiredParameterException
     */
    public void addPhotoToCollection(String photoId, String collectionId) throws IOException, RequiredParameterException {
        if (Strings.isNullOrEmpty(photoId))
            throw new RequiredParameterException("Photo id is a required field and cannot be null or empty!", new NullPointerException());
        if (Strings.isNullOrEmpty(collectionId))
            throw new RequiredParameterException("Collection id is a required field and cannot be null or empty!", new NullPointerException());

        String url = API_URL + COLLECTIONS + "/" + collectionId + ADD;
        Map<String, String> parameters = new HashMap();
        parameters.put(PHOTO_ID_PARAM, photoId);
        parameters.put(ACCESS_TOKEN_PARAM, accessToken);
        String response = request(url, POST, parameters);
    }

}
