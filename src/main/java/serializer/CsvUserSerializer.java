package serializer;

import java.io.File;
import java.io.IOException;
import java.util.Collection;

import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;

import serializer.deserializer.test.user.User;

public class CsvUserSerializer implements UserSerializer {
    @Override
    public void serialize(Collection<User> userCollection, String outputFile) {
        CsvMapper objectMapper = new CsvMapper();
        File output = new File(outputFile);
        objectMapper.disable(MapperFeature.SORT_PROPERTIES_ALPHABETICALLY);
        CsvSchema csvSchema = objectMapper
            .schemaFor(User.class)
            .withHeader();
        try {
            objectMapper.writer(csvSchema).writeValue(output, userCollection);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    }