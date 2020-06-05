package unsplash;

import exceptions.RequiredParameterException;
import model.Collection;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

public class CollectionsClientTest {

    private CollectionsClient client;

    @Before
    public void initialize() {
        this.client = new CollectionsClient();
    }

    @Test
    public void getCollectionsTest() {
        try {
            List<Collection> response = client.getCollections(Optional.empty(), Optional.empty());
            assertNotNull(response);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void createCollectiontest() throws RequiredParameterException {
        try {
            String title = "Junit_Bynder-serialized";
            String description = "Test of a description goes here.";
            boolean isPrivate = true;
            Collection response = client.createCollection(title, Optional.of(description), Optional.of(isPrivate));
            assertEquals(title, response.getTitle());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void addPhotoToCollectionTest() throws RequiredParameterException {
        try {
            String collectionId = "10586788";
            String photoId = "fEGyoLlHj-8";
            client.addPhotoToCollection(photoId, collectionId);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}