package serializer;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import serializer.deserializer.test.user.User;

public class XmlUserSerializer implements UserSerializer {
    @Override
    public void serialize(Collection<User> userCollection, String outputFile) {
        ObjectMapper objectMapper = new XmlMapper();
        File output = new File(outputFile);
        try {
            objectMapper.writerFor(userCollection.getClass()).writeValue(output, userCollection);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}