package serializer.deserializer;

import java.util.Collection;
import serializer.deserializer.test.user.User;

public interface UserDeserializer {

    Collection<User> deserialize(String inputFile);

}
