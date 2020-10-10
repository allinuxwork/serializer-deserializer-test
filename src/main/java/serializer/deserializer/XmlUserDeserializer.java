package serializer.deserializer;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import serializer.deserializer.test.user.User;

public class XmlUserDeserializer implements UserDeserializer {
    @Override
    public Collection<User> deserialize(String inputFile) {
        ObjectMapper objectMapper = new XmlMapper();
        File input = new File(inputFile);
        try {
            MappingIterator<User> it = objectMapper.readerFor(User.class).readValues(input);
            return it.readAll();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }
}