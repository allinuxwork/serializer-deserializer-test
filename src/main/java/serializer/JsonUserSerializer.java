package serializer;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import com.fasterxml.jackson.databind.ObjectMapper;
import serializer.deserializer.test.user.User;

public class JsonUserSerializer implements UserSerializer {
    @Override
    public void serialize(Collection<User> userCollection, String outputFile) {
        ObjectMapper objectMapper = new ObjectMapper();
        File output = new File(outputFile);
        try {
            objectMapper.writerFor(userCollection.getClass()).writeValue(output, userCollection);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}