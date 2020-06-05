package unsplash;

import model.Photo;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

public class PhotosClientTest {
    private PhotosClient client;

    @Before
    public void initialize() {
        client = new PhotosClient();
    }

    @Test
    public void getPhotosTest() {
        try {
            int perPage = 15;
            int page = 2;
            List<Photo> response = client.getPhotos(Optional.of(String.valueOf(perPage)), Optional.of(String.valueOf(page)));
            assertNotNull(response);
            assertEquals(perPage, response.size());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}